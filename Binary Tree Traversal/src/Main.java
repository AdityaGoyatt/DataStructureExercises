public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(6);
        tree.insert(14);
        tree.insert(24);
        tree.insert(3);
        tree.insert(1000);
        tree.insert(26);


        System.out.println(tree.binaryCheck());
    }
}