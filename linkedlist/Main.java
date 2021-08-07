package udemy.linkedlist;

public class Main {
    public  static void main(String[] args){
        Customer customer = new Customer("Tim",54.9);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(12.5);
        System.out.println();

    }

    }
