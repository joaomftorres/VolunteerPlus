package pt.ipg.projetofinal;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class VolunteerActivity extends AppCompatActivity {

    private Button acoes, oceanos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);

        acoes = (Button) findViewById(R.id.buttonacoes);
        oceanos = (Button) findViewById(R.id.buttonoceanos);


        acoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ActivityAcoes.class));
            }
        });

        oceanos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), OceanosActivity.class));
            }
        });

    }

}