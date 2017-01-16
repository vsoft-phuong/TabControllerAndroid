package com.appolica.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.appolica.sample.databinding.ActivityTabControllerBinding;
import com.appolica.tabcontroller.FragmentProvider;
import com.appolica.tabcontroller.TabController;
import com.appolica.tabcontroller.listener.OnFragmentChangeListener;

public class TabControllerActivity
        extends AppCompatActivity
        implements TabClickListener, OnFragmentChangeListener {

    private static final String TAG = "TabControllerActivity";

    private TabController tabController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTabControllerBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_tab_controller);

        binding.setClickListener(this);
        tabController = new TabController(getSupportFragmentManager(), R.id.container);
        tabController.setChangeListener(this);

        if (savedInstanceState != null) {
            tabController.restore(savedInstanceState);
        } else {
            tabController.switchTo(Tabs.TAB_1);
        }

    }

    @Override
    public void onTab1Click() {
        tabController.switchTo(Tabs.TAB_1);
    }

    @Override
    public void onTab2Click() {
        tabController.switchTo(Tabs.TAB_2);
    }

    @Override
    public void onTab3Click() {
        tabController.switchTo(Tabs.TAB_3);
    }

    @Override
    public void onTab4Click() {
        tabController.switchTo(Tabs.TAB_4);
    }

    @Override
    public void onFragmentShown(FragmentProvider fragmentType, Fragment shownFragment) {
        Log.d(TAG, "onFragmentShown: " + fragmentType.getTag());
    }

    @Override
    public void onFragmentAlreadyVisible(FragmentProvider fragmentType, Fragment visibleFragment) {
        Log.d(TAG, "onFragmentAlreadyVisible: " + fragmentType.getTag());
    }

    @Override
    public void onFragmentCreated(FragmentProvider fragmentType, Fragment addedFragment) {
        Log.d(TAG, "onFragmentCreated: " + fragmentType.getTag());
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        tabController.save(outState);
    }
}