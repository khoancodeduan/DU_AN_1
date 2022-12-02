package Nhom2.example.du_an_1.Model;

public class TbCategory {
    int id;
    String name;
    int giatien;
    String IMG;
    int id_sp;

    public TbCategory(int id, String name, int giatien, String IMG, int id_sp) {
        this.id = id;
        this.name = name;
        this.giatien = giatien;
        this.IMG = IMG;
        this.id_sp = id_sp;
    }

    public TbCategory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGiatien() {
        return giatien;
    }

    public void setGiatien(int giatien) {
        this.giatien = giatien;
    }

    public String getIMG() {
        return IMG;
    }

    public void setIMG(String IMG) {
        this.IMG = IMG;
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }
}
