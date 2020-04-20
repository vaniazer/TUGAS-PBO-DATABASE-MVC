package ContactList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewLihatPraktikum extends JFrame {
    JLabel judul = new JLabel("LIHAT KONTAK");
    JTextField tfnomor = new JTextField();
    JTextField tfnama = new JTextField();
    JTextField tfumur = new JTextField();
    JTextField tfemail = new JTextField();

    JButton btnHapus = new JButton("Hapus");
    JButton btnEdit = new JButton("Ubah");
    JButton btnBack= new JButton("Kembali");

    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Nomor","Nama","Umur","Email"};

    public ViewLihatPraktikum(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setResizable(true);
        setLocationRelativeTo(null);
        setSize(800, 350);

        add(scrollPane);
        scrollPane.setBounds(40, 5, 700, 250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(btnHapus);
        btnHapus.setBounds(210, 270, 90, 30);

        add(btnEdit);
        btnEdit.setBounds(350, 270, 90, 30);

        add(btnBack);
        btnBack.setBounds(490, 270, 90, 30);
    }
    public String getNomor() {
        return tfnomor.getText();
    }
    public String getNama() {
        return tfnama.getText();
    }
    public String getUmur() {
        return tfumur.getText();
    }
    public String getEmail() {
        return tfemail.getText();
    }
}
