package kareliaguide.vsquad.com.karelia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public TextView place_description;
    public FloatingActionButton icon_or_next;
    public ImageView background_photo;

    // БД для всех мест
    public String[][] Places_base = {{
            "",
            "",
            ""
    },{
            "",
            "",
            ""
    }};

    // БД для категорий
    public String[][] Category_trees = {{
            // Titles
            ""
    },{
            // Descriptions
            ""
    }};

    public String[][] Category_culture = {{
            // Titles
            ""
    },{
            // Descriptions
            ""
    }};

    public String[][] Category_active = {{
            // Titles
            ""
    },{
            // Descriptions
            ""
    }};

    public String[][] Category_food = {{
            // Titles
            ""
    },{
            // Descriptions
            ""
    }};

    public String[][] Category_popular = {{
            // Titles
            ""
    },{ // Descriptions
            ""
    }};

    // Nearby - ???


    // БД долготы и широты для всех мест; Потом изменить по номерам
    public double[] Places_latitude = {
            1.0,
            1.0,
            1.0
    };

    public double[] Places_longitude = {
            1.0,
            1.0,
            1.0
    };

    public int place_num;
    public int shown_place = 0;
    public double lat;
    public double lon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Локация добавлена в Ваш маршрут", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        place_description = (TextView) findViewById(R.id.place_description);
        icon_or_next = (FloatingActionButton) findViewById(R.id.icon_or_next);
        background_photo = (ImageView) findViewById(R.id.main_backdrop);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Bundle getData = getIntent().getExtras();

        if (getData != null) {
            place_num = getData.getInt(""); // Получаем номер места, необходимого для подгрузки
            lat = getData.getDouble(""); // Получаем широту места
            lon = getData.getDouble(""); // Получаем долготу места
        }

        /*
        [0;n]: номер места
        {-1}: место не указано
        [-7;-2]: номер категории для отображения

        {-2}: активный отдых
        {-3}: культурный отдых
        {-4}: природа
        {-5}: еда, гурман
        */

        switch (place_num) {
            // Определение единичных мест
            case 0:
                setTitle("");
                place_description.setText("");
            case 1:
                setTitle("");
                place_description.setText("");
            case 2:
                setTitle("");
                place_description.setText("");
            case 3:
                setTitle("");
                place_description.setText("");
            case 4:
                setTitle("");
                place_description.setText("");
            case 5:
                setTitle("");
                place_description.setText("");

            // Определение по категориям
            case -2:
                icon_or_next.setImageResource(R.drawable.ic_menu_send);
                setTitle(Category_active[shown_place%Category_active.length][shown_place+1%Category_active.length]);
                place_description.setText(Category_active[shown_place%Category_active.length][shown_place+1%Category_active.length]);
                background_photo.setImageResource(R.drawable.karelia);
            case -3:
                icon_or_next.setImageResource(R.drawable.ic_menu_send);
                setTitle("");
                place_description.setText("");
            case -4:
                icon_or_next.setImageResource(R.drawable.ic_menu_send);
                setTitle("");
                place_description.setText("");
            case -5:
                icon_or_next.setImageResource(R.drawable.ic_menu_send);
                setTitle("");
                place_description.setText("");
            case -6:
                icon_or_next.setImageResource(R.drawable.ic_menu_send);
                setTitle("");
                place_description.setText("");
            case -7:
                icon_or_next.setImageResource(R.drawable.ic_menu_send);
                setTitle("");
                place_description.setText("");

            // Место не указано
            case -1:
                // обработка
        }
    }

    public void ic_next (View view){
        if (place_num <= -2 && place_num >= -7){
            shown_place++;
            setTitle(Category_active[shown_place%Category_active.length][shown_place+1%Category_active.length]);
            place_description.setText(Category_active[shown_place%Category_active.length][shown_place+1%Category_active.length]);
            background_photo.setImageResource(R.drawable.karelia);
        }
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
        getMenuInflater().inflate(R.menu.place, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
