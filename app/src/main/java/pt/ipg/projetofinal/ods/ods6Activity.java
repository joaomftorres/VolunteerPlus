package pt.ipg.projetofinal.ods;

import androidx.appcompat.app.AppCompatActivity;
import pt.ipg.projetofinal.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ods6Activity extends AppCompatActivity {

    Button sabermais;
    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ods6);

        sabermais = (Button) findViewById(R.id.buttonsabermais6);

        link = "https://www.ods.pt/objectivos/6-agua-e-saneamento/?portfolioCats=24";

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