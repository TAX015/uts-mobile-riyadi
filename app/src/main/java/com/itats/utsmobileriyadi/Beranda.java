package com.itats.utsmobileriyadi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Beranda extends AppCompatActivity {

    private Button buttonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        buttonList = (Button) findViewById(R.id.btn_list);

        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Beranda.this, DaftarMaterial.class);
                startActivity(intent);
            }
        });
    }
}