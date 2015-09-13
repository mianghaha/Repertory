package com.wisi.core.web.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisi.core.util.JsonResult;

@Controller
@RequestMapping("systemCode")
public class SystemCodeController {
	/**
	 * get system code
	 * @return
	 */
	@RequestMapping("getSystemCode")
	@ResponseBody
	public JsonResult getSystemCode(){
		JsonResult json = new JsonResult();
		
		json.setCode("1");
		
		return json;
	}
}
