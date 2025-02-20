package br.com.estudos.streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static br.com.estudos.streams._Stream.Gender.*;

public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        boolean containsOnlyFemales = people.stream().allMatch(person -> FEMALE.equals(person.gender));
        boolean containsAtLeastOneFemale = people.stream().anyMatch(person -> FEMALE.equals(person.gender));
        boolean containsNoneFemales = people.stream().noneMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containsOnlyFemales);
        System.out.println(containsAtLeastOneFemale);
        System.out.println(containsNoneFemales);

        //Functions used on streams
//        Function<Person, String> personStringFunction = person -> person.name;
//        ToIntFunction<String> length = String::length;
//        IntConsumer println = System.out::println;

        //Used of Functions
//        people.stream()
//                .map(personStringFunction)
//                .mapToInt(length)
//                .forEach(println);

    }

    static class Person {
        private final String name;
        private final Gender gender;
        private int age;

        public Person(String name, Gender gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    ", age=" + age +
                    '}';
        }

        public String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
