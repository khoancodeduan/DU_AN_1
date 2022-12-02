package Nhom2.example.du_an_1.Database;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbSqlServer {

    Connection connection;
    final String TAG = "zzzzzz";

    public Connection openConnect(){
        String ip = "103.179.188.76", port = "1433", user = "CP17303_n2", pass = "Kmk@123456", db = "CP17303_n2";
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String connectUrl = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databasename=" + db +";user=" + user +";password=" + pass +";";
            this.connection = DriverManager.getConnection(connectUrl);
            Log.d(TAG, "openConnect: OK");
        } catch (Exception e) {
            Log.e(TAG, "getCollection: Loi ket noi CSDL" );
            e.printStackTrace();
        }
        return connection;
    }
}
