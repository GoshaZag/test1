package com.example.zagvozkings.test1.ui.activity;

import com.example.zagvozkings.test1.container.TimeContainer;
import com.example.zagvozkings.test1.protocol.RESTutils;
import com.example.zagvozkings.test1.ui.activity.interfaces.TimeModel;

import org.androidannotations.annotations.EBean;
import org.androidannotations.rest.spring.annotations.RestService;

/**
 * Created by zagvozkings on 13.04.2017.
 */

@EBean
public class TimeRESTModel implements TimeModel {

    @RestService
    protected RESTutils restUtils;

    @Override
    public TimeContainer getTime() {
        return restUtils.getTimeOnServer();
    }

}
