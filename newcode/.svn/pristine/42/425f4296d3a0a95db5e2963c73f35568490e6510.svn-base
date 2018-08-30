package com.dpm.unity.web.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.dpm.resource.common.constants.CommonCons.DictCode;
import com.dpm.resource.common.enity.TPatientTalk;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.common.enity.TalkRecordInfo;
import com.dpm.resource.common.enity.record.RecordInfo;
import com.dpm.resource.common.utils.DateUtil;
import com.dpm.resource.common.utils.FtpUtils;
import com.dpm.unity.common.utils.FileUtils;
import com.dpm.unity.web.feigns.IPatientFeignClient;

@Service
public class ITaskServiceImpl implements ITaskService {

	private static Logger logger = LoggerFactory.getLogger(ITaskServiceImpl.class);

	@Autowired
	private FtpUtils ftpUtils;

	@Autowired
	private IPatientFeignClient iPatientFeignClient;

	/**
	 * 创建并上传授权委托书
	 * 
	 * @param filePath
	 */
	@Async
	@Override
	public void createAndUploadSQWTS(String filePath, TalkRecordInfo talkRecordInfo, List<String> idList) {
		if (ObjectUtils.isEmpty(talkRecordInfo) || ObjectUtils.isEmpty(talkRecordInfo.getTPatientTalkList())
				|| ObjectUtils.isEmpty(talkRecordInfo.getTRecordInfo())) {
			logger.error("无法生成授权委托书", talkRecordInfo);
			return;
		}
		logger.info("--------------准备生成授权委托书-----------", talkRecordInfo);
		/** 用于组装word页面需要的数据 */
		Map<String, Object> dataMap = new HashMap<String, Object>();

		List<TPatientTalk> tPatientTalkList = talkRecordInfo.getTPatientTalkList();
		TRecordInfo tRecordInfo = talkRecordInfo.getTRecordInfo();
		List<RecordInfo> recordInfoList = iPatientFeignClient.getRecordInfoByCondition(tRecordInfo);
		if (ObjectUtils.isEmpty(recordInfoList)) {
			logger.error("沟通记录数据有误", tRecordInfo);
			return;
		}
		RecordInfo recodeInfo = recordInfoList.get(0);
		logger.info("--------------recodeId=" + recodeInfo.getId(), talkRecordInfo);
		for (TPatientTalk tPatientTalk : tPatientTalkList) {
			String rel = tPatientTalk.getRelationshipId();
			if (DictCode.ME.getValue().equals(rel)) {
				dataMap.put("patientName", tPatientTalk.getTalkName());
				dataMap.put("sex", tPatientTalk.getSex());
				dataMap.put("age", tPatientTalk.getAge());
				dataMap.put("patientIdNo", tPatientTalk.getIdNo());
			} else {
				dataMap.put("talkName", tPatientTalk.getTalkName());
				dataMap.put("talkSex", tPatientTalk.getSex());
				dataMap.put("talkAge", tPatientTalk.getAge());
				dataMap.put("talkIdNo", tPatientTalk.getIdNo());
			}
		}
		dataMap.put("hospitalName", recodeInfo.getHospitalInfo().getName());
		dataMap.put("wardCode", StringUtils.isEmpty(recodeInfo.getWardCode()) ? "" : recodeInfo.getWardCode());
		dataMap.put("bedNo", StringUtils.isEmpty(recodeInfo.getBedNo()) ? "" : recodeInfo.getBedNo());
		dataMap.put("inpNo", StringUtils.isEmpty(recodeInfo.getInpNo()) ? "" : recodeInfo.getInpNo());

		dataMap.put("year", DateUtil.getCurrentYear());
		dataMap.put("month", DateUtil.getCurrentMonth());
		dataMap.put("day", DateUtil.getCurrentDay());
		dataMap.put("idPics", idList);

		/** 生成word */
		File file = FileUtils.createWord(dataMap, FileUtils.FTL_SQWTS);

		logger.info("--------------准备上传授权委托书-----------", dataMap);

		try {
			ftpUtils.uploadFile(tRecordInfo.getId() + FileUtils.SQWTS_SUFFIX, filePath, new FileInputStream(file));
		} catch (FileNotFoundException e) {
			logger.error("要上传的授权委托书文件不存在", e);
		}
		logger.info("--------------成功生成并上传授权委托书-----------");
	}

}
