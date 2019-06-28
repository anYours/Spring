package com.aop;

import com.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *事务配置
 */
@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.aop.Master)" +
            " && (execution(* com.service.impl.*.select*(..))" +
            "||execution(* com.service.impl.*.get*(..))  )")
    public void readPointcut(){}


    @Pointcut("@annotation(com.aop.Master) " +
            " || (execution(* com.service.impl.*.insert*(..))" +
            " || execution(* com.service.impl.*.add*(..))" +
            " || execution(* com.service.impl.*.update*(..))" +
            " || execution(* com.service.impl.*.edit*(..))" +
            " || execution(* com.service.impl.*.delete*(..))" +
            " || execution(* com.service.impl.*.remove*(..))" +
            "  ) ")
    public void writePointcut(){

    }

    @Before("readPointcut()")
    public void read(){
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write(){
        DBContextHolder.master();
    }
}
