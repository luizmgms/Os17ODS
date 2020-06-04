package com.luizmagno.os17ods;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import com.luizmagno.os17ods.fragments.HomeFragment;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import android.view.Menu;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Gerenciamento dos Fragments
    public FragmentManager fragmentManager;
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        //Set Fragment Home
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_fragment, new HomeFragment(), "home")
                .commit();
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
        fragmentManager.beginTransaction()
                .replace(R.id.content_fragment, new HomeFragment())
                .commit();
    }
}
