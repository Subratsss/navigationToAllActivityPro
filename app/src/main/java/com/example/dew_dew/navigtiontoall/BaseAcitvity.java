package com.example.dew_dew.navigtiontoall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

import java.lang.reflect.Field;

public class BaseAcitvity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public DrawerLayout drawer;
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    protected void inItNavigationDrawer(int toolBarId ) {
        toolbar = (Toolbar) findViewById(toolBarId);

        if(getSupportActionBar()==null){

            setSupportActionBar(toolbar);
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    protected void inItNavigationDrawer() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(getSupportActionBar()==null){

            setSupportActionBar(toolbar);
        }
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    protected void replaceContentLayout(int sourceId,int destinationId){
        View contentLayout =findViewById(destinationId);
        ViewGroup parent= (ViewGroup) contentLayout.getParent();
        int index =parent.indexOfChild(contentLayout);
        parent.removeView(contentLayout);
        contentLayout=getLayoutInflater().inflate(sourceId,parent,false);
        parent.addView(contentLayout,index);

    }


    public void inItbottomNavigationModule() {
        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.b1:
                        startActivity(new Intent(BaseAcitvity.this,AnyActivity.class));
                        Toast.makeText(BaseAcitvity.this, "clicked", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;

            }


        });

        bottomNavigationItemShow(bottomNavigationView);

    }

    protected void bottomNavigationItemShow(BottomNavigationView bottomNavigationView){
        BottomNavigationMenuView bottomNVMenuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        try {

            Field shiftingMode = bottomNVMenuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(bottomNVMenuView, false);
            shiftingMode.setAccessible(false);


            for (int i = 0; i < bottomNVMenuView.getChildCount(); i++) {

                BottomNavigationItemView item = (BottomNavigationItemView) bottomNVMenuView.getChildAt(i);
                item.setShiftingMode(false);
                //To update view, set the checked value again
                item.setChecked(item.getItemData().isChecked());

            }


        } catch (NoSuchFieldException e) {
            e.printStackTrace();

        } catch (IllegalAccessException e) {
            e.printStackTrace();

        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }



}
