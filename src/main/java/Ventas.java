import java.util.Scanner;

/*
* Sistema para la carga de ordenes de ventas pensado para local de ropa, pero puede ser utilizado para cualquier rubro.
* Se le pide al usuario cargar su nombre, el numero de la orden a crear y los productos de la misma. Una vez finalizada la carga
* se visualiza el detalle con el total de los precios, la cantidad de productos y otros datos.
*
* En la clase DatosUsuario tengo métodos de entrada los cuales retornan como String lo ingresado por el usuario. Queda por hacer la validación de
* las entradas.
*
* En la clase Orden hay métodos para agregar los productos y realizar la lógica del mismo
*
*
*
* */

public class Ventas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char continuar = 'y';
        char proximoProducto = 'y';


        DatosUsuario datosUsuario = new DatosUsuario();

        String encargado = datosUsuario.pedirNombre();


        while (continuar == 'y') {

            int numeroOrden = datosUsuario.pedirOrden();

            // Creamos un objeto Orden
            Orden orden = new Orden(encargado, numeroOrden);

            while (proximoProducto == 'y') {
                Producto nuevoProducto = orden.agregarProducto();

                //Agregamos los productos a la orden
               boolean maxProducto =  orden.agregarProducto(nuevoProducto);

                if(maxProducto){
                    proximoProducto = datosUsuario.continuarCargaProducto();
                } else {
                    proximoProducto = 'n';
                }

            }

            orden.verOrden();
            continuar = datosUsuario.continuarCargaOrden();

            if (continuar == 'n') {
                orden.verOrden();
                scanner.close();
            } else {
                proximoProducto = 'y';
                orden = null;
            }

        }

    }

}
