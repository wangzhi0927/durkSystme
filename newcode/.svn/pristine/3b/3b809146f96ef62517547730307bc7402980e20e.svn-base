package com.dpm.db.web.dept.service.impl;

import com.dpm.db.common.example.TDeptInfoExample;
import com.dpm.db.common.mapper.TDeptInfoMapper;
import com.dpm.db.common.mapper.TDictDetailMapper;
import com.dpm.db.web.dept.service.IDeptService;
import com.dpm.resource.common.enity.TDeptInfo;
import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.resource.common.enity.TUserInfo;
import com.dpm.resource.common.enity.dept.DeptParam;
import com.dpm.resource.common.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/30
 * @Description:
 */
@Service
public class DeptServiceImpl implements IDeptService {
    @Autowired
    private TDeptInfoMapper tDeptInfoMapper;
    @Override
    public PageInfo<TDeptInfo> getDeptInfoByCondition(TDeptInfo tDeptInfo, int pageSize, int pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        TDeptInfoExample tDeptInfoExample = new TDeptInfoExample();
        TDeptInfoExample.Criteria criteria = tDeptInfoExample.createCriteria();
        if(!ObjectUtils.isEmpty(tDeptInfo)){
            criteria.andHosCodeEqualTo(tDeptInfo.getHosCode());
            if(!StringUtils.isEmpty(tDeptInfo.getDeptName()))
                criteria.andDeptNameLike(tDeptInfo.getDeptName()+"%");
            if(!StringUtils.isEmpty(tDeptInfo.getEnabled()))
                criteria.andEnabledEqualTo(tDeptInfo.getEnabled());
        }
        List<TDeptInfo> tDeptInfos = tDeptInfoMapper.selectByExample(tDeptInfoExample);
        PageInfo<TDeptInfo> page = new PageInfo<>(tDeptInfos);
        return new PageInfo<>(tDeptInfos);
    }

    @Override
    public TDeptInfo saveOrUpdateDeptInfo(TDeptInfo tDeptInfo) {
       if(StringUtils.isEmpty(tDeptInfo.getId())){
           tDeptInfo.setId(UUIDUtils.getUUID());
           String deptCode = tDeptInfoMapper.getMaxDeptCode(tDeptInfo.getHosCode());
           if(StringUtils.isEmpty(deptCode))
               tDeptInfo.setDeptCode("1001");
           else
               tDeptInfo.setDeptCode(String.valueOf(Integer.valueOf(deptCode)+1));
           tDeptInfo.setCreateTime(new Date());
           tDeptInfoMapper.insert(tDeptInfo);
       }else{
           tDeptInfo.setModifyTime(new Date());
           tDeptInfoMapper.updateByPrimaryKey(tDeptInfo);
       }
        return tDeptInfo;
    }

    @Override
    public int changDeptStateById(TDeptInfo tDeptInfo) {
        tDeptInfo.setModifyTime(new Date());
        tDeptInfo.setEnabled("0".equals(tDeptInfo.getEnabled())?"1":"0");
        return tDeptInfoMapper.updateByPrimaryKey(tDeptInfo);
    }
}
