package kareliaguide.vsquad.com.karelia;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.CardView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import github.vatsal.easyweather.Helper.ForecastCallback;
import github.vatsal.easyweather.Helper.TempUnitConverter;
import github.vatsal.easyweather.Helper.WeatherCallback;
import github.vatsal.easyweather.WeatherMap;
import github.vatsal.easyweather.retrofit.models.ForecastResponseModel;
import github.vatsal.easyweather.retrofit.models.Weather;
import github.vatsal.easyweather.retrofit.models.WeatherResponseModel;

public class WeatherActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public final String APP_ID = BuildConfig.OWM_API_KEY;
    String city = "Петрозаводск";

    String[] data = {"Петрозаводск", "Кондопога", "Костомукша", "Лахденпохья",
            "Олонец", "Питкяранта", "Пудож", "Сортавала", "Суоярви"};

    TextView weatherTitle;
    ImageButton refresh;
    ImageView weatherIcon;
    TextView condition;
    TextView temp;
    TextView tvHumidity;
    TextView tvPressure;
    TextView tvWind;
    TextView tvWindDeg;
    LinearLayout textLayout;
    TextView humidityDesc;
    TextView presDesc;
    TextView wsDesc;
    TextView wdDesc;
    LinearLayout llExtraWeather;
    CardView weatherCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        weatherTitle = (TextView) findViewById(R.id.weather_title);
        refresh = (ImageButton) findViewById(R.id.refresh);
        weatherIcon = (ImageView) findViewById(R.id.weather_icon);
        condition = (TextView) findViewById(R.id.condition);
        temp = (TextView) findViewById(R.id.temp);
        tvHumidity = (TextView) findViewById(R.id.tvHumidity);
        tvPressure = (TextView) findViewById(R.id.tvPressure);
        tvWind = (TextView) findViewById(R.id.tvWind);
        tvWindDeg = (TextView) findViewById(R.id.tvWindDeg);
        textLayout = (LinearLayout) findViewById(R.id.textLayout);
        humidityDesc = (TextView) findViewById(R.id.humidity_desc);
        presDesc = (TextView) findViewById(R.id.pres_desc);
        wsDesc = (TextView) findViewById(R.id.ws_desc);
        wdDesc = (TextView) findViewById(R.id.wd_desc);
        llExtraWeather = (LinearLayout) findViewById(R.id.ll_extraWeather);
        weatherCard = (CardView) findViewById(R.id.weatherCard);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        // заголовок
        spinner.setPrompt("Title");
        // выделяем элемент
        spinner.setSelection(0);
        // устанавливаем обработчик нажатия
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                city = spinner.getSelectedItem().toString().trim();
                loadWeather(city);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

    }

    public void refresh(View view) {
        loadWeather(city);
    }

    private void loadWeather(String city) {
        WeatherMap weatherMap = new WeatherMap(this, APP_ID);
        weatherMap.getCityWeather(city, new WeatherCallback() {
            @Override
            public void success(WeatherResponseModel response) {
                populateWeather(response);
            }

            @Override
            public void failure(String message) {

            }
        });

        weatherMap.getCityForecast(city, new ForecastCallback() {
            @Override
            public void success(ForecastResponseModel response) {
                ForecastResponseModel responseModel = response;
            }

            @Override
            public void failure(String message) {

            }
        });
    }

    private void populateWeather(WeatherResponseModel response) {

        Weather weather[] = response.getWeather();
        condition.setText(weather[0].getMain());
        temp.setText(TempUnitConverter.convertToCelsius(response.getMain().getTemp()).intValue() + " °C");

        tvHumidity.setText(response.getMain().getHumidity() + "%");
        tvPressure.setText(response.getMain().getPressure() + " hPa");
        tvWind.setText(response.getWind().getSpeed() + "m/s");
        tvWindDeg.setText(response.getWind().getDeg() + "°");

        String link = weather[0].getIconLink();
        Picasso.with(this).load(link).into(weatherIcon);
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
        getMenuInflater().inflate(R.menu.weather, menu);
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
