package com.dpm.db.web.tnm.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.dpm.db.common.example.TTnmInfoExample;
import com.dpm.db.common.mapper.TTnmInfoMapper;
import com.dpm.db.web.tnm.service.ITnmService;
import com.dpm.resource.common.enity.TTnmInfo;
import com.dpm.resource.common.enity.tnm.TnmParam;
import com.dpm.resource.common.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @ Purpose:
 * 
 * @Package Name: com.dpm.db.web.user.service.impl
 * @Author: gl
 * @Date: 2018/7/24
 */
@Service
public class TnmServiceImpl implements ITnmService {

	@Autowired
	TTnmInfoMapper tnmInfoMapper;

	@Override
	public PageInfo<TTnmInfo> getTnmInfoByCondition(TnmParam tnmParam) {
		PageHelper.startPage(tnmParam.getPageNum(), tnmParam.getPageSize());
		TTnmInfoExample tTnmInfoExample = new TTnmInfoExample();
		TTnmInfoExample.Criteria criteria = tTnmInfoExample.createCriteria();
		TTnmInfo tTnmInfo = tnmParam.getTTnmInfo();
		if (!ObjectUtils.isEmpty(tTnmInfo)) {
			if (StringUtils.isNotEmpty(tTnmInfo.getType()))
				criteria.andTypeEqualTo(tTnmInfo.getType());
		}
		List<TTnmInfo> tTnmInfoList = tnmInfoMapper.selectByExample(tTnmInfoExample);
		return new PageInfo<>(tTnmInfoList);
	}

	@Override
	public TTnmInfo saveOrUpdateTnmInfo(TTnmInfo tTnmInfo) {
		if (StringUtils.isEmpty(tTnmInfo.getId())) {
			tTnmInfo.setId(UUIDUtils.getUUID());
			tnmInfoMapper.insert(tTnmInfo);
		} else {
			tnmInfoMapper.updateByPrimaryKey(tTnmInfo);
		}
		return tTnmInfo;
	}

	@Override
	public int delTnmInfo(TTnmInfo tTnmInfo) {
		int ret = 0;
		if (StringUtils.isNotEmpty(tTnmInfo.getId())) {
			ret = tnmInfoMapper.deleteByPrimaryKey(tTnmInfo.getId());
		}
		return ret;
	}
}
