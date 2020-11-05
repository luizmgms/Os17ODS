package com.luizmagno.os17ods.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.luizmagno.os17ods.R;

public class DeclaracaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_declaration);

        //Set Toolbar
        Toolbar toolbar = findViewById(R.id.toolbarInDeclaracaoId);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setTitle(getResources().getString(R.string.menu_declaration));
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeclaracaoActivity.super.onBackPressed();
            }
        });
    }
}
