package cn.wangz.clientutil.druid;

import in.zapr.druid.druidry.dimension.DimensionSpec;
import in.zapr.druid.druidry.dimension.DruidDimension;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/**
 * Created by hadoop on 2018/9/4.
 */
@Getter
public class RegexFilteredDimensionSpec extends DruidDimension {

    private static final String DEFAULT_TYPE = "regexFiltered";

    private String type;

    private DimensionSpec delegate;

    private String pattern;

    @Builder
    public RegexFilteredDimensionSpec(@NonNull DimensionSpec delegate, @NonNull String pattern) {
        this.type = RegexFilteredDimensionSpec.DEFAULT_TYPE;
        this.delegate = delegate;
        this.pattern = pattern;
    }
}
