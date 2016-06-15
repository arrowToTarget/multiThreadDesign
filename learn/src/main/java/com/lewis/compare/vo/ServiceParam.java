package com.lewis.compare.vo;

import com.lewis.compare.MethodEnum;

/**
 * Created by zhangminghua on 2016/6/14.
 */
public class ServiceParam {
    private MethodEnum methodEnum = MethodEnum.GET;
    //服务名
    private String serviceName;
    //环境
    private Envirnment env;
    private String contextPath;
    //参数
    private String inputParams;
    //拆分前的URL
    private String urlSplitBefore;
    //拆分后的URL
    private String urlSplitAfter;
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getInputParams() {
        return inputParams;
    }

    public void setInputParams(String inputParams) {
        this.inputParams = inputParams;
    }

    public MethodEnum getMethodEnum() {
        return methodEnum;
    }

    public void setMethodEnum(MethodEnum methodEnum) {
        this.methodEnum = methodEnum;
    }

    public Envirnment getEnv() {
        return env;
    }

    public void setEnv(Envirnment env) {
        this.env = env;
    }

    public String getUrlSplitBefore() {
        urlSplitBefore = "http://"+this.env.getIpPortSplitBefore()+"/boh"+this.contextPath;
        return urlSplitBefore;
    }

    public void setUrlSplitBefore(String urlSplitBefore) {
        this.urlSplitBefore = urlSplitBefore;
    }

    public String getUrlSplitAfter() {
        urlSplitAfter = "http://"+this.env.getIpPortSplitAfter()+"/boh"+this.contextPath;
        return urlSplitAfter;
    }

    public void setUrlSplitAfter(String urlSplitAfter) {
        this.urlSplitAfter = urlSplitAfter;
    }

    public ServiceParam(MethodEnum methodEnum, String serviceName, Envirnment env, String contextPath) {
        this.methodEnum = methodEnum;
        this.serviceName = serviceName;
        this.env = env;
        this.contextPath = contextPath;
    }
}
