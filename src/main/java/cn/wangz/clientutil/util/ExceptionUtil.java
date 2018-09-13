package cn.wangz.clientutil.util;
/**
 * 
 * @author yangqi   
 * @date 2015-12-21 下午5:46:00    
 *
 */
public class ExceptionUtil {
	
	public static String stackTraceMsg(Exception e) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error:").append(e.toString());
        StackTraceElement[] trace = e.getStackTrace();
        for (StackTraceElement traceElement : trace) {
            stringBuilder.append("\n\t").append(traceElement);
        }
        Throwable cause = e.getCause();
        while (cause != null) {
            stringBuilder.append("\nCause by: ").append(cause.toString());
            trace = cause.getStackTrace();
            for (StackTraceElement traceElement : trace) {
                stringBuilder.append("\n\t").append(traceElement);
            }
            cause = cause.getCause();
        }

        return stringBuilder.toString();
	}
}
