package Nhom2.example.du_an_1.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import Nhom2.example.du_an_1.R;


public class Gio_hangFragment extends Fragment {



    public Gio_hangFragment() {
        // Required empty public constructor
    }

    public static Gio_hangFragment newInstance() {
        Gio_hangFragment fragment = new Gio_hangFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
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
        return inflater.inflate(R.layout.fragment_gio_hang, container, false);
    }
}