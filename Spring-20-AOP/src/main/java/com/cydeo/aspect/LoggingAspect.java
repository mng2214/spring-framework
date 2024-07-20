package com.cydeo.aspect;

import com.cydeo.dto.CourseDTO;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.sql.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    //return type *
//    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void myPointcut() {
//    }
//
//    @Before("myPointcut()")
//    public void log() {
//        logger.info("Info log................");
//    }


//    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void log() {
//        logger.info("Info log................");
//    }

    // just for particular method
//    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
//    public void courseRepositoryFindByIdPC() {
//    }
//
//    @Before("courseRepositoryFindByIdPC()")
//    public void log(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}",
//                joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }

//    @Pointcut("within(com.cydeo.controller..*)")
//    public void anyControllerOperation() {
//    }
//
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    public void anyServiceOperation() {
//    }
//
//    @Before("anyControllerOperation() || anyServiceOperation()")
//    public void combination(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}",
//                joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }

//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    public void anyOperation() {
//    }
//
//    @Before("anyOperation()")
//    public void advice(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}",
//                joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }

//        @Pointcut("@annotation(com.cydeo.annotation.Loggable)")
//    public void anyOperation() {
//    }
//
//    @Before("anyOperation()")
//    public void advice(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}",
//                joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }

//    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    public void anyOperation() {
//    }

//    @AfterReturning(pointcut = "anyOperation()", returning = "result")
//    public void advice(JoinPoint joinPoint, Object result) {
//        logger.info("AfterReturning -> Method: {}, Result: {}",
//                joinPoint.getSignature(), result.toString());
//    }

//    @AfterReturning(pointcut = "anyOperation()", returning = "results")
//    public void advice(JoinPoint joinPoint, List<CourseDTO> results) {
//        logger.info("AfterReturning -> Method: {}, Result: {}",
//                joinPoint.getSignature(), results.toString());
//    }

//    @AfterThrowing(pointcut = "anyOperation()", throwing = "exception")
//    public void advice(JoinPoint joinPoint, RuntimeException exception) {
//        logger.error("AfterThrowing -> Method: {}, Result: {}",
//                joinPoint.getSignature().toShortString(), exception.getMessage());
//    }


    @Pointcut("@annotation(com.cydeo.annotation.Loggable)")
    public void anyOperation() {
    }

    @Around("anyOperation()")
    public Object advice(ProceedingJoinPoint proceedingJoinPoint) {

        logger.info("Before -> Method: {}", proceedingJoinPoint.getSignature().toShortString());

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        assert result != null;
        logger.info("After -> Method: {}, Result: {}", proceedingJoinPoint.getSignature().toShortString(), result);

        return result;

    }


}
