package com.zj.mybatisplus.aspect;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zj.mybatisplus.entity.TAdmin;
import com.zj.mybatisplus.service.TAdminService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Aspect
public class TransactionAdvice {

    @Autowired
    private TAdminService adminService;

    @AfterThrowing(throwing = "th",value = "execution(* com.zj.mybatisplus.controller.TAdminController.insert(..))")
    public void afterThrowing(JoinPoint pointcut, Throwable th){
        Object[] args = pointcut.getArgs();
        for (Object arg : args) {
            System.out.println("arg = " + arg);
        }
        System.out.println("异常通知");

        BaseMapper<TAdmin> baseMapper = adminService.getBaseMapper();
        TAdmin admin = new TAdmin();
        admin.setId(3);
        admin.setName("zhangsan_" + 3);
        admin.setPassword("123_" + 3);
        baseMapper.insert(admin);
        System.out.println("###insert success");
    }

    @Before("execution(* com.zj.mybatisplus.controller.TAdminController.insert(..)) && @annotation(transactional)")
    public void beforeTransactionCommit(JoinPoint joinPoint, Transactional transactional) {
        // 这里写你想在事务提交后执行的代码
        System.out.println("Transaction committed, method: " + joinPoint.getSignature().getName());
    }

}
