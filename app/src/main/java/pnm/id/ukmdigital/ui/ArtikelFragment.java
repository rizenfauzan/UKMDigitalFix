package pnm.id.ukmdigital.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pnm.id.ukmdigital.R;
import pnm.id.ukmdigital.adapter.Artikel;
import pnm.id.ukmdigital.adapter.ArtikelAdapter;
import pnm.id.ukmdigital.adapter.ArtikelData;
import pnm.id.ukmdigital.adapter.Koment;
import pnm.id.ukmdigital.adapter.KomentAdapter;
import pnm.id.ukmdigital.adapter.KomentData;


public class ArtikelFragment extends Fragment {
    RecyclerView rv_koment;
    private ArrayList<Koment> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_artikel, container, false);


        rv_koment = view.findViewById(R.id.rvKomentar);
        list.addAll(KomentData.getListData());

        rv_koment.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()) );
        KomentAdapter komentAdapter = new KomentAdapter(list);
        rv_koment.setAdapter(komentAdapter);

        return view;

    }
}