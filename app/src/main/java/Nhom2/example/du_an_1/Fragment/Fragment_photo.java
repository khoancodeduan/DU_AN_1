package Nhom2.example.du_an_1.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import Nhom2.example.du_an_1.Model.Photo_Object;
import Nhom2.example.du_an_1.R;

public class Fragment_photo extends Fragment {

    private View mView;


    public Fragment_photo() {

    }


    public static Fragment_photo newInstance() {
        Fragment_photo fragment = new Fragment_photo();


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
        mView = inflater.inflate(R.layout.fragment_photo, container, false);

        Bundle bundle = getArguments();
        Photo_Object object = (Photo_Object) bundle.get("object_photo");
        ImageView imageView = mView.findViewById(R.id.img_photo);
        imageView.setImageResource(object.getResoudId());
        return mView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}