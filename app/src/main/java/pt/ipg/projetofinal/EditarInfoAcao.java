 package pt.ipg.projetofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

 public class EditarInfoAcao extends AppCompatActivity {

    EditText editarnome, editarcontacto,editarhorario,editarinstituicao,editarresultados, editarlocal, editarobjetivos;
    Button cancelar, atualizar;
     AcoesVoluntariado acoes;

    private DatabaseReference mDatabaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_info_acao);

        editarnome = (EditText) findViewById(R.id.editTextEditarNomeAcao);
        editarcontacto = (EditText) findViewById(R.id.editTextEditarContactos);
        editarhorario = (EditText) findViewById(R.id.editTextEditarHorarios);
        editarinstituicao = (EditText) findViewById(R.id.editTextEditarInstituicaoResposavel);
        editarresultados = (EditText) findViewById(R.id.editTextEditarResultadosEsperados);
        editarlocal = (EditText) findViewById(R.id.editTextEditarLocal);
        editarobjetivos = (EditText) findViewById(R.id.editTextEditarObjetivos);
        cancelar = (Button) findViewById(R.id.buttoncancelaredit);
        atualizar = (Button) findViewById(R.id.buttoneditar);

        final String Nome = getIntent().getStringExtra("Nome");
        final String Local = getIntent().getStringExtra("Local");
        final String Contacto = getIntent().getStringExtra("Contacto");
        final String Horarios = getIntent().getStringExtra("Horario");
        final String Objetivos = getIntent().getStringExtra("Objetivos");
        final String Resultados = getIntent().getStringExtra("Resultados");
        final String Responsavel = getIntent().getStringExtra("Responsavel");
        final String url = getIntent().getStringExtra("url");
        final String pag = getIntent().getStringExtra("pag");
        final String pagac = getIntent().getStringExtra("pagac");
        final String user = getIntent().getStringExtra("user");
        final String estado = getIntent().getStringExtra("estado");
        final String categoria = getIntent().getStringExtra("categoria");
        final String Id = getIntent().getStringExtra("Id");

        editarnome.setText(Nome);
        editarlocal.setText(Local);
        editarcontacto.setText(Contacto);
        editarhorario.setText(Horarios);
        editarresultados.setText(Resultados);
        editarobjetivos.setText(Objetivos);
        editarinstituicao.setText(Responsavel);

        //Toast.makeText(this, Id, Toast.LENGTH_LONG).show();


        acoes = new AcoesVoluntariado();
        final DatabaseReference updateData = FirebaseDatabase.getInstance()
                .getReference("Ações");


        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), InstitutionActivity.class));

                /*acoes.setNome(Nome);
                acoes.setObjetivos(Objetivos);
                acoes.setResultadosEsperados(Resultados);
                acoes.setResponsavel(Responsavel);
                acoes.setContactos(Contacto);
                acoes.setHorario(Horarios);
                acoes.setLocal(Local);
                acoes.setImageurl(url);
                acoes.setLinkInst(pag);
                acoes.setLink(pagac);
                acoes.setUserLogado(user);
                acoes.setEstado(estado);
                acoes.setCategoria(categoria);
                acoes.setId(Id);

                updateData.child(Id).setValue(acoes);*/


            }
        });

        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                acoes.setNome(editarnome.getText().toString().trim());
                acoes.setObjetivos(editarobjetivos.getText().toString().trim());
                acoes.setResultadosEsperados(editarresultados.getText().toString().trim());
                acoes.setResponsavel(editarinstituicao.getText().toString().trim());
                acoes.setContactos(editarcontacto.getText().toString().trim());
                acoes.setHorario(editarhorario.getText().toString().trim());
                acoes.setLocal(editarlocal.getText().toString().trim());
                acoes.setImageurl(url);
                acoes.setLinkInst(pag);
                acoes.setLink(pagac);
                acoes.setUserLogado(user);
                acoes.setEstado(estado);
                acoes.setCategoria(categoria);
                acoes.setId(Id);

                updateData.child(Id).setValue(acoes);

                Toast.makeText(EditarInfoAcao.this, "Alterações guardadas", Toast.LENGTH_LONG).show();

            }
        });
    }
}