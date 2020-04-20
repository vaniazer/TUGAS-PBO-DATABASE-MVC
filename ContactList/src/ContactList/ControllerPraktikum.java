package ContactList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControllerPraktikum {
    ModelPraktikum modelPraktikum;
    ViewPraktikum viewPraktikum;
    ViewInputPraktikum viewInputPraktikum;
    ViewLihatPraktikum viewLihatPraktikum;
    ViewEditPraktikum viewEditPraktikum;
    String dataInput;
    int baris;
    int kolom;


    public ControllerPraktikum(ModelPraktikum modelpraktikum, ViewPraktikum viewpraktikum) {
        this.modelPraktikum = modelpraktikum;
        this.viewPraktikum = viewpraktikum;

        viewpraktikum.btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewInputPraktikum = new ViewInputPraktikum();
                viewPraktikum.dispose();

                viewInputPraktikum.btnSimpan.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nomor = viewInputPraktikum.getNomor();
                        String nama = viewInputPraktikum.getNama();
                        String umur = viewInputPraktikum.getUmur();
                        String email = viewInputPraktikum.getEmail();
                        modelpraktikum.insertData(nomor, nama, umur, email);

                        viewInputPraktikum.dispose();
                        MVC_Praktikum mvc= new MVC_Praktikum();
                    }

                });
                viewInputPraktikum.btnKembali.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewInputPraktikum.dispose();
                        MVC_Praktikum mvc = new MVC_Praktikum();
                    }

                });
            }
        });

        viewpraktikum.btnLihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewLihatPraktikum = new ViewLihatPraktikum();
                viewPraktikum.dispose();

                String dataMahasiswa[][] = modelpraktikum.readData();
                viewLihatPraktikum.tabel.setModel(new JTable(dataMahasiswa, viewLihatPraktikum.namaKolom).getModel());


                viewLihatPraktikum.tabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mousePressed(e);
                        int baris = viewLihatPraktikum.tabel.getSelectedRow();
                        int kolom = viewLihatPraktikum.tabel.getSelectedColumn();

                        String dataterpilih = viewLihatPraktikum.tabel.getValueAt(baris, 0).toString();

                        System.out.println(dataterpilih);

                        viewLihatPraktikum.btnHapus.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int input = JOptionPane.showConfirmDialog(null,
                                        "Apa anda ingin menghapus NOMOR " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                                if (input == 0) {
                                    modelpraktikum.deleteData(dataterpilih);
                                    String dataMahasiswa[][] = modelpraktikum.readData();
                                    viewLihatPraktikum.tabel.setModel(new JTable(dataMahasiswa, viewLihatPraktikum.namaKolom).getModel());
                                } else {
                                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                                }
                            }
                        });

                        viewLihatPraktikum.btnEdit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {

                                        String nomor1 = viewLihatPraktikum.tabel.getValueAt(baris, 0).toString();
                                        String nama1 = viewLihatPraktikum.tabel.getValueAt(baris, 1).toString();
                                        String umur1 = viewLihatPraktikum.tabel.getValueAt(baris, 2).toString();
                                        String email1 = viewLihatPraktikum.tabel.getValueAt(baris, 3).toString();


                                        ViewEditPraktikum viewEditPraktikum = new ViewEditPraktikum();
                                        viewLihatPraktikum.dispose();
                                        viewEditPraktikum.tfnomor.setText(nomor1);
                                        viewEditPraktikum.tfnama.setText(nama1);
                                        viewEditPraktikum.tfumur.setText(umur1);
                                        viewEditPraktikum.tfemail.setText(email1);
                                        viewEditPraktikum.btnSimpan.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                if (viewEditPraktikum.tfnomor != null) {
                                                    String nomor2 = viewEditPraktikum.getNomor();
                                                    String nama2 = viewEditPraktikum.getNama();
                                                    String umur2 = viewEditPraktikum.getUmur();
                                                    String email2 = viewEditPraktikum.getEmail();

                                                    modelPraktikum.updateData(nomor2,nama2,umur2,email2);

                                                    viewEditPraktikum.dispose();
                                                    MVC_Praktikum mvc = new MVC_Praktikum();
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Nomor Hp masih kosong");
                                                }
                                            }

                                        });
                                        viewEditPraktikum.btnKembali.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                viewEditPraktikum.dispose();
                                                MVC_Praktikum mvc= new MVC_Praktikum();
                                            }

                                        });
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "Data Gagal Diubah!",
                                            "Hasil", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        });
                    }
                });

                viewLihatPraktikum.btnBack.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewLihatPraktikum.dispose();
                        MVC_Praktikum mvc= new MVC_Praktikum();
                    }

                });
            }
        });



    }
}
