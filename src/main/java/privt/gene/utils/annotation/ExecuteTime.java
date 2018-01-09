package privt.gene.utils.annotation;

import privt.gene.utils.aspect.enums.LogLevel;

import java.lang.annotation.*;

/**
 * Created by Gene on 2017/12/21.
 * 记录方法时长
 */
@Target(ElementType.METHOD)//注解用在方法上，用于描述方法
@Retention(RetentionPolicy.RUNTIME)//注解在运行时保留
@Documented//指定javadoc生成API文档时显示该注解信息
public @interface ExecuteTime {
    //调用时长阈值，默认为0，单位为毫秒，运行时长超过threshold毫秒时打印运行时长日志
    int threshold() default 0;

    String msg() default "";

    String postfix() default "接口---执行时长:{}毫秒";

    //日志级别
    LogLevel logLevel() default LogLevel.info;
}
