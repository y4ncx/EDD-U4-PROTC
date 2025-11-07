package com.y4ncx.analizador.estructuras.arboles;

/**
 * Clase de prueba para el Árbol Binario de Búsqueda.
 * Aquí se insertan, buscan y eliminan valores para comprobar su funcionamiento.
 */
public class PruebaArbol {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        System.out.println("🌳 Creando el árbol binario de búsqueda...\n");

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Recorridos del árbol:");
        tree.inOrder();
        tree.preOrder();
        tree.postOrder();
        tree.levelOrder();

        System.out.println("\n🔍 Búsqueda:");
        System.out.println("¿Existe el 40? " + tree.search(40));
        System.out.println("¿Existe el 90? " + tree.search(90));

        System.out.println("\n📏 Altura del árbol: " + tree.height());
        System.out.println("⚖️ ¿Está balanceado?: " + tree.isBalanced());

        System.out.println("\n❌ Eliminando el valor 70...");
        tree.delete(70);
        tree.inOrder();
    }
}
