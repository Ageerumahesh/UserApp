package com.mini.proj.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.microsoft.sqlserver.jdbc.SQLServerException;





@Controller
@ControllerAdvice
public class AppExceptionHandler {
      //global error msg
	
	@ExceptionHandler(value = SQLServerException.class)
	public String handleNullPointer(Model modelObj) {
		//add message to model obj to show to end user
		modelObj.addAttribute("nullPntrMsg","please provide all details");
		return "error";
	}
}
