package kelas;

import Kelas.Koneksi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SuratMasuk {

    int jumlah = 0;
    public static String id_surat, kategori, bagian, asal_surat, perihal, file_data;

    public static java.sql.Date tanggal_diterima;
    // private static final String destinationPath = "./Upload/surat/"; // Ensure this is declared at the class level

    private Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public SuratMasuk() throws SQLException {
        Koneksi koneksi = new Koneksi();
        konek = koneksi.koneksiDB();
    }

    public static String getId_surat() {
        return id_surat;
    }

    public static void setId_surat(String id_surat) {
        SuratMasuk.id_surat = id_surat;
    }

    public static String getKategori() {
        return kategori;
    }

    public static void setKategori(String kategori) {
        SuratMasuk.kategori = kategori;
    }

    public static String getBagian() {
        return bagian;
    }

    public static void setBagian(String bagian) {
        SuratMasuk.bagian = bagian;
    }

    public static String getAsal_surat() {
        return asal_surat;
    }

    public static void setAsal_surat(String asal_surat) {
        SuratMasuk.asal_surat = asal_surat;
    }

    public static String getPerihal() {
        return perihal;
    }

    public static void setPerihal(String perihal) {
        SuratMasuk.perihal = perihal;
    }

    public static String getFile_data() {
        return file_data;
    }

    public static void setFile_data(String file_data) {
        SuratMasuk.file_data = file_data;
    }

    public static Date getTanggal_diterima() {
        return tanggal_diterima;
    }

    public static void setTanggal_diterima(Date tanggal_diterima) {
        SuratMasuk.tanggal_diterima = tanggal_diterima;
    }

    public Connection getKonek() {
        return konek;
    }

    public void setKonek(Connection konek) {
        this.konek = konek;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void tambahSurat() {
        query = "INSERT INTO surat_masuk(id_surat,"
                + "kategori,"
                + "bagian,"
                + "asal_surat,"
                + "perihal,"
                + "tanggal_diterima,"
                + "file_data) VALUES(?,?,?,?,?,?,?)";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_surat);
            ps.setString(2, kategori);
            ps.setString(3, bagian);
            ps.setString(4, asal_surat);
            ps.setString(5, perihal);
            ps.setDate(6, tanggal_diterima);
            ps.setString(7, file_data);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Surat berhasil ditambahkan");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ResultSet tampilSurat() {
        query = "SELECT * FROM surat_masuk";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal tampil: " + ex.getMessage());
        }
        return rs;
    }

    public void hapusSurat() {
        query = "DELETE FROM surat_masuk WHERE id_surat = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, id_surat);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Surat berhasil dihapus");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Surat gagal dihapus: " + ex.getMessage());
        }
    }

    public void ubahSurat() {
        query = "UPDATE surat_masuk SET "
                + "kategori = ?, "
                + "bagian = ?, "
                + "asal_surat = ?, "
                + "perihal = ?, "
                + "tanggal_diterima = ?, "
                + "file_data = ? "
                + "WHERE id_surat = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, kategori);
            ps.setString(2, bagian);
            ps.setString(3, asal_surat);
            ps.setString(4, perihal);
            ps.setDate(5, tanggal_diterima);
            ps.setString(6, file_data);
            ps.setString(7, id_surat);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Surat berhasil diubah");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Surat gagal diubah: " + ex.getMessage());
        }
    }

  

    public String otoID() {
        // Menggunakan LocalDate untuk mendapatkan tanggal saat ini dalam format yyyyMMdd
        LocalDate today = LocalDate.now();
        String todayFormatted = today.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        // Membangun query untuk mendapatkan ID surat terakhir hari ini
        String query = "SELECT id_surat FROM surat_masuk WHERE id_surat LIKE '" + todayFormatted + "%' ORDER BY id_surat DESC LIMIT 1";

        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                String lastId = rs.getString("id_surat");
                // Mengambil bagian numerik dari ID surat terakhir dan menambahkannya dengan satu
                int num = Integer.parseInt(lastId.substring(8)) + 1;
                String newId = todayFormatted + String.format("%03d", num);
                return newId; // Mengembalikan ID baru
            } else {
                // Jika tidak ada surat pada hari ini, mulai dengan 001
                return todayFormatted + "001";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to fetch next surat ID: " + ex.getMessage());
            return null; // Mengembalikan null jika ada kegagalan dalam eksekusi query
        }
    }

    
      // Method untuk menggabungkan filter
    public ResultSet KodeTampilByFilters(String filterKategori, String filterBagian, java.sql.Date filterTanggal) {
        try {
            StringBuilder queryBuilder = new StringBuilder("SELECT id_surat, kategori, Bagian, asal_surat, perihal, tanggal_diterima FROM surat_masuk WHERE 1=1");

            if (filterKategori != null && !filterKategori.isEmpty()) {
                queryBuilder.append(" AND kategori = ?");
            }
            if (filterBagian != null && !filterBagian.isEmpty()) {
                queryBuilder.append(" AND bagian = ?");
            }
            if (filterTanggal != null) {
                queryBuilder.append(" AND tanggal_diterima = ?");
            }

            PreparedStatement ps = konek.prepareStatement(queryBuilder.toString());

            int index = 1;
            if (filterKategori != null && !filterKategori.isEmpty()) {
                ps.setString(index++, filterKategori);
            }
            if (filterBagian != null && !filterBagian.isEmpty()) {
                ps.setString(index++, filterBagian);
            }
            if (filterTanggal != null) {
                ps.setDate(index++, filterTanggal);
            }

            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Method untuk memfilter data berdasarkan Kategori
    public ResultSet KodeTampilByKategori(String filterKategori) {
        try {
            if (filterKategori == null || filterKategori.isEmpty()) {
                query = "SELECT id_surat, kategori, Bagian, asal_surat, perihal, tanggal_diterima FROM surat_masuk";
                PreparedStatement ps = konek.prepareStatement(query);
                rs = ps.executeQuery();
            } else {
                query = "SELECT id_surat, kategori, Bagian, asal_surat, perihal, tanggal_diterima FROM suratkeluar WHERE kategori = ?";
                PreparedStatement ps = konek.prepareStatement(query);
                ps.setString(1, filterKategori);
                rs = ps.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Method untuk memfilter data berdasarkan Bagian
    public ResultSet KodeTampilByBagian(String filterBagian) {
        try {
            if (filterBagian == null || filterBagian.isEmpty()) {
                // Query tanpa filter
                query = "SELECT iid_surat, kategori, Bagian, asal_surat, perihal, tanggal_diterima FROM surat_masuk";
                PreparedStatement ps = konek.prepareStatement(query);
                rs = ps.executeQuery();
            } else {
                // Query dengan filter bagian
                query = "SELECT id_surat, kategori, Bagian, asal_surat, perihal, tanggal_diterima FROM suratkeluar WHERE bagian = ?";
                PreparedStatement ps = konek.prepareStatement(query);
                ps.setString(1, filterBagian);
                rs = ps.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Method untuk memfilter data berdasarkan Tanggal
    public ResultSet KodeTampilByTanggal(java.sql.Date tanggal) {
        try {
            query = "SELECT id_surat, kategori, Bagian, asal_surat, perihal, tanggal_diterima FROM surat_masuk WHERE tanggal_diterima = ?";
            PreparedStatement ps = konek.prepareStatement(query);
            ps.setDate(1, tanggal);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    // Method untuk menampilkan jumlah Surat Masuk
    public int TampilJumlahBagian() {
        query = "SELECT COUNT(*) AS jumlah FROM surat_masuk";

        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);

            if (rs.next()) {
                jumlah = rs.getInt("jumlah");
            }

            rs.close();
            st.close();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkan: " + sQLException.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        return jumlah;
    }

}