package com.example.zagvozkings.test1.container;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by zagvozkings on 13.04.2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeContainer {
    private String time;
    //private String milliseconds_since_epoch;
    private String date;

    public String getTime(){return time;}
    public String getDate(){return date;}

    public void setTime(String time){this.time = time;}
    public void setDate(String date){this.date = date;}

}
