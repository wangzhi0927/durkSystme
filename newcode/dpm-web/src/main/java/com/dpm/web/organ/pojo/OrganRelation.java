package com.dpm.web.organ.pojo;

import java.util.List;
import java.util.Map;

import com.dpm.resource.common.enity.TOrganRelviewResource;
import com.dpm.resource.common.enity.TResourceInfo;

import lombok.Data;

@Data
public class OrganRelation {
	Map<String, String> sysInfo;
	
	List<TResourceInfo> modelList;
	
	List<TResourceInfo> relModelList;
	
	List<TOrganRelviewResource> tOrganRelviewResourceList;
}
