package pt.ipg.projetofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference users;

    EditText editNome, editPassword;
    Button btnSignIn;
    TextView inscrever;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        editNome = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editPassword = (EditText) findViewById(R.id.editTextTextPassword);
        btnSignIn = (Button) findViewById(R.id.loginbutton);
        inscrever = (TextView) findViewById(R.id.textViewInscrever);

        inscrever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(LoginActivity.this, "Cool", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });




        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(editNome.getText().toString(),
                        editPassword.getText().toString());
            }
        });


    }

    public void open(){
        Intent intent = new Intent(LoginActivity.this, InstitutionActivity.class);
        intent.putExtra ( "User", editNome.getText().toString());
        startActivity(intent);

        /*editNome = (EditText) findViewById(R.id.editTextTextEmailAddress);
        String text = editNome.getText().toString();*/



    }

    private void signIn(final String username, final String password) {
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(username).exists()){
                    if(!username.isEmpty()){
                        User login = dataSnapshot.child(username).getValue(User.class);
                        if(login.getPassword().equals(password)){
                            if(login.getType().equals("Voluntário"))
                                startActivity(new Intent(getApplicationContext(), VolunteerActivity.class));
                            if(login.getType().equals("Instituição"))
                                open();

                                //startActivity(new Intent(getApplicationContext(), InstitutionActivity.class));
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "nah fam", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "não tá cá", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}


