package br.edu.insper.whatsmorse.model;


/**
 * Created by Pedro Cunial on 4/18/16.
 */
public class NodeFactory {
    private static final int NUM_NODES = 39;

    public NodeFactory() {
        Node[] nodes = new Node[NUM_NODES];
        for (int i = 0; i < NUM_NODES; i++) {
            nodes[i] = new Node();
        }

        // Constroi a árvore
        nodes[0].setLetra(' ');
        nodes[0].setLeft(nodes[1]);
        nodes[0].setRight(nodes[2]);
        nodes[1].setLetra('e');
        nodes[1].setLeft(nodes[3]);
        nodes[1].setRight(nodes[4]);
        nodes[2].setLetra('t');
        nodes[2].setLeft(nodes[5]);
        nodes[2].setRight(nodes[6]);
        nodes[3].setLetra('i');
        nodes[3].setLeft(nodes[7]);
        nodes[3].setRight(nodes[8]);
        nodes[4].setLetra('a');
        nodes[4].setLeft(nodes[9]);
        nodes[4].setRight(nodes[10]);
        nodes[5].setLetra('n');
        nodes[5].setLeft(nodes[11]);
        nodes[5].setRight(nodes[12]);
        nodes[6].setLetra('m');
        nodes[6].setLeft(nodes[13]);
        nodes[6].setRight(nodes[14]);
        nodes[7].setLetra('s');
        nodes[7].setLeft(nodes[15]);
        nodes[7].setRight(nodes[16]);
        nodes[8].setLetra('u');
        nodes[8].setLeft(nodes[17]);
        nodes[8].setRight(nodes[18]); // espaço vazio
        nodes[9].setLetra('r');
        nodes[9].setLeft(nodes[19]);
        nodes[10].setLetra('w');
        nodes[10].setLeft(nodes[20]);
        nodes[10].setRight(nodes[21]);
        nodes[11].setLetra('d');
        nodes[11].setLeft(nodes[22]);
        nodes[11].setRight(nodes[23]);
        nodes[12].setLetra('k');
        nodes[12].setLeft(nodes[24]);
        nodes[12].setRight(nodes[25]);
        nodes[13].setLetra('g');
        nodes[13].setLeft(nodes[26]);
        nodes[13].setRight(nodes[27]);
        nodes[14].setLetra('o');
        nodes[14].setLeft(nodes[28]);
        nodes[14].setRight(nodes[29]);
        nodes[15].setLetra('h');
        nodes[15].setLeft(nodes[30]);
        nodes[15].setRight(nodes[31]);
        nodes[16].setLetra('v');
        nodes[16].setRight(nodes[32]);
        nodes[17].setLetra('f');
        nodes[18].setRight(nodes[33]);
        nodes[19].setLetra('l');
        nodes[20].setLetra('p');
        nodes[21].setLetra('j');
        nodes[21].setRight(nodes[34]);
        nodes[22].setLetra('b');
        nodes[22].setLeft(nodes[35]);
        nodes[23].setLetra('x');
        nodes[24].setLetra('c');
        nodes[25].setLetra('y');
        nodes[26].setLetra('z');
        nodes[26].setLeft(nodes[36]);
        nodes[27].setLetra('q');
        nodes[28].setLeft(nodes[37]);
        nodes[29].setLeft(nodes[38]);
        nodes[29].setRight(nodes[39]);
        nodes[30].setLetra('5');
        nodes[31].setLetra('4');
        nodes[32].setLetra('3');
        nodes[33].setLetra('2');
        nodes[34].setLetra('1');
        nodes[35].setLetra('6');
        nodes[36].setLetra('7');
        nodes[37].setLetra('8');
        nodes[38].setLetra('9');
        nodes[39].setLetra('0');
    }
}
