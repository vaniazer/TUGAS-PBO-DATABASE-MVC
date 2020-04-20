package ContactList;

import javax.swing.*;

public class ViewEditPraktikum extends JFrame {
    JLabel judul = new JLabel("EDIT KONTAK");

    JLabel lNomor = new JLabel("Nomor");
    JTextField tfnomor = new JTextField();

    JLabel lNama = new JLabel("Nama");
    JTextField tfnama = new JTextField();

    JLabel lUmur = new JLabel("Umur");
    JTextField tfumur = new JTextField();

    JLabel lEmail = new JLabel("Email");
    JTextField tfemail = new JTextField();

    JButton btnSimpan = new JButton("Simpan");
    JButton btnKembali = new JButton("Kembali");

    public ViewEditPraktikum(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setResizable(true);
        setLocationRelativeTo(null);
        setSize(500, 500);

        add(judul);
        judul.setBounds(200, 40, 200, 30);
        add(lNomor);
        lNomor.setBounds(80, 100, 130, 20);
        add(tfnomor);
        tfnomor.setBounds(150, 100, 240, 30);
        add(lNama);
        lNama.setBounds(80, 145, 130, 20);
        add(tfnama);
        tfnama.setBounds(150, 145, 240, 30);
        add(lUmur);
        lUmur.setBounds(80, 190, 130, 20);
        add(tfumur);
        tfumur.setBounds(150, 190, 240, 30);
        add(lEmail);
        lEmail.setBounds(80, 235, 130, 20);
        add(tfemail);
        tfemail.setBounds(150, 235, 240, 30);

        add(btnSimpan);
        btnSimpan.setBounds(150, 350, 90, 40);

        add(btnKembali);
        btnKembali.setBounds(250, 350, 90, 40);


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
