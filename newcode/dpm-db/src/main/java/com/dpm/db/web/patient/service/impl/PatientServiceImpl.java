package com.dpm.db.web.patient.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.dpm.db.common.example.TCaseInfoExample;
import com.dpm.db.common.example.TDeptInfoExample;
import com.dpm.db.common.example.TPatientInfoExample;
import com.dpm.db.common.example.TPatientTalkExample;
import com.dpm.db.common.example.TRecordInfoExample;
import com.dpm.db.common.example.TUserDeptExample;
import com.dpm.db.common.example.TUserInfoExample;
import com.dpm.db.common.mapper.TCaseInfoMapper;
import com.dpm.db.common.mapper.TDeptInfoMapper;
import com.dpm.db.common.mapper.TPatientInfoMapper;
import com.dpm.db.common.mapper.TPatientTalkMapper;
import com.dpm.db.common.mapper.TRecordInfoMapper;
import com.dpm.db.common.mapper.TUserDeptMapper;
import com.dpm.db.common.mapper.TUserInfoMapper;
import com.dpm.db.web.patient.service.IPatientService;
import com.dpm.resource.common.enity.HisPatientRecord;
import com.dpm.resource.common.enity.TCaseInfo;
import com.dpm.resource.common.enity.TDeptInfo;
import com.dpm.resource.common.enity.TPatientInfo;
import com.dpm.resource.common.enity.TPatientTalk;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.common.enity.TUserDept;
import com.dpm.resource.common.enity.TUserInfo;
import com.dpm.resource.common.enity.TalkRecordInfo;
import com.dpm.resource.common.enity.UserDeptInfo;
import com.dpm.resource.common.enity.record.RecordInfo;
import com.dpm.resource.common.utils.UUIDUtils;

/**
 * @ Purpose:
 * 
 * @Package Name: com.dpm.db.web.user.service.impl
 * @Author: liuxiaoxin
 * @Date: 2018/5/14
 */
@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	TPatientInfoMapper tPatientInfoMapper;
	@Autowired
	TRecordInfoMapper tRecordInfoMapper;
	@Autowired
	TUserInfoMapper tUserInfoMapper;
	@Autowired
	TUserDeptMapper tUserDeptMapper;
	@Autowired
	TDeptInfoMapper tDeptInfoMapper;
	@Autowired
	TCaseInfoMapper tCaseInfoMapper;
	@Autowired
	TPatientTalkMapper tPatientTalkMapper;

	@Transactional
	@Override
	public HisPatientRecord saveHisPatientRecord(HisPatientRecord hisPatientRecord) {
		hisPatientRecord.setPatientInfo(savePatientInfo(hisPatientRecord.getPatientInfo()));
		hisPatientRecord.setRecordInfo(insertPatientRecordInfo(hisPatientRecord.getRecordInfo()));
		return hisPatientRecord;
	}

	@Transactional
	@Override
	public UserDeptInfo saveUserDeptInfo(UserDeptInfo userDeptInfo) {
		// 保存用户信息
		saveUserInfo(userDeptInfo);
		// 保存用户科室信息
		userDeptInfo.setUserDept(saveUserDept(userDeptInfo.getUserDept()));
		saveUserDept(userDeptInfo.getUserDept());
		// 保存科室信息
		if (!CollectionUtils.isEmpty(userDeptInfo.getDeptInfo())) {
		}
		return userDeptInfo;
	}

	@Override
	public List<TCaseInfo> getOperationInfo(String code) {
		TCaseInfoExample tCaseInfoExample = new TCaseInfoExample();
		TCaseInfoExample.Criteria criteria = tCaseInfoExample.createCriteria();
		criteria.andTypeEqualTo("1");
		criteria.andPCodeLike(code + "%");
		TCaseInfoExample.Criteria criteria1 = tCaseInfoExample.createCriteria();
		criteria1.andTypeEqualTo("1");
		criteria1.andFCodeLike(code + "%");
		tCaseInfoExample.or(criteria);
		tCaseInfoExample.or(criteria1);
		List<TCaseInfo> tCaseInfos = tCaseInfoMapper.selectByExample(tCaseInfoExample);
		return tCaseInfos;
	}

	@Transactional
	@Override
	public int savePatientTalkInfo(TalkRecordInfo talkRecordInfo) {
		int i = 0;
		if (!ObjectUtils.isEmpty(talkRecordInfo)) {
			tRecordInfoMapper.updateByPrimaryKeySelective(talkRecordInfo.getTRecordInfo());
			for (TPatientTalk tPatientTalk : talkRecordInfo.getTPatientTalkList()) {
				i = tPatientTalkMapper.insert(tPatientTalk);
			}
		}
		return i;
	}

	private List<TDeptInfo> saveDeptInfo(List<TDeptInfo> deptInfoList) {
		if (!CollectionUtils.isEmpty(deptInfoList)) {
			deptInfoList.parallelStream().forEach(kk -> {
				TDeptInfoExample tDeptInfoExample = new TDeptInfoExample();
				TDeptInfoExample.Criteria criteria = tDeptInfoExample.createCriteria();
				criteria.andDeptCodeEqualTo(kk.getDeptCode());
				criteria.andHosCodeEqualTo(kk.getHosCode());
				List<TDeptInfo> deptInfos = tDeptInfoMapper.selectByExample(tDeptInfoExample);
				if (CollectionUtils.isEmpty(deptInfos)) {
					kk.setId(UUIDUtils.getUUID());
					tDeptInfoMapper.insert(kk);
				} else {
					kk.setId(deptInfos.get(0).getId());
					tDeptInfoMapper.updateByPrimaryKey(kk);
				}
			});
		}
		return deptInfoList;
	}

	private List<TUserDept> saveUserDept(List<TUserDept> userDept) {
		if (!CollectionUtils.isEmpty(userDept)) {
			userDept.parallelStream().forEach(kk -> {
				TUserDeptExample tUserDeptExample = new TUserDeptExample();
				TUserDeptExample.Criteria criteria = tUserDeptExample.createCriteria();
				criteria.andUserIdEqualTo(kk.getUserId());
				criteria.andDeptCodeEqualTo(kk.getDeptCode());
				List<TUserDept> userDeptList = tUserDeptMapper.selectByExample(tUserDeptExample);
				if (CollectionUtils.isEmpty(userDept)) {
					kk.setId(UUIDUtils.getUUID());
					tUserDeptMapper.insert(kk);
				} else {
					kk.setId(userDeptList.get(0).getId());
					tUserDeptMapper.updateByPrimaryKey(kk);
				}
			});
		}
		return userDept;
	}

	private UserDeptInfo saveUserInfo(UserDeptInfo userDeptInfo) {
		if (!ObjectUtils.isEmpty(userDeptInfo) && !CollectionUtils.isEmpty(userDeptInfo.getUserInfo())) {
			TUserInfoExample tUserInfoExample = new TUserInfoExample();
			TUserInfoExample.Criteria criteria = tUserInfoExample.createCriteria();
			criteria.andHosCodeEqualTo(userDeptInfo.getUserInfo().get(0).getHosCode());
			List<TUserInfo> tUserInfoList = tUserInfoMapper.selectByExample(tUserInfoExample);
			userDeptInfo.getUserInfo().parallelStream().forEach(ii -> {
				if (!CollectionUtils.isEmpty(tUserInfoList)) {
					Optional<TUserInfo> tUserInfo = tUserInfoList.stream().filter(
							kk -> kk.getHosCode().equals(ii.getHosCode()) && kk.getUserCode().equals(ii.getUserCode()))
							.findAny();
					if (tUserInfo.isPresent()) {
						ii.setId(tUserInfo.get().getId());
						tUserInfoMapper.updateByPrimaryKey(ii);
					} else {
						ii.setId(UUIDUtils.getUUID());
						tUserInfoMapper.insert(ii);
					}
					if (!CollectionUtils.isEmpty(userDeptInfo.getUserDept())) {
						userDeptInfo.getUserDept().stream().filter(k -> k.getUserId().equals(ii.getUserCode()))
								.forEach(m -> m.setUserId(ii.getId()));
					}
				}
			});
		}
		return userDeptInfo;
	}

	/**
	 * 保存病人信息，若数据库身份证对应有数据则更新字段信息
	 *
	 * @param tPatientInfo
	 * @return
	 */
	public TPatientInfo savePatientInfo(TPatientInfo tPatientInfo) {

		TPatientInfoExample patientInfoExample = new TPatientInfoExample();
		TPatientInfoExample.Criteria criteria = patientInfoExample.createCriteria();
		criteria.andIdNoEqualTo(tPatientInfo.getIdNo());
		criteria.andHosCodeEqualTo(tPatientInfo.getHosCode());
		List<TPatientInfo> patientInfoList = tPatientInfoMapper.selectByExample(patientInfoExample);
		// 更新数据
		if (!CollectionUtils.isEmpty(patientInfoList)) {
			patientInfoExample.clear();
			criteria.andIdEqualTo(patientInfoList.get(0).getId());
			tPatientInfoMapper.updateByExampleSelective(tPatientInfo, patientInfoExample);
			return tPatientInfoMapper.selectByPrimaryKey(patientInfoList.get(0).getId());
		} else {
			tPatientInfo.setId(UUIDUtils.getUUID());
			tPatientInfoMapper.insert(tPatientInfo);
		}
		return tPatientInfo;
	}

	public TRecordInfo insertPatientRecordInfo(TRecordInfo recordInfo) {
		recordInfo.setId(UUIDUtils.getUUID());
		tRecordInfoMapper.insert(recordInfo);
		return recordInfo;
	}

	@Override
	public List<TPatientTalk> getPatientTalkInfoList(TPatientTalk tPatientTalk) {
		TPatientTalkExample example = new TPatientTalkExample();
		TPatientTalkExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(tPatientTalk.getRecordId())) {
			criteria.andRecordIdEqualTo(tPatientTalk.getRecordId());
		}
		if (StringUtils.isNotEmpty(tPatientTalk.getId())) {
			criteria.andIdEqualTo(tPatientTalk.getId());
		}
		return tPatientTalkMapper.selectByExample(example);
	}

	@Override
	public List<TRecordInfo> getRecordInfoList(TRecordInfo tRecordInfo) {
		TRecordInfoExample example = new TRecordInfoExample();
		TRecordInfoExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(tRecordInfo.getId())) {
			criteria.andIdEqualTo(tRecordInfo.getId());
		}
		return tRecordInfoMapper.selectByExample(example);
	}

	@Override
	public List<RecordInfo> getRecordInfoByCondition(TRecordInfo tRecordInfo) {
		TRecordInfoExample example = new TRecordInfoExample();
		TRecordInfoExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotEmpty(tRecordInfo.getId())) {
			criteria.andIdEqualTo(tRecordInfo.getId());
		}
		return tRecordInfoMapper.selectRecHosByExample(example);
	}
}
