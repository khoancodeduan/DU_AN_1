package Nhom2.example.du_an_1.Model;

import java.io.Serializable;

public class rcv_Sp implements Serializable {
    String img;
    String text_name;
    String text_gia;
    String img_buy;



    public rcv_Sp(String img, String text_name, String text_gia, String img_buy) {
        this.img = img;
        this.text_name = text_name;
        this.text_gia = text_gia;
        this.img_buy = img_buy;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getText_name() {
        return text_name;
    }

    public void setText_name(String text_name) {
        this.text_name = text_name;
    }

    public String getText_gia() {
        return text_gia;
    }

    public void setText_gia(String text_gia) {
        this.text_gia = text_gia;
    }

    public String getImg_buy() {
        return img_buy;
    }

    public void setImg_buy(String img_buy) {
        this.img_buy = img_buy;
    }
}
