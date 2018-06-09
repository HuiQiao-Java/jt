package com.jt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysConfigDao;
import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;

@Service
public class SysConfigServiceImpl implements SysConfigService {

	@Autowired
	private SysConfigDao sysConfigDao;

	@Override
	public PageObject<SysConfig> findPageObjects(String name, Integer pageCurrent) {
		// 核心业务如下
		// 1.参数校验
		if (pageCurrent == null || pageCurrent < 1) {
			throw new IllegalArgumentException("页码值不正确，pageCurrent=" + pageCurrent);
		}
		// 2.基于条件查询总记录数
		int rowCount = sysConfigDao.getRowCount(name);
		// 3.对查询总记录数进行校验
		if (rowCount == 0) {
			throw new ServiceException("没有查询到记录");
		}
		// 4.依据条件查询当前页数据
		int pageSize = 2;// 将来可以封装在配置文件中
		int startIndex = (pageCurrent - 1) * pageSize;
		List<SysConfig> records = sysConfigDao.findPageObjects(name, startIndex, pageSize);
		// 5.封装数据
		PageObject<SysConfig> po = new PageObject<>();
		po.setRowCount(rowCount);
		po.setRecords(records);
		po.setPageCurrent(pageCurrent);
		po.setPageSize(pageSize);
		// 6.返回数据
		return po;
		// 扩展业务
		// 日志管理，权限验证等等
	}

	@Override
	public Integer delectObject(Integer...ids) {
		//数据校验
//		if(StringUtils.isEmptyOrWhitespaceOnly(ids)) 
//			throw new IllegalArgumentException("请选中一行数据");
//		//数据处理
//		 String[] idArray = ids.split(",");
		//访问数据库
		
		//数据校验
		if(ids==null||ids.length==0) {
			throw new ServiceException("请输入一个正确的参数");
		}
		 int rows;
		 try {
			 rows = sysConfigDao.delectObject(ids);	
			 System.out.println(rows);
		 }catch (Throwable e) {
			 e.printStackTrace();
			 throw new ServiceException("系统故障，正在恢复中");
		}
		 if (rows==0) {
			throw new ServiceException("记录可能已经不存在");
		}
		return rows;
	}

	@Override
	public Integer saveObject(SysConfig entity) {
		//1.合法校验
		if(entity==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("保存名称不能为空");
		//2.保存到数据库
		
		
		int	row = sysConfigDao.insertObject(entity);
		
		//3.对结果进行验证
		if(row!=1)
			throw new ServiceException("save fails");
		//4.返回结果
		return row;
	}

	@Override
	public Integer updateObject(SysConfig entity) {
		
		//数据校验
		if (entity==null) {
			throw new ServiceException("数据不能为空");
		}
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("数据名称不能为空");
		if(entity.getId()==null||entity.getId()<1)
			throw new ServiceException("数据id不能为null或者小于0");
		//执行更新操作
		int rows = sysConfigDao.updateObject(entity);
		//对结果进行校验
		if(rows!=1)
			throw new ServiceException("更新失败");
		//返回结果
		return rows;
	}



}
