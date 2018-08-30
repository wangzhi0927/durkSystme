package com.dpm.db.web.sys.controller;

import com.dpm.db.web.sys.service.impl.RecordServiceImpl;
import com.dpm.resource.common.enity.RecordCondition;
import com.dpm.resource.common.enity.TRecordInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/21
 * @Description:
 */
@RestController
@RequestMapping(value = "/sys/record")
public class RecordController {
    @Autowired
    private RecordServiceImpl recordService;

    @RequestMapping(value = "updatePatientTalkIdNoPath", method = RequestMethod.POST)
    public int updatePatientTalkIdNoPath(@RequestParam(value = "recordId") String recordId, @RequestParam(value = "path") String path) {
        return recordService.updatePatientTalkIdNoPath(recordId, path);
    }

    @RequestMapping(value = "/getRecordInfoByCondition", method = RequestMethod.POST)
    PageInfo<TRecordInfo> getRecordInfoByCondition(@RequestBody RecordCondition param) {
        return recordService.getRecordInfoByCondition(param.getRecordInfo(), param.getPageSize(), param.getPageNum());
    }
}
