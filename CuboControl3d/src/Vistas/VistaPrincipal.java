/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.awt.Graphics;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import Clases.Cubo;
import Clases.Matriz;
import java.awt.Container;
import javax.swing.GroupLayout;
import javax.swing.JButton;

/**
 *
 * @author divah_000
 */
public class VistaPrincipal extends JFrame {

    private Cubo cubo;
    private JButton btnMoverPosX = new JButton("Mover +X");
    private JButton btnMoverPosY = new JButton("Mover +Y");
    private JButton btnMoverPosZ = new JButton("Mover +Z");
    private JButton btnMoverNegX = new JButton("Mover -X");
    private JButton btnMoverNegY = new JButton("Mover -Y");
    private JButton btnMoverNegZ = new JButton("Mover -Z");
    private JButton btnRotarPosX = new JButton("Rotar +X");
    private JButton btnRotarPosY = new JButton("Rotar +Y");
    private JButton btnRotarPosZ = new JButton("Rotar +Z");
    private JButton btnRotarNegX = new JButton("Rotar -X");
    private JButton btnRotarNegY = new JButton("Rotar -Y");
    private JButton btnRotarNegZ = new JButton("Rotar -Z");
    private JButton btnEscalarPos = new JButton("Escalar +");
    private JButton btnEscalarNeg = new JButton("Escalar -");
    private Container drawArea = new Container();

    public VistaPrincipal() throws HeadlessException {
        super("Cubo 3d");
        init();
    }

    public void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1920, 600);
        Matriz[] matrices = new Matriz[16];
        cubo = new Cubo();
        System.out.println();

        btnMoverPosX.addActionListener((e) -> {
            cubo.moverPosX();
            repaint();
        });

        btnMoverPosY.addActionListener((e) -> {
            cubo.moverPosY();
            repaint();
        });
        btnMoverPosZ.addActionListener((e) -> {
            cubo.moverPosZ();
            repaint();
        });
        
        btnMoverNegX.addActionListener((e)->{
            cubo.moverNegX();
            repaint();
        });
        
        btnMoverNegY.addActionListener((e)->{
            cubo.moverNegY();
            repaint();
        });
        btnMoverNegZ.addActionListener((e)->{
            cubo.moverNegZ();
            repaint();
        });
        
        btnRotarPosX.addActionListener((e)->{
            cubo.rotarPosX();
            repaint();
        });
        
        btnRotarPosY.addActionListener((e)->{
            cubo.rotarPosY();
            repaint();
        });
        
        btnRotarPosZ.addActionListener((e)->{
            cubo.rotarPosZ();
            repaint();
        });
        

        GroupLayout orden = new GroupLayout(this.getContentPane());

        orden.setVerticalGroup(
                orden.createSequentialGroup()
                        .addGroup(
                                orden.createSequentialGroup().addGap(500)
                        ).addGroup(
                                orden.createParallelGroup()
                                        .addGroup(
                                                orden.createSequentialGroup().addGroup(
                                                        orden.createParallelGroup()
                                                                .addComponent(btnMoverPosX)
                                                                .addComponent(btnMoverPosY)
                                                ).addComponent(btnMoverPosZ)
                                        ).addGroup(
                                                orden.createSequentialGroup().addGroup(
                                                        orden.createParallelGroup()
                                                                .addComponent(btnMoverNegX)
                                                                .addComponent(btnMoverNegY)
                                                ).addComponent(btnMoverNegZ)
                                        ).addGroup(
                                                orden.createSequentialGroup().addGroup(
                                                        orden.createParallelGroup()
                                                                .addComponent(btnRotarPosX)
                                                                .addComponent(btnRotarPosY)
                                                ).addComponent(btnRotarPosZ)
                                        )
                        )
        );

        orden.setHorizontalGroup(
                orden.createParallelGroup()
                        .addGroup(
                                orden.createParallelGroup().addGap(500)
                        ).addGroup(
                                orden.createSequentialGroup().addGroup(
                                        orden.createParallelGroup().addGroup(
                                                orden.createSequentialGroup()
                                                        .addComponent(btnMoverPosX)
                                                        .addComponent(btnMoverPosY)
                                        ).addComponent(btnMoverPosZ)
                                ).addGroup(
                                        orden.createParallelGroup().addGroup(
                                                orden.createSequentialGroup()
                                                        .addComponent(btnMoverNegX)
                                                        .addComponent(btnMoverNegY)
                                        ).addComponent(btnMoverNegZ)
                                ).addGroup(
                                        orden.createParallelGroup().addGroup(
                                                orden.createSequentialGroup()
                                                        .addComponent(btnRotarPosX)
                                                        .addComponent(btnRotarPosY)
                                        ).addComponent(btnRotarPosZ)
                                )
                        )
        );

//        btnMoverPosX.setBounds(50, 50, 100, 100);
//        this.add(btnMoverPosX);
//        btnMoverPosY.setBounds(50, 70, 100, 100);
//        this.add(btnMoverPosY);
        setLayout(orden);
        this.pack();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        cubo.setG(g);
        cubo.dibujarCubo();

    }

}
