package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.sys.entity.SysConfig;

public interface SysConfigDao {
	
	/**
	 * 查询当前页数据
	 * @param name 查询操作时客户输入的用户名
	 * @param startIndex 当前页面的起始位置
	 * @param pageSize 当前页面大小
	 * @return 当前页面查询得到的数据
	 */
	List<SysConfig> findPageObjects(
			@Param("name")String name, 
			@Param("startIndex")Integer startIndex, 
			@Param("pageSize")Integer pageSize);
	/**
	 * 依据条件查询记录总数
	 * @param name
	 * @return
	 */
	int getRowCount(@Param("name")String name);
	
	int delectObject(@Param("ids")Integer...ids);
	/**
	 * 
	 * @param entity
	 * @return
	 */
	int insertObject(SysConfig entity);
	
	int updateObject(SysConfig entity);
}
