package pnm.id.ukmdigital;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import pnm.id.ukmdigital.ui.HomeFragment;
import pnm.id.ukmdigital.ui.ProfileFragment;

public class MainActivity extends AppCompatActivity  {

    private boolean doubleBackToExitPressedOnce = false;
    BottomNavigationView navigation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        navigation = findViewById(R.id.bottom_navigation);
       navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState==null){
            navigation.setSelectedItemId(R.id.Home);
        }
    }

    public void onBackPressed(){
        if (getSupportFragmentManager().getBackStackEntryCount() == 0){
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Tekan kembali sekali lagi untuk keluar dari aplikasi", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }
        else {
            super.onBackPressed();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;

            navigation.getMenu().getItem(0).setIcon(R.drawable.icon_home);
            navigation.getMenu().getItem(1).setIcon(R.drawable.icon_user);

            switch (item.getItemId()) {
                case R.id.Home:
                    fragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    item.setIcon(R.drawable.icon_home);
                    return true;

                case R.id.Profile:
                    fragment = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    item.setIcon(R.drawable.icon_user);
                    return true;

//                case R.id.Chat:
//                    fragment = new HomePekerjaFragment();
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
//                            .commit();
//                    item.setIcon(R.drawable.icon_chat);
//                    return true;

//                case R.id.Profile:
//                    fragment = new ProfileFragment();
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
//                            .commit();
//                    item.setIcon(R.drawable.ic_profile);
//                    return true;
            }
            return false;
        }
    };


}