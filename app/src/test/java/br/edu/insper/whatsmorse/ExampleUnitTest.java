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

//    @Test
//    public void addition_isCorrect() throws Exception {
//        assertEquals(4, 2 + 2);
//    }
}