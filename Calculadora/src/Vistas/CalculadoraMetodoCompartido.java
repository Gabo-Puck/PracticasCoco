package Vistas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import Funcionalidad.Expression;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Usuario
 */
public class CalculadoraMetodoCompartido extends JFrame implements ActionListener {

    JTextField resultado;
    Expression expression;


    public CalculadoraMetodoCompartido() {
        super();
        inicializar();
    }

    //Evento click
    @Override
    public void actionPerformed(ActionEvent e) {
        String signos = "+-/*.";
        if (((JButton) e.getSource()).getText().equals(("-")) && resultado.getText().isEmpty()) {
            resultado.setText("-");
            return;
        }
        if (resultado.getText().length() >= 1) {
            char ultimoChar = resultado.getText().charAt((resultado.getText().length() - 1));
            int previo = signos.indexOf(ultimoChar);
            if (previo != -1 && signos.contains(((JButton) e.getSource()).getText())) {
                return;
            }
        }
        if (((JButton) e.getSource()).getText().equals(("="))) {
            try{
                
                expression = new Expression(resultado.getText(), new Integer[]{1}, new String[]{"A"});
            String res = expression.resolverExpresion();
            resultado.setText("");
            resultado.setText(res);
            return;
            }catch(Error err){
                resultado.setText(err.getMessage());
                return;
            }
            
        }

        String t = ((JButton) e.getSource()).getText();
        resultado.setText(resultado.getText() + t);

    }

    private void inicializar() {

        this.setSize(250, 335);
        this.setTitle("Compartidos");
        this.setLayout(null);
        int tamano = 50;
        JButton[] botonesNumeros = new JButton[10];
        JButton[] operadores = new JButton[6];
        JButton controlMas = new JButton("+");
        Color background = new Color(255, 0, 255);
        this.getContentPane().setBackground(new Color(200, 200, 200));
        controlMas.setBounds(180, 60, tamano, tamano);
        controlMas.addActionListener(this);
        this.add(controlMas);
        JButton controlMenos = new JButton("-");
        controlMenos.setBounds(180, 120, tamano, tamano);
        this.add(controlMenos);
        controlMenos.addActionListener(this);

        JButton controlMultiplicar = new JButton("*");
        controlMultiplicar.setBounds(180, 180, tamano, tamano);
        this.add(controlMultiplicar);
        controlMultiplicar.addActionListener(this);

        JButton controlDividir = new JButton("/");
        controlDividir.setBounds(180, 240, tamano, tamano);
        controlDividir.addActionListener(this);

        this.add(controlDividir);
        JButton controlIgual = new JButton("=");
        controlIgual.setBounds(120, 240, tamano, tamano);
        controlIgual.addActionListener(this);

        this.add(controlIgual);

        JButton controlPunto = new JButton(".");
        controlPunto.addActionListener(this);

        controlPunto.setBounds(0, 240, tamano, tamano);
        this.add(controlPunto);
        //100231200;
        //-100474560;
        resultado = new JTextField();
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
                botonesNumeros[i].addActionListener(this);

            } else {
                botonesNumeros[i] = new JButton(Integer.toString(i));
                botonesNumeros[i].addActionListener(this);
                botonesNumeros[i].setBounds(x, y, tamano, tamano);
                botonesNumeros[i].setBackground(background);
                x += 10 + tamano;
                this.add(botonesNumeros[i]);
                if ((float) i % 3 == 0) {
                    x = 0;
                    y += tamano + 10;
                }
            }

        }
        //Esto crea los operadores

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
}
