package com.example.zagvozkings.test1.ui.activity;

import com.example.zagvozkings.test1.contanier.TimeContainer;
import com.example.zagvozkings.test1.protocol.RESTutils;
import com.example.zagvozkings.test1.ui.activity.interfaces.TimeModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.androidannotations.annotations.EBean;
import org.androidannotations.rest.spring.annotations.RestService;

import java.io.IOException;

/**
 * Created by zagvozkings on 13.04.2017.
 */

@EBean
public class TimeRESTModel implements TimeModel {

    @RestService
    protected RESTutils restUtils;

    @Override
    public TimeContainer getTime() {
        /*ObjectMapper mapper = new ObjectMapper();
        TimeContainer timeContainer;

        try {
            timeContainer = mapper.readValue(restUtils.getTimeOnServer(), TimeContainer.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }*/

        return restUtils.getTimeOnServer();
    }

}
