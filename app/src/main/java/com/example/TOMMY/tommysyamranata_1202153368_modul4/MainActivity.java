package com.example.TOMMY.tommysyamranata_1202153368_modul4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.TOMMY.tommysyamranata_1202153368_modul4.R;

public class MainActivity extends AppCompatActivity {
Button btnlist, btncari;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlist = (Button)findViewById(R.id.listmahasiswa);
        btncari = (Button)findViewById(R.id.carigamabar);


        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListMahasiswa.class);
                startActivity(intent);
            }
        });

        btncari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PencarianGambar.class);
                startActivity(intent);
            }
        });
    }
}
