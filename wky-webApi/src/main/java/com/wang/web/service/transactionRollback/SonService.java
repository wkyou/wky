package com.wang.web.service.transactionRollback;

import com.wang.dao.entity.TOrder;
import com.wang.web.service.seckill.OrderService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @Author WangKanYou
 * @Date 2023/3/17 11:11
 * @描述:
 */
@Service
public class SonService {
    @Resource
    private OrderService orderService;
    @Resource
    private PlatformTransactionManager transactionManager;

    /**
     * 参数说明:  以下4个方法参数和此相同
     *
     * @param args   业务中需要传递的参数
     * @param thread 调用者的线程, 用于aop获取参数, 不建议以方法重写的方式简略此参数,
     *               在调用者方法中可以以此参数为标识计算子线程的个数作为注解参数,避免线程参数计算错误导致锁表
     *               传参时参数固定为: Thread.currentThread()
     */
    //@Transactional(rollbackFor = Exception.class)
    //@Async("asyncServiceExecutor")
    //@SonTransaction
    public void sonMethod1(String args, Thread thread) {
        TOrder order = new TOrder();
        order.setOrderName("sonMethod1");
        order.setCreateBy("");
        order.setCreateDate(LocalDateTime.now());
        order.setUpdateBy(order.getOrderUser());
        order.setUpdateDate(LocalDateTime.now());
        order.setDelFlag("0");
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();// 开启事务
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);// 设置事务隔离级别
        TransactionStatus status = transactionManager.getTransaction(def);
        int i = orderService.saveOrder(order);
        transactionManager.rollback(status);
        System.out.println("sonMethod1线程名称1"+Thread.currentThread().getName());
        System.out.println("sonMethod1线程名称"+thread.currentThread().getName());
        System.out.println(args + "开启了线程");
    }

    //@Transactional(rollbackFor = Exception.class)
    //@Async("asyncServiceExecutor")
    //@SonTransaction
    public void sonMethod2(String args1, String args2, Thread thread) {
        TOrder order = new TOrder();
        order.setOrderName("sonMethod2");
        order.setCreateBy("");
        order.setCreateDate(LocalDateTime.now());
        order.setUpdateBy(order.getOrderUser());
        order.setUpdateDate(LocalDateTime.now());
        order.setDelFlag("0");
        int i = orderService.saveOrder(order);
        System.out.println("sonMethod2线程名称1"+Thread.currentThread().getName());
        System.out.println("sonMethod2线程名称"+thread.currentThread().getName());
        System.out.println(args1 + "和" + args2 + "开启了线程");
    }

    @Transactional(rollbackFor = Exception.class)
    //@Async("asyncServiceExecutor")
    //@SonTransaction
    public void sonMethod3(String args, Thread thread) {
        TOrder order = new TOrder();
        order.setOrderName("sonMethod3");
        order.setCreateBy("");
        order.setCreateDate(LocalDateTime.now());
        order.setUpdateBy(order.getOrderUser());
        order.setUpdateDate(LocalDateTime.now());
        order.setDelFlag("0");
        int i = orderService.saveOrder(order);
        if (true){
            throw new RuntimeException();
        }
        System.out.println("sonMethod3线程名称1"+Thread.currentThread().getName());
        System.out.println("sonMethod3线程名称"+thread.currentThread().getName());
        System.out.println(args + "开启了线程");
    }

    //sonMethod4方法没有使用线程池
    //@Transactional(rollbackFor = Exception.class)
    public void sonMethod4(String args) {
        TOrder order = new TOrder();
        order.setOrderName("sonMethod4");
        order.setCreateBy("");
        order.setCreateDate(LocalDateTime.now());
        order.setUpdateBy(order.getOrderUser());
        order.setUpdateDate(LocalDateTime.now());
        order.setDelFlag("0");
        int i = orderService.saveOrder(order);
        System.out.println("sonMethod4线程名称1"+Thread.currentThread().getName());
        if (true){
            throw new RuntimeException();
        }
        System.out.println(args + "没有开启线程");
    }
}
