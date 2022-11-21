package Nhom2.example.du_an_1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


import Nhom2.example.du_an_1.Addapter.Photo_Addapter;
import Nhom2.example.du_an_1.Dao.TbCatDao;
import Nhom2.example.du_an_1.Fragment.DangKyBanFragment;
import Nhom2.example.du_an_1.Fragment.DoanhThuFragment;
import Nhom2.example.du_an_1.Fragment.DoiMKFragment;
import Nhom2.example.du_an_1.Fragment.DonHangFragment;
import Nhom2.example.du_an_1.Fragment.QuanLyKhoFragment;
import Nhom2.example.du_an_1.Fragment.ShopFragment;
import Nhom2.example.du_an_1.Fragment.ThoatFragment;
import Nhom2.example.du_an_1.Model.Photo_Object;
import Nhom2.example.du_an_1.Model.TbCategory;
import Nhom2.example.du_an_1.R;
import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {
    DrawerLayout layout;
    Toolbar toolbar;
    NavigationView nav_menu;
    private ViewPager2 viewPager;
    private CircleIndicator3 indicator;
    private Photo_Addapter photoaddapter;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private List<Photo_Object> mlistphoto;

    ///khoan reser du an ...

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int curenItem = viewPager.getCurrentItem();
            int toItem = mlistphoto.size() - 1;

            if (curenItem == toItem) {
                viewPager.setCurrentItem(0);
            } else {
                viewPager.setCurrentItem(curenItem + 1);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.id_viewpage2);
        indicator = findViewById(R.id.Indicator);
        mlistphoto = getListphoto();
        photoaddapter = new Photo_Addapter(this, mlistphoto);
        viewPager.setAdapter(photoaddapter);
        indicator.setViewPager(viewPager);
        nav_menu =findViewById(R.id.nav_menu);


        nav_menu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager manager = getSupportFragmentManager();
                  switch (item.getItemId()){
                      case R.id.dh_cuatoi:
                          DonHangFragment donHangFragment = new DonHangFragment();
                          manager.beginTransaction().replace(R.id.frameContent,donHangFragment).commit();
                          break;
                      case R.id.nav_Home:
                          Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                          startActivity(intent);
                          break;
                      case R.id.ql_kho:
                          QuanLyKhoFragment quanLyKhoFragment = new QuanLyKhoFragment();
                          manager.beginTransaction().replace(R.id.frameContent,quanLyKhoFragment).commit();
                          break;
                      case R.id.Doang_thu:
                          DoanhThuFragment doanhThuFragment = new DoanhThuFragment();
                          manager.beginTransaction().replace(R.id.frameContent,doanhThuFragment).commit();
                          break;
                      case R.id.dang_ky_ban:
                          DangKyBanFragment dangKyBanFragment = new DangKyBanFragment();
                          manager.beginTransaction().replace(R.id.frameContent,dangKyBanFragment).commit();
                          break;
                      case R.id.shop_cuat:
                          ShopFragment shopFragment = new ShopFragment();
                          manager.beginTransaction().replace(R.id.frameContent,shopFragment).commit();
                          break;
                      case R.id.doi_mk:
                           DoiMKFragment doiMKFragment = new DoiMKFragment();
                          manager.beginTransaction().replace(R.id.frameContent,doiMKFragment).commit();
                          break;
                      case R.id.dang_xuat:
                          ThoatFragment thoatFragment = new ThoatFragment();
                          manager.beginTransaction().replace(R.id.frameContent,thoatFragment).commit();
                          break;
                  }

                  layout.closeDrawers();
                return false;
            }
        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        layout = findViewById(R.id.drawerLayout);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mHandler.removeCallbacks(runnable);
                mHandler.postDelayed(runnable, 1000);
            }
        });


        TbCatDao catDao = new TbCatDao();
        //======== Thêm mới 1 dòng
        TbCategory newObjCat = new TbCategory();
        newObjCat.setName("Thể loại mới");

        catDao.insertRow(newObjCat);


        // Sửa dữ liệu:
        TbCategory objCatUpdate = new TbCategory();
        objCatUpdate.setId(3);
        objCatUpdate.setName("Dữ liệu đã sửa");

        catDao.updateRow(objCatUpdate);

        List<TbCategory> listCat = catDao.getAll(); // lấy danh sách cho vào biến

        // duyệt mảng in ra danh sách
        for (int i = 0; i < listCat.size(); i++) {
            TbCategory objCat = listCat.get(i);
            Log.d("zzzzz", "onCreate: phần tử thứ " + i + ":  id = " + objCat.getId() + ", name = " + objCat.getName());

        }

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                layout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return true;

    }

    private List<Photo_Object> getListphoto() {
        List<Photo_Object> list = new ArrayList<>();
        list.add(new Photo_Object(R.drawable.vvv));
        list.add(new Photo_Object(R.drawable.meo3));
        list.add(new Photo_Object(R.drawable.meo2));
        return list;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(runnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(runnable, 3000);
    }
}