package com.y4ncx.analizador.estructuras;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // 🧩 Verificar si está vacía
    public boolean isEmpty() {
        return head == null;
    }

    // ➕ Agregar al inicio
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // ➕ Agregar al final
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // ❌ Eliminar el último nodo
    public void removeLast() {
        if (isEmpty()) {
            System.out.println("⚠️ La lista está vacía, no hay nada que eliminar.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    // 🖨️ Imprimir desde el inicio hasta el final
    public void printForward() {
        if (isEmpty()) {
            System.out.println("(lista vacía)");
            return;
        }

        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" <-> ");
            current = current.next;
        }
        System.out.println();
    }

    // 🖨️ Imprimir desde el final hacia el inicio
    public void printBackward() {
        if (isEmpty()) {
            System.out.println("(lista vacía)");
            return;
        }

        Node<T> current = tail;
        while (current != null) {
            System.out.print(current.data);
            if (current.prev != null) System.out.print(" <-> ");
            current = current.prev;
        }
        System.out.println();
    }

    // 📜 Convertir a lista de Java (útil para iterar fácilmente)
    public List<T> toList() {
        List<T> lista = new ArrayList<>();
        Node<T> actual = head;
        while (actual != null) {
            lista.add(actual.data);
            actual = actual.next;
        }
        return lista;
    }

    // 📤 Obtener primer valor
    public T getFirst() {
        return isEmpty() ? null : head.data;
    }

    // 📏 Tamaño actual
    public int getSize() {
        return size;
    }

    // 🔁 Alias para compatibilidad con AnalizadorNumeros
    public void printList() {
        printForward();
    }
}
