import java.time.LocalDate;
import java.util.Scanner;

public class Orden {

    private int numero;
    private LocalDate fecha;
    private String encargado;
    private Producto productos[];
    private static final int maxProductos = 5;
    private static int cantProductos;

    public Orden() {
    }

    public Orden(String encargado, int numero) {
        this.encargado = encargado;
        this.numero = numero;
        this.fecha = LocalDate.now();
        productos = new Producto [maxProductos];
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    Scanner scanner = new Scanner(System.in);

    public Producto agregarProducto(){
        System.out.println("Agregue el nombre de su producto: ");
        String nombreProducto = scanner.nextLine();

        System.out.println("Agregue el precio del mismo: ");
        double precioProducto = scanner.nextDouble();
        scanner.nextLine();

        Producto producto = new Producto(nombreProducto,precioProducto);
        return producto;

    }

    public boolean agregarProducto(Producto producto){
        if(cantProductos < maxProductos){
            productos[cantProductos++] = producto;

        } else {
            System.out.println("Ha alcanzado el máximo de productos");
            return false;
        }
        return true;
    }

    public double calculoTotal(){
        double total = 0;
        for (int i = 0; i < cantProductos; i++){
            total += productos[i].getPrecio();
        }
        return total;
    }


    public void verOrden(){
        System.out.println("Fecha: " + getFecha());
        System.out.println("Número de orden: " + getNumero());
        System.out.println("Encargado: " + getEncargado());
        System.out.println("Total: $" + calculoTotal());
        System.out.println("Productos: ");
        for (int i = 0; i < cantProductos; i++) {
            System.out.println(productos[i]);
        }
        System.out.println("Cantidad de productos: " + cantProductos);
    }
}
