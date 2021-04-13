import java.util.Scanner;

public class DatosUsuario {

    Scanner scanner = new Scanner(System.in);

    public String pedirNombre(){

        System.out.println("Ingrese su nombre: ");
        String encargado = scanner.nextLine();

        return encargado;
    }

    public int pedirOrden(){

        System.out.println("Ingrese número de orden: ");
        int numeroOrden = scanner.nextInt();
        return numeroOrden;
    }

    public char continuarCargaProducto(){
        System.out.println("Desea agregar otro producto? (y/n)");
        char proximoProducto = scanner.next().charAt(0);
        scanner.nextLine();

        return proximoProducto;
    }

    public char continuarCargaOrden(){
        System.out.println("Desea agregar otra orden? (y/n)");
        char continuar = scanner.next().charAt(0);
        return continuar;
    }

}
