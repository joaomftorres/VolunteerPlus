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

public class VerAcaoInst extends AppCompatActivity {

    TextView objetivos, nome, resultados, responsavel, horarios, contactos, local;
    Button editar, terminar;
    ImageView iv;
    String url, urlinst;
    DatabaseReference mDatabaseRef;
    AcoesVoluntariado acoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_acao_inst);

        objetivos = (TextView) findViewById(R.id.textViewObjetivos);
        nome = (TextView) findViewById(R.id.textViewNomeAcao);
        resultados = (TextView) findViewById(R.id.textViewResultados);
        responsavel = (TextView) findViewById(R.id.textViewResponsavel);
        horarios = (TextView) findViewById(R.id.textViewHorarios);
        contactos = (TextView) findViewById(R.id.textViewContactos);
        local = (TextView) findViewById(R.id.textViewLocal);
        iv = (ImageView) findViewById(R.id.imageViewAcao);
        editar = (Button) findViewById(R.id.buttonEditarAcao);
        terminar = (Button) findViewById(R.id.buttonTerminarAcao);

        acoes = new AcoesVoluntariado();
        final DatabaseReference updateData = FirebaseDatabase.getInstance()
                .getReference("Ações");

        Bundle bundle= getIntent().getExtras();
        final String idnext = bundle.getString("Id");
        final String nomenext = bundle.getString("Nome");
        final String urlnext = bundle.getString("Url");
        final String objecnext = bundle.getString("Objetivos");
        final String resnext = bundle.getString("Resultados");
        final String respnext = bundle.getString("Responsavel");
        final String hornext = bundle.getString("Horario");
        final String contnext = bundle.getString("Contacto");
        final String pagnext = bundle.getString("Pagina");
        final String pagacnext = bundle.getString("Paginaac");
        final String localnext = bundle.getString("Local");
        final String usernext = bundle.getString("User");
        final String estadonext = bundle.getString("Estado");
        final String categorianext = bundle.getString("Categoria");
        final String id;
        id = idnext;

        url = urlnext;
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


        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), EditarInfoAcao.class);
                intent.putExtra("Nome", nomenext);
                intent.putExtra("Local", localnext);
                intent.putExtra("Contacto", contnext);
                intent.putExtra("Id", idnext);
                intent.putExtra("Horario", hornext);
                intent.putExtra("Resultados", resnext);
                intent.putExtra("Objetivos", objecnext);
                intent.putExtra("Responsavel", respnext);
                intent.putExtra("Id", idnext);
                intent.putExtra("url", urlnext);
                intent.putExtra("pag", pagnext);
                intent.putExtra("pagac", pagacnext);
                intent.putExtra("user", usernext);
                intent.putExtra("estado", estadonext);
                intent.putExtra("categoria", categorianext);



                startActivity(intent);
            }
        });

        terminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acoes.setNome(nomenext);
                acoes.setObjetivos(objecnext);
                acoes.setResultadosEsperados(resnext);
                acoes.setResponsavel(respnext);
                acoes.setContactos(contnext);
                acoes.setHorario(hornext);
                acoes.setLocal(localnext);
                acoes.setImageurl(url);
                acoes.setLinkInst(pagnext);
                acoes.setLink(pagacnext);
                acoes.setUserLogado(usernext);
                acoes.setEstado("Terminado");
                acoes.setCategoria(categorianext);
                acoes.setId(idnext);

                updateData.child(id).setValue(acoes);

                Toast.makeText(VerAcaoInst.this, "Ação de voluntariado finalizada", Toast.LENGTH_LONG).show();
            }
        });
    }
}