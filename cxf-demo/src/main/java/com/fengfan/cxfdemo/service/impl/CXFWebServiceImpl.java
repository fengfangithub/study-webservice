package com.fengfan.cxfdemo.service.impl;

import com.fengfan.cxfdemo.service.CXFWebService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * Created by fengfan on 2021/2/24 16:41
 */

/**
 * name: 与接口中指定的name一致
 * targetNamespace: 命名空间，与接口中的命名空间一致,一般是接口的包名倒序
 * endpointInterface:
 */
@WebService(serviceName = "cxfWebService", targetNamespace = "http://service.cxfdemo.fengfan.com", endpointInterface = "com.fengfan.cxfdemo.service.CXFWebService")
@Service
public class CXFWebServiceImpl  implements CXFWebService {

    @Override
    public String hello(String name, int age) {
        return "hello：姓名"+ name + "年龄" + age;
    }
}
