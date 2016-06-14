package com.lewis.compare.vo;

/**
 * Created by zhangminghua on 2016/6/14.
 */
public enum Envirnment {

    SIT(Constants.IP_PORT_SIT_SPLIT_BEFORE,Constants.IP_PORT_SIT_SPLIT_AFTER),
    STABLE(Constants.IP_PORT_STABLE_SPLIT_BEFORE,Constants.IP_PORT_PRE_RELEASE_SPLIT_AFTER);

    private String ipPortSplitBefore;

    private String ipPortSplitAfter;

    Envirnment(String ipPortSplitBefore, String ipPortSplitAfter) {
        this.ipPortSplitBefore = ipPortSplitBefore;
        this.ipPortSplitAfter = ipPortSplitAfter;
    }

    public String getIpPortSplitBefore() {
        return ipPortSplitBefore;
    }

    public String getIpPortSplitAfter() {
        return ipPortSplitAfter;
    }
}
