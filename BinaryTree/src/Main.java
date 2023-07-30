public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(4);
        tree.insert(5);
        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(0);
        tree.insert(2);


        System.out.println(tree.find(55));
    }
}