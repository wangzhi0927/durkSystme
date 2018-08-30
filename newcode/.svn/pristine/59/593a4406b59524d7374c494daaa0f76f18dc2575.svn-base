package com.dpm.unity.web.patient.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dpm.resource.common.constants.CommonCons;
import com.dpm.resource.common.enity.FileResult;
import com.dpm.resource.common.enity.HisPatientRecord;
import com.dpm.resource.common.enity.PatientTalkInfo;
import com.dpm.resource.common.enity.TCaseInfo;
import com.dpm.resource.common.enity.TDiseaseInfo;
import com.dpm.resource.common.enity.TPatientTalk;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.common.enity.TalkInfo;
import com.dpm.resource.common.enity.TalkRecordInfo;
import com.dpm.resource.common.utils.BASE64DecodedMultipartFile;
import com.dpm.resource.common.utils.DateUtil;
import com.dpm.resource.common.utils.FtpUtils;
import com.dpm.resource.common.utils.UUIDUtils;
import com.dpm.resource.freamwork.BusinessException;
import com.dpm.unity.common.validation.ValidationProperty;
import com.dpm.unity.web.feigns.IDiseaseFeignClient;
import com.dpm.unity.web.feigns.IPatientFeignClient;
import com.dpm.unity.web.his.service.IRemoteHisClient;
import com.dpm.unity.web.his.service.impl.RemoteRouterServiceFactory;
import com.dpm.unity.web.patient.pojo.request.GetAnamnesisByInpNoRequestData;
import com.dpm.unity.web.patient.pojo.request.GetOperationInfoRequestData;
import com.dpm.unity.web.patient.pojo.response.GetAnamnesisByInpNoResponseData;
import com.dpm.unity.web.patient.pojo.response.GetOperationInfoResponseData;
import com.dpm.unity.web.patient.service.IPatientService;
import com.dpm.unity.web.task.ITaskServiceImpl;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/18
 * @Description:
 */
@Service
public class PatientServiceImpl implements IPatientService {
	@Autowired
	private IPatientFeignClient iPatientFeignClient;

	@Autowired
	private IDiseaseFeignClient IDiseaseFeignClient;

	@Autowired
	private RemoteRouterServiceFactory remoteRouterServiceFactory;

	@Autowired
    private ITaskServiceImpl taskService;
	
	@Autowired
	private FtpUtils ftpUtils;

	@Override
	public GetAnamnesisByInpNoResponseData getAnamnesisByInpNo(
			GetAnamnesisByInpNoRequestData getAnamnesisByInpNoRequestData) throws Exception {
		String checkResult = ValidationProperty.validate(getAnamnesisByInpNoRequestData,
				ValidationProperty.GetAnamnesisByInpNoCheckParams);
		if (!StringUtils.isEmpty(checkResult))
			throw new BusinessException("以下请求入参不可为空：" + checkResult);
		IRemoteHisClient remoteHisClient = remoteRouterServiceFactory
				.createRemoteHisClientService(getAnamnesisByInpNoRequestData.getHosCode());
		HisPatientRecord hisPatientRecord = remoteHisClient.getPatientRecord(
				getAnamnesisByInpNoRequestData.getHosCode(), getAnamnesisByInpNoRequestData.getInpNo());
		if (hisPatientRecord == null)
			throw new BusinessException("没有获取到对应的病人信息");
		String icd10 = hisPatientRecord.getRecordInfo().getDiagNo();
		TDiseaseInfo diseaseInfo = new TDiseaseInfo();
		diseaseInfo.setIcd10(icd10);

		GetAnamnesisByInpNoResponseData responseData = new GetAnamnesisByInpNoResponseData();
		responseData.setRecordId(hisPatientRecord.getRecordInfo().getId());
		responseData.setAge(hisPatientRecord.getRecordInfo().getAge());
		responseData.setInpNo(hisPatientRecord.getRecordInfo().getInpNo());
		responseData.setDiagNo(hisPatientRecord.getRecordInfo().getDiagNo());
		responseData.setDiagName(hisPatientRecord.getRecordInfo().getDiagName());
		responseData.setSex(hisPatientRecord.getRecordInfo().getSex());
		responseData.setPatientName(hisPatientRecord.getPatientInfo().getPatientName());
		responseData.setDeptName(hisPatientRecord.getRecordInfo().getDeptName());
		responseData.setWardName(hisPatientRecord.getRecordInfo().getWardName());
		responseData.setBedNo(hisPatientRecord.getRecordInfo().getBedNo());
		responseData.setRecordId(hisPatientRecord.getRecordInfo().getId());
		responseData.setIdNo(hisPatientRecord.getPatientInfo().getIdNo());
		List<TDiseaseInfo> diseaseInfoList = IDiseaseFeignClient.getDiseaseInfoByConditions(diseaseInfo);
		if (!ObjectUtils.isEmpty(diseaseInfoList)) {
			responseData.setDiseaseCode(diseaseInfoList.get(0).getDiseaseCode());
		}
		return responseData;
	}

	@Override
	public GetOperationInfoResponseData getOperationInfo(GetOperationInfoRequestData getOperationInfoRequestData) {
		String checkResult = ValidationProperty.validate(getOperationInfoRequestData,
				ValidationProperty.GetOperationInfoCheckParams);
		if (!StringUtils.isEmpty(checkResult))
			throw new BusinessException("以下请求入参不可为空：" + checkResult);
		List<TCaseInfo> tCaseInfos = iPatientFeignClient.getOperationInfo(getOperationInfoRequestData.getCode());
		GetOperationInfoResponseData responseData = new GetOperationInfoResponseData();
		responseData.setOperationInfo(tCaseInfos);
		return responseData;
	}

	@Override
	public int savePatientTalkInfo(PatientTalkInfo patientTalkInfo) {
		String checkResult = ValidationProperty.validate(patientTalkInfo,
				ValidationProperty.SavePatientTalkInfoCheckParams);
		if (!StringUtils.isEmpty(checkResult))
			throw new BusinessException("以下请求入参不可为空：" + checkResult);
		patientTalkInfo.getTalkInfoList().forEach(talkInfo -> {
			String talkInfoParams = ValidationProperty.validate(talkInfo, ValidationProperty.TalkInfoCheckParams);
			if (!StringUtils.isEmpty(talkInfoParams))
				throw new BusinessException("以下请求入参不可为空：" + talkInfoParams);
		});
		String uploadPath = CommonCons.UploadPathPrefix.RECORD + "/" + DateUtil.getCurrentDate() + "/"
				+ patientTalkInfo.getRecordId();
		List<TalkInfo> talkInfoList = patientTalkInfo.getTalkInfoList();
		// 谈话人有且只有2位，本人和委托人
		if(ObjectUtils.isEmpty(talkInfoList) || talkInfoList.size() != 2) {
			throw new BusinessException("谈话人信息有误，请确认有且只能有2个人");
		}
			
		List<TPatientTalk> tPatientTalkList = new ArrayList<TPatientTalk>();
		List<String> idList = new ArrayList<String>();
		// 上传身份证
		for (TalkInfo talkInfo : talkInfoList) {
			String fileName = "";
			List<String> fileList = talkInfo.getIdfileList();
			if(ObjectUtils.isEmpty(fileList) || fileList.size() != 2) {
				throw new BusinessException("请确认每个谈话人必须且只能上传2张身份证照片");
			}
			idList.addAll(fileList);
			for (String file : fileList) {
				MultipartFile[] files = new MultipartFile[] { BASE64DecodedMultipartFile.base64ToMultipart(file) };
				List<FileResult> fileResultList = ftpUtils.uploadFile(files, uploadPath);
				for (FileResult result : fileResultList) {
					fileName = fileName + result.getName() + ",";
				}
			}
			TPatientTalk tPatientTalk = new TPatientTalk();
			tPatientTalk.setId(UUIDUtils.getUUID());
			tPatientTalk.setTalkName(talkInfo.getTalkName());
			tPatientTalk.setRelationshipId(talkInfo.getRelationshipId());
			tPatientTalk.setAge(talkInfo.getAge());
			tPatientTalk.setSex(talkInfo.getSex());
			tPatientTalk.setIdNo(talkInfo.getIdNo());
			tPatientTalk.setIdFilePath(ftpUtils.getFilePath(uploadPath));
			tPatientTalk.setIdFileName(fileName);
			tPatientTalk.setRecordId(patientTalkInfo.getRecordId());
			tPatientTalk.setCreateTime(new Date());
			tPatientTalkList.add(tPatientTalk);
		}
		
		TRecordInfo tRecordInfo = new TRecordInfo();
		tRecordInfo.setId(patientTalkInfo.getRecordId());
		tRecordInfo.setNarcoticId(patientTalkInfo.getNarcoticId());
		tRecordInfo.setOperation(patientTalkInfo.getOperId());
		tRecordInfo.setUploadTime(new Date());
		tRecordInfo.setFoldPath(ftpUtils.getFilePath(uploadPath));
		
		TalkRecordInfo talkRecordInfo = new TalkRecordInfo();
		talkRecordInfo.setTPatientTalkList(tPatientTalkList);
		talkRecordInfo.setTRecordInfo(tRecordInfo);
		int i = iPatientFeignClient.savePatientTalkInfo(talkRecordInfo);
		
		// 创建并上传授权委托书
		taskService.createAndUploadSQWTS(uploadPath, talkRecordInfo, idList);
		return i;
	}
	
}
