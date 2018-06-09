package com.jt.sys.service;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysConfig;


public interface SysConfigService {
	
	PageObject<SysConfig> findPageObjects(
			String name,
			Integer pageCurrent);
	
	Integer delectObject(Integer...ids);
	
	Integer saveObject(SysConfig entity);
	
	Integer updateObject(SysConfig entity);
}
