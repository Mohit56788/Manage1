package com.example.user.managerapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mtoggle;
    ListView listView1;
    RatingBar rabMovie;
    TextView txtRating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setNavigationViewListener();
        setContentView(R.layout.activity_main);
        rabMovie=(RatingBar) findViewById(R.id.rabMovie);
        txtRating=(TextView) findViewById(R.id.txtRating) ;
        txtRating.setText("you have given"+rabMovie.getRating()+"stars");
        rabMovie.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                txtRating.setText("you have given"+rabMovie.getRating()+"stars");
            }
        });

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mtoggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        listView1 = (ListView) findViewById(R.id.listview1);




        mDrawerLayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<String> madapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Actions));
        listView1.setAdapter(madapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                             @Override
                                             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                                 switch (i) {
                                                     case 0:
                                                         Intent intent = new Intent(MainActivity.this, Uoactivity.class);
                                                         startActivity(intent);
                                                         break;
                                                     case 1:
                                                         Intent intent1 = new Intent(MainActivity.this, MenuEditActivity.class);
                                                         startActivity(intent1);
                                                 }
                                             }
                                         }

        );


    }

    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mtoggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav4:Intent intent2 = new Intent(MainActivity.this,SeventActivity.class);
                startActivity(intent2);

                break;

            case R.id.nav5:Intent intent3 = new Intent(MainActivity.this, RpayActivity.class);
                startActivity(intent3);
                break;

            case R.id.nav6:
                break;
            case R.id.nav7:
                //do somthing


        }
        //close navigation drawer
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;


    }
    }



