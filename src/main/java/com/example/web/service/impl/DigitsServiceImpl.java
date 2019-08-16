package com.example.web.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.web.service.DigitsService;
import com.example.web.utils.Result;

@Service
public class DigitsServiceImpl implements DigitsService {

	private final static Map<String,String[]> paramMap = new HashMap<>() ;
	
	/**
	 * inited paramMap
	 */
	public DigitsServiceImpl() {
		paramMap.put("2", new String[] {"a","b","c"}) ;
		paramMap.put("3", new String[] {"d","e","f"}) ;
		paramMap.put("4", new String[] {"g","h","i"}) ;
		paramMap.put("5", new String[] {"j","k","l"}) ;
		paramMap.put("6", new String[] {"m","n","o"}) ;
		paramMap.put("7", new String[] {"p","q","r","s"}) ;
		paramMap.put("8", new String[] {"t","u","v"}) ;
		paramMap.put("9", new String[] {"w","x","y","z"}) ;
	}
	
	/**
	 * @param param 
	 * @param rs
	 * @return rs
	 */
	public Result getOutput(String param, Result rs) throws Exception {
		List<String[]> list = new LinkedList<>() ;
		String[] numberArray = param.split(",") ;
		for(String number: numberArray) {
			if(null != paramMap.get(number)) {
				list.add(paramMap.get(number)) ;
			}
		}
		JSONObject json = new JSONObject() ;
		if(list.size() > 0) {
			List<String> resultList = new ArrayList<>() ;
			for(String[] arr : list) {
				buildData(arr,resultList) ;
			}
			json.put("info", resultList.toString()) ;
		}else {
			json.put("info", "nothing");
		}
		rs.setData(json);
		return rs ;
	}
	
	private static void buildData(String[] arr, List<String> resultList) {
		if(resultList.size() == 0) {
			resultList.addAll(Arrays.asList(arr)) ;
		}else {
			List<String> tempList = new ArrayList<>() ;
			for(String s : resultList) {
				for(String str : arr) {
					tempList.add(s+str) ;
				}
			}
			resultList.clear();
			resultList.addAll(tempList) ;
		}
	}

	/**
	 * validate str is empty or null
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		if(null == str || "".equals(str)) {
			return true ;
		}
		return false ;
	}

}
