public class Tree {
    private class Node{
        public int value;
        public Node leftNode;
        public Node rightNode;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;
    public Tree (int value){
        root = new Node(value);
    }

    public void insert(int givenValue) {
    Node node =  new Node(givenValue);
        Node tempNode = root;
        while (true){
            if(tempNode.value > givenValue){
                if(tempNode.leftNode==null) {
                    tempNode.leftNode =node;
                    break;
                }
                tempNode = tempNode.leftNode;
            }
            else {
                if(tempNode.value < givenValue){
                    if(tempNode.rightNode==null) {
                        tempNode.rightNode = node;
                        break;
                    }
                    tempNode = tempNode.rightNode;
                }
            }
        }
    }

    public boolean find(int givenValue){
        Node tempNode = root;
        while (tempNode!=null) {
            if (tempNode.value==givenValue) return true;
            if(tempNode.value > givenValue){

                tempNode = tempNode.leftNode;
            }
            else {
                if(tempNode.value < givenValue){

                    tempNode = tempNode.rightNode;
                }
            }
        }
        return false;
    }
}
