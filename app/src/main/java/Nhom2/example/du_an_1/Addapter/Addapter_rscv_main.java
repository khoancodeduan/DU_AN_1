package Nhom2.example.du_an_1.Addapter;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

import Nhom2.example.du_an_1.Model.TbCategory;
import Nhom2.example.du_an_1.R;

public class Addapter_rscv_main extends BaseAdapter {
    Context context;
    List<TbCategory> list;
    int layout;
    LayoutInflater inflater;

    public Addapter_rscv_main(Context context, List<TbCategory> list, int layout) {
        this.context = context;
        this.list = list;
        this.layout = layout;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_rscv_main, null);

            holder = new ViewHolder();
            holder.id_img01 = convertView.findViewById(R.id.id_img1);
            holder.id_name = convertView.findViewById(R.id.id_name);
            holder.id_gia = convertView.findViewById(R.id.id_gia);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //gán dữ liệu
//         = list.get(position);
        holder.id_name.setText(list.get(position).getName());
        holder.id_gia.setText(list.get(position).getGiatien() + "");

        Glide.with(convertView.getContext()).load(list.get(position).getIMG()).into(holder.id_img01);


//        holder.id_img01.setText(list.get(position).getIMG());
//        holder.id_img01.setText(R.drawable.logo);

        return convertView;
    }

    public class ViewHolder {
        TextView id_name, id_gia;
        ImageView id_img01;

    }
}
