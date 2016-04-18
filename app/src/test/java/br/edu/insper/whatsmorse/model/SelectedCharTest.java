package br.edu.insper.whatsmorse.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pedro Cunial on 4/18/16.
 */
public class SelectedCharTest {

    @Test
    public void charIsE() {
        Node Node = new Node();
        Node.setValues(false, null);
        char letra = Node.getValue();

        assertEquals(letra, 'e');
    }

    @Test
    public void charIsN() {
        Node Node = new Node();
        Node.setValues(true, false, null);
        char letra = Node.getValue();

        assertEquals(letra, 'n');
    }

    @Test
    public void charIsR() {
        Node Node = new Node();
        Node.setValues(false, true, false, null);
        char letra = Node.getValue();

        assertEquals(letra, 'r');
    }

    @Test
    public void charIsH() {
        Node Node = new Node();
        Node.setValues(false, false, false, false, null);
        char letra = Node.getValue();

        assertEquals(letra, 'r');
    }

    @Test
    public void charIs9() {
        Node Node = new Node();
        Node.setValues(true, true, true, true, false, null);
        char letra = Node.getValue();

        assertEquals(letra, '9');
    }



}
