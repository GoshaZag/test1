package com.example.zagvozkings.test1.ui.activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.zagvozkings.test1.ui.activity.interfaces.MainPresenter;
import com.example.zagvozkings.test1.ui.activity.interfaces.MainView;
import com.example.zagvozkings.test1.ui.activity.interfaces.TimeModel;
import com.example.zagvozkings.test1.ui.customViev.TimeView;
import com.example.zagvozkings.test1.ui.customViev.TimeView_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zagvozkings on 13.04.2017.
 */

@EBean
public class MainPre implements MainPresenter {

    @Bean(TimeRESTModel.class)
    protected TimeModel timeModel;

    @RootContext
    protected Context context;

    private List<View> listTime;
    private MainView mainView;

    @AfterViews
    protected void init(){
        if (listTime != null && mainView != null){
            MainActivity activity = (MainActivity)context;
            for (View view : listTime){
                ViewGroup parent = (ViewGroup) view.getParent();
                if (parent != null) {
                    parent.removeView(view);
                }
                activity.addView(view);
            }
        } else {
            listTime = new ArrayList<>();
        }
    }

    @Override
    public void createViev(MainView mainView) {
        this.mainView = mainView;
        TimeView_ view = new TimeView_(context);
        view.onFinishInflate();
        listTime.add(view);
        mainView.addView(view);
        getTime(view);
    }

    @Background
    protected void getTime(TimeView view) {
        try {
            view.setTime(timeModel.getTime());
        } catch (Exception e){
            view.setTime(e.toString());
        }
    }
}
