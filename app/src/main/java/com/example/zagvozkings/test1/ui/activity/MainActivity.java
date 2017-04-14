package com.example.zagvozkings.test1.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.zagvozkings.test1.ui.activity.interfaces.MainPresenter;
import com.example.zagvozkings.test1.ui.activity.interfaces.MainView;
import com.example.zagvozkings.test1.R;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements MainView{

    @ViewById
    protected LinearLayout main;

    @NonConfigurationInstance
    @Bean(MainPre.class)
    protected MainPresenter mainPresenter;


    @Click(R.id.MainButtonAddTime)
    protected void add(){
        mainPresenter.createViev(this);
    }

    @UiThread
    @Override
    public void addView(View view) {
        if (main != null && view != null){
            main.addView(view);
        }
    }

    @UiThread
    @Override
    public void delVieW(View view) {
        if (view == null) return;
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null) return;
        viewGroup.removeView(view);

    }
}
