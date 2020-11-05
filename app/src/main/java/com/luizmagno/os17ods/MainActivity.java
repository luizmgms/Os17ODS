package com.luizmagno.os17ods;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.luizmagno.os17ods.activities.AboutActivity;
import com.luizmagno.os17ods.activities.AgendaActivity;
import com.luizmagno.os17ods.activities.CupulaActivity;
import com.luizmagno.os17ods.activities.DeclaracaoActivity;
import com.luizmagno.os17ods.activities.DocumentsActivity;
import com.luizmagno.os17ods.activities.Obj17Activity;
import com.luizmagno.os17ods.adapters.OdsAdapter;

import java.util.ArrayList;

import static com.luizmagno.os17ods.utils.Utilities.getListIdsImagesOds;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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

        //RecyclerView
        RecyclerView recyclerView = findViewById(R.id.listViewOdsId);
        //Lista de Ids das Imagens dos ODS
        ArrayList<Integer> listOds = getListIdsImagesOds();
        //SetLayout (Grid)
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        //Adapter
        OdsAdapter odsAdapter = new OdsAdapter(this, listOds);
        //Set Adapter
        recyclerView.setAdapter(odsAdapter);
        recyclerView.setHasFixedSize(true);

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
        } else if (id == R.id.action_policy) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(getResources().getString(R.string.link_to_policy)));
            startActivity(i);
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
            sendIntent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.text_share_link));
            sendIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

}
