package pnm.id.ukmdigital.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import pnm.id.ukmdigital.R;


public class ProfileFragment extends Fragment implements View.OnClickListener {
    TextView daftar, lupa_password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        daftar = view.findViewById(R.id.tv_daftar);
        lupa_password = view.findViewById(R.id.tv_lupaPassword);

        lupa_password.setOnClickListener(this);
        daftar.setOnClickListener(this);

        return view;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onClick(View view) {
        Fragment fragment;
        if (view.getId()==R.id.tv_daftar){
            DaftarFragment daftarFragment = new DaftarFragment();
            String backStateName = daftarFragment.getClass().getName();
            FragmentManager mFragmentManager = getParentFragmentManager();
            if (mFragmentManager != null) {
                mFragmentManager
                        .beginTransaction()
                        .replace(R.id.container_layout, daftarFragment, DaftarFragment.class.getSimpleName())
                        .addToBackStack(backStateName)
                        .commit();
            }



//        } else if (view.getId()==R.id.btn_previous){
//            FragmentManager mFragmentManager = getParentFragmentManager();
//            TestFragment fragment = new TestFragment();
//            Bundle b = new Bundle();
//            b.putString(fragment.getClass().getSimpleName(), String.valueOf(Integer.parseInt(position)-1));
//            fragment.setArguments(b);
//            mFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.nav_host_fragment, fragment, fragment.getClass().getSimpleName())
//                    .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
//                    .commit();
        }

    }
}