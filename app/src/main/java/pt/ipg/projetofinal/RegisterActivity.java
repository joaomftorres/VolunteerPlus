package pt.ipg.projetofinal;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference users;

    EditText editName, editEmail, editPassword;
    Button buttonregistar, buttonVoltar;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editName = (EditText) findViewById(R.id.editTextNome);
        editEmail = (EditText) findViewById(R.id.editTextEmail);
        editPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonregistar = (Button) findViewById(R.id.registerbutton2);
        buttonVoltar = (Button) findViewById(R.id.buttonvoltar);
        spinner = (Spinner) findViewById(R.id.spinnertipodeconta2);

        database = FirebaseDatabase.getInstance();
        users = database.getReference().child("Users");


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.TipodeConta, R.layout.spinner_item_text);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener(this);



        buttonregistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final User user = new User(editName.getText().toString(),
                        editEmail.getText().toString(),
                        editPassword.getText().toString(),
                        spinner.getSelectedItem().toString());


                users.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(user.getUsername()).exists())
                            Toast.makeText(RegisterActivity.this, "Já existe uma conta com este Nome de Utilizador", Toast.LENGTH_LONG).show();
                        else {
                            users.child(user.getUsername()).setValue(user);
                            Toast.makeText(RegisterActivity.this, "Registado com Sucesso", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



               /* if(TextUtils.isEmpty(email)){
                    editEmail.setError("Introduza o seu Email.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    editPassword.setError("Introduza uma Password.");
                    return;
                }

                if(password.length() < 6){
                    editPassword.setError("Introduza uma Password mais forte.");
                    return;
                }

                user.setNomeUtilizador(editName.getText().toString().trim());

                user.setPassword(editPassword.getText().toString().trim());
                user.setTipo(spinner.getSelectedItem().toString());
                referencia.push().setValue(user);

                Toast.makeText(RegisterActivity.this, "Utilizador Criado com Sucesso", Toast.LENGTH_LONG).show();
                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));*/
            }
        });

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }
}