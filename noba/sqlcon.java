package com.example.noba;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlcon {

    String mysql_ip = "140.127.220.73";
    int mysql_port = 3306;
    String db_name = "NobaJosport";
    String url = "jdbc:mysql://"+mysql_ip+":"+mysql_port+"/"+db_name+"?useSSL=false";
    String db_user = "root";
    String db_password = "RBS%bf*5?rzV";

    public void run() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Log.v("DB","加載驅動成功");
        }catch( ClassNotFoundException e) {
            Log.e("DB","加載驅動失敗");
            return;
        }

        // 連接資料庫
        try {
            DriverManager.getConnection(url,db_user,db_password);
            Log.v("DB","遠端連接成功");
        }catch(SQLException e) {
            Log.e("DB","遠端連接失敗");
            Log.e("DB", e.toString());
        }
    }

    public void sql(String sqlstr) {
        try {
            Connection con = DriverManager.getConnection(url, db_user, db_password);
            String sql = sqlstr;
            Statement st = con.createStatement();
            st.execute(sql);

            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getData() {
        StringBuilder data = new StringBuilder();
        try {
            Connection con = DriverManager.getConnection(url, db_user, db_password);
            String sql = "SELECT a.ID,a.account FROM accounts a";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                String id = rs.getString("ID");
                String name = rs.getString("account");
                data.append(id).append(", ").append(name).append("\n");
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data.toString();
    }

    public String getinfo(String info,String sqlstr) {
        StringBuilder data = new StringBuilder();
        try {
            Connection con = DriverManager.getConnection(url, db_user, db_password);
            String sql = sqlstr;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String ret = rs.getString(info);
                data.append(ret);
            }

            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data.toString();
    }
}
