import java.util.ArrayList;

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

    public Node getRoot() {
        return root;
    }

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

    public void traversePreOrder(){
        traversePreOrder(root);
    }
    private void traversePreOrder(Node root){
        if(root==null) return;
        Node tempNode = root;
        System.out.print(tempNode.value + ", ");
        traversePreOrder(tempNode.leftNode);
        traversePreOrder(tempNode.rightNode);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    public void traverseInOrder(Node root){
        if(root.leftNode!=null) traverseInOrder(root.leftNode);
        System.out.print(root.value + ", ");
       if(root.rightNode!=null)  traverseInOrder(root.rightNode);
    }

    public void traversePostOrder(){
        traversePostorder(root);
    }
    public void traversePostorder(Node root){
        if(root==null) return;
        traversePostorder(root.leftNode);
        traversePostorder(root.rightNode);
        System.out.print(root.value + ", ");

    }

    public int height(Node root){
        if(root == null) return -1;
        if(root.leftNode==null && root.rightNode ==null) return 0;
        return 1 + Math.max(height(root.leftNode), height(root.rightNode));
    }


    public boolean equals(Tree tree){
        boolean result = rootsEquality(this.root, tree.getRoot());
        return result;
    }

    private boolean rootsEquality(Node root1, Node root2){
        if(root1 == null && root2==null) return true;
        if(root1==null || root2==null) return false;

        if(root1.value != root2.value) return false;
        boolean case2 = rootsEquality(root1.rightNode, root2.rightNode);
        if(!case2) return false;
        boolean case1 = rootsEquality(root1.leftNode, root2.leftNode);
        if(!case1) return false;


        return true;
    }


    public boolean bscheck(){
       return bscheck(root, -100000, 100000);
    }

    private boolean bscheck(Node root, int minValue, int maxValue){
        if(root == null) return true;
        if(root.value<minValue || root.value > maxValue) return false;
        boolean leftCheck = bscheck(root.leftNode, minValue, root.value);
        if(!leftCheck) return false;
        boolean rightCheck = bscheck(root.rightNode, root.value,maxValue);
        if(!rightCheck) return false;
        return true;
    }

    public boolean binaryCheck() {
//        var temp = root.leftNode;
//        root.leftNode = root.rightNode;
//        root.rightNode = temp;
        int lowest;
        Node temp = root;
        while (true){
            lowest = temp.leftNode.value;
            temp = temp.leftNode;
            if(temp.leftNode==null) break;
        }
        System.out.println("lowest = " + lowest);
        return binaryCheck(root,lowest);
    }

    private boolean binaryCheck(Node root, int lowest){
        if(root==null) return true;

        binaryCheck(root.leftNode,root.value);

        binaryCheck(root.rightNode,root.value);
        return true;
    }




    public ArrayList<Integer> kthElements(int k){
        ArrayList list = new ArrayList<Integer>();
        kthElements(root, k, list);
        return list;
    }
    private void kthElements(Node root, int k, ArrayList<Integer> list){
        if(root==null) return;
        if(k==0) {
            list.add(root.value);
            return;
        }
        k--;
        kthElements(root.leftNode, k, list);
        kthElements(root.rightNode,k, list);
    }
}