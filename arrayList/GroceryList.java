package udemy.arrayList;

import java.util.ArrayList;

public class GroceryList {
    private int[] myNumbers = new int[50];
    private ArrayList<String> groceryList = new ArrayList<>();// the arraylist is a class so it has a constructor

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public ArrayList<String> getGroceryList(){
        return groceryList;
    }

    public String printGroceryListAndSize() {
        String messege = "";
        for (int i = 0; i < groceryList.size(); i++) {
            messege += "\n" + (i + 1) + ". " + groceryList.get(i);
        }
        return "You have" + groceryList.size() + " items in your grocery list" + messege;
    }

    public void modifyGroceryItem(String currentItem, String item) {
        int pos = findItem(currentItem);
        if (pos > 0) {
            modifyGroceryItem(pos, item);
        }
    }

    private void modifyGroceryItem(int position, String item) {
        groceryList.set(position, item);
    }

    public void removeGroceryItem(String item) {
        int pos = findItem(item);
        if (pos > 0) {
            removeGroceryItem(pos);
        }
    }

    private void removeGroceryItem(int pos) {
        String item = groceryList.get(pos);
        groceryList.remove(pos);
    }

    private int findItem(String searchItem) {
        //boolean exist=groceryList.contains(searchItem);
       /* int pos = groceryList.indexOf(searchItem);
        if(pos >= 0){
            return groceryList.get(pos);
        }
        return null;*/
        return groceryList.indexOf(searchItem);
    }

    public boolean onFile(String searchItem) {
        int pos = findItem(searchItem);
        if (pos >= 0) {
            return true;
        }
        return false;
    }

}

