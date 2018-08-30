package com.dpm.db.web.user.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dpm.db.common.example.*;
import com.dpm.db.common.mapper.*;
import com.dpm.db.web.user.service.IUserService;
import com.dpm.resource.common.enity.*;
import com.dpm.resource.common.enity.userInfo.DeptAndRoleInfoResponse;
import com.dpm.resource.common.enity.userInfo.UserAddOrUpdateParams;
import com.dpm.resource.common.enity.userInfo.UserParam;
import com.dpm.resource.common.enity.userInfo.UserSearchResult;
import com.dpm.resource.common.utils.UUIDUtils;
import com.dpm.resource.freamwork.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @ Purpose:
 * @Package Name: com.dpm.db.web.user.service.impl
 * @Author: liuxiaoxin
 * @Date: 2018/5/14
 */
@Service("UserServiceImpl")
@PropertySource(value = "classpath:config/config.properties")
public class UserServiceImpl implements IUserService {

    @Value("${jwt.expires.refresh.day}")
    private int refreshTokenDays;
    @Value("${jwt.expires.refresh.hour}")
    private int refreshTokenHours;
    @Value("${jwt.expires.refresh.min}")
    private int refreshTokenMinutes;


    @Autowired
    TUserInfoMapper tUserInfoMapper;
    @Autowired
    TDeptInfoMapper tDeptInfoMapper;
    @Autowired
    TRoleInfoMapper tRoleInfoMapper;
    @Autowired
    TLoginTokenMapper tLoginTokenMapper;
    @Autowired
    TRecordInfoMapper tRecordInfoMapper;
    @Autowired
    TUserDeptMapper tUserDeptMapper;
    @Autowired
    TRoleMenuMapper tRoleMenuMapper;
    @Autowired
    TMenuInfoMapper tMenuInfoMapper;

    /**
     * 用户登录
     *
     * @param loginUserInfo
     * @return
     */
    @Transactional
    @Override
    public LoginUserInfo doLogin(LoginUserInfo loginUserInfo) {
        //获取登录信息
        loginUserInfo.setUserInfo(getUserInfo(loginUserInfo.getUserInfo().getUserCode(), loginUserInfo.getUserInfo().getPassword()));
        //获取用户关联科室
        loginUserInfo.setUserDeptList(tDeptInfoMapper.getDeptListByUserId(loginUserInfo.getUserInfo().getId()));
        //获取用户关联角色
        loginUserInfo.setRoleInfoList(getRoleInfoList(loginUserInfo.getUserInfo().getRoleId()));
        if (!loginUserInfo.isAutoLogin()) {
            //保存Token
            saveRefreshToken(loginUserInfo.getToken());
        }

        return loginUserInfo;
    }

    @Override
    public String getLoginToken(String userKey) {
        if (StringUtils.isEmpty(userKey)) return "";
        TLoginTokenExample tokenExample = new TLoginTokenExample();
        TLoginTokenExample.Criteria tokenCriteria = tokenExample.createCriteria();
        tokenCriteria.andUserKeyEqualTo(userKey);
        tokenCriteria.andExpireTimeGreaterThan(new Date());
        List<TLoginToken> tLoginTokenList = tLoginTokenMapper.selectByExample(tokenExample);
        return CollectionUtils.isEmpty(tLoginTokenList) ? "" : tLoginTokenList.get(0).getRefreshToken();
    }

    @Override
    public String doLogout(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        Map<String, Claim> claimMap = decodedJWT.getClaims();
        String userKey = claimMap.get("userkey").asString();
        TLoginTokenExample tLoginTokenExample = new TLoginTokenExample();
        TLoginTokenExample.Criteria criteria = tLoginTokenExample.createCriteria();
        criteria.andUserKeyEqualTo(userKey);
        tLoginTokenMapper.deleteByExample(tLoginTokenExample);
        return token;
    }

    @Override
    public List<TRecordInfo> getRecentOperations(String userId, String hosCode) {
        TRecordInfoExample tRecordInfoExample = new TRecordInfoExample();
        TRecordInfoExample.Criteria criteria = tRecordInfoExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andHosCodeEqualTo(hosCode);
        criteria.andIsfinishedEqualTo("1");
        tRecordInfoExample.setOrderByClause("upload_time desc");
        tRecordInfoExample.setLimit(10);
        
        return tRecordInfoMapper.selectByExample(tRecordInfoExample);
    }

    @Override
    public List<TMenuInfo> getUserMenuInfo(String roleId) {
        TRoleMenuExample userMenuExample = new TRoleMenuExample();
        TRoleMenuExample.Criteria menuCriteria = userMenuExample.createCriteria();
        menuCriteria.andRoleIdEqualTo(roleId);
        List<TRoleMenu> userMenuList = tRoleMenuMapper.selectByExample(userMenuExample);
        if (CollectionUtils.isEmpty(userMenuList))
            return new ArrayList<>();

        /**
         * TODO 菜单表默认为二级结构，不递归查询
         */
        TMenuInfoExample tMenuInfoExample = new TMenuInfoExample();
        TMenuInfoExample.Criteria criteria = tMenuInfoExample.createCriteria();
        List<String> menuList = userMenuList.stream().map(k -> k.getMenuCode()).collect(Collectors.toList());
        menuList.add("");
        criteria.andMenuCodeIn(menuList);
        criteria.andPathIsNotNull().andUrlIsNotNull();
        List<TMenuInfo> tMenuInfoList = tMenuInfoMapper.selectByExample(tMenuInfoExample);
        tMenuInfoExample.clear();
        criteria = tMenuInfoExample.createCriteria();
        List<String> childMenuList = tMenuInfoList.stream().filter(l -> "1".equals(l.getLevel())).map(m -> m.getParentCode()).collect(Collectors.toList());
        childMenuList.add("");
        criteria.andMenuCodeIn(childMenuList)
                .andPathIsNotNull().andUrlIsNotNull().andLevelEqualTo("0");
        tMenuInfoList.addAll(tMenuInfoMapper.selectByExample(tMenuInfoExample));

        List<TMenuInfo> uniqueList = tMenuInfoList.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparing(TMenuInfo::getId))), ArrayList::new)
        );
        return uniqueList;
    }

    @Override
    public List<TMenuInfo> getMenuByPage(int pageSize, int pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.getLocalPage();
        return tMenuInfoMapper.selectByExample(new TMenuInfoExample());
    }

    @Override
    public PageInfo<UserSearchResult> getUserInfoByCondition(UserParam userParam, int pageSize, int pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserSearchResult> userSearchResults = tUserInfoMapper.getUserInfoByCondition(userParam);
        PageInfo<UserSearchResult> page = new PageInfo<>(userSearchResults);
       return new PageInfo<>(userSearchResults);
    }

    @Override
    public DeptAndRoleInfoResponse getDeptAndRoleInfo(String hosCode) {
        DeptAndRoleInfoResponse deptAndRoleInfoResponse = new DeptAndRoleInfoResponse();
        List<Map<String,String>> deptList = new ArrayList<>();
        List<Map<String,String>> roleList = new ArrayList<>();
        TDeptInfoExample tDeptInfoExample = new TDeptInfoExample();
        TDeptInfoExample.Criteria criteria = tDeptInfoExample.createCriteria();
        criteria.andHosCodeEqualTo(hosCode);
        List<TDeptInfo> tDeptInfos = tDeptInfoMapper.selectByExample(tDeptInfoExample);
        if(!ObjectUtils.isEmpty(tDeptInfos)){
            tDeptInfos.forEach(tDeptInfo -> {
                Map<String,String> deptMap = new HashMap<String,String>();
                deptMap.put("deptName",tDeptInfo.getDeptName());
                deptMap.put("deptCode",tDeptInfo.getDeptCode());
                deptList.add(deptMap);
            });
        }
        TRoleInfoExample tRoleInfoExample = new TRoleInfoExample();
        TRoleInfoExample.Criteria criteria1 = tRoleInfoExample.createCriteria();
        List<TRoleInfo> tRoleInfos = tRoleInfoMapper.selectByExample(tRoleInfoExample);
        if(!ObjectUtils.isEmpty(tRoleInfos)){
            tRoleInfos.forEach(tRoleInfo -> {
                Map<String,String> roleMap = new HashMap<String,String>();
                roleMap.put("roleName",tRoleInfo.getRoleName());
                roleMap.put("roleId",tRoleInfo.getId());
                roleList.add(roleMap);

            });
        }
        deptAndRoleInfoResponse.setDeptInfo(deptList);
        deptAndRoleInfoResponse.setRoleInfo(roleList);
        return deptAndRoleInfoResponse;
    }

    @Transactional
    @Override
    public UserAddOrUpdateParams saveOrUpdateUserInfo(UserAddOrUpdateParams userAddOrUpdateParams) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            TUserInfo tUserInfo = new TUserInfo();
            tUserInfo.setId(userAddOrUpdateParams.getId());
            tUserInfo.setName(userAddOrUpdateParams.getName());
            tUserInfo.setPassword(DigestUtils.md5Hex(userAddOrUpdateParams.getPassword()));
            tUserInfo.setPhone(userAddOrUpdateParams.getPhone());
            tUserInfo.setRoleId(userAddOrUpdateParams.getRoleId());
            tUserInfo.setSex(userAddOrUpdateParams.getSex());
            tUserInfo.setUserCode(userAddOrUpdateParams.getUserCode());
            tUserInfo.setHosCode(userAddOrUpdateParams.getHosCode());
            tUserInfo.setUsername(userAddOrUpdateParams.getUsername());
            tUserInfo.setState(userAddOrUpdateParams.getState());
            if(!StringUtils.isEmpty(userAddOrUpdateParams.getEntryTime())){
                tUserInfo.setEntryTime(sdf.parse(userAddOrUpdateParams.getEntryTime()));
            }
            if (StringUtils.isEmpty(tUserInfo.getId())) {
                tUserInfo.setId(UUIDUtils.getUUID());
                tUserInfo.setCreateUser(userAddOrUpdateParams.getCreateUser());
                tUserInfo.setCreateTime(new Date());
                tUserInfoMapper.insert(tUserInfo);
                if(!ObjectUtils.isEmpty(userAddOrUpdateParams.getDeptCode())) {
                    updateUserDeptByDeptCode(tUserInfo, userAddOrUpdateParams.getDeptCode());
                }
            } else {
                tUserInfo.setModifyUser(userAddOrUpdateParams.getModifyUser());
                tUserInfo.setModifyTime(new Date());
                tUserInfoMapper.updateByPrimaryKeySelective(tUserInfo);
                if(!ObjectUtils.isEmpty(userAddOrUpdateParams.getDeptCode())) {
                    TUserDeptExample tUserDeptExample = new TUserDeptExample();
                    TUserDeptExample.Criteria criteria = tUserDeptExample.createCriteria();
                    criteria.andUserIdEqualTo(tUserInfo.getId());
                    tUserDeptMapper.deleteByExample(tUserDeptExample);
                    updateUserDeptByDeptCode(tUserInfo, userAddOrUpdateParams.getDeptCode());
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return userAddOrUpdateParams;
    }

    @Override
    public int changUserStateById(String userId) {
        TUserInfo tUserInfo = tUserInfoMapper.selectByPrimaryKey(userId);
        tUserInfo.setState("0".equals(tUserInfo.getState())?"1":"0");
        return tUserInfoMapper.updateByPrimaryKey(tUserInfo);
    }

    @Override
    public int resetPassword(String userId) {
        TUserInfo tUserInfo = new TUserInfo();
        tUserInfo.setId(userId);
        tUserInfo.setPassword(DigestUtils.md5Hex("888888"));
        return tUserInfoMapper.updateByPrimaryKeySelective(tUserInfo);
    }

    public void updateUserDeptByDeptCode(TUserInfo tUserInfo,String deptCode){
            TUserDept tUserDept = new TUserDept();
            tUserDept.setId(UUIDUtils.getUUID());
            tUserDept.setUserId(tUserInfo.getId());
            tUserDept.setDeptCode(deptCode);
            tUserDeptMapper.insert(tUserDept);
    }


    /**
     * 用户登录
     *
     * @param userCode
     * @param password
     * @return
     */
    private TUserInfo getUserInfo(String userCode, String password) {
        TUserInfoExample tUserInfoExample = new TUserInfoExample();
        TUserInfoExample.Criteria tUserCriteria = tUserInfoExample.createCriteria();
        tUserCriteria.andUserCodeEqualTo(userCode);
        tUserCriteria.andPasswordEqualTo(password);

        List<TUserInfo> tUserInfoList = tUserInfoMapper.selectByExample(tUserInfoExample);
        if (CollectionUtils.isEmpty(tUserInfoList))
            throw new BusinessException("用户名密码错误");
        return tUserInfoList.get(0);
    }

    private static final String IS_ACCESS_ROLE = "1";

    private List<TRoleInfo> getRoleInfoList(String roleId) {
        TRoleInfoExample tRoleInfoExample = new TRoleInfoExample();
        TRoleInfoExample.Criteria criteria = tRoleInfoExample.createCriteria();
        criteria.andIdEqualTo(roleId);
        criteria.andEnabledEqualTo(IS_ACCESS_ROLE);
        return tRoleInfoMapper.selectByExample(tRoleInfoExample);
    }

    private void saveRefreshToken(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        Map<String, Claim> claimMap = decodedJWT.getClaims();
        String userKey = claimMap.get("userkey").asString();
        //删除数据库中过期或者同Key数据
        TLoginTokenExample tLoginTokenExample = new TLoginTokenExample();
        tLoginTokenExample.or().andExpireTimeLessThanOrEqualTo(new Date());
        tLoginTokenExample.or().andUserKeyEqualTo(userKey);
        tLoginTokenMapper.deleteByExample(tLoginTokenExample);

        //生成登录记录
        TLoginToken tLoginToken = new TLoginToken();
        tLoginToken.setId(UUIDUtils.getUUID());
        tLoginToken.setRefreshToken(token);
        tLoginToken.setUserKey(userKey);
        tLoginToken.setExpireTime(getRefreshTokenExpire());
        System.out.println(token.length());
        tLoginTokenMapper.insert(tLoginToken);
    }

    /**
     * 获取过期时间
     *
     * @return
     */
    private Date getRefreshTokenExpire() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, refreshTokenDays);
        calendar.add(Calendar.HOUR, refreshTokenHours);
        calendar.add(Calendar.MINUTE, refreshTokenMinutes);
        return calendar.getTime();
    }
}
