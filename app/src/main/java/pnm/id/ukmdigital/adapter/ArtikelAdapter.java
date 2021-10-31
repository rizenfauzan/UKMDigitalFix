package pnm.id.ukmdigital.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import pnm.id.ukmdigital.R;
import pnm.id.ukmdigital.ui.ArtikelFragment;
import pnm.id.ukmdigital.ui.DaftarFragment;

public class ArtikelAdapter extends RecyclerView.Adapter<ArtikelAdapter.Holder> {

    private ArrayList<Artikel> listArtikel;
    private Context context;
    public ArtikelAdapter(Context context, ArrayList<Artikel> list) {
        this.context = context;
        this.listArtikel = list;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item_artikel, viewGroup, false);
        return new Holder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Artikel artikel = listArtikel.get(position);
        Glide.with(holder.itemView.getContext())
                .load(artikel.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvNama.setText(artikel.getName());
        holder.tvJudul.setText(artikel.getJudul());


        holder.card_artikel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArtikelFragment artikelFragment = new ArtikelFragment();
                String backStateName = artikelFragment.getClass().getName();
                ((FragmentActivity)view.getContext()).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_layout, artikelFragment, ArtikelFragment.class.getSimpleName())
                        .addToBackStack(backStateName)

                        .commit();
            }
        });

    }




    public interface OnItemClickCallback {
        void onItemClicked(Artikel data);
    }

    @Override
    public int getItemCount() {
        return listArtikel.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvNama, tvJudul;
        CardView card_artikel;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.foto_artikel);
            tvNama = itemView.findViewById(R.id.txt_penulis);
            tvJudul = itemView.findViewById(R.id.txt_judul);
            card_artikel = itemView.findViewById(R.id.card_artikel);
        }
    }
}
