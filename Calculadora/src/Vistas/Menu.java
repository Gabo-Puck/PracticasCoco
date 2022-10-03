/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author divah_000
 */
public class Menu extends JFrame {

    CalculadoraMetodoCompartido calculadoraMC;
    CalculadorMetodoIndependiente calculadoraMI;

    public Menu() {
        super();
        calculadoraMC = new CalculadoraMetodoCompartido();
        calculadoraMI = new CalculadorMetodoIndependiente();
        inicializar();
    }

    public void inicializar() {
        JButton buttonMC = new JButton("Métodos Compartidos");
        this.setTitle("Calculadoras");
        this.setSize(500, 500);
        this.setLayout(null);
        buttonMC.setBounds(10, 10, 200, 50);
        this.add(buttonMC);
        buttonMC.addActionListener((e) -> {
            if (!calculadoraMC.isVisible()) {
//                calculadoraMC = new CalculadoraMetodoCompartido();
                calculadoraMC.setVisible(true);
            }
        });

        JButton buttonA = new JButton("Métodos Independientes");
        buttonA.setBounds(10, 70, 200, 50);
        this.add(buttonA);
        buttonA.addActionListener((e) -> {
            if (!calculadoraMI.isVisible()) {
                calculadoraMI.setVisible(true);
            }
        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
