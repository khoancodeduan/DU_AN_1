package Nhom2.example.du_an_1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


import Nhom2.example.du_an_1.Addapter.Photo_Addapter;
import Nhom2.example.du_an_1.Dao.TbCatDao;
import Nhom2.example.du_an_1.Model.Photo_Object;
import Nhom2.example.du_an_1.Model.TbCategory;
import Nhom2.example.du_an_1.R;
import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {
    DrawerLayout layout;
    Toolbar toolbar;
    private ViewPager2 viewPager;
    private CircleIndicator3 indicator;
    private Photo_Addapter photoaddapter;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private List<Photo_Object> mlistphoto;

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