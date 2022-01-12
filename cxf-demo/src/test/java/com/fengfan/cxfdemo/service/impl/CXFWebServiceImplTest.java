package com.fengfan.cxfdemo.service.impl;

import com.fengfan.cxfdemo.service.CXFWebService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.jupiter.api.Test;

/**
 * Created by fengfan on 2021/2/25 9:32
 */
class CXFWebServiceImplTest {

    /**
     * 方式1 代理类工厂方式
     */

    @Test
    void hello1 (){
        try {
            // 接口地址
            String address = "http://127.0.0.1:8080/cxfDemo/services/cxfWebService?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(CXFWebService.class);
            // 创建一个代理接口实现
            CXFWebService cxfWebService = (CXFWebService) jaxWsProxyFactoryBean.create();
            // 调用代理接口的方法调用并返回结果
            String result = cxfWebService.hello("张三", 1);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 方式2 动态调用
     */
    @Test
    void hello2() {
        JaxWsDynamicClientFactory jaxWsDynamicClientFactory = JaxWsDynamicClientFactory.newInstance();
        try {
            Client client = jaxWsDynamicClientFactory.createClient("http://127.0.0.1:8080/cxfDemo/services/cxfWebService?wsdl");
            Object[] objects = client.invoke("hello", "张三", 1);
            System.out.println(objects[0].toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
