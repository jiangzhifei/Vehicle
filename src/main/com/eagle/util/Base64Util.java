package com.eagle.util;

import java.io.UnsupportedEncodingException;

/**
 * Created by jiang on 15/7/29.
 */
public class Base64Util {
    public static String getBase64(String var0) throws UnsupportedEncodingException {
        byte[] var1 = org.apache.commons.codec.binary.Base64.encodeBase64(var0.getBytes("utf-8"));
        return new String(var1, "utf-8");
    }

    public static String getFromBase64(String var0) throws UnsupportedEncodingException {
        byte[] var1 = var0.getBytes("GBK");
        byte[] var2 = org.apache.commons.codec.binary.Base64.decodeBase64(var1);
        return new String(var2, "GBK");
    }
//
//    public static void main(String [] args){
//        try {
//            String str = getBase64("1qa2ws!@#");
//            System.out.println(str);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//    }
}
