package com.example.zagvozkings.test1.ui.activity;

import android.view.View;

import com.example.zagvozkings.test1.ui.activity.interfaces.OldDataModel;

import java.util.ArrayList;
import java.util.List;


public class OldDataNewList implements OldDataModel {
    @Override
    public List<View> loadListView() {
        return new ArrayList<>();
    }
}
