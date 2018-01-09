package privt.gene.utils.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import privt.gene.utils.annotation.ExecuteTime;
import privt.gene.utils.aspect.enums.LogLevel;

/**
 * Created by Gene on 2017/12/21.
 */
@Aspect
public class ExecuteTimeAdvice {
    @Pointcut("@annotation(executeTime)")
//    @Pointcut("execution(public * privt.gene..*.*(..))&&@annotation(executeTime)")
    public void pointcut(ExecuteTime executeTime){

    }
    @Before("pointcut(executeTime)")
    public void doBefore(JoinPoint joinPoint, ExecuteTime executeTime){
        final Logger LOGGER = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        System.out.println("进入方法");
    }


    @Around("pointcut(executeTime)")
    public Object doBefore(ProceedingJoinPoint joinPoint,ExecuteTime executeTime) throws Throwable {
//    public Object doBefore(ExecuteTime executeTime, ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();//开始时间
        final Logger LOGGER = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        try {
            return joinPoint.proceed();
        } finally {
            long end = System.currentTimeMillis();//结束时间
            long duration = end - start;
            if (duration >= executeTime.threshold()) {
                String msg = executeTime.msg();
                if (msg == null || msg.trim().length() == 0) {
                    String methodName = joinPoint.getSignature().getName();//方法名
                    LogUtils.log(LOGGER, executeTime.logLevel(), "方法[{}]执行时长:{}毫秒", methodName, duration);
                }
            } else {
                LogUtils.log(LOGGER, executeTime.logLevel(), executeTime.msg() + executeTime.postfix(), duration);
            }
        }
    }

    public static void log(Logger LOGGER, LogLevel logLevel, String msg) {
        if (logLevel == LogLevel.debug) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(msg);
            }
        } else if (logLevel == LogLevel.info) {
            LOGGER.info(msg);
        } else if (logLevel == LogLevel.warning) {
            LOGGER.warn(msg);
        } else if (logLevel == LogLevel.error) {
            LOGGER.error(msg);
        } else {
            LOGGER.info(msg);
        }
    }
}
