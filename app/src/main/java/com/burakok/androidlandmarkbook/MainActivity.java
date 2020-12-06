package com.burakok.androidlandmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView); //ListView oluşturuluyor

        ArrayList<String> arrayList = new ArrayList<>(); //ArrayList oluşturuluyor
        arrayList.add("Pisa");
        arrayList.add("Eiffel");
        arrayList.add("Colleseo");
        arrayList.add("London Bridge");

        ArrayList<String> counrtyName = new ArrayList<>();
        counrtyName.add("Italy");
        counrtyName.add("France");
        counrtyName.add("Italy");
        counrtyName.add("UnitedKingdom");

        //Resimler kodlanıyor
        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources() , R.drawable.pisa);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources() , R.drawable.eyfel);
        Bitmap collesseo = BitmapFactory.decodeResource(getApplicationContext().getResources() , R.drawable.collesso);
        Bitmap londomBridge = BitmapFactory.decodeResource(getApplicationContext().getResources() , R.drawable.londombridge);

        ArrayList<Bitmap> landmarkImages = new ArrayList<>(); //Resimler Arraylist'e ekleniyor
        landmarkImages.add(pisa);
        landmarkImages.add(eiffel);
        landmarkImages.add(collesseo);
        landmarkImages.add(londomBridge);

        //arrayAdaptor'un icine list'i koyuyoruz
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this , android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter); // ListView'e arrayAdapter'i set ediyoruz

        // Liste'de hangi index'e tıklandığını gösteriyor İ'ninici index
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arrayAdapter, View view, int i, long id) {

                //System.out.println(arrayList.get(i));
                //System.out.println(counrtyName.get(i));

                //MainActivity'den DetailActivity sayfasına gecis
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                // name ve country key'leri ile value'ları yolluyoruz
                intent.putExtra("name",arrayList.get(i));
                intent.putExtra("country",counrtyName.get(i));

                //olusturdugumuz singleton obje ile resmi set ediyoruz
                Singleton singleton = Singleton.getInstance();
                singleton.setChoosenImage(landmarkImages.get(i));

                startActivity(intent);
            }
        });
    }
}