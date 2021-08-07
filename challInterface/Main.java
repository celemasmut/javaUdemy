package udemy.challInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Player tim = new Player("Tim", 10,15);
        System.out.println(tim.toString());
        saveObject(tim);

        tim.setHitPoints(8);
        System.out.println(tim);
        tim.setWeapon("Stormbringer");
        saveObject(tim);
        loadObject(tim);
        System.out.println(tim);

        ISaveable werewolf = new Monster("Werewolf",20,40);
        System.out.println(werewolf);
        saveObject(werewolf);
        //the obj's type is an interface so it is needed to cast the obj if I need an specific method
        System.out.println(((Monster) werewolf).getStrenght());

    }

    public static Scanner scan = new Scanner(System.in);
    public static List<String> readValues(){
        ArrayList<String> values = new ArrayList<>();
        boolean quit = false;
        int index =0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit){
            System.out.println("Choose an option: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scan.nextLine();
                    values.add(index,stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave){
        for(int i =0; i<objectToSave.write().size(); i++){
            System.out.println("Savong "+ objectToSave.write().get(i) + " to storage devise");
        }
    }

    public static void loadObject(ISaveable objectToLoad){
        List<String> values = readValues();
        objectToLoad.read(values);
    }


}
