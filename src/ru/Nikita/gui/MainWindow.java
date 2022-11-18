package ru.Nikita.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame
{
    private Dimension minSize = new Dimension(600,400);
    private JButton btn1;
    private JTextField tf1;
    private JLabel lbl1;
    private GroupLayout gl; // раскладка
    public MainWindow()
    {
        setSize(minSize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        gl = new GroupLayout(getContentPane()); // Наше окно без рамок
        setLayout(gl);
        btn1 = new JButton();
        btn1.setText("Touche me");

//        btn1.addActionListener(new ActionListener() { // Событие которые отобржает на панельке
//            @Override
        setMinimumSize(minSize);
//            public void actionPerformed(ActionEvent e) {
//                lbl1.setText(tf1.getText());
//            }
//        });
        btn1.addActionListener(e -> lbl1.setText(tf1.getText()));


        tf1 = new JTextField(); // Создание "Ввода текста"
        lbl1 = new JLabel(); // Создание лейбла
        lbl1.setText("Здесь будет другой текст");
        gl.setHorizontalGroup(gl.createSequentialGroup()
                        .addGap(8)
                        .addGroup(gl.createParallelGroup()
                                .addComponent(tf1,250,250,GroupLayout.DEFAULT_SIZE)
                                .addGroup(gl.createSequentialGroup()
                                        .addGap(8,8,Integer.MAX_VALUE)
                                        .addComponent(btn1,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE)
                                        .addGap(8,8,Integer.MAX_VALUE)
                                )
                                .addComponent(lbl1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE))
                        .addGap(8)
        );
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(8)
                .addComponent(tf1,25,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE)
                .addGap(8,8,Integer.MAX_VALUE)
                .addComponent(btn1,25,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE)
                .addGap(8,8,Integer.MAX_VALUE)
                .addComponent(lbl1,25,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE)
                .addGap(8)
        );

    }

}
