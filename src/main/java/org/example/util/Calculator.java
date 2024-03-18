package org.example.util;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = calculateRes(scanner);
        System.out.println("Итоговый результат: " + result);


    }

    static double calculateRes(Scanner scanner) {
        double firstNumber = getFirstNumber(scanner);
        double secondNumber = getSecondNumber(scanner);
        String math = getMath(scanner);
        double result = getRes(firstNumber, math, secondNumber);
        result = checkWhile(scanner, result);
        return result;
    }

    static double getFirstNumber(Scanner scanner) {
        System.out.println("Введите первое число: ");
        return checkNumbers(scanner);
    }

    static double getSecondNumber(Scanner scanner) {
        System.out.println("Введите второе число: ");
        return checkNumbers(scanner);
    }

    static String getMath(Scanner scanner) {
        System.out.println("Выберите операцию (+, -, *, /)");
        String math = scanner.next();

        while (!math.matches("[+\\-*/]")) {
            System.out.println("Вы ввели некорректную операцию, введите корректную операцию (+, -, *, /):");
            math = scanner.next();
        }
        return math;
    }

    static double getRes(double result, String math, double nextNumber) {
        result = switch (math) {
            case "+" -> sum(result, nextNumber);
            case "-" -> minus(result, nextNumber);
            case "*" -> multiplication(result, nextNumber);
            case "/" -> {
                if (nextNumber != 0) {
                    yield division(result, nextNumber);
                } else {
                    System.out.println("На 0 делить нелья");
                    yield 0;
                }
            }
            default -> throw new IllegalStateException("Неверная операция: " + math);
        };
        return result;
    }

    static double checkWhile(Scanner scanner, double result) {
        while (true) {
            System.out.println("Текущий результат: " + result);
            System.out.println("Выберите операцию (+, -, *, /) или введите 'exit' для выхода:");

            String math = scanner.next();

            if (math.equals("exit")) {
                break;
            }

            if (!math.matches("[+\\-*/]")) {
                System.out.println("Вы ввели некорректную операцию.");
                continue;
            }

            System.out.print("Введите число: ");
            double nextNumber = checkNumbers(scanner);

            result = getRes(result, math, nextNumber);
        }
        return result;
    }

    static double sum(double x, double y) {
        return x + y;
    }

    static double minus(double x, double y) {
        return x - y;
    }

    static double multiplication(double x, double y) {
        return x * y;
    }

    static double division(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return x / y;
    }

    static double checkNumbers(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Вы ввели не число, введите число:");
            scanner.next(); // очистка ввода перед повторным запросом
        }
        return scanner.nextDouble();
    }


}


