package kareliaguide.vsquad.com.karelia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.net.URL;

public class ToursActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tours);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void tour1 (View view){
        Intent toToursURL = new Intent(Intent.ACTION_VIEW, Uri.parse("http://scantour.ru/turi-v-kareliu/ekskursionnyy-tur-v-ruskealu-na-1-den"));
        startActivity(toToursURL);
    }

    public void tour2 (View view){
        Intent toToursURL = new Intent(Intent.ACTION_VIEW, Uri.parse("http://scantour.ru/turi-v-kareliu/bezmyatezhnyy-otpusk-v-karelii-4-dnya"));
        startActivity(toToursURL);
    }

    public void tour3 (View view){
        Intent toToursURL = new Intent(Intent.ACTION_VIEW, Uri.parse("http://scantour.ru/turi-v-kareliu/tur-v-kareliyu-na-2-dnya-romanticheskiy-uik-end-v-karelii"));
        startActivity(toToursURL);
    }

    public void tour4 (View view){
        Intent toToursURL = new Intent(Intent.ACTION_VIEW, Uri.parse("http://karelia-lines.ru/ekskursii-po-karelii/katanie-na-loshadyah.html"));
        startActivity(toToursURL);
    }

    public void tour5 (View view){
        Intent toToursURL = new Intent(Intent.ACTION_VIEW, Uri.parse("http://karelia-lines.ru/tury-na-sobachih-upryazhkah-v-karelii/katanie-na-upryazhkakh-v-votchine-talvi-ukko.html"));
        startActivity(toToursURL);
    }

    public void tour6 (View view){
        Intent toToursURL = new Intent(Intent.ACTION_VIEW, Uri.parse("http://karelia-lines.ru/tury-na-kvadrotsiklah/tur-na-kvadrotsiklah-2-dnya.html"));
        startActivity(toToursURL);
    }

    public void tour7 (View view){
        Intent toToursURL = new Intent(Intent.ACTION_VIEW, Uri.parse("http://scantour.ru/turi-v-kareliu/ekskursiya-na-valaam-na-1-den"));
        startActivity(toToursURL);
    }

    public void tour8 (View view){
        Intent toToursURL = new Intent(Intent.ACTION_VIEW, Uri.parse("http://scantour.ru/turi-v-kareliu/drevnie-vodopady-i-kanony-karelii-2-dnya"));
        startActivity(toToursURL);
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
        getMenuInflater().inflate(R.menu.tours, menu);
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
            // Handle the camera action
        } else if (id == R.id.nav_places) {

        } else if (id == R.id.nav_map) {

        } else if (id == R.id.nav_tours) {

        } else if (id == R.id.nav_advices) {

        } else if (id == R.id.nav_weather) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
