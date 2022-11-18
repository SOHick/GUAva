package ru.Nikita.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainNewWindow extends JFrame
{


        JSpinner spXMin;
        JSpinner spXMax;
        SpinnerNumberModel nmXMin;
        SpinnerNumberModel nmXMax;
        JLabel lblXMin;
        JLabel lblXMax;
        Dimension minSz = new Dimension(600, 450);
        JPanel colorPanel1;
        public MainNewWindow(){
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setMinimumSize(minSz);
            GroupLayout gl = new GroupLayout(getContentPane());
            setLayout(gl);
            lblXMin = new JLabel();
            lblXMin.setText("Xmin=");
            lblXMax = new JLabel();
            lblXMax.setText("Xmax=");
            nmXMin = new SpinnerNumberModel(-5.0, -100.0, 4.9, 0.1);
            nmXMax = new SpinnerNumberModel( 5.0, -4.9, 100.0, 0.1);
            spXMin = new JSpinner(nmXMin);
            spXMax = new JSpinner(nmXMax);
            spXMin.addChangeListener(e -> {
                nmXMax.setMinimum((Double)nmXMin.getNumber() + 2 * (Double)nmXMax.getStepSize());
            });
            spXMax.addChangeListener(e -> {
                nmXMin.setMaximum((Double)nmXMax.getNumber() - 2 * (Double)nmXMin.getStepSize());
            });
            colorPanel1 = new JPanel();
            colorPanel1.setBackground(Color.BLUE);
            colorPanel1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    var newColor =
                            JColorChooser.showDialog(
                                    MainNewWindow.this,
                                    "Выбор цвета графика",
                                    colorPanel1.getBackground()
                            );
                    if (newColor != null){
                        colorPanel1.setBackground(newColor);
                    }
                }
            });
            /////////
           // var brp = new CrtPainter();
           // GraphicsPanel2new mainPanel = new GraphicsPanel2new(brp);


            gl.setVerticalGroup(gl.createSequentialGroup()
                    .addGap(8)
                    .addGroup(gl.createParallelGroup()
                            .addComponent(lblXMin, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(spXMin, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblXMax, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(spXMax, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(8)
                    .addComponent(colorPanel1, 20, 20, 20)
                    .addGap(8)
            );
            gl.setHorizontalGroup(gl.createSequentialGroup()
                    .addGap(8)
                    .addGroup(
                            gl.createParallelGroup()
                                    .addGroup(gl.createSequentialGroup()
                                            .addComponent(lblXMin, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spXMin, 70, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGap(8)
                                            .addComponent(lblXMax, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spXMax, 70, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                    )
                                    .addComponent(colorPanel1, 20, 20, 20)
                    )
                    .addGap(8)
            );
        }

}
