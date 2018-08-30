package com.dpm.resource.common.enity;

import java.util.Date;

import lombok.Data;

@Data
public class TPatientTalk {
	private String id;

    private String talkName;

    private String relationshipId;
    
    private String sex;

    private String age;

    private String idNo;

    private String idFilePath;

    private String idFileName;

    private String recordId;

    private Date createTime;
}