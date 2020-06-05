package kr.co.ikosmo.mvc.model;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(UnsatisfiedServletRequestParameterException.class)
	public ModelAndView paramsException(UnsatisfiedServletRequestParameterException e) {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("emsg", e);
		return mav;
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView paramsException(MissingServletRequestParameterException e) {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("emsg", e);
		return mav;
	}
	
	
}

