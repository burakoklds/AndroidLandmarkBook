package com.burakok.androidlandmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView txtLandmarkName = findViewById(R.id.landmarkNameText);
        TextView txtCountryName = findViewById(R.id.countrynameText);

        Intent intent = getIntent();
        //name ve country key'lerinden yakalıyıp value'ları alıyoruz
        String landmarkName  = intent.getStringExtra("name");
        txtLandmarkName.setText(landmarkName);
        String countryName = intent.getStringExtra("country");
        txtCountryName.setText(countryName);

        //Singleton objesi icindeki get ile resmi alıyoruz
        Singleton singleton = Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChoosenImage());
    }
}