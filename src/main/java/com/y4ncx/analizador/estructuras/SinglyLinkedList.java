 package com.y4ncx.analizador.estructuras;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
            head = null;
            size = 0;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
        size++;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
                current.next = node;
            }

            size++;
        }
    }

    public T removeFirst() {
        if (isEmpty()) throw new IllegalStateException("Lista vacia");
        T value = head.data;
        head = head.next;
        size--;
        return value;
    }

    public T removeLast() {
        if (isEmpty()) throw new IllegalStateException("Lista vacía");
        if (head.next == null) {
            T value = head.data;
            head = null;
            size--;
            return value;
        }
        Node<T> current = head;
        while (current.next.next != null)
            current = current.next;
        T value = current.next.data;
        current.next = null;
        size--;
        return value;
    }


    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current.data;
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }
    public void clear() { head = null; size = 0; }

    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(value)) return true;
            current = current.next;
        }
        return false;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }


}
