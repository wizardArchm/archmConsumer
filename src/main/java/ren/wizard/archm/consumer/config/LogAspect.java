package ren.wizard.archm.consumer.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author uyangjie
 */
@Component
@Aspect
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* ren.wizard.archm.consumer.controller.*.*(..))")
    public void webLog() {
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) {
        long start = System.currentTimeMillis();
        Object res = null;
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        try {
            res = proceedingJoinPoint.proceed();
            logger.info("request {}: {} with arg{} takes {}ms with response {}",
                    request.getMethod(),
                    request.getRequestURL().toString(),
                    Arrays.toString(proceedingJoinPoint.getArgs()),
                    System.currentTimeMillis() - start,
                    res);
        } catch (Throwable e) {
            logger.error("request {}: {} with arg{} takes {}ms with error {}",
                    request.getMethod(),
                    request.getRequestURL().toString(),
                    Arrays.toString(proceedingJoinPoint.getArgs()),
                    System.currentTimeMillis() - start,
                    e);
        }
        return res;
    }
}
