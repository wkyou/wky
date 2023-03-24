package com.wang.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @Author WangKanYou
 * @Date 2023/3/15 11:47
 * @描述:
 */
@WebService
public interface HelloService {
    /**
     * 对外发布服务的接口的方法
     * @param name
     * @return
     */
    @WebMethod
    public String sayHello(@WebParam(name="cxtj",targetNamespace = "http://com.wang.webservice.service.impl.sayHello")String name);
}
