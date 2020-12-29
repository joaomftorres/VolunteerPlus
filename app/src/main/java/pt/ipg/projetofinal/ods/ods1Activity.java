package pt.ipg.projetofinal.ods;

import androidx.appcompat.app.AppCompatActivity;
import pt.ipg.projetofinal.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ods1Activity extends AppCompatActivity {

    Button sabermais;
    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ods1);

        sabermais = (Button) findViewById(R.id.buttonsabermais);

        link = "https://www.ods.pt/objectivos/1-erradicar-a-pobreza/?portfolioCats=24";

        sabermais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(link));
                startActivity(intent);
            }
        });
    }
}