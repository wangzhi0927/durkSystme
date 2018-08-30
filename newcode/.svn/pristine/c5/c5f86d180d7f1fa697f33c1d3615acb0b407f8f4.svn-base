package com.dpm.unity.web.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dpm.resource.common.enity.template.TemplateA;
import com.dpm.resource.freamwork.BusinessResult;

import io.swagger.annotations.ApiOperation;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/16
 * @Description:
 */
@Controller
@RequestMapping(value = "/template")
public class TemplateController {
	
	@ApiOperation(value = "获取模板信息", notes = "获取模板信息")
	@GetMapping(value = "/getTemplates")
	public String getTemplates(Model model) throws Exception {
		model.addAttribute("TemplateA",new TemplateA());
		return "case/rx";
	}
	
	@ApiOperation(value = "获取模板信息", notes = "获取模板信息")
	@PostMapping(value = "/submitTemplates")
	@ResponseBody
	public BusinessResult submitTemplates(@ModelAttribute(value = "TemplateA") TemplateA templateA,Model model) throws Exception {
		if(null != templateA) {
			System.out.println(templateA.toString());
		}
		return BusinessResult.success(templateA);
	}
}
