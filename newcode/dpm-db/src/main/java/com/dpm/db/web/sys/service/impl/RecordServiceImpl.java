package com.dpm.db.web.sys.service.impl;

import com.dpm.db.common.example.TPatientTalkExample;
import com.dpm.db.common.example.TRecordInfoExample;
import com.dpm.db.common.mapper.TPatientTalkMapper;
import com.dpm.db.common.mapper.TRecordInfoMapper;
import com.dpm.db.web.sys.service.IRecordService;
import com.dpm.resource.common.enity.TPatientTalk;
import com.dpm.resource.common.enity.TRecordInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/21
 * @Description:
 */
@Service
public class RecordServiceImpl implements IRecordService {
    @Autowired
    TPatientTalkMapper tPatientTalkMapper;
    @Autowired
    TRecordInfoMapper tRecordInfoMapper;

    @Override
    public int updatePatientTalkIdNoPath(String recordId, String path) {
        TPatientTalkExample tPatientInfoExample = new TPatientTalkExample();
        TPatientTalkExample.Criteria criteria = tPatientInfoExample.createCriteria();
        criteria.andRecordIdEqualTo(recordId);
        TPatientTalk tPatientTalk = new TPatientTalk();
        tPatientTalk.setIdFilePath(path);
        return tPatientTalkMapper.updateByExampleSelective(tPatientTalk, tPatientInfoExample);
    }

    @Override
    public PageInfo<TRecordInfo> getRecordInfoByCondition(TRecordInfo recordInfo, int pageSize, int pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<TRecordInfo> resourceInfoList = tRecordInfoMapper.selectByExample(initRecordExample(recordInfo));
        PageInfo<TRecordInfo> page = new PageInfo<>(resourceInfoList);
        return page;
    }

    private TRecordInfoExample initRecordExample(TRecordInfo resourceInfo) {
        TRecordInfoExample tRecordInfoExample = new TRecordInfoExample();
        if (ObjectUtils.isEmpty(resourceInfo))
            return tRecordInfoExample;
        TRecordInfoExample.Criteria criteria = tRecordInfoExample.createCriteria();
        if (!ObjectUtils.isEmpty(resourceInfo.getPatientId())) {
            criteria.andPatientIdEqualTo(resourceInfo.getPatientId());
        }
        if (!ObjectUtils.isEmpty(resourceInfo.getInpNo())) {
            criteria.andInpNoEqualTo(resourceInfo.getInpNo());
        }
        return tRecordInfoExample;
    }
}
