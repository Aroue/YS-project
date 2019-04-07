package org.ys.utils;

// 异常对象的堆栈信息
public class BacktraceToString {
    public static String getStackMsg(Exception e) {

        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackArray = e.getStackTrace();
        for (StackTraceElement element : stackArray) {
            sb.append(element.toString()).append("\n");
        }
        return sb.toString();
    }

}
