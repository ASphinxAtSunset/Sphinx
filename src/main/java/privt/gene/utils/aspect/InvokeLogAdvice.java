package privt.gene.utils.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import privt.gene.utils.annotation.InvokeLog;
import privt.gene.utils.aspect.enums.ArgsPrintTypeEnum;
import privt.gene.utils.aspect.enums.ResultPrintTypeEnum;

import static privt.gene.utils.aspect.LogUtils.log;

/**
 * Created by Gene on 2017/12/21.
 * 使用这种日志记录方式是否可能造成性能缓慢
 */
@Aspect
public class InvokeLogAdvice {
    @Pointcut("@annotation(invokeLog)")
    public void pointcut(InvokeLog invokeLog){

    }
    @Before("pointcut(invokeLog)")
    public void doBefore(JoinPoint joinPoint,InvokeLog invokeLog){
        final Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        log(logger,invokeLog.logLevel(),invokeLog.value()+invokeLog.start());
    }
    @AfterReturning(pointcut = "pointcut(invokeLog)",returning = "returnValue")
    public void doAfter(JoinPoint joinPoint,InvokeLog invokeLog, Object returnValue){
        if (!invokeLog.printResult()){
            return;
        }
        final Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        if (returnValue == null){
            log(logger,invokeLog.logLevel(),invokeLog.retMsg(),null);
            return;
        }
        /**
         * 判断传递参数是否是json
         */
        ResultPrintTypeEnum resultPrintType = invokeLog.resultPrintType();
        switch (resultPrintType) {
            case json:
                //log(logger, invokeLog.logLevel(), invokeLog.retMsg(), JSON.toJSONString(returnValue));
                break;
            case string:
                log(logger, invokeLog.logLevel(), invokeLog.retMsg(), returnValue.toString());
                break;
        }
    }
    private void printArgs(JoinPoint joinPoint, InvokeLog invokeLog, Logger logger){
        if (!invokeLog.printArgs()) return;
        Object[] args = joinPoint.getArgs();
        int argLenth = args.length;
        if (argLenth==0) return;
        StringBuilder builder = new StringBuilder(invokeLog.args()).append("(");
        ArgsPrintTypeEnum displayTypeEnum = invokeLog.argsPrintType();
        for(int i=0;i<argLenth;i++){
            Object arg = args[i];
            builder.append((i+1)).append(".");
            if(arg instanceof Number || arg instanceof CharSequence || arg instanceof Character){
                builder.append(arg);
            }else{
                if (displayTypeEnum == ArgsPrintTypeEnum.string){
                    builder.append(arg);
                }
            }
            if (i<argLenth-1){
                builder.append(",");
            }
        }
        builder.append(")");
        log(logger,invokeLog.logLevel(),builder.toString(),args);
    }
}
