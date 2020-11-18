package pt.ipg.projetofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> implements Filterable {

    private Context mContext;
    private List<AcoesVoluntariado> mUploads;
    private List<AcoesVoluntariado> mUploadsListFull;

    public ImageAdapter(Context context, List<AcoesVoluntariado> uploads){
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
        AcoesVoluntariado uploadCurrent = mUploads.get(position);
        holder.textViewName.setText(uploadCurrent.getNome());
        holder.textViewInst.setText(uploadCurrent.getResponsavel());
        holder.textViewCategoria.setText(uploadCurrent.getCategoria());
        Picasso.get()
                .load(uploadCurrent.getImageurl())
                .fit()
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
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
