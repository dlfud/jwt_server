package com.example.jwtserver_forlecture.config;

import com.example.jwtserver_forlecture.filter.MyFilter1;
import com.example.jwtserver_forlecture.filter.MyFilter2;
import com.example.jwtserver_forlecture.filter.MyFilter3;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<MyFilter1> filter1() {
        FilterRegistrationBean<MyFilter1> bean =new FilterRegistrationBean<>(new MyFilter1());
        bean.addUrlPatterns("/*");
        bean.setOrder(1);// 낮은 번호가 필터중에서 가장 먼저 실행됨.
        return bean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter2> filter2() {
        FilterRegistrationBean<MyFilter2> bean =new FilterRegistrationBean<>(new MyFilter2());
        bean.addUrlPatterns("/*");
        bean.setOrder(0);// 낮은 번호가 필터중에서 가장 먼저 실행됨.
        return bean;
    }

    @Bean
    public MyFilter3 createMyFilter3() {
        return new MyFilter3();
    }

    @Bean
    public FilterRegistrationBean registration(MyFilter3 filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);  // disabled

        return registration;
    }


}
