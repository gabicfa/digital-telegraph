package br.edu.insper.whatsmorse;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    @Test
    public void charIsE() {
        SelectedCharacter selectedCharacter = new SelectedCharacter();
        selectedCharacter.setValues(false, null);
        char letra = selectedCharacter.getValue();

        assertEquals(letra, 'e');
    }

    @Test
    public void charIsN() {
        SelectedCharacter selectedCharacter = new SelectedCharacter();
        selectedCharacter.setValues(true, false, null);
        char letra = selectedCharacter.getValue();

        assertEquals(letra, 'n');
    }

    @Test
    public void charIsR() {
        SelectedCharacter selectedCharacter = new SelectedCharacter();
        selectedCharacter.setValues(false, true, false, null);
        char letra = selectedCharacter.getValue();

        assertEquals(letra, 'r');
    }

    @Test
    public void charIsH() {
        SelectedCharacter selectedCharacter = new SelectedCharacter();
        selectedCharacter.setValues(false, false, false, false, null);
        char letra = selectedCharacter.getValue();

        assertEquals(letra, 'r');
    }

    @Test
    public void charIs9() {
        SelectedCharacter selectedCharacter = new SelectedCharacter();
        selectedCharacter.setValues(true, true, true, true, false, null);
        char letra = selectedCharacter.getValue();

        assertEquals(letra, '9');
    }

//    @Test
//    public void addition_isCorrect() throws Exception {
//        assertEquals(4, 2 + 2);
//    }
}