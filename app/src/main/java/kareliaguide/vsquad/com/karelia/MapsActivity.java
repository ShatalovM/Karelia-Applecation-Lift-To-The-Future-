package kareliaguide.vsquad.com.karelia;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.akexorcist.googledirection.DirectionCallback;
import com.akexorcist.googledirection.GoogleDirection;
import com.akexorcist.googledirection.constant.AvoidType;
import com.akexorcist.googledirection.constant.Language;
import com.akexorcist.googledirection.constant.TransportMode;
import com.akexorcist.googledirection.model.Direction;
import com.akexorcist.googledirection.util.DirectionConverter;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {

    public String[] Places_base = {
            "Кижи",
            "Онежское озеро",
            "Валаамский монастырь",
            "Церковь Преображения Господня",
            "Ладожское озеро",
            "Рускеала Горный Парк",
            "Кивач",
            "Рускеальские водопады",
            "Воттоваара",
            "Памятник Петру I"
    };

    public double[] Places_latitude = {
            62.0844,
            61.6057,
            61.389167,
            62.0661,
            60.7954,
            61.9446486,
            62.2628,
            61.9095,
            63.0697,
            61.7903
    };

    public double[] Places_longitude = {
            35.2191,
            35.9583,
            30.945,
            35.2412,
            31.9908,
            30.5128264,
            33.9775,
            30.629,
            32.6254,
            34.3897
    };

    public ArrayList<Double> Locations_list_lat = new ArrayList<Double>();
    public ArrayList<Double> Locations_list_lon = new ArrayList<Double>();

    double longitude4places;
    double latitude4places;

    private GoogleMap mMap;
    private final LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            longitude = location.getLongitude();
            latitude = location.getLatitude();
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };

    LocationManager lm;
    Location location;
    double longitude;
    double latitude;
    LatLngBounds.Builder builder;
    CameraUpdate cu;
    Marker m1;
    Marker m2;
    Marker m3;
    Marker m4;
    Marker m5;
    Marker m6;
    Marker m7;
    Marker m8;
    Marker m9;
    Marker m10;
    Marker userLocation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener()
        {

            @Override
            public void onInfoWindowClick(Marker arg0) {
                int place_num = 0;
                if(arg0 != null) {
                    Intent toMoreInfo = new Intent(MapsActivity.this, PlaceActivity.class);

                    for (int i = 0; i < Places_base.length; i++) {
                        if (arg0.getTitle().equals(Places_base[i])) {
                            place_num = i;
                            latitude4places = Places_latitude[i];
                            longitude4places = Places_longitude[i];
                        }
                    }

                    toMoreInfo.putExtra("place_num", place_num);
                    toMoreInfo.putExtra("latitude", latitude4places);
                    toMoreInfo.putExtra("longitude", longitude4places);
                    startActivity(toMoreInfo);
                }
            }
        });

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        LatLng user_location = new LatLng(latitude, longitude);
        List<Marker> markersList = new ArrayList<Marker>();
        builder = new LatLngBounds.Builder();

        userLocation = mMap.addMarker(new MarkerOptions().position(new LatLng(
                location.getLatitude(), location.getLongitude())).title("Вы здесь"));

        mMap.addMarker(new MarkerOptions().position(new LatLng(
                location.getLatitude(), location.getLongitude())).title("Вы здесь"));

        for (int i = 0; i < Places_base.length; i++){
            /*
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(Places_latitude[i], Places_longitude[i]))
                    .title(Places_base[i])
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.kizhi_marker))
                    .snippet("Подробнее...")
            );
            */


            switch (i){
                case 0:
                    m1 = mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(Places_latitude[i], Places_longitude[i]))
                            .title(Places_base[i])
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.kizhi_marker))
                            .snippet("Подробнее...")
                    );
                    continue;
                case 1:
                    m2 = mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(Places_latitude[i], Places_longitude[i]))
                            .title(Places_base[i])
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.onejskoe_logo))
                            .snippet("Подробнее...")
                    );
                    continue;
                case 2:
                    m3 = mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(Places_latitude[i], Places_longitude[i]))
                            .title(Places_base[i])
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.monastir_logo))
                            .snippet("Подробнее...")
                    );
                    continue;
                case 3:
                    m4 = mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(Places_latitude[i], Places_longitude[i]))
                            .title(Places_base[i])
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.cerkovnakizhah_logo))
                            .snippet("Подробнее...")
                    );
                    continue;
                case 4:
                    m5 = mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(Places_latitude[i], Places_longitude[i]))
                            .title(Places_base[i])
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ladojskoe_logo))
                            .snippet("Подробнее...")
                    );
                    continue;
                case 5:
                    m6 = mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(Places_latitude[i], Places_longitude[i]))
                            .title(Places_base[i])
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ruskeala_logo))
                            .snippet("Подробнее...")
                    );
                    continue;
                case 6:
                    m7 = mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(Places_latitude[i], Places_longitude[i]))
                            .title(Places_base[i])
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.kivach_logo))
                            .snippet("Подробнее...")
                    );
                    continue;
                case 7:
                    m8 = mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(Places_latitude[i], Places_longitude[i]))
                            .title(Places_base[i])
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.vodopadi_logo))
                            .snippet("Подробнее...")
                    );
                    continue;
                case 8:
                    m9 = mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(Places_latitude[i], Places_longitude[i]))
                            .title(Places_base[i])
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.vottavara_logo))
                            .snippet("Подробнее...")
                    );
                case 9:
                    m10 = mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(Places_latitude[i], Places_longitude[i]))
                            .title(Places_base[i])
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.petr_first_logo))
                            .snippet("Подробнее...")
                    );
                    continue;
            }
        }

        builder.include(m1.getPosition());
        builder.include(m2.getPosition());
        builder.include(m3.getPosition());
        builder.include(m4.getPosition());
        builder.include(m5.getPosition());
        builder.include(m6.getPosition());
        builder.include(m7.getPosition());
        builder.include(m8.getPosition());
        builder.include(m9.getPosition());
        builder.include(m10.getPosition());

        int padding = 50;
        LatLngBounds bounds = builder.build();
        cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                mMap.animateCamera(cu);
            }
        });
    }

    public void toCorrector (View view){
        GoogleDirection.withServerKey("AIzaSyDO8ApRI_rmn5fHoXZdE8RlASKSbqz-PPA")
                .from(new LatLng(Places_latitude[0], Places_longitude[0]))
                .to(new LatLng(Places_latitude[1], Places_longitude[1]))
                .avoid(AvoidType.FERRIES)
                .avoid(AvoidType.HIGHWAYS)
                .execute(new DirectionCallback() {
                    @Override
                    public void onDirectionSuccess(Direction direction, String rawBody) {
                        if(direction.isOK()) {
                            Toast.makeText(MapsActivity.this, "Success with status : " + direction.getStatus(), Toast.LENGTH_SHORT).show();
                            mMap.addMarker(new MarkerOptions().position(new LatLng(Places_latitude[0], Places_longitude[0])));
                            mMap.addMarker(new MarkerOptions().position(new LatLng(Places_latitude[1], Places_longitude[1])));

                            ArrayList<LatLng> directionPositionList = direction.getRouteList().get(0).getLegList().get(0).getDirectionPoint();
                            mMap.addPolyline(DirectionConverter.createPolyline(MapsActivity.this, directionPositionList, 5, Color.RED));
                    } else {
                            System.out.println("OK or not");
                        }
                }

        @Override
        public void onDirectionFailure(Throwable t) {
            System.out.println("Fail"+t.getMessage()+"\n"+t.getCause());
        }
    });
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
        getMenuInflater().inflate(R.menu.maps, menu);
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
