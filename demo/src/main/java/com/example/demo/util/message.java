package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class message {
    @Autowired
    MessageSource messageSource;

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public String getMessage(String code) {

        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());

    }
}
