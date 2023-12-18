//package com.zj.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * 拦截器配置类
// */
//@Configuration
//public class MyInterceptorConfig implements WebMvcConfigurer {
//
//    /**
//     * 配置拦截器
//     * @param registry
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(myInterceptor())
//                .addPathPatterns("/api/lsl/**")//需要拦截的请求
//                .addPathPatterns("/api/mjx/**")//需要拦截的请求
//                .excludePathPatterns("/api/debug/**")//不拦截的请求
//                .excludePathPatterns("api/lsl/getName");//不拦截的请求
//    }
//
//    /**
//     * 注入拦截器到spring容器
//     * @return
//     */
//    @Bean
//    public MyInterceptor myInterceptor(){
//        return new MyInterceptor();
//    }
//}