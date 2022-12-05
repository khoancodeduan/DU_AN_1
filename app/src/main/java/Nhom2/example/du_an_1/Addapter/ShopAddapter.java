package Nhom2.example.du_an_1.Addapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import Nhom2.example.du_an_1.Model.ShopObject;
import Nhom2.example.du_an_1.R;

public class ShopAddapter extends BaseAdapter {
    List<ShopObject> list;
    Context context;
    LayoutInflater inflater;

    public ShopAddapter(List<ShopObject> list, Context context) {
        this.list = list;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        ImageView id_img1;
        TextView id_name, id_gia;

        if (view == null) {
            view = inflater.inflate(R.layout.item_rscv_main, null);
        }


        id_img1 = view.findViewById(R.id.id_img1);
        id_name = view.findViewById(R.id.id_name);
        id_gia = view.findViewById(R.id.id_gia);

        id_img1.setImageBitmap(CovertBitmap(list.get(i).getImg()));
        id_name.setText(list.get(i).getNameSP());
        id_gia.setText(String.valueOf(list.get(i).getGiaTien()));

        return view;
    }

    public Bitmap CovertBitmap(String path) {
        Bitmap mbitmap = null;
        try {
            URL url = new URL(path);
            InputStream inputStream = url.openConnection().getInputStream();

            mbitmap = BitmapFactory.decodeStream(inputStream);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mbitmap;
    }


}