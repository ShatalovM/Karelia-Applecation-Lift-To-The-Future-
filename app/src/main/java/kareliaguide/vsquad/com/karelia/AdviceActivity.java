package kareliaguide.vsquad.com.karelia;

import android.content.Intent;
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
import android.widget.TextView;

public class AdviceActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String[] Advices_pull = {
            "Лето - идеальное для любителей экскурсионного отдыха время.",
            "Летом погода непредсказуема, возможны перепады температур от +10 до +30!",
            "Лето - наилучшее время для рыбалки.",
            "Весна - лучшее время для любителей речных сплавов.",
            "Весна - великолепное время для желающих поохотиться на пернатых.",
            "Осенью Карелия ожидает охотников и грибников со всего мира!",
            "Для любителей активного зимнего отдыха и желающих покататься на собачьих упряжках, Карелия  - одно из лучших мест!",
            "Зимой все отмечают шикарную зимнюю рыбалку!",
            "В Карелии рекомендуем путешествовать на своем автомобиле или же арендовать транспорт на месте.",
            "В Карелии очень хорошо развито водное сообщение, но крайне мало популярен железнодорожный транспорт.",
            "Меньше всего в карельских лесах летом опасайтесь диких зверей! :)",
            "Пик клещевой опасности начинается в мае, к сентябрю сходит на нет.",
            "Если собираетесь на природу в Карелию летом, то лучше заранее сделайте прививку либо проводите постоянный само-осмотр и обработку себя спреем против клещей.",
            "В Карелии водятся гадюки, поэтому лучше держитесь подальше от развалин старых домов поблизости от жилья, сваленных бревен, завалов камней, валежника, на берегу озера змея прячется в плавниках и т.д., но от укуса гадюки в Карелии никто не умирал, даже собаки проболев пару дней выздоравливают."
    };
    public int advice_num = 0;

    public TextView advice_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        advice_num = (int) Math.floor(Math.random()*Advices_pull.length);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        advice_textview = (TextView) findViewById(R.id.advice_textview);
    }

    public void nextAdvice(View view){
        advice_num = (int) Math.floor(Math.random()*Advices_pull.length);
        advice_textview.setText(advice_num);
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
        getMenuInflater().inflate(R.menu.advice, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu) {
            Intent toActivity = new Intent();
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
