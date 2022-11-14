package Nhom2.example.du_an_1.Addapter;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;
import Nhom2.example.du_an_1.Fragment.Fragment_photo;
import Nhom2.example.du_an_1.Model.Photo_Object;
public class Photo_Addapter extends FragmentStateAdapter {

    private Context mContext;
    private List<Photo_Object> mlist;

    public Photo_Addapter(@NonNull FragmentActivity fragmentActivity, List<Photo_Object> list) {
        super(fragmentActivity);
        this.mlist = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Photo_Object object = mlist.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_photo", object);
        Fragment_photo photo = new Fragment_photo();
        photo.setArguments(bundle);
        return photo;
    }

    @Override
    public int getItemCount() {
        if (mlist != null) {
            return mlist.size();
        }
        return 0;
    }
}
