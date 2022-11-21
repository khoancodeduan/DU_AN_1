package Nhom2.example.du_an_1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import Nhom2.example.du_an_1.Fragment.DangKyBanFragment;
import Nhom2.example.du_an_1.Fragment.DoanhThuFragment;
import Nhom2.example.du_an_1.Fragment.DoiMKFragment;
import Nhom2.example.du_an_1.Fragment.DonHangFragment;
import Nhom2.example.du_an_1.Fragment.QuanLyKhoFragment;
import Nhom2.example.du_an_1.Fragment.ShopFragment;
import Nhom2.example.du_an_1.Fragment.ThoatFragment;
import Nhom2.example.du_an_1.R;

public class Tao_tkActivity extends AppCompatActivity {
    DrawerLayout layout;
    NavigationView nav_menu;
    Toolbar toolbar1;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tao_tk);

        nav_menu = findViewById(R.id.nav_menu);
        layout = findViewById(R.id.drawbleLayout2);

        textView = findViewById(R.id.id_back);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignActivity.class);
                startActivity(intent);
            }
        });


    }

}