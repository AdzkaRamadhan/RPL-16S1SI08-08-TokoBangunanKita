/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class KoneksiDB {
    public Connection con;
    
    public void KoneksiDB() {
        String pesan ="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                String url = "jdbc:mysql://localhost:3306/KASIR";
                con = DriverManager.getConnection(url, "root", "");
            } catch (SQLException se) {
                se.printStackTrace();
                pesan = "Koneksi basis data gagal: Error: " + se;
                JOptionPane.showMessageDialog(null, pesan, "Terjadi Kesalahan",
                        JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        } catch (ClassNotFoundException cnfe) {
            pesan = "Class tidak tersedia. Error: " + cnfe;
            JOptionPane.showMessageDialog(null, pesan, "Terjadi Kesalahan",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
