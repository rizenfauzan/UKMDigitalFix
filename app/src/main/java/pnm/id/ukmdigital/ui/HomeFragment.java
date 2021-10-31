package pnm.id.ukmdigital.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pnm.id.ukmdigital.R;
import pnm.id.ukmdigital.adapter.Artikel;
import pnm.id.ukmdigital.adapter.ArtikelAdapter;
import pnm.id.ukmdigital.adapter.ArtikelData;


public class HomeFragment extends Fragment {
    private RecyclerView rv_artikel;
    private ArrayList<Artikel> list = new ArrayList<>();
    private Context context;
    private String title = "Mode List";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        rv_artikel = view.findViewById(R.id.rv_rtikel);
        rv_artikel.setHasFixedSize(true);
        rv_artikel.setNestedScrollingEnabled(false);
        list.addAll(ArtikelData.getListData());


        rv_artikel.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false) );
        ArtikelAdapter artikelAdapter = new ArtikelAdapter(context,list);
        rv_artikel.setAdapter(artikelAdapter);
        return view;
    }




}