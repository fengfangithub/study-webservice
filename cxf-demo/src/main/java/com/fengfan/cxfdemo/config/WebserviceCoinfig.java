package com.fengfan.cxfdemo.config;

import com.fengfan.cxfdemo.service.CXFWebService;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.xml.ws.Endpoint;

/**
 * Created by fengfan on 2021/2/24 16:47
 */
@Configuration
public class WebserviceCoinfig {
    @Resource
    private CXFWebService cxfWebService;

    @Bean
    public ServletRegistrationBean cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/services/*");
    }

    @Bean
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(cxf(), cxfWebService);
        endpoint.publish("/cxfWebService");
        return endpoint;
    }
}
