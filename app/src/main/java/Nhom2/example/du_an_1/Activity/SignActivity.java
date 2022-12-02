package Nhom2.example.du_an_1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;

import Nhom2.example.du_an_1.Fragment.DangKyBanFragment;
import Nhom2.example.du_an_1.Fragment.DoanhThuFragment;
import Nhom2.example.du_an_1.Fragment.DoiMKFragment;
import Nhom2.example.du_an_1.Fragment.DonHangFragment;
import Nhom2.example.du_an_1.Fragment.QuanLyKhoFragment;
import Nhom2.example.du_an_1.Fragment.ShopFragment;
import Nhom2.example.du_an_1.Fragment.ThoatFragment;
import Nhom2.example.du_an_1.R;

public class SignActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout layout;
    NavigationView nav_menu;
    TextInputLayout lUser, lPass;
    CheckBox chk;
    Button btnSignIn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        nav_menu =findViewById(R.id.nav_menu);
        layout = findViewById(R.id.drawbleLayout1);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return true;

    }
}