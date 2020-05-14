package com.luizmagno.os17ods;

import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.luizmagno.os17ods.fragments.AgendaFragment;
import com.luizmagno.os17ods.fragments.CupulaFragment;
import com.luizmagno.os17ods.fragments.DeclarationFragment;
import com.luizmagno.os17ods.fragments.DocumentsFragment;
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
                .replace(R.id.content_fragment, new HomeFragment())
                .commit();
    }

    @Override
    public void onBackPressed() {

        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        toolbar.setTitle(R.string.app_name);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        //Se o Nav está aberto e a Pilha de Fragments é > 0
        if (drawer.isDrawerOpen(GravityCompat.START) && fragmentManager.getBackStackEntryCount() > 0) {
            drawer.closeDrawer(GravityCompat.START);
            fragmentManager.popBackStack();
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
            return true;
        } else if (id == R.id.action_home) {

            verifyStackOfFragments();

            //Não coloca o home na Pilha de Fragments
            fragmentManager.beginTransaction()
                    .replace(R.id.content_fragment, new HomeFragment())
                    .commit();

            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            toolbar.setTitle(R.string.app_name);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_declaration) {

            verifyStackOfFragments();
            fragmentManager.beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .replace(R.id.content_fragment, new DeclarationFragment())
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_docs) {

            verifyStackOfFragments();
            fragmentManager.beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .replace(R.id.content_fragment, new DocumentsFragment())
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_cupula) {

            verifyStackOfFragments();
            fragmentManager.beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .replace(R.id.content_fragment, new CupulaFragment())
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_agenda) {

            verifyStackOfFragments();
            fragmentManager.beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .replace(R.id.content_fragment, new AgendaFragment())
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Verificar pilha de fragments
    private void verifyStackOfFragments() {
        if (fragmentManager.getBackStackEntryCount()> 0){
            fragmentManager.popBackStack();
        }
    }

}
