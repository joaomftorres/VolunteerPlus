package pt.ipg.projetofinal.ods;

import androidx.appcompat.app.AppCompatActivity;
import pt.ipg.projetofinal.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ods15Activity extends AppCompatActivity {

    Button sabermais;
    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ods15);

        sabermais = (Button) findViewById(R.id.buttonsabermais15);

        link = "https://www.ods.pt/objectivos/15-ecosistemas-terrestres-biodiversidade/?portfolioCats=24";

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