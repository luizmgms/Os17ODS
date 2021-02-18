package com.luizmagno.os17ods.activities;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.ViewPager;

import com.luizmagno.os17ods.R;
import com.luizmagno.os17ods.adapters.PagerImgOdsAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import static com.luizmagno.os17ods.utils.Utilities.getIdsOfAttribOds;
import static com.luizmagno.os17ods.utils.Utilities.getListIdsImagesOds;

public class ViewImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        final Resources resources = getResources();

        int num_ods = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null ) {
            num_ods = extras.getInt("numOds");
        }

        ArrayList<Integer> listIdsImgsOds = getListIdsImagesOds();

        final ViewPager viewPager = findViewById(R.id.viewPagerImgOdsId);

        final PagerImgOdsAdapter pagerImgOdsAdapter = new PagerImgOdsAdapter(
                getSupportFragmentManager(), 0, listIdsImgsOds);

        viewPager.setAdapter(pagerImgOdsAdapter);
        viewPager.setCurrentItem(num_ods);

        //BACK
        ImageView btnBack = findViewById(R.id.btnBackId);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewImageActivity.super.onBackPressed();
            }
        });

        //COMPARTILHAR
        ImageView btnShare = findViewById(R.id.btnShareId);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] id = getIdsOfAttribOds(viewPager.getCurrentItem());
                shareImage(id[0], resources);
            }
        });

        //SALVAR
        ImageView btnSave = findViewById(R.id.btnSaveId);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveImage(viewPager.getCurrentItem());
            }
        });
    }

    private void saveImage(int pos) {

        // Verifica  o estado da permissão de WRITE_EXTERNAL_STORAGE
        int permissionCheck = ContextCompat
                .checkSelfPermission(
                        this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            // Se for diferente de PERMISSION_GRANTED, então vamos exibir a tela padrão
            ActivityCompat
                    .requestPermissions(
                            this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            1);
        } else {
            //Se não, vamos salvar a imagem
            toSaveImage(pos, getResources());
        }
    }

    private void shareImage(int id, Resources res) {
        Uri uri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(res.getResourcePackageName(id))
                .appendPath(res.getResourceTypeName(id))
                .appendPath(res.getResourceEntryName(id))
                .build();

        Intent shareIntent = new Intent();
        shareIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.setType("image/*");
        startActivity(Intent.createChooser(shareIntent, res.getString(R.string.shared_with)));
    }

    private void toSaveImage(int pos, Resources res) {

        int[] id = getIdsOfAttribOds(pos);

        Bitmap bitmap = ((BitmapDrawable) ResourcesCompat.getDrawable(res, id[0], null))
                .getBitmap();

        String nameOds = res.getString(id[5]);
        String descOds = res.getString(id[1]);

        OutputStream fOut = null;
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fileName = "Image-" + n + "-ODS" + pos + ".png";
        final String appDirectoryName = "imagesOds";
        final File imageRoot = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), appDirectoryName);

        imageRoot.mkdirs();

        final File file = new File(imageRoot, fileName);
        try {
            fOut = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            Toast.makeText(ViewImageActivity.this,
                    file.getAbsolutePath(),
                    Toast.LENGTH_LONG).show();
            fOut.flush();
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, nameOds);
        values.put(MediaStore.Images.Media.DESCRIPTION, descOds);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis());
            values.put(MediaStore.Images.ImageColumns.BUCKET_ID, file.toString()
                    .toLowerCase(Locale.getDefault()).hashCode());
            values.put(MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME, file.getName()
                    .toLowerCase(Locale.getDefault()));
        }
        values.put("_data", file.getAbsolutePath());
        Toast.makeText(ViewImageActivity.this,
                file.getAbsolutePath(),
                Toast.LENGTH_LONG).show();
        ContentResolver cr = getContentResolver();
        cr.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        Toast.makeText(ViewImageActivity.this,
                    getResources().getString(R.string.save_on_dis), Toast.LENGTH_LONG).show();


    }
}