package com.dpm.db.web.caseInfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.dpm.db.common.example.TCaseInfoExample;
import com.dpm.db.common.example.TCaseRelResExample;
import com.dpm.db.common.example.TPatientInfoExample;
import com.dpm.db.common.example.TRecordInfoExample;
import com.dpm.db.common.mapper.TCaseInfoMapper;
import com.dpm.db.common.mapper.TCaseRelResMapper;
import com.dpm.db.common.mapper.TPatientInfoMapper;
import com.dpm.db.common.mapper.TRecordInfoMapper;
import com.dpm.db.common.mapper.TResourceInfoMapper;
import com.dpm.db.web.caseInfo.service.ICaseService;
import com.dpm.resource.common.enity.CaseInfo;
import com.dpm.resource.common.enity.PatientRecordInfo;
import com.dpm.resource.common.enity.TCaseInfo;
import com.dpm.resource.common.enity.TCaseRelRes;
import com.dpm.resource.common.enity.TPatientInfo;
import com.dpm.resource.common.enity.TRecordInfo;
import com.dpm.resource.common.enity.TResourceInfo;
import com.dpm.resource.common.enity.caseinfo.CaseInfoParam;
import com.dpm.resource.common.utils.UUIDUtils;
import com.dpm.resource.freamwork.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/16
 * @Description:
 */
@Service
public class CaseServiceImpl implements ICaseService {
    @Autowired
    private TCaseInfoMapper caseInfoMapper;
    @Autowired
    private TResourceInfoMapper resourceInfoMapper;
    @Autowired
    private TRecordInfoMapper tRecordInfoMapper;
    @Autowired
    private TPatientInfoMapper tPatientInfoMapper;
    @Autowired
    private TCaseRelResMapper tCaseRelResMapper;
    
    @Override
    public List<CaseInfo> getCaseInfoByDisease(String diseaseCode) {
        TCaseInfoExample caseInfoExample = new TCaseInfoExample();
        TCaseInfoExample.Criteria criteria = caseInfoExample.createCriteria();
        criteria.andDiseaseCodeEqualTo(diseaseCode);
        List<TCaseInfo> tCaseInfos = caseInfoMapper.selectByExample(caseInfoExample);
        if(!ObjectUtils.isEmpty(tCaseInfos)){
            List<CaseInfo> caseInfos = new ArrayList<CaseInfo>();
            tCaseInfos.forEach(tcaseInfo ->{
                TResourceInfo resourceInfo = null;
                if(!StringUtils.isEmpty(tcaseInfo.getResourceId())){
                     resourceInfo = resourceInfoMapper.selectByPrimaryKey(tcaseInfo.getResourceId());
                }
                CaseInfo caseInfo = new CaseInfo();
                BeanUtils.copyProperties(tcaseInfo,caseInfo);
                caseInfo.setRscInfo(resourceInfo);
                caseInfos.add(caseInfo);
            });
            return caseInfos;
        }
    return null;
    }

    @Override
    public CaseInfo getCaseInfoByCaseId(String caseId) {

        TCaseInfo tCaseInfo = caseInfoMapper.selectByPrimaryKey(caseId);
        if(!ObjectUtils.isEmpty(tCaseInfo)){
            TResourceInfo resourceInfo = null;
            if(!StringUtils.isEmpty(tCaseInfo.getResourceId())){
                resourceInfo = resourceInfoMapper.selectByPrimaryKey(tCaseInfo.getResourceId());
            }
            CaseInfo caseInfo = new CaseInfo();
            BeanUtils.copyProperties(tCaseInfo,caseInfo);
            caseInfo.setRscInfo(resourceInfo);
            return caseInfo;
        }
        return null;
    }

    @Override
    public PatientRecordInfo getPatientRecordInfo(String inpNo, String hosCode, String talkType) {
        TRecordInfoExample tRecordInfoExample = new TRecordInfoExample();
        TRecordInfoExample.Criteria criteria1 = tRecordInfoExample.createCriteria();
        criteria1.andInpNoEqualTo(inpNo);
        criteria1.andHosCodeEqualTo(hosCode);
        if(!StringUtils.isEmpty(talkType))
            criteria1.andTalkTypeEqualTo(talkType);
        List<TRecordInfo> tRecordInfos = tRecordInfoMapper.selectByExample(tRecordInfoExample);
        if(ObjectUtils.isEmpty(tRecordInfos))
            throw new BusinessException("查无病人相关的沟通记录信息");
        TPatientInfoExample tPatientInfoExample = new TPatientInfoExample();
        TPatientInfoExample.Criteria criteria = tPatientInfoExample.createCriteria();
        criteria.andPatientIdEqualTo(tRecordInfos.get(0).getPatientId());
        List<TPatientInfo> tPatientInfos = tPatientInfoMapper.selectByExample(tPatientInfoExample);
        if(ObjectUtils.isEmpty(tPatientInfos))
            return null;
        PatientRecordInfo patientRecordInfo = new PatientRecordInfo();
        BeanUtils.copyProperties(tPatientInfos.get(0),patientRecordInfo);
        patientRecordInfo.setRecordInfo(tRecordInfos);
        return patientRecordInfo;
    }

    @Override
    public int saveTalkRecordInfo(TRecordInfo tRecordInfo) {
        TRecordInfo tRecordInfo1 = tRecordInfoMapper.selectByPrimaryKey(tRecordInfo.getId());
        if(ObjectUtils.isEmpty(tRecordInfo1))
            throw new BusinessException("查无相关的病人信息");
        tRecordInfo.setRecordName(tRecordInfo1.getHosCode()+tRecordInfo1.getInpNo()+tRecordInfo.getTalkType());
        tRecordInfo.setIsfinished("1");
        tRecordInfo.setUploadTime(new java.util.Date());
        return tRecordInfoMapper.updateByPrimaryKeySelective(tRecordInfo);
    }
    
    @Override
	public PageInfo<TCaseInfo> getCaseInfoByCondition(CaseInfoParam caseParam) {
    	PageHelper.startPage(caseParam.getPageNum(), caseParam.getPageSize());
        TCaseInfoExample tCaseInfoExample = new TCaseInfoExample();
        TCaseInfoExample.Criteria criteria = tCaseInfoExample.createCriteria();
        TCaseInfo caseInfo = caseParam.getCaseInfo();
        if(!ObjectUtils.isEmpty(caseInfo)){
            if(!StringUtils.isEmpty(caseInfo.getCaseName()))
                criteria.andCaseNameLike("%" + caseInfo.getCaseName()+"%");
            if(!StringUtils.isEmpty(caseInfo.getType()))
            	criteria.andTypeEqualTo(caseInfo.getType());
        }
        List<TCaseInfo> tCaseInfoList = caseInfoMapper.selectByExample(tCaseInfoExample);
        return new PageInfo<>(tCaseInfoList);
	}

	@Override
	public TCaseInfo saveOrUpdateCaseInfo(TCaseInfo tCaseInfo) {
		if(StringUtils.isEmpty(tCaseInfo.getId())){
        	tCaseInfo.setId(UUIDUtils.getUUID());
        	caseInfoMapper.insert(tCaseInfo);
        }else{
        	caseInfoMapper.updateByPrimaryKey(tCaseInfo);
        }
        return tCaseInfo;
	}

	@Override
	@Transactional
	public int delCaseInfo(TCaseInfo tCaseInfo) {
		int ret = 0;
        if(StringUtil.isNotEmpty(tCaseInfo.getId())){
        	ret = caseInfoMapper.deleteByPrimaryKey(tCaseInfo.getId());
			if (ret > 0) {
        		TCaseRelRes tCaseRelRes = new TCaseRelRes();
        		tCaseRelRes.setCaseId(tCaseInfo.getId());
        		this.delCaseRelRes(tCaseRelRes);
        	}
        }
        return ret;
	}
	
	@Override
	public List<TCaseRelRes> getCaseRelResList(TCaseRelRes tCaseRelRes){
		TCaseRelResExample example = new TCaseRelResExample();
		TCaseRelResExample.Criteria criteria = example.createCriteria();
		if(!ObjectUtils.isEmpty(tCaseRelRes)) {
			if(StringUtil.isNotEmpty(tCaseRelRes.getCaseId())) {
				criteria.andCaseIdEqualTo(tCaseRelRes.getCaseId());
			}
			if(StringUtil.isNotEmpty(tCaseRelRes.getPlatform())) {
				criteria.andPlatformEqualTo(tCaseRelRes.getPlatform());
			}
		}
		return tCaseRelResMapper.selectResByExample(example);
	}
	
	@Override
	public int delCaseRelRes(TCaseRelRes tCaseRelRes) {
		if (ObjectUtils.isEmpty(tCaseRelRes) || StringUtil.isEmpty(tCaseRelRes.getCaseId())) {
			return 0;
		}
		TCaseRelResExample example = new TCaseRelResExample();
		TCaseRelResExample.Criteria criteria = example.createCriteria();
		criteria.andCaseIdEqualTo(tCaseRelRes.getCaseId());
		return tCaseRelResMapper.deleteByExample(example);
	}
	
	@Override
    public List<TCaseRelRes> saveCaseRelResList(List<TCaseRelRes> tCaseRelResList) {
		if (ObjectUtils.isEmpty(tCaseRelResList))
			throw new BusinessException("方案关联资源信息不能为空");
		for (TCaseRelRes tCaseRelRes : tCaseRelResList) {
			tCaseRelRes.setId(UUIDUtils.getUUID());
			tCaseRelResMapper.insert(tCaseRelRes);
		}
		return tCaseRelResList;
    }
	
	public List<TCaseInfo> getCaseInfoList(TCaseInfo caseInfo) {
        TCaseInfoExample tCaseInfoExample = new TCaseInfoExample();
        TCaseInfoExample.Criteria criteria = tCaseInfoExample.createCriteria();
        if(!ObjectUtils.isEmpty(caseInfo)){
            if(!StringUtils.isEmpty(caseInfo.getCaseName()))
                criteria.andCaseNameLike("%" + caseInfo.getCaseName()+"%");
            if(!StringUtils.isEmpty(caseInfo.getType()))
            	criteria.andTypeEqualTo(caseInfo.getType());
        }
        return caseInfoMapper.selectByExample(tCaseInfoExample);
	}
}
