package pnm.id.ukmdigital.adapter;

import java.util.ArrayList;

import pnm.id.ukmdigital.R;

public class ArtikelData {
    private static String[] namaPenulis = {
            "Fadhilah Gtaya",
            "Ahmad Yani",
            "Sutomo",
            "Gatot Soebroto",
            "Ki Hadjar Dewantara",
            "Fadhilah Gtaya",

    };

    private static String[] isiArtikel = {
            "Tips UMKM Bersikap Terbuka Akan Kritik dan Masukan Konsumen",
            "Bisnis Kopi Diprediksi Masih akan Terus Berkembang",
            "Mengenal Video 360 Derajat, Teknologi VR untuk Masa Depan Perfilman Dunia",
            "Tips UMKM Bersikap Terbuka Akan Kritik dan Masukan Konsumen",
            "Bisnis Kopi Diprediksi Masih akan Terus Berkembang",
            "Mengenal Video 360 Derajat, Teknologi VR untuk Masa Depan Perfilman Dunia",

    };

    private static int[] heroesImages = {
            R.drawable.marketing,
            R.drawable.coffee,
            R.drawable.technology,
            R.drawable.marketing,
            R.drawable.coffee,
            R.drawable.technology,

    };

    public static ArrayList<Artikel> getListData() {
        ArrayList<Artikel> list = new ArrayList<>();
        for (int position = 0; position <namaPenulis.length; position++) {
            Artikel artikel = new Artikel();
            artikel.setName(namaPenulis[position]);
            artikel.setJudul(isiArtikel[position]);
            artikel.setPhoto(heroesImages[position]);
            list.add(artikel);
        }
        return list;
    }
}
