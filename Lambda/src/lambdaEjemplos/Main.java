package lambdaEjemplos;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Employee cele= new Employee("Celeste Masmut",29);
        Employee Luciano= new Employee("Lucino Cunsolo ",30);
        Employee Ayelen= new Employee("Ayelen Bulacio",27);
        Employee Francisca= new Employee("Francisca Guiña",27);
        List<Employee> myEmployees = new ArrayList<>();

        myEmployees.add(cele);
        myEmployees.add(Luciano);
        myEmployees.add(Ayelen);
        myEmployees.add(Francisca);

  //      Collections.sort(myEmployees, new Comparator<Employee>(){
    //        @Override
     //       public int compare(Employee employee1, Employee employee2){
      //          return employee1.getName().compareTo(employee2.getName());
       //     }
       // });

        Collections.sort(myEmployees, ( employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        for(Employee  employee : myEmployees){
            System.out.println(employee.getName());
        }

        myEmployees.forEach(employee -> System.out.println(employee.getName() +" "+employee.getAge()));

        myEmployees.forEach(employee -> {
            if(employee.getAge() > 27){
                System.out.println(employee.getName());
            }
        });

        //using Predicate

        printEmployeesByAge(myEmployees,"Employees over 27", employee -> employee.getAge() > 27);
        printEmployeesByAge(myEmployees,"\nEmployees 27 or under", employee -> employee.getAge() <= 27);


/*        String sillyString = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + s2.toUpperCase();
            }
        },
          myEmployees.get(0).getName(), myEmployees.get(1).getName());
        System.out.println(sillyString);
*/

        UpperConcat uc = ( s1,  s2) ->s1.toUpperCase() + s2.toUpperCase();
        String sillyString = doStringStuff(uc,myEmployees.get(0).getName(), myEmployees.get(1).getName());
        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomethng();
        System.out.println(s);

        //PREDICATE

        System.out.println("PREDICATE : LAMBDA");
        IntPredicate greaterThen15 = i -> i > 15;
        IntPredicate lessThan100 = i ->  i < 100;

        System.out.println(greaterThen15.test(10));
        int a = 20;
        System.out.println(greaterThen15.test(a + 5));
        System.out.println(greaterThen15.and(lessThan100).test(50));
        System.out.println(greaterThen15.and(lessThan100).test(15));

        System.out.println("==============Suplier====================");

        Random random = new Random();
        Supplier<Integer> randomSupplier =  ()-> random.nextInt(1000);
        for(int i =0 ; i<10; i++){
            System.out.println(randomSupplier.get());
        }
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2){
        return  uc.upperAndConcat(s1,s2);
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition){
        System.out.println(ageText);
        System.out.println("===========================");
        employees.forEach( employee -> {
            if(ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        });
    }

}