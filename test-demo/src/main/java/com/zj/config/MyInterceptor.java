//package com.zj.config;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//public class MyInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//
//        //在拦截的请求了添加属性,在对应请求的controller中的request中就可以获取该参数了
//        //比如String userName = (String)request.getAttribute("userName");
//        request.setAttribute("userName","lsl");
//
//        //获取cookie
//        Cookie[] cookies = request.getCookies();
//
//        //设置header属性
//        response.addHeader("SameSite","Lax");
//
//        //添加cookie
//        Cookie cookie = new Cookie("name","lsl");
//        response.addCookie(cookie);
//
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
//}