package com.example.dew_dew.navigtiontoall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AnyActivity extends BaseAcitvity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.inItNavigationDrawer();
        super.inItbottomNavigationModule();

    }
}
