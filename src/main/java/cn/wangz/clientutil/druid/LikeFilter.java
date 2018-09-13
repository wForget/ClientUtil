package cn.wangz.clientutil.druid;

import in.zapr.druid.druidry.filter.DruidFilter;
import lombok.Getter;
import lombok.NonNull;

/**
 * Created by hadoop on 2018/9/3.
 */
@Getter
public class LikeFilter extends DruidFilter {

    private static String REGEX_DRUID_FILTER_TYPE = "like";

    private String dimension;
    private String pattern;

    public LikeFilter(@NonNull String dimension, @NonNull String pattern) {
        this.type = REGEX_DRUID_FILTER_TYPE;
        this.dimension = dimension;
        this.pattern = pattern;
    }
}
