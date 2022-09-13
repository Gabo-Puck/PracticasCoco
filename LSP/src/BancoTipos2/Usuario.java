/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BancoTipos2;

/**
 *
 * @author Melkor
 */
public interface Usuario {

    public void validarPrestamo();

    public void crearEmpleado();

    public void calcularPrestamo();

    public void pedirPrestamo();
}

public class Gerente implements Usuario {

    public Gerente() {

    }

    @Override
    public void validarPrestamo() {
        //...Creando prestamo
    }

    public void crearEmpleato() {
        //...Creando emplado
    }

    public void calcularPrestamo() {
        //...calcularPrestamo
    }

    public void pedirPrestamo() {
        //...pedirPrestamo
    }

}

public class Empleado implements Usuario {

    public Empleado() {
    }

    public void validarPrestamo() {
        //...Creando prestamo
    }

    public void crearEmpleato() {
        throw new Error("Un empleado no puede validar prestamos");

    }

    public void calcularPrestamo() {
        //...calcularPrestamo
    }

    public void pedirPrestamo() {
        //...pedirPrestamo
    }
}

public class Cliente implements Usuario {

    public Cliente() {

    }

    public void pedirPrestamo() {
        //...pedirPrestamo
    }

    public void validarPrestamo() {
        throw new Error("Un cliente no puede validar prestamos");
    }

    public void crearEmpleato() {
        //...Creando emplado
        throw new Error("Un cliente no puede crear emplados");

    }

    public void calcularPrestamo() {
        throw new Error("Un cliente no puede validar prestamo");

        //...calcularPrestamo
    }
}