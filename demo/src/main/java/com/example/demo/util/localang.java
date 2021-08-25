//package com.example.demo.util;
//
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.support.RequestContextUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Locale;
//
//public class localang implements LocaleResolver {
//    @Override
//    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
//        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(httpServletRequest);
//        return localeResolver.resolveLocale(httpServletRequest);
//    }
//
//    @Override
//    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
//
//    }
//}
