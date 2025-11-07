package com.y4ncx.analizador.estructuras.arboles;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase que representa un Árbol Binario de Búsqueda (ABB).
 * Implementa inserción, búsqueda, eliminación y recorridos.
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    // 🧩 Insertar un valor
    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private TreeNode<T> insertRecursive(TreeNode<T> node, T value) {
        if (node == null) return new TreeNode<>(value);

        if (value.compareTo(node.value) < 0)
            node.left = insertRecursive(node.left, value);
        else if (value.compareTo(node.value) > 0)
            node.right = insertRecursive(node.right, value);

        return node;
    }

    // 🔍 Buscar un valor
    public boolean search(T value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(TreeNode<T> node, T value) {
        if (node == null) return false;
        if (value.compareTo(node.value) == 0) return true;
        return value.compareTo(node.value) < 0
                ? searchRecursive(node.left, value)
                : searchRecursive(node.right, value);
    }

    // ❌ Eliminar un valor (opcional)
    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    private TreeNode<T> deleteRecursive(TreeNode<T> node, T value) {
        if (node == null) return null;

        if (value.compareTo(node.value) < 0)
            node.left = deleteRecursive(node.left, value);
        else if (value.compareTo(node.value) > 0)
            node.right = deleteRecursive(node.right, value);
        else {
            // Nodo encontrado
            if (node.left == null && node.right == null)
                return null;
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;

            T minValue = findMin(node.right);
            node.value = minValue;
            node.right = deleteRecursive(node.right, minValue);
        }
        return node;
    }

    private T findMin(TreeNode<T> node) {
        return node.left == null ? node.value : findMin(node.left);
    }

    // 🔁 Recorridos
    public void inOrder() {
        System.out.print("InOrder: ");
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(TreeNode<T> node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.value + " ");
            inOrderRecursive(node.right);
        }
    }

    public void preOrder() {
        System.out.print("PreOrder: ");
        preOrderRecursive(root);
        System.out.println();
    }

    private void preOrderRecursive(TreeNode<T> node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }

    public void postOrder() {
        System.out.print("PostOrder: ");
        postOrderRecursive(root);
        System.out.println();
    }

    private void postOrderRecursive(TreeNode<T> node) {
        if (node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.print(node.value + " ");
        }
    }

    public void levelOrder() {
        System.out.print("LevelOrder: ");
        if (root == null) return;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }

    // 📏 Altura del árbol
    public int height() {
        return heightRecursive(root);
    }

    private int heightRecursive(TreeNode<T> node) {
        if (node == null) return 0;
        return 1 + Math.max(heightRecursive(node.left), heightRecursive(node.right));
    }

    // ⚖️ Verificar si está balanceado
    public boolean isBalanced() {
        return isBalancedRecursive(root);
    }

    private boolean isBalancedRecursive(TreeNode<T> node) {
        if (node == null) return true;
        int leftH = heightRecursive(node.left);
        int rightH = heightRecursive(node.right);

        if (Math.abs(leftH - rightH) > 1) return false;
        return isBalancedRecursive(node.left) && isBalancedRecursive(node.right);
    }
}
