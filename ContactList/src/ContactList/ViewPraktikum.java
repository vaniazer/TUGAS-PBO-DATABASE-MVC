package ContactList;

import javax.swing.*;

public class ViewPraktikum extends JFrame {
    JLabel judul = new JLabel("CONTACT LIST");

    JButton btnInput = new JButton("Tambah Kontak");
    JButton btnLihat = new JButton("Lihat Kontak");

    public ViewPraktikum(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setResizable(true);
        setLocationRelativeTo(null);
        setSize(400, 400);

        add(judul);
        judul.setBounds(150, 30, 100, 30);
        add(btnInput);
        btnInput.setBounds(110,100,150,50);
        add(btnLihat);
        btnLihat.setBounds(110,200,150,50);

    }
}
