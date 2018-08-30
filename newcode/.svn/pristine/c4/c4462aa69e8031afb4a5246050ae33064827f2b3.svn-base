package com.dpm.unity.web.his.service.impl;

import com.dpm.resource.common.enity.*;
import com.dpm.unity.web.feigns.IPatientFeignClient;
import com.dpm.unity.web.his.service.IRemoteHisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ Purpose:江苏省人民医院HIS服务调用
 * @Package Name: com.dpm.his.service.impl
 * @Author: liuxiaoxin
 * @Date: 2018/5/16
 */
@Service("JssymHisClientImpl")
public class JssymHisClientImpl implements IRemoteHisClient {
    @Autowired
    IPatientFeignClient patientFeignClient;

    @Override
    public HisPatientRecord getPatientRecord(String hosCode, String inpno) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        /*
        由于暂无可调用HIS，具体调用逻辑采用静态数据
        若对方接口为soap webservices 需调用SoapUtils.getWebserviceResponse方法获取具体数据
        若对方接口为restful接口需调用HttpClientUtils内方法
        若对方接口为数据库直连则需要考虑动态数据源切换
         */
        /*
        对HIS数据整理得出所需数据
         */
        HisPatientRecord hisPatientRecord = new HisPatientRecord();
       
        Random rand = new Random();
        int i = rand.nextInt(); //int范围类的随机数
        i = rand.nextInt(100); //生成0-100以内的随机数
        TPatientInfo tPatientInfo = new TPatientInfo();
        TRecordInfo tRecordInfo = new TRecordInfo();
        if("1000001".equals(inpno)){
        	tPatientInfo.setPatientName("张三");
        	tPatientInfo.setSex("1");
	        tPatientInfo.setIdNo("320000000000000001");
	        tRecordInfo.setInpNo("1000001");
	        tRecordInfo.setAge("30");
	        tRecordInfo.setDiagNo("I21.900");
	        tRecordInfo.setDiagName("急性心肌梗死");
	        tRecordInfo.setDeptName("心内科");
	        tRecordInfo.setBedNo("CB101");
	        tRecordInfo.setWardName("1区");
        }else if("1000002".equals(inpno)){
        	tPatientInfo.setPatientName("李四");
        	tPatientInfo.setSex("1");
	        tPatientInfo.setIdNo("320000000000000002");
	        tRecordInfo.setInpNo("1000002");
	        tRecordInfo.setAge("31");
	        tRecordInfo.setDiagNo("I71.000");
	        tRecordInfo.setDiagName("主动脉夹层");
	        tRecordInfo.setDeptName("心胸外科");
	        tRecordInfo.setBedNo("CB102");
	        tRecordInfo.setWardName("1区");
        }
        else if("1000003".equals(inpno)){
        	tPatientInfo.setPatientName("王二");
        	tPatientInfo.setSex("1");
	        tPatientInfo.setIdNo("320000000000000003");
	        tRecordInfo.setInpNo("1000003");
	        tRecordInfo.setAge("32");
	        tRecordInfo.setDiagNo("C73.x00");
	        tRecordInfo.setDiagName("甲状腺癌");
	        tRecordInfo.setDeptName("甲乳外科");
	        tRecordInfo.setBedNo("CB201");
	        tRecordInfo.setWardName("2区");
        }
        else if("1000004".equals(inpno)){
        	tPatientInfo.setPatientName("吴六");
        	tPatientInfo.setSex("2");
	        tPatientInfo.setIdNo("320000000000000004");
	        tRecordInfo.setInpNo("1000004");
	        tRecordInfo.setAge("33");
	        tRecordInfo.setDiagNo("S72.900");
	        tRecordInfo.setDiagName("股骨骨折");
	        tRecordInfo.setDeptName("骨科");
	        tRecordInfo.setBedNo("CB301");
	        tRecordInfo.setWardName("3区");
        }
        else {
	        tPatientInfo.setPatientId("P_" + simpleDateFormat.format(new Date()));
	        tPatientInfo.setPatientName("测试_" + i);
	        tPatientInfo.setSex("1");
	        tPatientInfo.setDateOfBirth(simpleDateFormat.parse("19880824235900"));
	        tPatientInfo.setBloodType("O");
	        tPatientInfo.setIdNo("421023198808245775");
	        tPatientInfo.setMaritalStatus("已婚");
	        tPatientInfo.setAllergyhis("过敏史:对任何事物都过敏");
	        tPatientInfo.setPasthis("既往史:重大疾病");
	
	        tRecordInfo.setPatientId(tPatientInfo.getPatientId());
	        tRecordInfo.setAge("29");
	        tRecordInfo.setBedNo("CB201");
	        tRecordInfo.setDeptCode("3054");
	        tRecordInfo.setDeptName("呼吸科");
	        tRecordInfo.setDiagNo("I905");
	        tRecordInfo.setDiagName("肺癌");
	        tRecordInfo.setInpNo("2061123");
	        tRecordInfo.setSex("1");
        }
        tRecordInfo.setHosCode(hosCode);
        tRecordInfo.setCreateTime(new Date());
        tPatientInfo.setHosCode(hosCode);
        hisPatientRecord.setPatientInfo(tPatientInfo);
        hisPatientRecord.setRecordInfo(tRecordInfo);
        hisPatientRecord = patientFeignClient.savePatientInfo(hisPatientRecord);

        return hisPatientRecord;
    }

    public UserDeptInfo getHisUserInfo(String hosCode) throws Exception {

        UserDeptInfo deptData = new UserDeptInfo();

        List<TUserInfo> tUserInfoList = new ArrayList<>();
        List<String> userNameList = Arrays.asList("user", "lxx", "mpf", "bcm");
        List<TUserDept> tUserDeptList = new ArrayList<>();
        String password = "21218cca77804d2ba1922c33e0151105";
        userNameList.stream().forEach(name -> {
            TUserInfo tUserInfo = new TUserInfo();
            tUserInfo.setUserCode(name);
            tUserInfo.setPassword(password);
            tUserInfo.setHosCode(hosCode);
            tUserInfo.setSex("1");
            tUserInfo.setState("1");
            tUserInfoList.add(tUserInfo);

            TUserDept tUserDept = new TUserDept();
            tUserDept.setUserId(name);
            tUserDept.setDeptCode("3054");
            tUserDeptList.add(tUserDept);
        });
        List<String> deptNameList = Arrays.asList("呼吸科");
        List<TDeptInfo> tDeptInfoList = new ArrayList<>();
        deptNameList.stream().forEach(name -> {
            TDeptInfo tDeptInfo = new TDeptInfo();
            tDeptInfo.setDeptCode("3054");
            tDeptInfo.setDeptName(name);
            tDeptInfo.setHosCode(hosCode);
            tDeptInfo.setComment("sdasdasdasdasdasasd");
            tDeptInfoList.add(tDeptInfo);
        });

        deptData.setDeptInfo(tDeptInfoList);
        deptData.setUserDept(tUserDeptList);
        deptData.setUserInfo(tUserInfoList);
        return deptData;
    }

    @Override
    public void asyncUserDeptInfo(String hosCode) throws Exception {
        UserDeptInfo deptData = getHisUserInfo(hosCode);

    }
}
