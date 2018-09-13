package com.ifast.common.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.beans.editors.StringEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;


/**
 * 控制器增强处理
 *
 */
@ControllerAdvice
public class MyControllerAdvice {


	/**
	 * 处理日期转换
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
		binder.registerCustomEditor(String.class, new StringEditor());
	}

}
