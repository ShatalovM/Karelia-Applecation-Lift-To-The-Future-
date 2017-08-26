package kareliaguide.vsquad.com.karelia;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Display;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView first;
    ImageView second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        setTitle("Категории");

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        first = (ImageView) findViewById(R.id.btn_first);
        second = (ImageView) findViewById(R.id.btn_second);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        first.setMinimumWidth(width/2);
        first.setMaxWidth(width/2);

        second.setMinimumWidth(width/2);
        second.setMaxWidth(width/2);
    }

    public void toPlaces(View view){
        Intent toPlaceActivity = new Intent(MenuActivity.this, PlaceActivity.class);
        toPlaceActivity.putExtra("place_num", 1);
        startActivity(toPlaceActivity);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu) {
            Intent toActivity = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(toActivity);
        } else if (id == R.id.nav_places) {
            Intent toActivity = new Intent(getApplicationContext(), PlaceActivity.class);
            toActivity.putExtra("place_num", -1);
            startActivity(toActivity);
        } else if (id == R.id.nav_map) {
            Intent toActivity = new Intent(getApplicationContext(), MapsActivity.class);
            startActivity(toActivity);
        } else if (id == R.id.nav_tours) {
            Intent toActivity = new Intent(getApplicationContext(), ToursActivity.class);
            startActivity(toActivity);
        } else if (id == R.id.nav_advices) {
            Intent toActivity = new Intent(getApplicationContext(), AdviceActivity.class);
            startActivity(toActivity);
        } else if (id == R.id.nav_weather) {
            Intent toActivity = new Intent(getApplicationContext(), WeatherActivity.class);
            startActivity(toActivity);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
