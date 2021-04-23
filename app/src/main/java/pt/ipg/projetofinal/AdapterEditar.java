package pt.ipg.projetofinal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class AdapterEditar extends RecyclerView.Adapter<AdapterEditar.ImageViewHolder> implements Filterable {

    private Context mContext;
    private List<AcoesVoluntariado> mUploads;
    private List<AcoesVoluntariado> mUploadsListFull;
    private RecyclerView recycler;



    public AdapterEditar(Context context, List<AcoesVoluntariado> uploads, ValueEventListener onNoteListener){
        mContext = context;
        mUploads = uploads;
        mUploadsListFull = new ArrayList<>(mUploads);
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        final AcoesVoluntariado acoesVoluntariado = mUploadsListFull.get(position);

        final AcoesVoluntariado uploadCurrent = mUploads.get(position);
        holder.textViewName.setText(uploadCurrent.getNome());
        holder.textViewInst.setText(uploadCurrent.getResponsavel());
        holder.textViewCategoria.setText(uploadCurrent.getCategoria());
        Picasso.get()
                .load(uploadCurrent.getImageurl())
                .fit()
                .centerCrop()
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idnext = uploadCurrent.getId();
                String nomenext = uploadCurrent.getNome();
                String urlnext = uploadCurrent.getImageurl();
                String objecnext = uploadCurrent.getObjetivos();
                String resnext = uploadCurrent.getResultadosEsperados();
                String respnext = uploadCurrent.getResponsavel();
                String hornext = uploadCurrent.getHorario();
                String contnext = uploadCurrent.getContactos();
                String pagnext = uploadCurrent.getLink();
                String pagacnext = uploadCurrent.getLinkInst();
                String localnext = uploadCurrent.getLocal();
                String usernext = uploadCurrent.getUserLogado();
                String estadonext = uploadCurrent.getEstado();
                String categorianext = uploadCurrent.getCategoria();
                Intent intent = new Intent(mContext, VerAcaoInst.class);
                intent.putExtra("Id", idnext);
                intent.putExtra("Nome", nomenext);
                intent.putExtra("Url", urlnext);
                intent.putExtra("Objetivos", objecnext);
                intent.putExtra("Resultados", resnext);
                intent.putExtra("Responsavel", respnext);
                intent.putExtra("Horario", hornext);
                intent.putExtra("Contacto", contnext);
                intent.putExtra("Pagina", pagnext);
                intent.putExtra("Paginaac", pagacnext);
                intent.putExtra("Local", localnext);
                intent.putExtra("User", usernext);
                intent.putExtra("Estado", estadonext);
                intent.putExtra("Categoria", categorianext);

                mContext.startActivity(intent);

                //Toast.makeText(mContext, idnext, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewInst;
        public TextView textViewCategoria;
        public ImageView imageView;


        public ImageViewHolder(View itemView){
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewInst = itemView.findViewById(R.id.text_view_inst);
            textViewCategoria = itemView.findViewById(R.id.text_view_categoria);
            imageView = itemView.findViewById(R.id.image_view_upload);
        }


    }



    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<AcoesVoluntariado> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mUploadsListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (AcoesVoluntariado item : mUploadsListFull) {
                    if( item.getCategoria().toLowerCase().contains(filterPattern) ||
                            item.getNome().toLowerCase().contains(filterPattern) ||
                            item.getResponsavel().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mUploads.clear();
            mUploads.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

}
