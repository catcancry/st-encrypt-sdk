package vip.ylove.annotation;

import java.lang.annotation.*;

/**
 *  跳过加密，在开启全局加密下使用该注解，可以跳过加密解决
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StEncryptSkip {

}
