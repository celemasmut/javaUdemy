package udemy.apiCollections;

import java.util.*;

public class testCollections {

    public static void main(String[] args) {
        List myList = new ArrayList(); // guarda el orden por lo que las operaciones pueden ser lentas.
        myList.add("Lunes");//ademas se pueden duplicar los elementos.
        myList.add("Martes");
        myList.add("Miercoles");
        myList.add("Jueves");
        myList.add("Viernes");
        myList.add("Sabado");
        myList.add("Domingo");

        imprimir(myList);
        System.out.println("");

        Set mySet = new HashSet(); // no garantiza orden. es mas rapido al agregar los elementos
        mySet.add("Lunes"); // ademas no se pueden duplicar los elementos.
        mySet.add("Martes");
        mySet.add("Miercoles");
        mySet.add("Jueves");
        mySet.add("Viernes");

        imprimir(mySet);
        System.out.println("");

        Map myMap = new HashMap();
        myMap.put("valor1","Juan");
        myMap.put("valor2","Cele");
        myMap.put("valor3","Luchi");
        myMap.put("valor4","Mama");

        String elementoMap = (String) myMap.get("valor2");
        System.out.println(elementoMap);

        imprimir(myMap.keySet()); // keySet es un Set que es una collection y como es un set no se imprimira en orden
        imprimir(myMap.values());
    }

    public static  void imprimir (Collection collection){
        collection.forEach(ob -> System.out.println("Elemento : " + ob));
    }


}
