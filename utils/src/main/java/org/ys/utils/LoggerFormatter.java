package org.ys.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class LoggerFormatter {

    public static void Info(String message) {
        getLogger().info(String.format("%s \n %s: %s", message, getRemoteIP(), getRequestAgent()));
    }

    /**
     * @param message    日志内容
     * @param className  类名
     * @param methodName 方法名
     */
    public static void Info(String message, String className, String methodName) {
        getLogger().info(String.format("%s#%s - %s \n %s: %s", className, methodName, message, getRemoteIP(), getRequestAgent()));
    }

    public static void warning(String message) {
        getLogger().warn(String.format("%s \n %s: %s", message, getRemoteIP(), getRequestAgent()));
    }

    /**
     * @param message    日志内容
     * @param className  类名
     * @param methodName 方法名
     */
    public static void warning(String message, String className, String methodName) {
        getLogger().warn(String.format("%s#%s - %s \n %s: %s", className, methodName, message, getRemoteIP(), getRequestAgent()));
    }

    public static void error(String message) {
        getLogger().error(String.format("%s \n %s: %s", message, getRemoteIP(), getRequestAgent()));
    }

    /**
     * @param message    日志内容
     * @param className  类名
     * @param methodName 方法名
     */
    public static void error(String message, String className, String methodName) {
        getLogger().error(String.format("%s#%s - %s \n %s: %s", className, methodName, message, getRemoteIP(), getRequestAgent()));
    }

    private static Logger getLogger() {
        return LoggerFactory.getLogger("LOGSTASH");
    }

    // 获取代理字符串
    private static String getRequestAgent() {
        HttpServletRequest req = getCurrentRequest();
        if (req == null)
            return "";
        return getCurrentRequest().getHeader("User-Agent");
    }

    // 获取远程ip
    private static String getRemoteIP() {
        HttpServletRequest req = getCurrentRequest();
        if (req == null)
            return "";
        return req.getRemoteAddr();
    }

    // 获取当前的请求对象
    private static HttpServletRequest getCurrentRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        } catch (Exception e) {
            return null;
        }
    }
}
