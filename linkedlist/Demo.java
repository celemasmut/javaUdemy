package udemy.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String > placesToVisit= new LinkedList<>();

        addInOrder(placesToVisit,"Sydney");
        addInOrder(placesToVisit,"Melbourne");
        addInOrder(placesToVisit,"Brisbane");
        addInOrder(placesToVisit,"Perth");
        addInOrder(placesToVisit,"Canberra");
        addInOrder(placesToVisit,"Adelaide");
        addInOrder(placesToVisit,"Darwin");
        printList(placesToVisit);

        addInOrder(placesToVisit,"Alice Springs");
        addInOrder(placesToVisit, "Darwin");
        printList(placesToVisit);
      /*  placesToVisit.add("Sydney");
        placesToVisit.add("Melbourne");
        placesToVisit.add("Brisbane");
        placesToVisit.add("Perth");
        placesToVisit.add("Canberra");
        placesToVisit.add("Adelaide");
        placesToVisit.add("Darwin");
        printList(placesToVisit);
        placesToVisit.add(1,"Alice Spring");
        printList(placesToVisit);

        placesToVisit.remove(4);
        printList(placesToVisit);*/

        visit(placesToVisit);
    }

    private static void printList(LinkedList<String> linkedList){
        //iterator
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()){
            System.out.println("visiting "+ i.next());
        }
        System.out.println("===================");
    }

    private static boolean addInOrder(LinkedList <String> linkedList,String newCity){
        ListIterator<String>stringListIterator = linkedList.listIterator();// here does not point to the first record. we need to use next to get the first entry

        while (stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newCity);// 0 is matched // .next return the current x but then it moves to next one
            if (comparison == 0){
                //do not add
                System.out.println(newCity + " is already in the linkedlist");
                return false;
            }else if(comparison > 0){// because we moved to the next one we need to go back
                //newcity should appear before this one.
                //Brisbane  ->  Adelaide
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }else if (comparison < 0){
                //move to the next city
            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities){
        Scanner scan = new Scanner(System.in);

        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()){
            System.out.println("is empty");
        }else{
            System.out.println("now visiting "+listIterator.next());
            printMenu();
        }

        while (!quit){
            int action = scan.nextInt();
            scan.nextLine();
            switch (action){
                case 0:
                    System.out.println("holiday vacation over");
                    quit=true;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("now visiting "+listIterator.next());
                    }else{
                        System.out.println("reached the end of the list");
                        goingForward=false;
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("now visiting "+listIterator.previous());
                    }else{
                        System.out.println("u r at teh  start of th list");
                        goingForward= true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }

        }
    }
    private  static void printMenu(){
        System.out.println("0 to quit");
        System.out.println("1 go to next city");
        System.out.println("2 go to previous city");
        System.out.println("3 menu");
    }

}
