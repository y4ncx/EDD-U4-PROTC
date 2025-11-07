package com.y4ncx.analizador.estructuras.arboles;

// Nodo genérico para el árbol binario
public class TreeNode<T extends Comparable<T>> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
