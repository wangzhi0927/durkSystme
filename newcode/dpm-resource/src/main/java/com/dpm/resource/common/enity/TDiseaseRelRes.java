package com.dpm.resource.common.enity;

import lombok.Data;

@Data
public class TDiseaseRelRes {
    private String id;

    private String platform;

    private String resId;
    
    private String diseaseId;
    
    private TResourceInfo resourceInfo;

}