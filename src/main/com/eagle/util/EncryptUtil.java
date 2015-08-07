package com.eagle.util;

import org.apache.commons.codec.binary.Base64;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jiang on 15/7/29.
 */
public class EncryptUtil {
    private static final String key = "@#$%^6a7";

    public EncryptUtil() {
    }

    public static String encryptMd5(String var0) throws Exception {
        MessageDigest var1 = null;
        Object var2 = null;

        try {
            var1 = MessageDigest.getInstance("MD5");
            byte[] var3 = var1.digest(var0.getBytes());
            return new String(Base64.encodeBase64(var3));
        } catch (NoSuchAlgorithmException var4) {
            var4.printStackTrace();
            throw var4;
        }
    }

    public static synchronized String encryptSha256(String var0) {
        try {
            MessageDigest var1 = MessageDigest.getInstance("SHA-256");
            byte[] var2 = var1.digest(var0.getBytes("UTF-8"));
            return new String(Base64.encodeBase64(var2));
        } catch (Exception var3) {
            return null;
        }
    }

    private static String byte2hex(byte[] var0) {
        String var1 = "";
        String var2 = "";

        for(int var3 = 0; var3 < var0.length; ++var3) {
            var2 = Integer.toHexString(var0[var3] & 255);
            if(var2.length() == 1) {
                var1 = var1 + "0" + var2;
            } else {
                var1 = var1 + var2;
            }
        }

        return var1.toLowerCase();
    }

    public static String decrypt(String var0) throws Exception {
        byte[] var1 = stringToBytes(var0);
        Cipher var2 = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec var3 = new DESKeySpec("@#$%^6a7".getBytes("UTF-8"));
        SecretKeyFactory var4 = SecretKeyFactory.getInstance("DES");
        SecretKey var5 = var4.generateSecret(var3);
        IvParameterSpec var6 = new IvParameterSpec("@#$%^6a7".getBytes("UTF-8"));
        var2.init(2, var5, var6);
        byte[] var7 = var2.doFinal(var1);
        return new String(var7, "UTF-8");
    }

    public static String encrypt(String var0) throws Exception {
        Cipher var1 = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec var2 = new DESKeySpec("@#$%^6a7".getBytes("UTF-8"));
        SecretKeyFactory var3 = SecretKeyFactory.getInstance("DES");
        SecretKey var4 = var3.generateSecret(var2);
        IvParameterSpec var5 = new IvParameterSpec("@#$%^6a7".getBytes("UTF-8"));
        var1.init(1, var4, var5);
        String var6 = bytesToString(var1.doFinal(var0.getBytes("UTF-8")));
        return var6;
    }

    private static byte[] stringToBytes(String var0) {
        byte[] var1 = new byte[var0.length() / 2];

        for(int var2 = 0; var2 < var1.length; ++var2) {
            String var3 = var0.substring(2 * var2, 2 * var2 + 2);
            int var4 = Integer.parseInt(var3, 16);
            var1[var2] = (byte)var4;
        }

        return var1;
    }

    private static String bytesToString(byte[] var0) {
        StringBuffer var1 = new StringBuffer();

        for(int var2 = 0; var2 < var0.length; ++var2) {
            String var3 = Integer.toHexString(255 & var0[var2]);
            if(var3.length() < 2) {
                var3 = "0" + var3;
            }

            var1.append(var3);
        }

        return var1.toString();
    }

//    public static void main(String[]args){
//        String str = encryptSha256("1qa2ws!@#");
//        System.out.print(str);
//    }
}
