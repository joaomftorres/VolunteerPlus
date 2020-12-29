package pt.ipg.projetofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class VerInfoAcaoActivity extends AppCompatActivity {

    TextView objetivos, nome, resultados, responsavel, horarios, contactos, local;
    Button visitar, visitarinst;
    ImageView iv;
    String url, urlinst;
    DatabaseReference mDatabaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_info_acao);

        objetivos = (TextView) findViewById(R.id.textViewObjetivos);
        nome = (TextView) findViewById(R.id.textViewNomeAcao);
        resultados = (TextView) findViewById(R.id.textViewResultados);
        responsavel = (TextView) findViewById(R.id.textViewResponsavel);
        horarios = (TextView) findViewById(R.id.textViewHorarios);
        contactos = (TextView) findViewById(R.id.textViewContactos);
        local = (TextView) findViewById(R.id.textViewLocal);
        iv = (ImageView) findViewById(R.id.imageViewAcao);
        visitar = (Button) findViewById(R.id.buttonVisitarAcao);
        visitarinst = (Button) findViewById(R.id.buttonVisitarWebsite);



        Bundle bundle= getIntent().getExtras();
        //String idnext = bundle.getString("Id");
        String nomenext = bundle.getString("Nome");
        String urlnext = bundle.getString("Url");
        String objecnext = bundle.getString("Objetivos");
        String resnext = bundle.getString("Resultados");
        String respnext = bundle.getString("Responsavel");
        String hornext = bundle.getString("Horario");
        String contnext = bundle.getString("Contacto");
        String pagnext = bundle.getString("Pagina");
        String pagacnext = bundle.getString("Paginaac");
        String localnext = bundle.getString("Local");

        url = pagnext;
        urlinst = pagacnext;


        ///String aaa = "O nome é" + nomenext;
        nome.setText(nomenext);
        objetivos.setText(objecnext);
        resultados.setText(resnext);
        responsavel.setText(respnext);
        horarios.setText(hornext);
        contactos.setText(contnext);
        local.setText(localnext);

        Picasso.get().load(urlnext).fit().centerCrop().into(iv);
        //Toast.makeText(this, urlnext, Toast.LENGTH_SHORT).show();


        visitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (url.equals("https//:")) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent); }
                else {
                    Toast.makeText(getApplicationContext(), "Link da Ação não atribuído", Toast.LENGTH_LONG).show();
                }
            }
        });

        visitarinst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (urlinst.equals("https//:")) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlinst));
                startActivity(intent); }
                else {
                    Toast.makeText(getApplicationContext(), "Link da Instituição não atribuído", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}