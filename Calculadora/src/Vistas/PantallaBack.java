package Vistas;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Usuario
 */
public class PantallaBack extends JFrame {

    public PantallaBack() {
        super();
        inicializar();
    }

    private void inicializar() {

        this.setSize(250, 335);
        this.setTitle("Calculadora");
        this.setLayout(null);
        int tamano = 50;
        JButton[] botonesNumeros = new JButton[10];
        JButton[] operadores = new JButton[6];
        JButton controlMas = new JButton("+");
        Color background = new Color(150, 150, 150);
        this.getContentPane().setBackground(background);
        controlMas.setBounds(180, 60, tamano, tamano);
        this.add(controlMas);
        JButton controlMenos = new JButton("-");
        controlMenos.setBounds(180, 120, tamano, tamano);
        this.add(controlMenos);
        JButton controlMultiplicar = new JButton("*");
        controlMultiplicar.setBounds(180, 180, tamano, tamano);
        this.add(controlMultiplicar);
        JButton controlDividir = new JButton("/");
        controlDividir.setBounds(180, 240, tamano, tamano);
        this.add(controlDividir);
        JButton controlIgual = new JButton("=");
        controlIgual.setBounds(120, 240, tamano, tamano);
        this.add(controlIgual);
        
        JButton controlPunto = new JButton(".");
        controlPunto.setBounds(0, 240, tamano, tamano);
        this.add(controlPunto);
        //100231200;
        //-100474560;
        JTextField resultado = new JTextField();
        resultado.setBounds(0, 0, 230, 50);
        this.add(resultado);
        int x = 0, y = 60;
        //Este crea los numeros
        for (int i = 0; i < botonesNumeros.length; i++) {
            
            if (i == 0) {
                botonesNumeros[i] = new JButton(Integer.toString(i));
                botonesNumeros[i].setBackground(background);
                botonesNumeros[i].setBounds(tamano + 10, tamano * 3 + 90, tamano, tamano);
                this.add(botonesNumeros[i]);

            } else {
                botonesNumeros[i] = new JButton(Integer.toString(i));
                botonesNumeros[i].setBounds(x, y, tamano, tamano);
                x += 10 + tamano;
                this.add(botonesNumeros[i]);
                if ((float) i % 3 == 0) {
                    x = 0;
                    y += tamano + 10;
                }
            }

        }
        //Esto crea los operadores
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
