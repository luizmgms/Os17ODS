package com.luizmagno.os17ods;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private ArrayList<View> objectives;
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objectives = new ArrayList<>();

        //Preenchendo Array de Objetivos - 0 a 17
        fillListOfObjectives();

        //Set OnClick
        for (View objective: objectives) {
            objective.setOnClickListener(this);
        }

        //toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //NavigationDrawer
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Ação do Item do Navigation
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        //Se o Nav está aberto
        if (drawer.isDrawerOpen(GravityCompat.START) ) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            //Intent intent = new Intent(this, AboutActivity.class);
            //startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_declaration) {

            Intent intent = new Intent(this, DeclaracaoActivity.class);
            startActivity(intent);
            setHome();

        } else if (id == R.id.nav_docs) {

            Intent intent = new Intent(this, DocumentsActivity.class);
            startActivity(intent);
            setHome();

        } else if (id == R.id.nav_cupula) {

            Intent intent = new Intent(this, CupulaActivity.class);
            startActivity(intent);
            setHome();

        } else if (id == R.id.nav_agenda) {

            Intent intent = new Intent(this, AgendaActivity.class);
            startActivity(intent);
            setHome();

        } else if (id == R.id.nav_17_obj) {
            Intent intent = new Intent(this, Obj17Activity.class);
            startActivity(intent);
            setHome();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    //Set Home
    private void setHome(){

    }

    private void fillListOfObjectives() {
        objectives.add( findViewById(R.id.imageOds1Id) );
        objectives.add( findViewById(R.id.imageOds2Id) );
        objectives.add(  findViewById(R.id.imageOds3Id) );
        objectives.add(  findViewById(R.id.imageOds4Id) );
        objectives.add(  findViewById(R.id.imageOds5Id) );
        objectives.add(  findViewById(R.id.imageOds6Id) );
        objectives.add(  findViewById(R.id.imageOds7Id) );
        objectives.add(  findViewById(R.id.imageOds8Id) );
        objectives.add(  findViewById(R.id.imageOds9Id) );
        objectives.add(  findViewById(R.id.imageOds10Id) );
        objectives.add(  findViewById(R.id.imageOds11Id) );
        objectives.add(  findViewById(R.id.imageOds12Id) );
        objectives.add(  findViewById(R.id.imageOds13Id) );
        objectives.add(  findViewById(R.id.imageOds14Id) );
        objectives.add(  findViewById(R.id.imageOds15Id) );
        objectives.add(  findViewById(R.id.imageOds16Id) );
        objectives.add(  findViewById(R.id.imageOds17Id) );
        objectives.add(  findViewById(R.id.imageONUId) );

    }

    @Override
    public void onClick(View v) {

        v.setAlpha(0.6f);
        String numOfOds = getNumOds(v);

        Intent intent = new Intent(this, OdsActivity.class);
        intent.putExtra("idOds", numOfOds);

        //Transição com elemento comum
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions
                    .makeSceneTransitionAnimation(this, v, "transform");
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }


    }

    private String getNumOds(@NotNull View v){
        String numOds;
        switch (v.getId()) {
            case R.id.imageOds1Id:
                numOds = "1";
                break;
            case R.id.imageOds2Id:
                numOds = "2";
                break;
            case R.id.imageOds3Id:
                numOds = "3";
                break;
            case R.id.imageOds4Id:
                numOds = "4";
                break;
            case R.id.imageOds5Id:
                numOds = "5";
                break;
            case R.id.imageOds6Id:
                numOds = "6";
                break;
            case R.id.imageOds7Id:
                numOds = "7";
                break;
            case R.id.imageOds8Id:
                numOds = "8";
                break;
            case R.id.imageOds9Id:
                numOds = "9";
                break;
            case R.id.imageOds10Id:
                numOds = "10";
                break;
            case R.id.imageOds11Id:
                numOds = "11";
                break;
            case R.id.imageOds12Id:
                numOds = "12";
                break;
            case R.id.imageOds13Id:
                numOds = "13";
                break;
            case R.id.imageOds14Id:
                numOds = "14";
                break;
            case R.id.imageOds15Id:
                numOds = "15";
                break;
            case R.id.imageOds16Id:
                numOds = "16";
                break;
            case R.id.imageOds17Id:
                numOds = "17";
                break;
            default:
                numOds = "0";
                break;
        }

        return numOds;

    }
}
