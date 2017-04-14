package com.example.zagvozkings.test1.ui.customViev;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.zagvozkings.test1.R;
import com.example.zagvozkings.test1.contanier.TimeContainer;
import com.example.zagvozkings.test1.ui.activity.MainActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

/**
 * Created by zagvozkings on 13.04.2017.
 */

@EViewGroup(R.layout.time_view)
public class TimeView extends LinearLayout{

    @ViewById
    protected TextView TimeText;
    @ViewById
    protected Button TimeButtonDel;
    @ViewById
    protected LinearLayout Line;
    protected ProgressBar progresBar;

    private int x = 0;

    @AfterViews
    protected void init(){
        progresBar = new ProgressBar(getContext());
        Line.addView(progresBar, 0);
        Line.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = (int) event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        int newX = (int) event.getX();
                        int size = Line.getWidth() / 4;
                        if (x > newX && Math.abs(x - newX) > size) {
                            TimeButtonDel.setVisibility(VISIBLE);
                        } else if (x < newX && Math.abs(x - newX) > size) {
                            TimeButtonDel.setVisibility(INVISIBLE);
                        }
                        break;
                }
                return true;
            }
        });
    }

    public TimeView(Context context) {
        super(context);
    }

    public void setTime(TimeContainer time) {
        if (time != null) {
            setTime(time.getTime() + "\n" + time.getDate());
        } else {
            setTime("problem convert");
        }
    }

    @UiThread
    public void setTime(String s) {
        if (progresBar != null)
            Line.removeView(progresBar);
        if (TimeText != null)
            TimeText.setText(s);
    }

    @Click(R.id.TimeButtonDel)
    protected void clickDel(){
        MainActivity main = (MainActivity) getContext();
        if (main != null)
            main.delVieW(this);
    }
}
