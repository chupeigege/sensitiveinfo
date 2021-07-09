package vip.aquan.sensitiveinfo.util.sensitive;

import java.lang.annotation.*;

/**
 * 用于标注实体字段敏感字段类型
 * {@link vip.aquan.sensitiveinfo.util.sensitive.SensitiveType}}
 *
 * @author wcp
 * @date 2021-06-15
 * @since 2.0.0
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SensitiveInfoType {

    SensitiveType value();

}
