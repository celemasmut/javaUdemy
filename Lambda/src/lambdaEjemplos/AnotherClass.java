package lambdaEjemplos;

public class AnotherClass {

    public String doSomethng(){
//        System.out.println("The Another class's name is:" + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class's name is : " + getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String1", "String2");

        UpperConcat uc = (s1, s2)->{
            System.out.println("The lambda expession's is " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        System.out.println("The anotherClasss class's name is "+ getClass().getSimpleName());
        return Main.doStringStuff(uc,"String1","String2");
    }
}
