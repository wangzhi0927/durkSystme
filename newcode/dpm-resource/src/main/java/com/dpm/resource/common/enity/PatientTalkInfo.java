package com.dpm.resource.common.enity;

import lombok.Data;

import java.util.List;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/18
 * @Description:
 */
@Data
public class PatientTalkInfo {
    private String recordId;
    private String narcoticId;
    private String operId;
    private List<TalkInfo> talkInfoList;
}
