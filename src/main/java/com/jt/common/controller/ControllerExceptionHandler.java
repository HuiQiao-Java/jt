package com.jt.common.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JasonResult;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler({
		RuntimeException.class
		})
	@ResponseBody
	public JasonResult doHandleException(RuntimeException e) {
		e.printStackTrace();
		return new JasonResult(e);
	}
	
	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public JasonResult doHandleSysException(Throwable e) {
		e.printStackTrace();
		return new JasonResult("系统故障，正在恢复中");
	}
}
