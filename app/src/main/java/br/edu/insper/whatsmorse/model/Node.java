package br.edu.insper.whatsmorse.model;

/**
 * Created by Pedro Cunial on 4/18/16.
 */
public class Node {
    private char letra;
    private boolean[] subChars = [2]

    public Node(char letra) {
        this.letra = letra;
    }

    public void setSubChars(boolean firstChar, boolean secondChar) {
        this.subChars[0] = firstChar;
        this.subChars[1] = secondChar;
    }

    public char getLetra(boolean[] currentInput) {
        if(currentInput == null) {
            return this.letra;
        }

        boolean currentChar = currentInput[-1];

    }
}
