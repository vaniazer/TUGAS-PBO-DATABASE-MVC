package ContactList;

import javax.swing.*;
import java.sql.*;

public class ModelPraktikum {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbcontact";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public ModelPraktikum() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    public void insertData(String nomor, String nama, String umur, String email){
        try {
            String query = "INSERT INTO `contact` VALUES ('"+nomor+"','"+nama+"','"+umur+"','"+email+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data Berhasil Diinput!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public String[][] readData(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][4];

            String query = "SELECT * FROM `contact`";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nomor");
                data[jmlData][1] = resultSet.getString("nama");
                data[jmlData][2] = resultSet.getString("umur");
                data[jmlData][3] = resultSet.getString("email");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM `contact`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    public void updateData(String nomor, String nama, String umur, String email){
        try {
            String query = "UPDATE `contact` SET `nomor` = '"+nomor+"',`nama`= '"+nama+"', `umur`= '"+umur+"' , `email`='"+email+"'  WHERE `nomor` = '"+nomor+"'";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil diUpdate");
            JOptionPane.showMessageDialog(null, "Data Berhasil diupdate!");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    public void deleteData (String nomor) {
        try{
            String query = "DELETE FROM `contact` WHERE `nomor` = '"+nomor+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus!");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

}
