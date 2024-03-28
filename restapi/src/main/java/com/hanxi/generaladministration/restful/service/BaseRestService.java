package com.hanxi.generaladministration.restful.service;


import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 
 * 基础Rest服务，提供一些常用的功能，例如：
 * 1、构造最终的响应对象RestResponse，getSuccessRestResponse方法；
 * 2、构造分页模型对象createBasePage方法；
 */
public class BaseRestService {
	



	/** 请求响应构造	 */
	protected RestResponse getSuccessRestResponse(String info) {
		RestResponse result = new RestResponse();
		result.setApiStatus(0);
		result.setInfo(info);
		return result;
	}
	
	protected RestResponse getSuccessRestResponse(String info,Object data) {
		RestResponse result = new RestResponse();
		result.setApiStatus(0);
		result.setInfo(info);
		result.setData(data);
		return result;
	}

}
