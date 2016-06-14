package com.lewis.compare;


/**
 * Created by zhangminghua on 2016/6/14.
 */
public enum  MethodEnum {
    GET("GET"),POST("POST");


    private String methodName;

    MethodEnum(String methodName) {
        this.methodName = methodName;
    }
}
