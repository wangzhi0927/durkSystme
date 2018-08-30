package com.dpm.db.web.sys.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.dpm.db.common.example.TDictDetailExample;
import com.dpm.db.common.example.THospitalInfoExample;
import com.dpm.db.common.mapper.TDictDetailMapper;
import com.dpm.db.common.mapper.THospitalInfoMapper;
import com.dpm.db.web.sys.service.ISysService;
import com.dpm.resource.common.enity.TDictDetail;
import com.dpm.resource.common.enity.THospitalInfo;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/21
 * @Description:
 */
@Service
public class SysServiceImpl implements ISysService {
    @Autowired
    private TDictDetailMapper tDictDetailMapper;
    @Autowired
    private THospitalInfoMapper tHospitalInfoMapper;
    @Override
    public Map<String, List<TDictDetail>> getDictDetailInfo(String dictType) {
        TDictDetailExample tDictDetailExample = new TDictDetailExample();
        TDictDetailExample.Criteria criteria = tDictDetailExample.createCriteria();
        criteria.andDictCodeNotEqualTo("!");
        if(!StringUtils.isEmpty(dictType))
            criteria.andTypeEqualTo(dictType);
        List<TDictDetail> tDictDetails = tDictDetailMapper.selectByExample(tDictDetailExample);
        Map<String,List<TDictDetail>> dictInfo = null;
        if(!ObjectUtils.isEmpty(tDictDetails)){
            dictInfo = tDictDetails.stream().collect(Collectors.groupingBy(TDictDetail::getType));
        }
        return dictInfo;
    }

    @Override
    public List<THospitalInfo> getHospitalInfos(String hosCode) {

        THospitalInfoExample tHospitalInfoExample = new THospitalInfoExample();
        THospitalInfoExample.Criteria criteria = tHospitalInfoExample.createCriteria();
        if(!StringUtils.isEmpty(hosCode))
            criteria.andHosCodeEqualTo(hosCode);
        List<THospitalInfo> tHospitalInfos = tHospitalInfoMapper.selectByExample(tHospitalInfoExample);
        return tHospitalInfos;
    }
}
