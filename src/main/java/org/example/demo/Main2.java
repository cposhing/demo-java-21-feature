package org.example.demo;

public class Main2 {

    public static void main(String[] args) {

        String action = getAction(new Worker());

    }

    private static String getAction(Human human) {
        return switch (human) {
            case Student student -> student.action();
            case Teacher teacher -> teacher.action();
            case Worker worker -> worker.action();
        };
    }

//    private static String getAction(Human human) {
//        var result = (String) null;
//        if (human instanceof Student student) {
//            result = student.action();
//        }
//        if (human instanceof Teacher teacher) {
//            result = teacher.action();
//        }
//        return result;
//    }
}


sealed interface Human permits Student, Teacher, Worker {
}


final class Student implements Human {
    String action() {
        return "study";
    }
}


final class Teacher implements Human {
    String action() {
        return "teach";
    }
}

final class Worker implements Human {
    String action() {
        return "work";
    }
}