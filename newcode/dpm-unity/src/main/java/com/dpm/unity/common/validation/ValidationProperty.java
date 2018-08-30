package com.dpm.unity.common.validation;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/15
 * @Description:请求参数验证
 */
public class ValidationProperty {

    /**
     * 获取系统下对应的器官请求参数验证
     */
   public static final String[] GetOrganInfoBySystemCheckParams = {"systemId"};

   public static final String[] GetOrganInfoByOrganCheckParams = {"organCode"};

   public static final String[] GetDiseaseInfoByOrganCheckParams = {"organCode"};

   public static final String[] GetRscInfoByOrganCheckParams = {"organCode","displayRate"};

   public static final String[] GetRscInfoByDiseaseCheckParams = {"diseaseCode","displayRate"};

   public static final String[] GetRscInfoByRscCheckParams = {"resourceId","displayRate"};

   public static final String[] GetModeDisplayParamCheckParams = {"resourceId","displayRate"};

   public static final String[] GetCaseInfoByDiseaseCheckParams = {"diseaseCode","platform"};

   public static final String[] GetCaseInfoByCaseIdCheckParams = {"caseId"};

   public static final String[] GetPatientRecordInfoCheckParams = {"inpNo","hosCode"};

   public static final String[] SaveTalkRecordInfoCheckParams = {"id","talkType","foldPath","userId"};

   public static final String[] GetRecentOperationsCheckParams = {"patientId"};

    public static final String[] GetAnamnesisByInpNoCheckParams = {"inpNo","hosCode"};

    public static final String[] GetOperationInfoCheckParams = {"code"};

    public static final String[] SavePatientTalkInfoCheckParams = {"recordId"};

    public static final String[] TalkInfoCheckParams = {"talkName","idNo","idfileList"};

    public static final String[] FileUploadCheckParams = {"type","recordId","inpNo"};

    public static final String[] GetTnmInfoByDiseaseCheckParams = {"diseaseCode"};

   /** 
   * @Description: 验证请求参数
   * @Param: [reqData, checkParms] 
   * @return: java.lang.String 
   * @Author: mapengfei 
   * @Date: 2018/5/15 
   */ 
    public static String validate(Object reqData,String[] checkParms) {
        StringBuilder sb = new StringBuilder();
        JSONObject checkData;
        String result = null;
        if (!ObjectUtils.isEmpty(reqData)) {
            checkData = (JSONObject) JSONObject.toJSON(reqData);
            for (String str : checkParms) {
                if (checkData.containsKey(str) && StringUtils.isEmpty(checkData.get(str))) {
                    sb.append(str).append(",");
                }
            }
        }
        if(!ObjectUtils.isEmpty(sb)){
            result = sb.substring(0,sb.length()-1);
        }
        return result;
    }

}
