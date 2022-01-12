package com.fengfan.cxfdemo.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by fengfan on 2021/2/24 16:40
 */

/**
 * name: 暴露服务名称
 * targetNamespace: 命名空间,一般是接口的包名倒序，这两个可以不设置，有默认值的
 *
 */
@WebService(name = "cxfWebService", targetNamespace = "http://service.cxfdemo.fengfan.com")
public interface CXFWebService {

    @WebMethod(operationName = "hello")
    @WebResult
    String hello(@WebParam(name = "name") String name, @WebParam(name = "age") int age);

}
