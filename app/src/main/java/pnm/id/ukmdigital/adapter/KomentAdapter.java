package pnm.id.ukmdigital.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pnm.id.ukmdigital.R;

public class KomentAdapter extends RecyclerView.Adapter<KomentAdapter.Holder> {
    private ArrayList<Koment> listKoment;
    private Context context;

    public KomentAdapter(ArrayList<Koment> listKoment) {
        this.context = context;
        this.listKoment = listKoment;
    }



    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_komentar, viewGroup, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Koment koment = listKoment.get(position);
        holder.tvNama.setText(koment.getName());
        holder.tvIsi.setText(koment.getIsi_koment());

    }

    @Override
    public int getItemCount() {
        return listKoment.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView tvNama, tvIsi;
        public Holder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvIsi = itemView.findViewById(R.id.tv_isikoment);
        }
    }
}
