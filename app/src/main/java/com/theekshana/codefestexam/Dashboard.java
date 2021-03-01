package com.theekshana.codefestexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class Dashboard extends AppCompatActivity {
    ChipNavigationBar chipNavigationBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        chipNavigationBar = findViewById(R.id.bottom_nav_menu);
        chipNavigationBar.setItemSelected(R.id.bottom_nav_dashboard, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NewsDash()).commit();
        bottomMenu();
    }

    private void bottomMenu() {
        chipNavigationBar.showBadge(R.id.bottom_nav_dashboard,8);
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i) {
                    case R.id.bottom_nav_dashboard:
                        fragment = new NewsDash();
                        break;
                    case R.id.bottom_nav_manage:
                        fragment = new Addticket();
                        break;
                    case R.id.bottom_nav_profile:
                        fragment = new showorder();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        });
    }
}