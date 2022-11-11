package Nhom2.example.du_an_1.Model;

import java.io.Serializable;

public class Photo_Object implements Serializable {
    private int ResoudId;

    public Photo_Object(int resoudId) {
        ResoudId = resoudId;
    }

    public int getResoudId() {
        return ResoudId;
    }

    public void setResoudId(int resoudId) {
        ResoudId = resoudId;
    }
}
