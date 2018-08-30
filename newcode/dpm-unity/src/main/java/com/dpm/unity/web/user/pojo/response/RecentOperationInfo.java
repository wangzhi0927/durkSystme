package com.dpm.unity.web.user.pojo.response;

import lombok.Data;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/17
 * @Description:
 */

public class RecentOperationInfo {
    private String diagCode;
    private String diagName;
    private String talkType;
    private String narcoticId;
    private String operation;

    public String getDiagCode() {
        return diagCode;
    }

    public RecentOperationInfo setDiagCode(String diagCode) {
        this.diagCode = diagCode;
        return this;
    }

    public String getDiagName() {
        return diagName;
    }

    public RecentOperationInfo setDiagName(String diagName) {
        this.diagName = diagName;
        return this;
    }

    public String getTalkType() {
        return talkType;
    }

    public RecentOperationInfo setTalkType(String talkType) {
        this.talkType = talkType;
        return this;
    }

    public String getNarcoticId() {
        return narcoticId;
    }

    public RecentOperationInfo setNarcoticId(String narcoticId) {
        this.narcoticId = narcoticId;
        return this;
    }

    public String getOperation() {
        return operation;
    }

    public RecentOperationInfo setOperation(String operation) {
        this.operation = operation;
        return this;
    }

}
