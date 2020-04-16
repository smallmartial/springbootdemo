package cn.smallmartial.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author smallmartial
 * @Date 2020/4/16
 * @Email smallmarital@qq.com
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoIdempotent {
}
