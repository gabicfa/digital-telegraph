package br.edu.insper.whatsmorse.model;

/**
 * Created by Pedro Cunial on 4/18/16.
 */
public class SelectedCharacter {
    private Node node;
    private Node[] allNodes;
    private NodeFactory nodeFactory;

    public SelectedCharacter() {
        this.nodeFactory = new NodeFactory();
        this.allNodes = nodeFactory.getNodes();
        this.node = allNodes[0];

    }

    public void setNode(boolean[] instruction) {
        for(boolean inst : instruction) {
            if(inst) {
                this.node = this.node.getRight();
            } else if(! inst) {
                this.node = this.node.getLeft();
            } else {
                System.out.println("Erro");
            }
        }
    }

    public char getValue(){
        return this.node.getLetra();
    }

}
