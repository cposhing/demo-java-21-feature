package org.example.demo;

public class Main3 {
    public static void main(String[] args) {


        System.out.println(action(new CustomerCreatedEvent("ps")));
        System.out.println(action(new CustomerDeleteEvent(new Customer("ps"))));
    }

    static String action(Object event) {
        return switch (event) {
            //case CustomerCreatedEvent(var name) -> name + " created!";
            case CustomerCreatedEvent name -> name + " created!";

            //case CustomerDeleteEvent(var customer) -> customer.name() + " deleted!";
            case CustomerDeleteEvent(Customer customer) -> customer.name() + " deleted!";

            default -> throw new IllegalArgumentException();
        };
    }
}


record Customer(String name) {
}

record CustomerDeleteEvent(Customer customer) {
}

record CustomerCreatedEvent(String name) {
}