package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach((number) -> System.out.println(number));

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter((number) -> number < 5).forEach((number) -> System.out.println(number));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter((number) -> number > 5).skip(1).limit(2).forEach((number) -> System.out.println(number));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Integer integer = StreamSources.intNumbersStream().filter((number) -> number > 5).findFirst().orElse(-1);
        System.out.println(integer);

        // Print first names of all users in userStream
        StreamSources.userStream().forEach((user) -> System.out.println(user.getFirstName()));
        // Print first names in userStream for users that have IDs from number stream
        StreamSources.userStream().filter((user) -> {
                    return StreamSources.intNumbersStream().anyMatch((number) -> number == user.getId());
                })
                .forEach((user) -> System.out.println(user.getFirstName()));

    }

}
