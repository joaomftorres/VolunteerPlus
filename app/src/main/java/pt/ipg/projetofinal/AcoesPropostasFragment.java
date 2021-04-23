package pt.ipg.projetofinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AcoesPropostasFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private AdapterEditar mAdapter;
    private DatabaseReference mDatabaseRef;
    private List<AcoesVoluntariado> mUploads;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_acoespropostas, container, false);

        /* mRecyclerView = view.findViewById(R.id.recyclerviewpropostas);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mUploads = new ArrayList<>();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("Ações");

        InstitutionActivity activity = (InstitutionActivity) getActivity();
        final String user = activity.getMyData();


        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    String key = dataSnapshot.getKey();
                    AcoesVoluntariado upload = postSnapshot.getValue(AcoesVoluntariado.class);
                    //if(upload.getUserLogado().equals(user) && upload.getEstado().equals("A decorrer")){
                    mUploads.add(upload);
                //}
                }

                mAdapter = new AdapterEditar(getContext(), mUploads, this);

                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(),"Erro", Toast.LENGTH_SHORT).show();
            }
        });

*/
        return view; 
    }
}
