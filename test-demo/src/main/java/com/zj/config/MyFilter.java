//package com.zj.config;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseCookie;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Enumeration;
//
//@Component
//@WebFilter(filterName = "myFilter",urlPatterns = {"/*"})
//public class MyFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//        //获取filter名字
//        String filterName = filterConfig.getFilterName();
//
//        //获取filter里配置的init-param配置指定参数的值,如果参数不存在，则返回 null
//        String email = filterConfig.getInitParameter("email");
//
//        //获取filter里配置的init-param配置所有参数值,如果过滤器没有初始化参数，则返回一个空的 Enumeration
//        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
//
//        //返回对调用者在其中执行操作的 ServletContext 的引用。
//        ServletContext servletContext = filterConfig.getServletContext();
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
//        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
//
//        //统一编码处理
//        httpRequest.setCharacterEncoding("UTF-8");
//        httpResponse.setContentType("text/html;charset=UTF-8");
//
//        //添加name属性
//        httpRequest.setAttribute("name", "tom");
//
//        //获取请求中的所有cookie
//        Cookie[] cookies = httpRequest.getCookies();
//        if (cookies != null) {
//            StringBuilder sb = new StringBuilder();
//            for (Cookie cookie : cookies) {
//                String cookieName = cookie.getName();
//                String cookieValue = cookie.getValue();
//                //设置cookie的相关属性
//                ResponseCookie lastCookie = ResponseCookie.from(cookieName, cookieValue).httpOnly(true).sameSite("Lax").build();
//                httpResponse.addHeader(HttpHeaders.SET_COOKIE, lastCookie.toString());
//            }
//
//            filterChain.doFilter(httpRequest, httpResponse);
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}