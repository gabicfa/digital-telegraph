package br.edu.insper.whatsmorse.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Pedro Cunial on 4/18/16.
 */
public class SelectedCharacterTest {

    @Test
    public void charIsE() {
        List<Boolean> instruction = new ArrayList<Boolean>();
        instruction.add(false);

        SelectedCharacter selectedChar = new SelectedCharacter();
        selectedChar.setNode(instruction);
        char letra = selectedChar.getValue();

        assertEquals(letra, 'e');
    }

    @Test
    public void charIsN() {
        List<Boolean> instruction = new ArrayList<Boolean>();
        instruction.add(true);
        instruction.add(false);

        SelectedCharacter selectedChar = new SelectedCharacter();
        selectedChar.setNode(instruction);
        char letra = selectedChar.getValue();

        assertEquals(letra, 'n');
    }

    @Test
    public void charIsR() {
        List<Boolean> instruction = new ArrayList<Boolean>();
        instruction.add(false);
        instruction.add(true);
        instruction.add(false);

        SelectedCharacter selectedChar = new SelectedCharacter();
        selectedChar.setNode(instruction);
        char letra = selectedChar.getValue();

        assertEquals(letra, 'r');
    }

    @Test
    public void charIsH() {
        List<Boolean> instruction = new ArrayList<Boolean>();
        instruction.add(false);
        instruction.add(false);
        instruction.add(false);
        instruction.add(false);

        SelectedCharacter selectedChar = new SelectedCharacter();
        selectedChar.setNode(instruction);
        char letra = selectedChar.getValue();

        assertEquals(letra, 'h');
    }

    @Test
    public void charIs9() {
        List<Boolean> instruction = new ArrayList<Boolean>();
        instruction.add(true);
        instruction.add(true);
        instruction.add(true);
        instruction.add(true);
        instruction.add(false);

        SelectedCharacter selectedChar = new SelectedCharacter();
        selectedChar.setNode(instruction);
        char letra = selectedChar.getValue();

        assertEquals(letra, '9');
    }


}
