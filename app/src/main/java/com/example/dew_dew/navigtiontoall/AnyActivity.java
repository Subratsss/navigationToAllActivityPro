package com.example.dew_dew.navigtiontoall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AnyActivity extends BaseAcitvity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.home_toolbar_layout, R.id.base_appBar);
        super.inItNavigationDrawer(R.id.home_toolbar);
       super.inItbottomNavigationModule();

    }
}
