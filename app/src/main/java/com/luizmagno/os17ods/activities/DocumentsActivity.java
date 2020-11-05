package com.luizmagno.os17ods.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.luizmagno.os17ods.R;

public class DocumentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_documents);
        Toolbar toolbar = findViewById(R.id.toolbarInDocs);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentsActivity.super.onBackPressed();
            }
        });
        TextView link = findViewById(R.id.textLinkDocsTemsId);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getResources().getString(R.string.link_pdf_doc_tem);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }
}
