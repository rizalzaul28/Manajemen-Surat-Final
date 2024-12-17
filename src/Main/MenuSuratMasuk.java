/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Main;

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

    }

    public void setModel(DefaultTableModel model) {
        tbSuratMasuk.setModel(model);
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

        tbSuratMasuk.setModel(model);
         tbSuratMasuk.getColumnModel().getColumn(0).setMinWidth(0);
        tbSuratMasuk.getColumnModel().getColumn(0).setMaxWidth(0);
        tbSuratMasuk.getColumnModel().getColumn(0).setWidth(0);


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        pn1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSuratMasuk = new javax.swing.JTable();
        bTambah = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        bDetail = new javax.swing.JButton();
        pnDetail = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bpn2Kembali = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        bOpen = new javax.swing.JButton();
        tId = new javax.swing.JLabel();
        tdJudul = new javax.swing.JLabel();
        tdPerihal = new javax.swing.JLabel();
        tdNoSurat = new javax.swing.JLabel();
        tdAsalSurat = new javax.swing.JLabel();
        tdTujuan = new javax.swing.JLabel();
        tdTanggalDIterima = new javax.swing.JLabel();
        tdJenisSurat = new javax.swing.JLabel();
        tdKeterangan = new javax.swing.JLabel();
        tdFile = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        bEdit = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        bHapus = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        pnMain.setBackground(new java.awt.Color(255, 255, 255));
        pnMain.setLayout(new java.awt.CardLayout());

        tbSuratMasuk.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSuratMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSuratMasukMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbSuratMasukMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbSuratMasuk);

        bTambah.setBackground(new java.awt.Color(0, 0, 255));
        bTambah.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        bTambah.setForeground(new java.awt.Color(255, 255, 255));
        bTambah.setText("Tambah Surat");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        jLabel10.setText("Divisi");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ITM", "SI", "PTI", "TI" }));

        jLabel11.setText("Cari");

        bDetail.setText("Detail");
        bDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDetailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn1Layout = new javax.swing.GroupLayout(pn1);
        pn1.setLayout(pn1Layout);
        pn1Layout.setHorizontalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1054, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bTambah)
                .addContainerGap())
            .addGroup(pn1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(338, 338, 338)
                .addComponent(bDetail)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn1Layout.setVerticalGroup(
            pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(bTambah)
                .addGap(14, 14, 14)
                .addGroup(pn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDetail))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnMain.add(pn1, "card7");

        jLabel1.setText("Id Surat");

        jLabel2.setText("Judul");

        jLabel3.setText("Perihal");

        jLabel4.setText("No.Surat");

        jLabel5.setText("Asal Surat");

        jLabel6.setText("Tujuan");

        jLabel7.setText("Tanggal Diterima");

        jLabel8.setText("Jenis Surat");

        jLabel9.setText("Keterangan");

        bpn2Kembali.setBackground(new java.awt.Color(204, 0, 0));
        bpn2Kembali.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        bpn2Kembali.setForeground(new java.awt.Color(255, 255, 255));
        bpn2Kembali.setText("Kembali");
        bpn2Kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpn2KembaliActionPerformed(evt);
            }
        });

        jLabel12.setText("File");

        bOpen.setText("Open File");
        bOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOpenActionPerformed(evt);
            }
        });

        tId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tId.setText("tID");

        tdJudul.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tdJudul.setText("jLabel13");

        tdPerihal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tdPerihal.setText("jLabel14");

        tdNoSurat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tdNoSurat.setText("jLabel15");

        tdAsalSurat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tdAsalSurat.setText("jLabel16");

        tdTujuan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tdTujuan.setText("jLabel17");

        tdTanggalDIterima.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tdTanggalDIterima.setText("jLabel18");

        tdJenisSurat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tdJenisSurat.setText("jLabel19");

        tdKeterangan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tdKeterangan.setText("jLabel20");

        tdFile.setText("jLabel13");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText(":");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText(":");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText(":");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText(":");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText(":");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText(":");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText(":");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText(":");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText(":");

        bEdit.setText("EDIT");
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText(":");

        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDetailLayout = new javax.swing.GroupLayout(pnDetail);
        pnDetail.setLayout(pnDetailLayout);
        pnDetailLayout.setHorizontalGroup(
            pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetailLayout.createSequentialGroup()
                        .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDetailLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21)))
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tdJudul)
                            .addComponent(tId)
                            .addComponent(tdPerihal)
                            .addComponent(tdNoSurat)
                            .addComponent(tdAsalSurat)
                            .addComponent(tdTujuan)
                            .addComponent(tdTanggalDIterima)
                            .addComponent(tdJenisSurat)
                            .addComponent(tdKeterangan)
                            .addComponent(bOpen)))
                    .addGroup(pnDetailLayout.createSequentialGroup()
                        .addComponent(bpn2Kembali)
                        .addGap(29, 29, 29)
                        .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnDetailLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tdFile))
                            .addComponent(bEdit))
                        .addGap(18, 18, 18)
                        .addComponent(bHapus)))
                .addContainerGap(788, Short.MAX_VALUE))
        );
        pnDetailLayout.setVerticalGroup(
            pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tId)
                    .addComponent(jLabel13))
                .addGap(9, 9, 9)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tdJudul)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tdPerihal)
                    .addComponent(jLabel16))
                .addGap(24, 24, 24)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tdNoSurat)
                    .addComponent(jLabel17))
                .addGap(28, 28, 28)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tdAsalSurat)
                    .addComponent(jLabel18))
                .addGap(26, 26, 26)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tdTujuan)
                    .addComponent(jLabel19))
                .addGap(29, 29, 29)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(tdTanggalDIterima))
                .addGap(26, 26, 26)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(tdJenisSurat)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(tdKeterangan)
                    .addComponent(jLabel22))
                .addGap(75, 75, 75)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel23))
                    .addComponent(tdFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bOpen)
                .addGap(32, 32, 32)
                .addGroup(pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bpn2Kembali)
                    .addComponent(bEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bHapus)))
        );

        pnMain.add(pnDetail, "card3");

        add(pnMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void tbSuratMasukMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSuratMasukMousePressed
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




    }//GEN-LAST:event_tbSuratMasukMousePressed

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        PopUpSuratMasuk sk = new PopUpSuratMasuk();
        sk.setVisible(true);
        sk.bEdit.setVisible(false);
        sk.otoID();
    }//GEN-LAST:event_bTambahActionPerformed

    private void bpn2KembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpn2KembaliActionPerformed
        pnMain.removeAll();
        pnMain.add(pn1);
        pnMain.repaint();
        pnMain.revalidate();
    }//GEN-LAST:event_bpn2KembaliActionPerformed

    private void bOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOpenActionPerformed
        try {
            String filePath = tdFile.getText().trim();
            File file = new File(filePath);

            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                JOptionPane.showMessageDialog(this, "File tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bOpenActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
       
        
       
          PopUpSuratMasuk suratMasukFrame = new PopUpSuratMasuk();
        suratMasukFrame.setVisible(true);
        
        suratMasukFrame.bTambah.setVisible(false);
        suratMasukFrame.setLocationRelativeTo(null);
        
        suratMasukFrame.ambilDetail();
        
        
        

    }//GEN-LAST:event_bEditActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
         try {
          SuratMasuk sur = new SuratMasuk();
            sur.setId_surat((tId.getText()));
            sur.hapusSurat();
        } catch (SQLException sQLException) {
        }
        
        
        
        MenuUtama.pn_Utama.removeAll();
        MenuUtama.pn_Utama.add(new MenuSuratMasuk());
        MenuUtama.pn_Utama.repaint();
        MenuUtama.pn_Utama.revalidate();
    }//GEN-LAST:event_bHapusActionPerformed

    private void tbSuratMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSuratMasukMouseClicked
     PopUpSuratMasuk suratMasukFrame = new PopUpSuratMasuk();
        suratMasukFrame.setVisible(true);
        
        suratMasukFrame.bTambah.setVisible(false);
        suratMasukFrame.setLocationRelativeTo(null);
        
        suratMasukFrame.ambilDetail();
        
        
        
        try {
            SuratMasuk sur = new SuratMasuk();

            
    

            int baris = tbSuratMasuk.getSelectedRow();
       
               
                sur.setId_surat(tbSuratMasuk.getValueAt(baris, 0).toString());
                sur.setKategori(tbSuratMasuk.getValueAt(baris, 1).toString());
                sur.setBagian(tbSuratMasuk.getValueAt(baris, 2).toString());
                sur.setAsal_surat(tbSuratMasuk.getValueAt(baris, 3).toString());
                sur.setPerihal(tbSuratMasuk.getValueAt(baris, 4).toString());

               
                String tanggalDiterimaStr = tbSuratMasuk.getValueAt(baris, 5).toString();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd"); 

                try {
                    Date tanggalDiterima = dateFormat.parse(tanggalDiterimaStr);
                    sur.setTanggal_diterima(new java.sql.Date(tanggalDiterima.getTime())); 
                } catch (Exception e) {
                    e.printStackTrace(); 
                }

             
  
                sur.setFile_data(tbSuratMasuk.getValueAt(baris, 6).toString());
               
              suratMasukFrame.ambilDetail();
              
           
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }//GEN-LAST:event_tbSuratMasukMouseClicked

    private void bDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDetailActionPerformed
      
    }//GEN-LAST:event_bDetailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bDetail;
    public javax.swing.JButton bEdit;
    public javax.swing.JButton bHapus;
    public javax.swing.JButton bOpen;
    public javax.swing.JButton bTambah;
    public javax.swing.JButton bpn2Kembali;
    public javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel18;
    public javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel20;
    public javax.swing.JLabel jLabel21;
    public javax.swing.JLabel jLabel22;
    public javax.swing.JLabel jLabel23;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextField jTextField9;
    public javax.swing.JPanel pn1;
    public static javax.swing.JPanel pnDetail;
    public static javax.swing.JPanel pnMain;
    public javax.swing.JLabel tId;
    public javax.swing.JTable tbSuratMasuk;
    public javax.swing.JLabel tdAsalSurat;
    public javax.swing.JLabel tdFile;
    public javax.swing.JLabel tdJenisSurat;
    public javax.swing.JLabel tdJudul;
    public javax.swing.JLabel tdKeterangan;
    public javax.swing.JLabel tdNoSurat;
    public javax.swing.JLabel tdPerihal;
    public javax.swing.JLabel tdTanggalDIterima;
    public javax.swing.JLabel tdTujuan;
    // End of variables declaration//GEN-END:variables
}
