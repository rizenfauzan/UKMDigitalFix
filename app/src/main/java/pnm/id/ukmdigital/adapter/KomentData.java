package pnm.id.ukmdigital.adapter;

import java.util.ArrayList;

import pnm.id.ukmdigital.R;

public class KomentData {
    private static String[] namaPenulis = {
            "Fadhilah Gtaya",
            "Ahmad Yani",
            "Sutomo",
            "Gatot Soebroto",
            "Ki Hadjar Dewantara",
            "Fadhilah Gtaya",

    };

    private static String[] isiKoment = {
            "Makasih kak, ilmunya sangat bermanfaat sekali. Akhirnya saya jadi tau tentang dunia bisnis di bidang kopi..",
            "Mantab sekali infonya..",
            "Hmm jadi tertarik masuk jurusan IT",
            "Masokk Pak eko !!!",
            "Wasekk bro",
            "Mengenal Video 360 Derajat, Teknologi VR untuk Masa Depan Perfilman Dunia",

    };


    public static ArrayList<Koment> getListData() {
        ArrayList<Koment> list = new ArrayList<>();
        for (int position = 0; position <namaPenulis.length; position++) {
            Koment koment = new Koment();
            koment.setName(namaPenulis[position]);
            koment.setIsi_koment(isiKoment[position]);
            list.add(koment);
        }
        return list;
    }
}
