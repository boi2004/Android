package com.example.buoi5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.buoi5.frament.Login;
import com.example.buoi5.frament.j4f;
import com.example.buoi5.frament.register;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("main");
    }
    void loadFragment(Fragment fmNew){
        FragmentTransaction fmtran = getSupportFragmentManager().beginTransaction();
        fmtran.replace(R.id.main_frame,fmNew);
        fmtran.addToBackStack(null);
        fmtran.commit();
    }
    private  void addEvent(){
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //load Fragment
                Fragment fmNew;
                if(item.getItemId()==R.id.bottomNav){
                    fmNew= new j4f();
                    loadFragment(fmNew);
                    getSupportActionBar().setTitle(item.getTitle());
                    return true;
                }
                if(item.getItemId()==R.id.bottomNav){
                    fmNew= new Login();
                    loadFragment(fmNew);
                    return true;
                }
                if(item.getItemId()==R.id.bottomNav){
                    fmNew= new register();
                    loadFragment(fmNew);
                    return true;
                }
                return true;
            }
        });
    }
    private  void  addControls(){
        bottomNav=findViewById(R.id.bottomNav);
    }
}