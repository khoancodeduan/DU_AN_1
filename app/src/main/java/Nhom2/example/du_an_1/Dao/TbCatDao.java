package Nhom2.example.du_an_1.Dao;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Nhom2.example.du_an_1.Database.DbSqlServer;
import Nhom2.example.du_an_1.Model.ShopObject;
import Nhom2.example.du_an_1.Model.TbCategory;

public class TbCatDao {
    Connection objConn;

    public TbCatDao() {
        // hàm khởi tạo để mở kết nối
        DbSqlServer db = new DbSqlServer();
        objConn = db.openConnect(); // tạo mới DAO thì mở kết nối CSDL
    }


    public List<TbCategory> getAll() {
        List<TbCategory> listCat = new ArrayList<TbCategory>();
        try {
            if (this.objConn != null) {

                String sqlQuery = "SELECT * FROM BANG_SAN_PHAM ";
                Statement statement = this.objConn.createStatement(); // khởi tạo cấu trúc truy vấn
                ResultSet resultSet = statement.executeQuery(sqlQuery); // thực thi câu lệnh truy vấn

                while (resultSet.next()) { // đọc dữ liệu gán vào đối tượng và đưa vào list
                    TbCategory objCat = new TbCategory();
                    objCat.setId(resultSet.getInt("ID")); // truyền tên cột dữ liệu
                    objCat.setName(resultSet.getString("NAME_SP"));
                    objCat.setGiatien(resultSet.getInt("GIA_TIEN"));
                    objCat.setIMG(resultSet.getString("IMG"));
                    objCat.setId_sp(resultSet.getInt("ID_HANG_SP"));
                    listCat.add(objCat);
                }
            } // nếu kết nối khác null thì mới select và thêm dữ liệu vào, nếu không thì trả về ds rỗng
        } catch (Exception e) {
            Log.e("zzzzzzzzzz", "getAll: Có lỗi truy vấn dữ liệu ");
            e.printStackTrace();
        }

        return listCat;
    }


    public void insertRow(ShopObject obj) {

        try {
            if (this.objConn != null) {
                // ghép chuỗi SQL
                String insertSQL = " INSERT INTO BANG_SAN_PHAM VALUES ("+obj.getId()+",N'"+obj.getNameSP()+"',"+obj.getGiaTien()+","+obj.getIdhangSP()+",'"+obj.getImg()+"')";
                String generatedColumns[] = {"ID"};
                PreparedStatement stmtInsert = this.objConn.prepareStatement(insertSQL, generatedColumns);
                stmtInsert.execute();

                Log.d("zzzzz", "insertRow: finish insert");
                // lấy ra ID cột tự động tăng
                ResultSet rs = stmtInsert.getGeneratedKeys();
                if (rs.next()) {
                    long id = rs.getLong(1);
                    Log.d("zzzz", "insertRow: ID = " + id);
                }

            } // nếu kết nối khác null thì mới select và thêm dữ liệu vào, nếu không thì trả về ds rỗng


        } catch (Exception e) {
            Log.e("zzzzzzzzzz", "insertRow: Có lỗi thêm dữ liệu ");
            e.printStackTrace();
        }
    }

    public void updateRow(TbCategory objCat) {
        try {
            if (this.objConn != null) {
                // ghép chuỗi SQL
                String sqlUpdate = "UPDATE HANG SET name= N'" + objCat.getName() + "' WHERE id = " + objCat.getId();
                PreparedStatement stmt = this.objConn.prepareStatement(sqlUpdate);
                stmt.execute(); // thực thi câu lệnh SQL
                Log.d("zzzzz", "updateRow: finish Update");
            } // nếu kết nối khác null thì mới select và thêm dữ liệu vào, nếu không thì trả về ds rỗng


        } catch (Exception e) {
            Log.e("zzzzzzzzzz", "updateRow: Có lỗi sửa dữ liệu ");
            e.printStackTrace();
        }
    }

    public void deleteProd(String maSp) {
        try {
            if (this.objConn != null) {
                String deleteSQL = "DELETE SanPham WHERE maSP='" + maSp + "'";

                PreparedStatement stmtDelete = this.objConn.prepareStatement(deleteSQL);
                stmtDelete.execute();

                Log.d("TAG Debug", "deleteProd: finish delete");
            }

        } catch (Exception e) {
            Log.e("TAG Lỗi", "deleteProd: Có lỗi xóa dữ liệu ");
            e.printStackTrace();
        }

    }



}
