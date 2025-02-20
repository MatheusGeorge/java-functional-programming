package br.com.estudos.optionals;

import java.util.Optional;

public class _Optional {

    public static void main(String[] args) {
        Optional<String> hello = Optional.ofNullable(null);
        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());

        String orElse = hello
                .map(String::toUpperCase)
                .orElseGet(() -> {
                    // .. extra computation to retrieve the value
                    return "world";
                });

//        String orElse = hello
//                .map(String::toUpperCase)
//                .orElseThrow(IllegalStateException::new);

        hello.ifPresent(System.out::println);
        hello.ifPresentOrElse(System.out::println, () -> System.out.println("world"));

        System.out.println(orElse);


    }
}
