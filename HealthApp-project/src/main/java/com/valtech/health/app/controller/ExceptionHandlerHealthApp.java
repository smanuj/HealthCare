package com.valtech.health.app.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerHealthApp {

	@ExceptionHandler(Exception.class)
	public String exceptionHandling(Model model) {

		return "/errorpage";
	}
}
