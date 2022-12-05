package Nhom2.example.du_an_1.Addapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Nhom2.example.du_an_1.Activity.Gio_hang_Activity;
import Nhom2.example.du_an_1.Model.rcv_Sp;
import Nhom2.example.du_an_1.R;

public class Addapter_bsk_Rsc extends RecyclerView.Adapter<Addapter_bsk_Rsc.UserViewHodle> {
    private List<rcv_Sp> list;
    private Context mContext;

    public Addapter_bsk_Rsc(Context context, List<rcv_Sp> list) {
        this.mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public UserViewHodle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHodle holder, int position) {

        final rcv_Sp sp = list.get(position);
        if ((sp == null)) {
            return;
        }
    }

    private void onclickItem(rcv_Sp sp) {
        Intent intent = new Intent(mContext, Gio_hang_Activity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("all", sp);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class UserViewHodle extends RecyclerView.ViewHolder {
        private ImageView imageView, img_Them;
        private TextView Names, Gias;
        private LinearLayout linearLayout;

        public UserViewHodle(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.id_liner_item);
            imageView = itemView.findViewById(R.id.id_img1);
            img_Them = itemView.findViewById(R.id.id_imgthem);
            Names = itemView.findViewById(R.id.id_name);
            Gias = itemView.findViewById(R.id.id_gia);
        }
    }
}
