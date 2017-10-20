package com.example.dew_dew.navigtiontoall;

import android.os.Bundle;
import android.view.Menu;

public class HomeActivity extends BaseAcitvity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.inItNavigationDrawer();
        super.inItbottomNavigationModule();

    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu,menu);
        return true;
    }
}
