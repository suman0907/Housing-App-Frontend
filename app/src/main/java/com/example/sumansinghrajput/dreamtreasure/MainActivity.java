package com.example.sumansinghrajput.dreamtreasure;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    public static FragmentManager frman;
    FragmentTransaction frtran;
    public static Fragment current_frag;
    HomeFrag frgobj;
    //frag2 frag1;
    LinearLayout lin1;
    public static  EditText search;
    public Button go;
    SearchRecyler frag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
         toolbar.setTitle("Dream Treasure");
        //setSupportActionBar(toolbar);
        search=(EditText) findViewById(R.id.search);
        go=(Button)findViewById(R.id.go);
        go.setOnClickListener(this);
        frag2= new SearchRecyler();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_close, R.string.navigation_drawer_open);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);





        frgobj = new HomeFrag();


        lin1 = (LinearLayout) findViewById(R.id.pf1);
        frman = getSupportFragmentManager();
        frtran = frman.beginTransaction();
        if(current_frag == null)
        {
            frtran.replace(R.id.pf1,frgobj);
            frtran.show(frgobj);
            current_frag = frgobj;
        }
        else
        {
            frtran.remove(current_frag);
            frtran.replace(R.id.pf1,frgobj);
            frtran.show(frgobj);
            current_frag = frgobj;
        }
        frtran.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            try {
                Intent intent = new Intent("android.intent.action.SECONDPAGE");
                startActivity(intent);

            } catch (Exception e) {
                Toast.makeText(this,"error occured, nahi deni kisi ko ( Personal )",Toast.LENGTH_SHORT).show();
            }
        }
        if(id==R.id.account)
        {
            try {
                Intent intent = new Intent("android.intent.action.LOG");
                startActivity(intent);

            } catch (Exception e) {
                Toast.makeText(this,"error occured, nahi deni kisi ko ( Personal )",Toast.LENGTH_SHORT).show();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.go)
        {
            if (search != null && !search.getText().toString().equals(""))
            {

                FragmentTransaction fragmentTransaction = frman.beginTransaction();
                frag2 = new SearchRecyler();
                fragmentTransaction.remove(current_frag);
                fragmentTransaction.replace(R.id.pf1,frag2);
                current_frag = frag2;
                fragmentTransaction.show(frag2);
                fragmentTransaction.commit();

            }
            else  {
                Toast.makeText(this, "Enter your search ", Toast.LENGTH_SHORT).show();
                return ;
            }
        }

    }
}
