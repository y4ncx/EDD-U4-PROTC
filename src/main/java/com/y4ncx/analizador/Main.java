package com.y4ncx.analizador;

import com.y4ncx.analizador.AnalizadorNumeros;

public class Main {
    public static void main(String[] args) {
        AnalizadorNumeros analizador = new AnalizadorNumeros();

        // Ruta del archivo de números (ajústala según tu carpeta)
        String ruta = "src/main/resources/numeros.txt";

        // 1️⃣ Cargar datos
        analizador.cargarArchivo(ruta);

        // 2️⃣ Mostrar los números leídos
        analizador.mostrarNumeros();

        // 3️⃣ Mostrar resultados del análisis
        System.out.println("\n📊 Resultados del análisis:");
        System.out.println("Número mayor: " + analizador.obtenerMaximo());
        System.out.println("Número menor: " + analizador.obtenerMinimo());
        System.out.println("Promedio: " + analizador.obtenerPromedio());
    }
}
