package com.lewis.compare;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by zhangminghua on 2016/6/14.
 */
public class Base64Util {

    public static String encode(String str){
        return Base64.encodeBase64String(str.getBytes());
    }

    public static String decode(String str){
        return new String(Base64.decodeBase64(str));
    }
}
