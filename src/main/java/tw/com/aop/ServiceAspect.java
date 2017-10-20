package tw.com.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Service AOP
 *
 * @author Rex
 */
@Component
@Aspect
public class ServiceAspect {

    private static Logger logger = Logger.getLogger(ServiceAspect.class);

    @Pointcut("execution(* tw.com.service.impl.*.*(..))")
    private void defaultPointcut() {}

    /**
     * method執行前log
     *
     * @param joinPoint 連接點資訊
     */
    @Before("defaultPointcut()")
    public void beforeLog(JoinPoint joinPoint) {
        logger.info(joinPoint.getSignature() + " start!");
        Stream.of(joinPoint.getArgs()).forEach(arg -> logger.info("arg: " + arg));
    }

    /**
     * method執行後log
     *
     * @param joinPoint 連接點資訊
     */
    @After("defaultPointcut()")
    public void afterLog(JoinPoint joinPoint) {
        logger.info(joinPoint.getSignature() + " end!");
        Stream.of(joinPoint.getArgs()).forEach(arg -> logger.info("arg: " + arg.toString()));
    }


    /**
     * 返回結果後log
     *
     * @param joinPoint 連接點資訊
     * @param result    結果
     */
    @AfterReturning(value = "defaultPointcut()", returning = "result")
    public void resultLog(JoinPoint joinPoint, Object result) {
        logger.info(joinPoint.getSignature() + " result = " + result);
    }

    @AfterThrowing(value = "defaultPointcut()", throwing = "e")
    public void exceptionLog(JoinPoint joinPoint, Exception e) {
        logger.info(joinPoint.getSignature() + " Error!", e);
    }

}
