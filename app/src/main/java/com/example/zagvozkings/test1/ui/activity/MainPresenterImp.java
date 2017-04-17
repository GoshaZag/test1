package com.example.zagvozkings.test1.ui.activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.zagvozkings.test1.ui.activity.interfaces.MainPresenter;
import com.example.zagvozkings.test1.ui.activity.interfaces.MainView;
import com.example.zagvozkings.test1.ui.activity.interfaces.OldDataModel;
import com.example.zagvozkings.test1.ui.activity.interfaces.TimeModel;
import com.example.zagvozkings.test1.ui.customView.TimeView;
import com.example.zagvozkings.test1.ui.customView.TimeView_;

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
public class MainPresenterImp implements MainPresenter {

    @Bean(TimeRESTModel.class)
    protected TimeModel timeModel;
    @Bean(OldDataNewList.class)
    protected OldDataModel oldData;

    @RootContext
    protected Context context;

    private List<View> listTime;

    @AfterViews
    protected void init(){
        //загрузка данных или создание нового списка
        if (listTime == null)
            listTime = oldData.loadListView();
        //если придет null, то создадим новый список
        if (listTime == null)
            listTime = new ArrayList<>();

        //если некуда выводим, то на этом и закончим
        MainActivity activity = (MainActivity)context;
        if (activity == null) return;

        //если есть что выводить, то выведем
        for (View view : listTime) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
            activity.addView(view);
        }
    }

    @Override
    public void createViev(MainView mainView) {
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
