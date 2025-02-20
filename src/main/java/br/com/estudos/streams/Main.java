package br.com.estudos.streams;

import java.util.*;
import java.util.stream.Collectors;

import br.com.estudos.streams._Stream.*;

import static br.com.estudos.streams._Stream.Gender.FEMALE;
import static br.com.estudos.streams._Stream.Gender.MALE;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        // Imperative approach ❌

//        List<Person> females = new ArrayList<>();
//        for(Person person: people) {
//            if(person.getGender().equals(FEMALE)) {
//                females.add(person);
//            }
//        }
//
//        females.forEach(System.out::println);

        // Declarative approach ✅

        //Filter
        System.out.println("-------- Filter ---------");

        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(FEMALE))
                .toList();
        females.forEach(System.out::println);

        System.out.println();

        //Sort
        System.out.println("-------- Sort ---------");

        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed().thenComparing(Person::getGender))
                .toList();
        sorted.forEach(System.out::println);

        System.out.println();

        //All Match
        System.out.println("-------- All Match ---------");

        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 8);

        System.out.println(allMatch + "\n");

        //Any Match
        System.out.println("-------- Any Match ---------");

        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 121);

        System.out.println(anyMatch + "\n");

        //None Match
        System.out.println("-------- None Match ---------");

        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));

        System.out.println(noneMatch + "\n");

        //Max
        System.out.println("-------- Max ---------");

        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        System.out.println();

        //Min
        System.out.println("-------- Min ---------");

        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        System.out.println();

        //Group
        System.out.println("-------- Group ---------");

        Map<Gender, List<Person>> groupByGender = people.stream().collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach((gender, peopleGroupedByGender) -> {
            System.out.println(gender);
            peopleGroupedByGender.forEach(System.out::println);
        });

        System.out.println();

        //Chain -> the oldest female, return the first name
        System.out.println("-------- Chain ---------");

        people.stream()
                .filter(person -> person.getGender().equals(FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName)
                .ifPresent(System.out::println);

        System.out.println();

    }

    private static List<Person> getPeople() {
        return List.of(
               new Person("Antonio", MALE, 20),
               new Person("Alina Smith", FEMALE, 33),
               new Person("Helen White", FEMALE, 57),
               new Person("Alex Boz", MALE, 14),
               new Person("Jamie Goa", MALE, 99),
               new Person("Anna Cook", FEMALE, 7),
               new Person("Zelda Brown", FEMALE, 120)
        );
    }
}
