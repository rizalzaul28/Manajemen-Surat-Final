/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Main;

import Kelas.Bagian;
import Kelas.Kategori;
import Kelas.SuratKeluar;
import Main.MenuUtama;
import java.awt.Desktop;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import kelas.SuratMasuk;
import Main.MenuSuratMasuk;
import PopUp.PopUpSuratMasuk;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MenuSuratMasuk extends javax.swing.JPanel {

    public MenuSuratMasuk() {
        initComponents();
        loadTabel();

        cbBagianSurat();
        cbKategoriSurat();

        cb_KategoriMenu.addActionListener(evt -> applyFilters());
        cb_BagianMenu.addActionListener(evt -> applyFilters());
        tf_TglMenu.addPropertyChangeListener(evt -> {
            if ("date".equals(evt.getPropertyName())) {
                applyFilters();
            }
        });

    }

    public void setModel(DefaultTableModel model) {
        tb_SuratMasuk.setModel(model);
    }

    void loadTabel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(null);
        model.addColumn("Kategori");
        model.addColumn("Bagian");
        model.addColumn("Asal Surat");
        model.addColumn("Perihal");
        model.addColumn("Tanggal Diterima");
        model.addColumn("File Surat");

        try {
            SuratMasuk surat = new SuratMasuk();
            ResultSet data = surat.tampilSurat();

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("id_surat"),
                    data.getString("kategori"),
                    data.getString("bagian"),
                    data.getString("asal_surat"),
                    data.getString("perihal"),
                    data.getString("tanggal_diterima"),
                    data.getString("file_data"),});

            }

        } catch (SQLException sQLException) {
        }

        tb_SuratMasuk.setModel(model);
        tb_SuratMasuk.getColumnModel().getColumn(0).setMinWidth(0);
        tb_SuratMasuk.getColumnModel().getColumn(0).setMaxWidth(0);
        tb_SuratMasuk.getColumnModel().getColumn(0).setWidth(0);
    }

    void cbKategoriSurat() {
        try {
            cb_KategoriMenu.addItem("--Pilih Kategori Surat--");

            Kategori ks = new Kategori();
            ResultSet data = ks.Tampil_CbKategoriSurat();

            while (data.next()) {
                cb_KategoriMenu.addItem(data.getString("kode") + " - " + data.getString("nama"));
            }

            cb_KategoriMenu.setSelectedItem("--Pilih Kategori Surat--");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void cbBagianSurat() {
        try {
            cb_BagianMenu.addItem("--Pilih Bagian Surat--");

            Bagian bg = new Bagian();
            ResultSet data = bg.Tampil_CbBagianSurat();

            while (data.next()) {
                cb_BagianMenu.addItem(data.getString("kode") + " - " + data.getString("nama"));
            }

            cb_BagianMenu.setSelectedItem("--Pilih Bagian Surat--"); // Pilih default option
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void applyFilters() {
        String selectedKategori = cb_KategoriMenu.getSelectedItem().toString();
        String selectedBagian = cb_BagianMenu.getSelectedItem().toString();
        java.util.Date selectedDate = tf_TglMenu.getDate();

        String filterKategori = null;
        String filterBagian = null;
        java.sql.Date filterTanggal = null;

        if (!selectedKategori.equals("--Pilih Kategori Surat--")) {
            filterKategori = selectedKategori.split(" - ")[0];
        }

        if (!selectedBagian.equals("--Pilih Bagian Surat--")) {
            filterBagian = selectedBagian.split(" - ")[0];
        }

        if (selectedDate != null) {
            filterTanggal = new java.sql.Date(selectedDate.getTime());
        }

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(null);
        model.addColumn("Kategori");
        model.addColumn("Bagian");
        model.addColumn("Asal Surat");
        model.addColumn("Perihal");
        model.addColumn("Tanggal Diterima");
        model.addColumn("File Surat");

        try {
            SuratMasuk bg = new SuratMasuk();
            ResultSet data = bg.KodeTampilByFilters(filterKategori, filterBagian, filterTanggal);

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("id_surat"),
                    data.getString("kategori"),
                    data.getString("bagian"),
                    data.getString("asal_surat"),
                    data.getString("perihal"),
                    data.getString("tanggal_diterima"),
                    data.getString("file_data"),});
            }

            data.close();
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }

        tb_SuratMasuk.setModel(model);

        tb_SuratMasuk.getColumnModel().getColumn(0).setMinWidth(0);
        tb_SuratMasuk.getColumnModel().getColumn(0).setMaxWidth(0);
        tb_SuratMasuk.getColumnModel().getColumn(0).setWidth(0);
    }

    private void filterTabelByKategori() {
        String selectedKategori = cb_KategoriMenu.getSelectedItem().toString();
        if (selectedKategori.equals("--Pilih Kategori Surat--")) {
            loadTabel();
            return;
        }

        String kodeKategori = selectedKategori.split(" - ")[0]; // Ambil kode kategori
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(null);
        model.addColumn("Kategori");
        model.addColumn("Bagian");
        model.addColumn("Asal Surat");
        model.addColumn("Perihal");
        model.addColumn("Tanggal Diterima");
        model.addColumn("File Surat");

        try {
            SuratKeluar bg = new SuratKeluar();
            ResultSet data = bg.KodeTampilByKategori(kodeKategori);

            while (data.next()) {
                if (data.getString("kategori").equals(kodeKategori)) {
                    model.addRow(new Object[]{
                        data.getString("id_surat"),
                        data.getString("kategori"),
                        data.getString("bagian"),
                        data.getString("asal_surat"),
                        data.getString("perihal"),
                        data.getString("tanggal_diterima"),
                        data.getString("file_data"),});
                }
            }

            data.close();
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }

        tb_SuratMasuk.setModel(model);

        tb_SuratMasuk.getColumnModel().getColumn(0).setMinWidth(0);
        tb_SuratMasuk.getColumnModel().getColumn(0).setMaxWidth(0);
        tb_SuratMasuk.getColumnModel().getColumn(0).setWidth(0);
    }

    private void filterTabelByBagian() {
        String selectedBagian = cb_BagianMenu.getSelectedItem().toString();

        if (selectedBagian.equals("--Pilih Bagian Surat--")) {
            loadTabel();
        } else {
            String filterBagian = selectedBagian.split(" - ")[0];
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn(null);
            model.addColumn("Kategori");
            model.addColumn("Bagian");
            model.addColumn("Asal Surat");
            model.addColumn("Perihal");
            model.addColumn("Tanggal Diterima");
            model.addColumn("File Surat");
            try {
                SuratKeluar bg = new SuratKeluar();
                ResultSet data = bg.KodeTampilByBagian(filterBagian);

                while (data.next()) {
                    model.addRow(new Object[]{
                        data.getString("id_surat"),
                        data.getString("kategori"),
                        data.getString("bagian"),
                        data.getString("asal_surat"),
                        data.getString("perihal"),
                        data.getString("tanggal_diterima"),
                        data.getString("file_data"),});
                }

                data.close();
            } catch (SQLException sQLException) {
                sQLException.printStackTrace();
            }

            tb_SuratMasuk.setModel(model);

            tb_SuratMasuk.getColumnModel().getColumn(0).setMinWidth(0);
            tb_SuratMasuk.getColumnModel().getColumn(0).setMaxWidth(0);
            tb_SuratMasuk.getColumnModel().getColumn(0).setWidth(0);
        }
    }

    private void tf_TglPropertyChange(java.beans.PropertyChangeEvent evt) {
        if ("date".equals(evt.getPropertyName())) {
            java.util.Date selectedDate = tf_TglMenu.getDate();
            if (selectedDate != null) {
                filterTabelByTanggal(selectedDate);
            } else {
                filterTabelByKategori();
                filterTabelByBagian();
                loadTabel();
            }
        }
    }

    private void filterTabelByTanggal(java.util.Date tanggal) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(null);
        model.addColumn("Kategori");
        model.addColumn("Bagian");
        model.addColumn("Asal Surat");
        model.addColumn("Perihal");
        model.addColumn("Tanggal Diterima");
        model.addColumn("File Surat");
        try {
            java.sql.Date sqlDate = new java.sql.Date(tanggal.getTime());
            SuratKeluar bg = new SuratKeluar();
            ResultSet data = bg.KodeTampilByTanggal(sqlDate);

            while (data.next()) {
                model.addRow(new Object[]{
                     data.getString("id_surat"),
                    data.getString("kategori"),
                    data.getString("bagian"),
                    data.getString("asal_surat"),
                    data.getString("perihal"),
                    data.getString("tanggal_diterima"),
                    data.getString("file_data"),});
            }

            data.close();
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }

        tb_SuratMasuk.setModel(model);

        tb_SuratMasuk.getColumnModel().getColumn(0).setMinWidth(0);
        tb_SuratMasuk.getColumnModel().getColumn(0).setMaxWidth(0);
        tb_SuratMasuk.getColumnModel().getColumn(0).setWidth(0);
    }

    void resetTgl() {
        tf_TglMenu.setDate(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        pn1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_SuratMasuk = new javax.swing.JTable();
        bTambah = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cb_KategoriMenu = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cb_BagianMenu = new javax.swing.JComboBox<>();
        tf_TglMenu = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        pnMain.setBackground(new java.awt.Color(255, 255, 255));
        pnMain.setLayout(new java.awt.CardLayout());

        tb_SuratMasuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_SuratMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_SuratMasukMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tb_SuratMasukMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tb_SuratMasuk);

        bTambah.setBackground(new java.awt.Color(0, 0, 255));
        bTambah.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        bTambah.setForeground(new java.awt.Color(255, 255, 255));
        bTambah.setText("Tambah Surat");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        jLabel11.setText("Kategori");

        jLabel15.setText("Bagian");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Menu Surat Masuk");

        jButton1.setText("Reset Tanggal");

        javax.swing.GroupLayout pn1Layout = new javax.swing.GroupLayout(pn1);
        pn1.setLayout(pn1Layout);
        pn1Layout.setHorizontalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn1Layout.createSequentialGroup()
                .addGroup(pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1054, Short.MAX_VALUE))
                    .addGroup(pn1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(bTambah)
                            .addGroup(pn1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_KategoriMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_BagianMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(tf_TglMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pn1Layout.setVerticalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(bTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn1Layout.createSequentialGroup()
                        .addGroup(pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(cb_BagianMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(cb_KategoriMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_TglMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnMain.add(pn1, "card7");

        add(pnMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void tb_SuratMasukMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_SuratMasukMousePressed
//        pnMain.removeAll();
//        pnMain.add(pnDetail);
//        pnMain.repaint();
//        pnMain.revalidate();
//
//        try {
//            suratMasuk sur = new suratMasuk();
//
//        
//
//            int selectedRow = tbSuratMasuk.getSelectedRow();
//            if (selectedRow != -1) {
//
//               
//                sur.setId_surat(tbSuratMasuk.getValueAt(selectedRow, 0).toString());
//                sur.setJudul(tbSuratMasuk.getValueAt(selectedRow, 1).toString());
//                sur.setPerihal(tbSuratMasuk.getValueAt(selectedRow, 2).toString());
//                sur.setNo_surat(tbSuratMasuk.getValueAt(selectedRow, 3).toString());
//                sur.setAsal_surat(tbSuratMasuk.getValueAt(selectedRow, 4).toString());
//                sur.setTujuan(tbSuratMasuk.getValueAt(selectedRow, 5).toString());
//
//               
//                String tanggalDiterimaStr = tbSuratMasuk.getValueAt(selectedRow, 6).toString();
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd"); 
//
//                try {
//                    Date tanggalDiterima = dateFormat.parse(tanggalDiterimaStr);
//                    sur.setTanggal_diterima(new java.sql.Date(tanggalDiterima.getTime())); 
//                } catch (Exception e) {
//                    e.printStackTrace(); 
//                }
//
//             
//                sur.setJenis_surat(tbSuratMasuk.getValueAt(selectedRow, 7).toString());
//                sur.setKeterangan(tbSuratMasuk.getValueAt(selectedRow, 8).toString());
//                sur.setFile_data(tbSuratMasuk.getValueAt(selectedRow, 9).toString());
//
//              
//                tId.setText(sur.getId_surat());
//                tdJudul.setText(sur.getJudul());
//                tdPerihal.setText(sur.getPerihal());
//                tdNoSurat.setText(sur.getNo_surat());
//                tdAsalSurat.setText(sur.getAsal_surat());
//                tdTujuan.setText(sur.getTujuan());
//
//           
//                SimpleDateFormat displayFormat = new SimpleDateFormat("yy-MM-dd");
//                String formattedTanggalDiterima = displayFormat.format(sur.getTanggal_diterima());
//                tdTanggalDIterima.setText(formattedTanggalDiterima);
//
//                tdJenisSurat.setText(sur.getJenis_surat());
//                tdKeterangan.setText(sur.getKeterangan());
//                tdFile.setText(sur.getFile_data());
//            }
//        } catch (SQLException sQLException) {
//            sQLException.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace(); 
//        }
//


    }//GEN-LAST:event_tb_SuratMasukMousePressed

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        PopUpSuratMasuk sk = new PopUpSuratMasuk();
        sk.setVisible(true);
        sk.bEdit.setVisible(false);
        sk.otoID();
    }//GEN-LAST:event_bTambahActionPerformed

    private void tb_SuratMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_SuratMasukMouseClicked
        PopUpSuratMasuk suratMasukFrame = new PopUpSuratMasuk();
        suratMasukFrame.setVisible(true);

        suratMasukFrame.bTambah.setVisible(false);
        suratMasukFrame.setLocationRelativeTo(null);

        suratMasukFrame.ambilDetail();

        try {
            SuratMasuk sur = new SuratMasuk();

            int baris = tb_SuratMasuk.getSelectedRow();

            sur.setId_surat(tb_SuratMasuk.getValueAt(baris, 0).toString());
            sur.setKategori(tb_SuratMasuk.getValueAt(baris, 1).toString());
            sur.setBagian(tb_SuratMasuk.getValueAt(baris, 2).toString());
            sur.setAsal_surat(tb_SuratMasuk.getValueAt(baris, 3).toString());
            sur.setPerihal(tb_SuratMasuk.getValueAt(baris, 4).toString());

            String tanggalDiterimaStr = tb_SuratMasuk.getValueAt(baris, 5).toString();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");

            try {
                Date tanggalDiterima = dateFormat.parse(tanggalDiterimaStr);
                sur.setTanggal_diterima(new java.sql.Date(tanggalDiterima.getTime()));
            } catch (Exception e) {
                e.printStackTrace();
            }

            sur.setFile_data(tb_SuratMasuk.getValueAt(baris, 6).toString());

            suratMasukFrame.ambilDetail();

        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tb_SuratMasukMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bTambah;
    public javax.swing.JComboBox<String> cb_BagianMenu;
    public javax.swing.JComboBox<String> cb_KategoriMenu;
    public javax.swing.JButton jButton1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JPanel pn1;
    public static javax.swing.JPanel pnMain;
    public javax.swing.JTable tb_SuratMasuk;
    public com.toedter.calendar.JDateChooser tf_TglMenu;
    // End of variables declaration//GEN-END:variables
}
