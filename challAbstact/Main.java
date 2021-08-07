package udemy.challAbstact;

public class Main {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList(null);
        System.out.println("================List===============");
        list.traverse(list.getRoot());

        String stringData = "Cele Lucho Sofi Mami Aldo Luis Alcira Ayelen";

        String[] data = stringData.split(" ");
        for(String s : data){
            list.addItem(new Node(s));
        }
        list.traverse(list.getRoot());
        list.removeItem(new Node("Cele"));
        list.traverse(list.getRoot());

        list.removeItem(new Node("Aldo"));
        list.traverse(list.getRoot());

        list.removeItem(new Node("Luis"));
        list.removeItem(new Node("Sofi"));
        list.removeItem(new Node("Cele"));
        list.traverse(list.getRoot());


        System.out.println("================Tree===============");
        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());


        for(String s : data){
            tree.addItem(new Node(s));
        }
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("Cele"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("Aldo"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("Luis"));
        tree.removeItem(new Node("Sofi"));
        tree.removeItem(new Node("Cele"));
        tree.traverse(tree.getRoot());
    }
}
