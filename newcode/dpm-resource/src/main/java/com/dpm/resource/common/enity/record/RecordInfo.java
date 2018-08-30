package com.dpm.resource.common.enity.record;

import com.dpm.resource.common.enity.THospitalInfo;
import com.dpm.resource.common.enity.TRecordInfo;

import lombok.Data;

@Data
public class RecordInfo extends TRecordInfo{
	private THospitalInfo hospitalInfo;
}
