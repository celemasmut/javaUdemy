package udemy.challAbstact;

public class SearchTree implements NodeList{

    private  ListItem root ;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if(root == null){ // tree empty
            root = item;
            return true;
        }
        ListItem currentItem = root;//if not empty start compare
        while (currentItem != null){
            int comparison = (currentItem.compareTo(item));
            if(comparison < 0){
                //item is greater, move right if posible
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                }else{
                    //there's no node to the right, so add at this point
                    currentItem.setNext(item);
                    return true;
                }
            }else if( comparison > 0){
                //iem is less, move left if possible
                if(currentItem.previous() != null){
                    currentItem = currentItem.previous();
                }else{
                    //there's no node to the left. add at this point.
                    currentItem.setPrevious(item);
                    return true;
                }
            }else{//equal
                System.out.println(item.getValue() + " is already present");
                return false;
            }
        }
        return false;
    }

    private void performRemoval(ListItem item, ListItem parent){
        //remove item from tree
        if(item.next() == null){
            //no right tree, so make parent point left tree
            if(parent.next() == item){
                //item is right child of its parent
                parent.setNext(item.previous());
            }else if( parent.previous() == item){
                //otem if left child of its parent
                parent.setPrevious(item.previous());
            }else{
                //parent must be item, wich means we were looking at the root of the tree
                root = item.previous();
            }
        }else if(item.previous() == null){
            //no left tree
            if(parent.next() == item){
                //item is right child of its parent
                parent.setNext(item.next());
            }else if(parent.previous() == item){
                //item is left child of its parent
                parent.setPrevious(item.next());
            }else{
                //again we are deleting the root
                root= item.next();
            }
        }else{
            //neither left nor right are null, deletion is now a lot trickier
            //From the right sub-tree, find the smallest value ( i.e, the leftmost).
            ListItem current = item.next();
            ListItem leftMostParent = item;
            while (current.previous() != null){
                leftMostParent =  current;
                current = current.previous();
            }
            // now put the smallest value into pur node to be deleted
            item.setValue(current.getValue());
            //and delete the smallest
            if( leftMostParent == item){
                //there was no leftmost node, so current points to the smallest
                //node ( the one that must now be deleted)
                item.setNext(current.next());
            }
        }
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item != null){
            System.out.println("Deleting item "+item.getValue());
        }
        ListItem currentItem = root;
        ListItem paretnItem= currentItem;

        while (currentItem != null){
            int comparison = (currentItem.compareTo(item));
            if(comparison < 0){
                paretnItem = currentItem;
                currentItem = currentItem.next();
            }else if ( comparison > 0){
                paretnItem = currentItem;
                currentItem = currentItem.previous();
            }else{
                //equal
                performRemoval(currentItem, paretnItem);
                return true;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {//recursive
        if(root != null){
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }

    }
}
