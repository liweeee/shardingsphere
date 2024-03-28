package com.hanxi.generaladministration.restful.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ibm on 2016/1/11.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Setter
@Getter
public class RestResponse<T> {

    /**
     * 接口状态返回值，正常为0
     */
    private int    apiStatus;

    /**
     * 账号状态返回值，正常为0
     */
    private int    sysStatus;

    /**
     * 接口返回对象值
     */
    @JsonInclude
    private T      data;

    /**
     * 接口返回提示信息
     */
    private String info      = "";

    private long   timestamp = System.currentTimeMillis();

    @SuppressWarnings("unchecked")
    public static <T> RestResponse<T> buildRestResponse(T t) throws IOException {
        RestResponse restResponse = new RestResponse();

        if (t == null) {
            restResponse.setData(new HashMap<String, String>());
        } else if (t instanceof String) {
            restResponse.setInfo(t.toString());
        } else if (t instanceof List) {
            int total = ((List) t).size() == 0 ? 1 : ((List) t).size();
            org.springframework.data.domain.Pageable pageable = PageRequest.of(0, total);

            PageImpl page = new PageImpl(((List) t), pageable, total);
            restResponse.setData(page);
        } else if (t instanceof ArrayNode) {
            int total = ((ArrayNode) t).size() == 0 ? 1
                : ((ArrayNode) t).size();

            org.springframework.data.domain.Pageable pageable = PageRequest.of(0, total);
            ArrayNode entityNode = (ArrayNode) t;

            ObjectMapper mapper = new ObjectMapper();
            List<Map> list = mapper.readValue(entityNode.toString(),
                    TypeFactory.defaultInstance().constructCollectionType(List.class, Map.class));
            PageImpl page = new PageImpl(list, pageable,
                total);
            restResponse.setData(page);
        } else {
            restResponse.setData(t);
        }

        return restResponse;
    }

    public RestResponse() {

    }

    public static RestResponse<Object> buildResponse(Object data, int apiStatus) {
        RestResponse<Object> restResponse = new RestResponse<>();
        restResponse.setData(data);
        restResponse.setApiStatus(apiStatus);
        return restResponse;
    }

    @SuppressWarnings("unchecked")
    public static RestResponse buildResponse(Object data, int apiStatus, String info) {
        RestResponse restResponse = new RestResponse();
        restResponse.setData(data);
        restResponse.setApiStatus(apiStatus);
        restResponse.setInfo(info);
        return restResponse;
    }

    /**
     * 默认apiStatus为0
     * @param data
     * @return
     */
    @SuppressWarnings("unchecked")
    public static RestResponse buildResponse(Object data) {
        RestResponse restResponse = new RestResponse();
        restResponse.setData(data);
        restResponse.setApiStatus(0);
        return restResponse;
    }

    public static RestResponse buildResponse(String info) {
        RestResponse restResponse = new RestResponse();
        restResponse.setInfo(info);
        restResponse.setApiStatus(0);
        return restResponse;
    }

    public static RestResponse buildExceptionResponse(String errorMessage) {
        RestResponse restResponse = new RestResponse();
        restResponse.setInfo(errorMessage);
        restResponse.setApiStatus(-1);
        return restResponse;
    }

    public static RestResponse buildExceptionResponse(String errorMessage, int apiStatus) {
        RestResponse restResponse = new RestResponse();
        restResponse.setInfo(errorMessage);
        restResponse.setApiStatus(apiStatus);
        return restResponse;
    }



}
