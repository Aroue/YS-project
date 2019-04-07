package org.ys.utils.encrption;

import org.ys.utils.LoggerFormatter;
import org.ys.utils.exception.BusinessException;

import java.security.MessageDigest;
import java.util.List;

public class Md5 {
    // 按顺序生成md5
    public static String encrypt(String originStr) {
        String md5str = "";

        try {
            // 1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 2 将消息变成byte数组
            byte[] input = originStr.toString().getBytes();

            // 3 计算后获得字节数组,这就是那128位了
            byte[] buff = md.digest(input);

            // 4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
            md5str = bytesToHex(buff);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5str;
    }

    // 转换md5字符
    public static String bytesToHex(byte[] bytes) {
        StringBuilder md5str = new StringBuilder();
        // 把数组每一字节换成16进制连成md5字符串
        int digital;
        for (byte aByte : bytes) {
            digital = aByte;

            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }


    public static String paramsSign(List<String> paramNames, List<String> paramValues) throws BusinessException {
        if (paramNames.size() != paramValues.size()) {
            LoggerFormatter.error("参数个数与参数值个数不匹配", "BaseController", "paramsSign");
            throw new BusinessException("参数个数与参数值个数不匹配");
        }

        StringBuilder paramsUrl = new StringBuilder();

        for (int i = 0; i < paramNames.size(); i++) {
            paramsUrl.append(paramNames.get(i));
            paramsUrl.append("=");
            paramsUrl.append(paramValues.get(i));
            if (i + 1 != paramNames.size())
                paramsUrl.append("&");
        }
        return Md5.encrypt(paramsUrl.toString());
    }
}
