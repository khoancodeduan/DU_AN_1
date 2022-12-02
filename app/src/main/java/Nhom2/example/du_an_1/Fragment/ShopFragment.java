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
import Nhom2.example.du_an_1.Model.TbCategory;
import Nhom2.example.du_an_1.R;

public class ShopFragment extends Fragment {



    public ShopFragment() {

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
        Button id_btn_them = view.findViewById(R.id.id_btn_them);



        id_btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}