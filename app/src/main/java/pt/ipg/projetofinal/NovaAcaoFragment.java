package pt.ipg.projetofinal;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NovaAcaoFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private static final int PICK_IMAGE_REQUEST = 1;
    private StorageReference Folder;
    private Button buttonpropor;
    private Button buttonescolherimagem;
    private Uri mImageUri;
    private EditText editTextNomeAcao, editTextObjetivos, editTextResultadosEsperados, editTextResponsavel, editTextLink;
    AcoesVoluntariado acoes;
    private ImageView mImageView;
    private TextView user;

    private Spinner spinner;

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_novaacao, container, false);

        editTextNomeAcao = (EditText) view.findViewById(R.id.editTextNomeAcao);
        editTextObjetivos = (EditText) view.findViewById(R.id.editTextObjetivos);
        editTextResultadosEsperados = (EditText) view.findViewById(R.id.editTextResultadosEsperados);
        editTextResponsavel = (EditText) view.findViewById(R.id.editTextInstituicaoResposavel);
        buttonpropor = (Button) view.findViewById(R.id.buttonpropor);
        buttonescolherimagem = (Button) view.findViewById(R.id.buttonescolherimagem);
        spinner = (Spinner) view.findViewById(R.id.spinnercategorias);
        mImageView = (ImageView) view.findViewById(R.id.imageViewAcao);
        user = (TextView) view.findViewById(R.id.textViewLogged);
        editTextLink = (EditText) view.findViewById(R.id.editTextLink);


        Folder = FirebaseStorage.getInstance().getReference().child("ImageFolder");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.Categorias, R.layout.spinner_item_text);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        acoes = new AcoesVoluntariado();
        referencia = FirebaseDatabase.getInstance().getReference().child("Ações");

        InstitutionActivity activity = (InstitutionActivity) getActivity();
        String username = activity.getMyData();
        user.setText(username);

        buttonescolherimagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        buttonpropor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                acoes.setNome(editTextNomeAcao.getText().toString().trim());
                acoes.setObjetivos(editTextObjetivos.getText().toString().trim());
                acoes.setResultadosEsperados(editTextResultadosEsperados.getText().toString().trim());
                acoes.setCategoria(spinner.getSelectedItem().toString());
                acoes.setResponsavel(editTextResponsavel.getText().toString().trim());
                acoes.setLink(editTextLink.getText().toString().trim());
                acoes.setUserLogado(user.getText().toString().trim());
                referencia.push().setValue(acoes);

                Toast.makeText(NovaAcaoFragment.this.getActivity(), "Ação Proposta com Sucesso", Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }


    private void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            mImageUri = data.getData();

            final StorageReference ImageName = Folder.child("image" + mImageUri.getLastPathSegment());
            ImageName.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    ImageName.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {
                            Uri url = task.getResult();
                            String urlConvertida = url.toString();

                            acoes.setImageurl(urlConvertida);
                        }
                    });
                }
            });

            Picasso.get().load(mImageUri).into(mImageView);

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
