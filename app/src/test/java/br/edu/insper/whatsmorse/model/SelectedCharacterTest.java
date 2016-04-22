package br.edu.insper.whatsmorse.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pedro Cunial on 4/18/16.
 */
public class SelectedCharacterTest {

    @Test
    public void charIsE() {
        boolean[] instruction = {false};
        SelectedCharacter selectedChar = new SelectedCharacter();
        selectedChar.setNode(instruction);
        char letra = selectedChar.getValue();

        assertEquals(letra, 'e');
    }

    @Test
    public void charIsN() {
        boolean[] instruction = {true, false};
        SelectedCharacter selectedChar = new SelectedCharacter();
        selectedChar.setNode(instruction);
        char letra = selectedChar.getValue();

        assertEquals(letra, 'n');
    }

    @Test
    public void charIsR() {
        boolean[] instruction = {false, true, false};
        SelectedCharacter selectedChar = new SelectedCharacter();
        selectedChar.setNode(instruction);
        char letra = selectedChar.getValue();

        assertEquals(letra, 'r');
    }

    @Test
    public void charIsH() {
        boolean[] instruction = {false, false, false, false};
        SelectedCharacter selectedChar = new SelectedCharacter();
        selectedChar.setNode(instruction);
        char letra = selectedChar.getValue();

        assertEquals(letra, 'h');
    }

    @Test
    public void charIs9() {
        boolean[] instruction = {true, true, true, true, false};
        SelectedCharacter selectedChar = new SelectedCharacter();
        selectedChar.setNode(instruction);
        char letra = selectedChar.getValue();

        assertEquals(letra, '9');
    }



}
