package br.edu.insper.whatsmorse.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pedro Cunial on 4/18/16.
 */
public class SelectedCharTest {

    @Test
    public void charIsE() {
        SelectedChar selectedChar = new SelectedChar();
        selectedChar.setValues(false, null);
        char letra = selectedChar.getValue();

        assertEquals(letra, 'e');
    }

    @Test
    public void charIsN() {
        SelectedChar selectedChar = new SelectedChar();
        selectedChar.setValues(true, false, null);
        char letra = selectedChar.getValue();

        assertEquals(letra, 'n');
    }

    @Test
    public void charIsR() {
        SelectedChar selectedChar = new SelectedChar();
        selectedChar.setValues(false, true, false, null);
        char letra = selectedChar.getValue();

        assertEquals(letra, 'r');
    }

    @Test
    public void charIsH() {
        SelectedChar selectedChar = new SelectedChar();
        selectedChar.setValues(false, false, false, false, null);
        char letra = selectedChar.getValue();

        assertEquals(letra, 'r');
    }

    @Test
    public void charIs9() {
        SelectedChar selectedChar = new SelectedChar();
        selectedChar.setValues(true, true, true, true, false, null);
        char letra = selectedChar.getValue();

        assertEquals(letra, '9');
    }



}
