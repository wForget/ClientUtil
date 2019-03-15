package cn.wangz.clientutil.html;

import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;

/**
 * Created by hadoop on 2019/3/12.
 */
public class UserAgentUtils {
    private static UserAgentAnalyzer ANALYZER = null;

    static {
        ANALYZER  = UserAgentAnalyzer.newBuilder().withAllFields()
                .withField(UserAgent.AGENT_CLASS)
                .withField(UserAgent.AGENT_NAME)
                .withField(UserAgent.AGENT_VERSION)
                .withField(UserAgent.AGENT_VERSION_MAJOR)
                .withField(UserAgent.OPERATING_SYSTEM_CLASS)
                .withField(UserAgent.OPERATING_SYSTEM_NAME)
                .withField(UserAgent.OPERATING_SYSTEM_VERSION)
                .build();
    }

    public static final UserAgent getUserAgent(String userAgentString) {
        UserAgent userAgent = ANALYZER.parse(userAgentString);
//        String deviceName = userAgent.getValue(UserAgent.DEVICE_NAME);
        return userAgent;
    }
}
