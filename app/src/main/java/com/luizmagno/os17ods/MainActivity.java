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

            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_declaration) {

            Intent intent = new Intent(this, DeclaracaoActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_docs) {

            Intent intent = new Intent(this, DocumentsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_cupula) {

            Intent intent = new Intent(this, CupulaActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_agenda) {

            Intent intent = new Intent(this, AgendaActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_17_obj) {
            
            Intent intent = new Intent(this, Obj17Activity.class);
            startActivity(intent);
            
        } else if (id == R.id.nav_share) {
            
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, R.string.text_share_link);
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
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

        //Número do ODS
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
        switch (v.getId()) {
            case R.id.imageOds1Id:
                return "1";
            case R.id.imageOds2Id:
                return "2";
            case R.id.imageOds3Id:
                return "3";
            case R.id.imageOds4Id:
                return "4";
            case R.id.imageOds5Id:
                return "5";
            case R.id.imageOds6Id:
                return "6";
            case R.id.imageOds7Id:
                return "7";
            case R.id.imageOds8Id:
                return "8";
            case R.id.imageOds9Id:
                return "9";
            case R.id.imageOds10Id:
                return "10";
            case R.id.imageOds11Id:
                return "11";
            case R.id.imageOds12Id:
                return "12";
            case R.id.imageOds13Id:
                return "13";
            case R.id.imageOds14Id:
                return "14";
            case R.id.imageOds15Id:
                return "15";
            case R.id.imageOds16Id:
                return "16";
            case R.id.imageOds17Id:
                return "17";
            default:
                return "0";
                
        }

    }
}
