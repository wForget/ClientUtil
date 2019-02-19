package cn.wangz.clientutil.html;

import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;
import info.monitorenter.cpdetector.io.ParsingDetector;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 处理数据通用方法
 *
 */
public class HtmlUtil {

	/**
	 * 获取html编码
	 * @param content
	 * @return
	 * @throws Exception
	 */
	private static CodepageDetectorProxy detector = null;
	static {
        detector = CodepageDetectorProxy.getInstance();
        detector.add(JChardetFacade.getInstance());
        detector.add(new ParsingDetector(false));
    }
	public static synchronized String getHtmlEncode(byte[] content) throws Exception {

        java.nio.charset.Charset charset = null;
        try {
        	InputStream in = new ByteArrayInputStream(content);
        	charset = detector.detectCodepage(in, in.available());
        	in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String charsetName = null;  
        if (charset != null && !"void".equals(charset.name())) {
            charsetName = charset.name();
        } else {
            charsetName = getHtmlEncodeByRegEx(content);
            if (charsetName == null){
                charsetName = "UTF-8";
            }
        }
        
        return charsetName;  
    }

    /**
     * 通过正则匹配获得html的charset
     * @param content
     * @return
     */
    public static String getHtmlEncodeByRegEx(byte[] content) {
	    String chartset = null;

	    String str = new String(content);
        String regEx = "charset=[\"|']?([\\-\\w]*)";
        Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            chartset = matcher.group(1);
        }

        return chartset;
    }
}
