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

public class ShopDao {
    Connection connection;

    public ShopDao() {
        // hàm khởi tạo để mở kết nối
        DbSqlServer db = new DbSqlServer();
        connection = db.openConnect(); // tạo mới DAO thì mở kết nối CSDL
    }
    public List<ShopObject> getAll() {
        List<ShopObject> ls = new ArrayList<ShopObject>();
        try {
            if (this.connection != null) {

                String sqlQuery = "SELECT * FROM BANG_SAN_PHAM ";
                Statement statement = this.connection.createStatement(); // khởi tạo cấu trúc truy vấn
                ResultSet resultSet = statement.executeQuery(sqlQuery); // thực thi câu lệnh truy vấn

                while (resultSet.next()) { // đọc dữ liệu gán vào đối tượng và đưa vào list
                    ShopObject shopObject = new ShopObject();
                    shopObject.setId(resultSet.getInt("ID"));
                    shopObject.setNameSP(resultSet.getString("NAME_SP"));
                    shopObject.setGiaTien(resultSet.getInt("GIA_TIEN"));
                    shopObject.setIdhangSP(resultSet.getInt("ID_HANG_SP"));
                    shopObject.setImg(resultSet.getString("IMG"));

                    ls.add(shopObject);
                }
            } // nếu kết nối khác null thì mới select và thêm dữ liệu vào, nếu không thì trả về ds rỗng
        } catch (Exception e) {
            Log.e("zzzzzzzzzz", "getAll: Có lỗi truy vấn dữ liệu ");
            e.printStackTrace();
        }

        return ls;
    }
    public void insertRow(ShopObject obj) {

        try {
            if (this.connection != null) {
                // ghép chuỗi SQL
                String insertSQL = " INSERT INTO BANG_SAN_PHAM VALUES ("+obj.getId()+",N'"+obj.getNameSP()+"',"+obj.getGiaTien()+","+obj.getIdhangSP()+",'"+obj.getImg()+"')";
                String generatedColumns[] = {"ID"};
                PreparedStatement stmtInsert = this.connection.prepareStatement(insertSQL, generatedColumns);
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
}
