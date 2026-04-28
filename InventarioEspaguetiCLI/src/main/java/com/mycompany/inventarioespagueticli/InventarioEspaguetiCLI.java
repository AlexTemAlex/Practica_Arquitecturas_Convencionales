package com.mycompany.inventarioespagueticli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InventarioEspaguetiCLI {
    
    public static class Product {
        String name;
        int quantity;
        double price;
        String category;
        String supplier;

        public Product(String name, int quantity, double price, String category, String supplier) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
            this.category = category;
            this.supplier = supplier;
        }

        @Override
        public String toString() {
            return "Producto{" + "name=" + name + ", quantity=" + quantity + ", price=" + price + ", category=" + category + ", supplier=" + supplier + '}';
        }
        
    }
    
    static Scanner sc = new Scanner(System.in);
    static List<Product> inventory = new ArrayList<>();

    static {
        inventory.add(new Product("Arroz", 10, 2.5, "Granos", "Proveedor1"));
        inventory.add(new Product("Fideos", 20, 1.8, "Pastas", "Proveedor2"));
        inventory.add(new Product("Azúcar", 15, 1.2, "Endulzantes", "Proveedor3"));
    }
    
    static double cash = 0; 
    static int totalSales = 0;

    public static void main(String[] args) {
        
        int option = 0;
        
        while (true) {            
            System.out.println("\n=== INVENTARIO ULTRA SPAGHETTI ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Vender producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Buscar producto");
            System.out.println("6. Actualizar precio");
            System.out.println("7. Reporte inventario");
            System.out.println("8. Caja");
            System.out.println("9. Reabastecer");
            System.out.println("10. Reporte por categoría");
            System.out.println("11. Salir");
            
            System.out.println("Ingrese una opcion: ");
            option = sc.nextInt();
            sc.nextLine();
            
            switch (option) {
                case 1:
                    System.out.println("Nombre: ");
                    String name = sc.nextLine();

                    System.out.print("Cantidad: ");
                    int quantity = sc.nextInt();

                    System.out.print("Precio: ");
                    double price = sc.nextDouble();

                    System.out.print("Categoría: ");
                    String category = sc.nextLine();
                    sc.nextLine();
                    
                    System.out.print("Proveedor: ");
                    String supplier = sc.nextLine();
                    
                    inventory.add(new Product(name, quantity, price, category, supplier));

                    System.out.println("Producto agregado con exito");
                    break;
                case 2:
                    for (int i = 0; i < inventory.size(); i++) {
                        System.out.println(i + " -> " + inventory.get(i));
                    }
                    break;
                case 3:
                    System.out.print("Índice: ");
                    int idx_select = sc.nextInt();
                    
                    if (idx_select >= 0 && idx_select < inventory.size()) {
                        Product prod = inventory.get(idx_select);
                        
                        System.out.println("Producto seleccionado: " + prod.name);
                        System.out.println("Categoría: " + prod.category);
                        System.out.println("Precio: $" + prod.price);
                        System.out.println("Stock actual: " + prod.quantity);
                        
                        System.out.print("Cantidad a vender: ");
                        int cant = sc.nextInt();
                        
                        if (prod.quantity >= cant) {
                            double total = cant * prod.price;
                            
                            //discounts by category and quantity
                            switch (prod.category.toLowerCase()) {
                                case "granos" -> total *= 0.95;
                                case "pastas" -> total *= 0.90;
                            }
                            
                            if (cant > 10) total *= 0.85;
                            
                            prod.quantity -= cant;
                            cash += total;
                            totalSales++;
                            
                            System.out.println("Venta realizada: $" + total);
                            System.out.println("Producto: " + prod.name);
                            System.out.println("Stock restante: " + prod.quantity);
                            break;
                        } else {
                            System.out.println("Stock insuficiente");
                            break;
                        }
                    } else {
                        System.out.println("Producto no existe");
                        break;
                    }
                case 4:
                    System.out.print("Índice a eliminar: ");
                    int idx_del = sc.nextInt();
                    
                    if (idx_del >= 0 && idx_del < inventory.size()) {
                        Product prod = inventory.get(idx_del);
                        
                        System.out.println("Producto seleccionado: " + prod.name);
                        System.out.println("Categoría: " + prod.category);
                        System.out.println("Precio: $" + prod.price);
                        System.out.println("Stock actual: " + prod.quantity);
                        
                        inventory.remove(idx_del);
                        System.out.println("Eliminado");
                        break;

                    } else {
                        System.out.println("No existe");
                        break;
                    }
                case 5:
                    sc.nextLine();
                    System.out.print("Buscar nombre: ");
                    String searchedName = sc.nextLine();

                    boolean found = false;
                    
                    for (Product pr : inventory) {
                        if (pr.name.toLowerCase().contains(searchedName.toLowerCase())) {
                                System.out.println("Encontrado: " + pr);
                                found = true;
                        }
                    }
                    
                    if (!found) System.out.println("No encontrado");
                    break;
                case 6:
                    System.out.print("Índice: ");
                    int idx_update = sc.nextInt();

                    if (idx_update >= 0 && idx_update < inventory.size()) {
                        Product prod = inventory.get(idx_update);
                        
                        System.out.println("Producto seleccionado: " + prod.name);
                        System.out.println("Categoría: " + prod.category);
                        System.out.println("Precio: $" + prod.price);
                        System.out.println("Stock actual: " + prod.quantity);
                        
                        System.out.print("Nuevo precio: ");
                        double newPrice = sc.nextDouble();
                        
                        if (newPrice>0) {
                            prod.price = newPrice;
                            System.out.println("Precio actualizado");
                        }else{
                            System.out.println("Precio inválido");
                        }
                        
                        break;

                    } else {
                        System.out.println("No existe");
                        break;
                    }
                case 7:
                    double totalInv = 0;

                    for (Product pr : inventory) {
                        totalInv += pr.quantity * pr.price;
                    }

                    System.out.println("Total inventario: " + totalInv);
                    System.out.println(totalInv > 100 ? "Inventario alto" : "Inventario bajo");
                    break;
                case 8:
                    System.out.println("Caja: $" + cash);
                    System.out.println("Ventas: " + totalSales);
                    break;
                case 9:
                    System.out.print("Índice: ");
                    int idx_restock = sc.nextInt();

                    if (idx_restock >= 0 && idx_restock < inventory.size()) {
                        Product prod = inventory.get(idx_restock);

                        System.out.println("Producto seleccionado: " + prod.name);
                        System.out.println("Categoría: " + prod.category);
                        System.out.println("Precio: $" + prod.price);
                        System.out.println("Stock actual: " + prod.quantity);
                        
                        System.out.print("Cantidad a agregar: ");
                        int add = sc.nextInt();
                        
                        prod.quantity += add;
                        
                        System.out.println("Reabastecido");
                    } else {
                        System.out.println("No existe");
                    }
                    break;
                case 10:
                    Map<String, Integer> map = new HashMap<>();

                    for (Product pr : inventory) {
                        map.put(pr.category, map.getOrDefault(pr.category, 0) + pr.quantity);
                    }

                    for (String key : map.keySet()) {
                        System.out.println(key + " -> " + map.get(key));
                    }
                    break;
                case 11:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;                        
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}
