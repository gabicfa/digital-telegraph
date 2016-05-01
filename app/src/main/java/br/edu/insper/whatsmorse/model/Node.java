package br.edu.insper.whatsmorse.model;

/**
 * Created by Pedro Cunial on 4/18/16.
 */

public class Node {
    private char letra;
    private Node left;
    private Node right;

    public Node() {
        this.left = null;
        this.right = null;
    }


    public char getLetra() {
        return this.letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

}

