package com.wisi.core.web.controller.main;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wisi.core.web.base.BaseController;

@Controller
@RequestMapping("timeout")
public class TimeoutController extends BaseController {
	/**
	 * timeout
	 * @return
	 */
	@RequestMapping("timeout")
	public ModelAndView timeout() throws IOException{
		ModelAndView mv = new ModelAndView();
		mv.addObject("timeout", "Time out");
		mv.setViewName("timeout");
		return mv;
	}
}
