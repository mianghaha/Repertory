package com.wisi.core.web.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisi.core.util.SignUtil;

@Controller
@RequestMapping("/certificate")
public class WeiXinCertificateController {

	@RequestMapping(value="/", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Object certificate(HttpServletRequest request,
			@RequestParam(value="signatrue", required = true )String signatrue,
			@RequestParam(value="timestamp", required = true )String timestamp,
			@RequestParam(value="nonce", required = true )String nonce,
			@RequestParam(value="echostr", required = true )String echostr
			){
		
		if(SignUtil.checkSignature(signatrue, timestamp, nonce)){
			return echostr;
		}
		return null;
	}
	
}
