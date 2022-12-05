package Nhom2.example.du_an_1.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import Nhom2.example.du_an_1.Addapter.Addapter_rscv_main;
import Nhom2.example.du_an_1.Dao.TbCatDao;
import Nhom2.example.du_an_1.Model.ShopObject;
import Nhom2.example.du_an_1.Model.TbCategory;
import Nhom2.example.du_an_1.R;

public class ShopFragment extends Fragment {

    TbCatDao dao;

    public ShopFragment() {
        dao = new TbCatDao();
    }


    public static ShopFragment newInstance() {
        ShopFragment fragment = new ShopFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        EditText id_name = view.findViewById(R.id.id_name);
        EditText id_gia = view.findViewById(R.id.id_gia);
        EditText id = view.findViewById(R.id.id);
        EditText id_Hang = view.findViewById(R.id.id_Hang);
        EditText id_LinkAnh = view.findViewById(R.id.id_linkANH);
        Button id_btn_them = view.findViewById(R.id.id_btn_them);


        id_btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ShopObject shopObject = new ShopObject();
                shopObject.setId(Integer.parseInt(id.getText().toString()));
                shopObject.setNameSP(id_name.getText().toString());
                shopObject.setIdhangSP(Integer.parseInt(id_Hang.getText().toString()));
                shopObject.setGiaTien(Integer.parseInt(id_gia.getText().toString()));
                shopObject.setImg(id_LinkAnh.getText().toString());
                dao.insertRow(shopObject);

            }
        });

    }
}