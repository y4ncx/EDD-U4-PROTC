package com.y4ncx.analizador;

import com.y4ncx.analizador.estructuras.DoublyLinkedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnalizadorNumeros {

    private DoublyLinkedList<Integer> listaNumeros;

    public AnalizadorNumeros() {
        listaNumeros = new DoublyLinkedList<>();
    }

    // 📥 Cargar números desde un archivo de texto
    public void cargarArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty()) {
                    // divide la línea por espacios, así puede leer varios números en una misma línea
                    String[] partes = linea.split("\\s+");
                    for (String p : partes) {
                        try {
                            int numero = Integer.parseInt(p);
                            listaNumeros.addLast(numero); // usa tu lista doble
                        } catch (NumberFormatException e) {
                            System.out.println("⚠️ Valor no numérico ignorado: " + p);
                        }
                    }
                }
            }
            System.out.println("✅ Archivo cargado correctamente.");
        } catch (IOException e) {
            System.out.println("❌ Error al leer el archivo: " + e.getMessage());
        }
    }


    // 🔍 Mostrar todos los números almacenados
    public void mostrarNumeros() {
        System.out.println("\n📋 Números cargados:");
        listaNumeros.printList();
    }

    // 📈 Calcular el número mayor
    public int obtenerMaximo() {
        if (listaNumeros.isEmpty()) return Integer.MIN_VALUE;

        int max = listaNumeros.getFirst();
        for (int num : listaNumeros.toList()) {
            if (num > max) max = num;
        }
        return max;
    }

    // 📉 Calcular el número menor
    public int obtenerMinimo() {
        if (listaNumeros.isEmpty()) return Integer.MAX_VALUE;

        int min = listaNumeros.getFirst();
        for (int num : listaNumeros.toList()) {
            if (num < min) min = num;
        }
        return min;
    }

    // 📊 Calcular el promedio
    public double obtenerPromedio() {
        if (listaNumeros.isEmpty()) return 0;

        double suma = 0;
        int contador = 0;
        for (int num : listaNumeros.toList()) {
            suma += num;
            contador++;
        }
        return suma / contador;
    }
}
