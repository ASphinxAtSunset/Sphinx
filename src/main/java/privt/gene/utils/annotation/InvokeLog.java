package privt.gene.utils.annotation;

import privt.gene.utils.aspect.enums.ArgsPrintTypeEnum;
import privt.gene.utils.aspect.enums.LogLevel;
import privt.gene.utils.aspect.enums.ResultPrintTypeEnum;

import java.lang.annotation.*;

/**
 * Created by Gene on 2017/12/20.
 * 用于记录调用接口的日志记录，包括但不限于{出入时间，异常栈等}
 */
@Target(ElementType.METHOD)//注解用在方法上，用于描述方法
@Retention(RetentionPolicy.RUNTIME)//注解在运行时保留
@Documented//指定javadoc生成API文档时显示该注解信息
public @interface InvokeLog {
    String value() default "";

    String start() default "接口--调用开始-------------------------->>>";

    String ex() default "接口--调用异常:{}";

    String retMsg() default "执行结果:{}";

    String end() default "接口--调用结束-------------------------->>>";

    String args() default "参数:";

    //是否打印方法参数
    boolean printArgs() default false;

    //是否打印方法返回结果
    boolean printResult() default true;

    //参数输出格式
    ArgsPrintTypeEnum argsPrintType() default ArgsPrintTypeEnum.json;

    //返回结果输出格式
    ResultPrintTypeEnum resultPrintType() default ResultPrintTypeEnum.json;

    //日志级别
    LogLevel logLevel() default LogLevel.info;

}
