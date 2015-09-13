package com.wisi.core.web.controller.main;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisi.core.util.JsonResult;
import com.wisi.core.util.ValidateCode;
import com.wisi.core.web.base.BaseController;

@Controller
@RequestMapping("login")
public class LoginController extends BaseController {
	/**
	 * get validate code
	 * @return
	 */
	@RequestMapping("getValidateCode")
	@ResponseBody
	public void getValidateCode() throws IOException{
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		ValidateCode vCode = new ValidateCode(100,30,4,160);
		// System.out.println(vCode.getCode());
		session.setAttribute("validateCode", vCode.getCode());
		vCode.write(response.getOutputStream());
	}
	
	/**
	 * login check
	 * @return
	 */
	@RequestMapping("loginCheck.html")
	@ResponseBody
	public JsonResult loginCheck(@RequestParam Map<Object, Object> map) throws IOException{
		JsonResult json = new JsonResult();
		String validateCode = session.getAttribute("validateCode").toString();
		int i = 1/0;
		return json;
	}
	
	/**
	 * login check
	 * @return
	 */
	@RequestMapping("index.html")
	public JsonResult index(@RequestParam Map<Object, Object> map) throws IOException{
		JsonResult json = new JsonResult();
		String validateCode = session.getAttribute("validateCode").toString();
		int i = 1/0;
		return json;
	}
}
