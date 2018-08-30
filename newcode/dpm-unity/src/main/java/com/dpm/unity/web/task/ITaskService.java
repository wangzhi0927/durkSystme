package com.dpm.unity.web.task;

import java.util.List;

import com.dpm.resource.common.enity.TalkRecordInfo;

public interface ITaskService {

	void createAndUploadSQWTS(String filePath, TalkRecordInfo talkRecordInfo,List<String> idList);

}
