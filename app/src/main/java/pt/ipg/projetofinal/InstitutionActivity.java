package pt.ipg.projetofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InstitutionActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView teste;
    AcoesVoluntariado acoes;
    String myString;

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institution);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

       if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new PerfilInstFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_lista);
            //navigationView.getMenu().findItem(R.id.nav_lista).setVisible(true);
           getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                   new AcoesPropostasFragment()).commit();
        }


        Intent i = getIntent();
        String text = i.getStringExtra ( "User");
        myString = text;

        getMyData();


    }

    public String getMyData(){
        return myString;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_nova:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new NovaAcaoFragment()).commit();
                break;

            case R.id.nav_lista:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AcoesPropostasFragment()).commit();
                break;

            case R.id.nav_done:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AcoesTerminadasFragment()).commit();
                break;

            case R.id.nav_Perfil:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                return true;

            case R.id.nav_sair:
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                return true;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                return true;
            case R.id.sair:
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}