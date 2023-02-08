package exercise;

import java.util.List;

import java.util.Arrays;

// BEGIN
class App {
    public static int getCountOfFreeEmails(List<String> emails) {
        long amount = emails.stream()
                .filter(email -> email.contains("@yandex.ru") || email.contains("@hotmail.com") || email.contains("@gmail.com"))
                .count();
        return (int) amount;
    }
}

// END
