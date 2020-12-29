package pt.ipg.projetofinal;

import androidx.appcompat.app.AppCompatActivity;
import pt.ipg.projetofinal.ods.ods10Activity;
import pt.ipg.projetofinal.ods.ods11Activity;
import pt.ipg.projetofinal.ods.ods12Activity;
import pt.ipg.projetofinal.ods.ods13Activity;
import pt.ipg.projetofinal.ods.ods14Activity;
import pt.ipg.projetofinal.ods.ods15Activity;
import pt.ipg.projetofinal.ods.ods16Activity;
import pt.ipg.projetofinal.ods.ods17Activity;
import pt.ipg.projetofinal.ods.ods1Activity;
import pt.ipg.projetofinal.ods.ods2Activity;
import pt.ipg.projetofinal.ods.ods3Activity;
import pt.ipg.projetofinal.ods.ods4Activity;
import pt.ipg.projetofinal.ods.ods5Activity;
import pt.ipg.projetofinal.ods.ods6Activity;
import pt.ipg.projetofinal.ods.ods7Activity;
import pt.ipg.projetofinal.ods.ods8Activity;
import pt.ipg.projetofinal.ods.ods9Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;

public class ActivityODS extends AppCompatActivity {

    ImageView ods1, ods2, ods3, ods4, ods5, ods6, ods7, ods8, ods9, ods10, ods11, ods12, ods13, ods14, ods15, ods16, ods17, odsicon;
    Layout od1large;
    String link;
    PopupWindow myPopUpWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_d_s);

        ods1 = (ImageView) findViewById(R.id.imageViewODS1);
        ods2 = (ImageView) findViewById(R.id.imageViewODS2);
        ods3 = (ImageView) findViewById(R.id.imageViewODS3);
        ods4 = (ImageView) findViewById(R.id.imageViewODS4);
        ods5 = (ImageView) findViewById(R.id.imageViewODS5);
        ods6 = (ImageView) findViewById(R.id.imageViewODS6);
        ods7 = (ImageView) findViewById(R.id.imageViewODS7);
        ods8 = (ImageView) findViewById(R.id.imageViewODS8);
        ods9 = (ImageView) findViewById(R.id.imageViewODS9);
        ods10 = (ImageView) findViewById(R.id.imageViewODS10);
        ods11 = (ImageView) findViewById(R.id.imageViewODS11);
        ods12 = (ImageView) findViewById(R.id.imageViewODS12);
        ods13 = (ImageView) findViewById(R.id.imageViewODS13);
        ods14 = (ImageView) findViewById(R.id.imageViewODS14);
        ods15 = (ImageView) findViewById(R.id.imageViewODS15);
        ods16 = (ImageView) findViewById(R.id.imageViewODS16);
        ods17 = (ImageView) findViewById(R.id.imageViewODS17);
        odsicon = (ImageView) findViewById(R.id.imageViewODSicon);

        link = "https://www.ods.pt";

        ods1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ods1Activity.class));
            }
        });

        ods2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ods2Activity.class));
            }
        });

        ods3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ods3Activity.class));
            }
        });

        ods4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ods4Activity.class));
            }
        });

        ods5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ods5Activity.class));
            }
        });

        ods6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ods6Activity.class));
            }
        });

        ods7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ods7Activity.class));
            }
        });

        ods8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ods8Activity.class));
            }
        });

        ods9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ods9Activity.class));
            }
        });

        ods10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ods10Activity.class));
            }
        });

        ods11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ods11Activity.class));
            }
        });

        ods12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ods12Activity.class));
            }
        });

        ods13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ods13Activity.class));
            }
        });

        ods14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ods14Activity.class));
            }
        });

        ods15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ods15Activity.class));
            }
        });

        ods16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ods16Activity.class));
            }
        });

        ods17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ods17Activity.class));
            }
        });

        odsicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(link));
                startActivity(intent);
            }
        });

    }
}