package privt.gene.utils.apsect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import privt.gene.utils.annotation.ExecuteTime;

/**
 * Created by Gene on 2017/12/21.
 */
@Aspect
public class ExecuteTimeAdvice {
    @Pointcut("execution(public * privt.gene..*.*(..))&&@annotation(executeTime)")
    public void pointcut(ExecuteTime executeTime){

    }
    @Around("pointcut(executeTime)")
    public Object doBefore(ExecuteTime executeTime, ProceedingJoinPoint joinPoint) throws Throwable {
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
}
