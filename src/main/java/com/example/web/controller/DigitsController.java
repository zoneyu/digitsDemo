package com.example.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.web.service.DigitsService;
import com.example.web.utils.Result;

@RestController
public class DigitsController {

	private Logger logger = LoggerFactory.getLogger(DigitsController.class) ;
	
	@Autowired
	private DigitsService service ;
	
	@PostMapping("/getDigitsOutput")
	public Result getOutput(@RequestBody JSONObject json) {
		Result rs = new Result() ;
		String param = (String) json.get("param") ;
		try {
			rs = service.getOutput(param,rs) ;
		} catch (Exception e) {
			rs.setStatus(20001);
			rs.setMsg("System error");
			logger.error("", e);
		}
		return rs ;
	}
}
