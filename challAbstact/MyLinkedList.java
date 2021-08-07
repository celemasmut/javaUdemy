package udemy.challAbstact;

public class MyLinkedList implements NodeList{

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if(root == null){
            //the list was empty, so this item becomes the head of the list
            root = item;
            return true;
        }
        ListItem currentItem = root;
        while (currentItem != null){
            int comparison = (currentItem.compareTo(item));
            if(comparison < 0){
                //item is greater, move right if possible
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                }else{
                    //there is no next, so insert at the end of the list
                    currentItem.setNext(item).setPrevious(currentItem);
                    return true;
                }
            }else if (comparison > 0){
                //item is less , insert before
                if(currentItem.previous() != null){
                    currentItem.previous().setNext(item).setPrevious(currentItem.previous());
                    item.setNext(currentItem).setPrevious(item);
                }else{
                    //the node with a previous is a root
                    item.setNext(root).setPrevious(item);
                    root=item;
                }
                return true;
            }else{
                //equal
                System.out.println(item.getValue() + " is already present, not added ");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {

        if(item != null){
            System.out.println("Deleting item "+ item.getValue());
        }
        ListItem currentItem = root;

        while (currentItem != null){
            int comparison = currentItem.compareTo(item);
            if(comparison == 0){
                if(currentItem == root){
                    root = currentItem.next();
                }else {
                    currentItem.previous().setNext(currentItem.next());
                    if(currentItem.next() != null){
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            }else if( comparison < 0){
                currentItem = currentItem.next();
            }else{
                return false;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {

        if(root == null){
            System.out.println("The list is empty");
        }else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
