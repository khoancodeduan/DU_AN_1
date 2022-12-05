package Nhom2.example.du_an_1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import Nhom2.example.du_an_1.Fragment.SettingFragment;
import Nhom2.example.du_an_1.Fragment.Thong_baoFragment;
import Nhom2.example.du_an_1.Model.rcv_Sp;
import Nhom2.example.du_an_1.R;

public class Gio_hang_Activity extends AppCompatActivity {
    BottomNavigationView view;
    ImageView imageView;
    TextView Namee, Gia;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        view = findViewById(R.id.bottom_nav1);
        imageView = findViewById(R.id.id_img011);
        Namee = findViewById(R.id.id_tensp);
        Gia = findViewById(R.id.id_gia);


        Intent intent = getIntent();
        String anh = intent.getStringExtra("all");
        String ten = intent.getStringExtra("ten");
        String gia = String.valueOf(intent.getIntExtra("gia", 0));

        Namee.setText(ten);
        Gia.setText(gia);
        Glide.with(getApplicationContext()).load(anh).into(imageView);

//        imageView.setImageResource(sp.getImg() + "");


        view.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.nav_Home:
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_Cart:
                        Intent intent1 = new Intent(getApplicationContext(), Gio_hang_Activity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_Bell:
                        fragment = new Thong_baoFragment();
                        loadFrag(fragment);
                        break;
                    case R.id.nav_setting:
                        fragment = new SettingFragment();
                        loadFrag(fragment);

                        break;
                }
                return true;
            }
        });


    }

    public void loadFrag(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContent1, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}