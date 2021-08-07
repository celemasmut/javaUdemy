package udemy.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
   private static GroceryList groceryList = new GroceryList();
    public  static void main(String[] args){

        boolean quit = false;
        int choice =0;
        printInstructions();
        while (!quit){
            System.out.println("Enter your choice: ");
            choice=scan.nextInt();
            scan.nextLine();

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    System.out.println(groceryList.printGroceryListAndSize());
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }

    }

    public static void printInstructions(){
        System.out.println("0 choice op");
        System.out.println("1 print list");
        System.out.println("2 add item");
        System.out.println("3 modify item");
        System.out.println("4 remove item");
        System.out.println("5 search 4 an item");
        System.out.println("6 quit");

    }

    public static void addItem(){
        System.out.print("enter the item");
        groceryList.addGroceryItem(scan.nextLine());
    }

    public static void modifyItem(){
        System.out.print("enter item name: ");
        String itemNumber=scan.nextLine();
        scan.nextLine();
        System.out.println("enter replacement item: ");
        String newItem= scan.nextLine();
        groceryList.modifyGroceryItem(itemNumber,newItem);
    }

    public static void removeItem(){
        System.out.print("enter item name: ");
        String itemNumber=scan.nextLine();
        scan.nextLine();
        groceryList.removeGroceryItem(itemNumber);
    }

    public static void searchForItem(){
        System.out.print("enter the item to search for: ");
        String searchItem = scan.nextLine();
        if(groceryList.onFile(searchItem)){
            System.out.println("Fount");
        }else{
            System.out.println("Not found");
        }
    }

    public static void processArrayList(){
        ArrayList<String> newArray = new ArrayList<>();
        newArray.addAll(groceryList.getGroceryList());

        String[] myArray= new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }
}
