package com.jt.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JasonResult;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;

@Controller
@RequestMapping("/config/")
public class SysConfigController {
	@Autowired
	private SysConfigService sysConfigService;

	@RequestMapping("doConfigListUI")
	public String doConfigListUI() {
		return "sys/config_list";
	}

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JasonResult doFindPageObjects(String name, Integer pageCurrent) {
		System.out.println(name);
		System.out.println(pageCurrent);
		PageObject<SysConfig> pageObject = sysConfigService.findPageObjects(name, pageCurrent);
		JasonResult jasonResult = new JasonResult(pageObject);
		return jasonResult;
	}
	@RequestMapping("doDelectObjects")
	@ResponseBody
	public JasonResult doDelectObjects(Integer... ids) {
		sysConfigService.delectObject(ids);
		return new JasonResult("delect ok");
	}
	
	@RequestMapping("doConfigEditUI")
	public String doConfigEditUI() {
		return "sys/config_edit";
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JasonResult doSaveObject(SysConfig entity) {
		sysConfigService.saveObject(entity);
		return new JasonResult("save ok");
	}
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JasonResult doUpdateObject(SysConfig entity) {
		sysConfigService.updateObject(entity);
		return new JasonResult("update ok");
	}
}
