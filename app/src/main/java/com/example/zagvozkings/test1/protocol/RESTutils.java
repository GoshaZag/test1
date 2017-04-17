package com.example.zagvozkings.test1.protocol;

import com.example.zagvozkings.test1.container.TimeContainer;

import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Rest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by zagvozkings on 13.04.2017.
 */

@Rest(converters = {MappingJackson2HttpMessageConverter.class})
public interface RESTutils {

    @Get("http://date.jsontest.com")
    TimeContainer getTimeOnServer();
}
