/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BancoTipos;

/**
 *
 * @author divah_000
 */
public interface Usuario {

    public void login();
}

public interface prestamoBasico {

    public void pedirPestamo();

    public void calcularPrestamo();
}

public interface manipularEmpleados {

    public void crearEmpleado();

    public void eliminarEmpleado();

}

public interface validar {

    public void validarPrestamo();
}

public class Gerente implements Usuario, prestamoBasico, manipularEmpleados, validar {

    public Gerente() {

    }

    @Override
    public void validarPrestamo() {
        //...Creando prestamo
    }

    @Override

    public void crearEmpleado() {
        //...Creando empleado
    }

    @Override

    public void calcularPrestamo() {
        //...calcularPrestamo
    }

    @Override

    public void pedirPrestamo() {
        //...pedirPrestamo
    }

    @Override

    public void eliminarEmpleado() {

    }

}

public class Empleado implements Usuario, prestamoBasico, validar {

    public Empleado() {
    }

    @Override

    public void validarPrestamo() {
        //...Creando prestamo
    }

    @Override

    public void crearEmpleato() {
        throw new Error("Un empleado no puede validar prestamos");

    }

    @Override

    public void calcularPrestamo() {
        //...calcularPrestamo
    }

    @Override

    public void pedirPrestamo() {
        //...pedirPrestamo
    }
}

public class Cliente implements Usuario, PrestamoBasico {

    public Cliente() {

    }

    @Override

    public void pedirPrestamo() {
        //...pedirPrestamo
    }

    @Override

    public void calcularPrestamo() {
        //...calcularPrestamo
    }
}
