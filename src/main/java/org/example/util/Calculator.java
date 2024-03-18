package org.example.util;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber, secondNumber, result;

        System.out.print("Введите первое число: ");
        firstNumber = checkNumbers(scanner);

        System.out.println("Выберите операцию (+, -, *, /)");
        String math = scanner.next();

        while (!math.matches("[+\\-*/]")) {
            System.out.println("Вы ввели некорректную операцию, введите корректную операцию (+, -, *, /):");
            math = scanner.next();
        }

        System.out.print("Введите второе число: ");
        secondNumber = checkNumbers(scanner);

        result = switch (math) {
            case "+" -> sum(firstNumber, secondNumber);
            case "-" -> minus(firstNumber, secondNumber);
            case "*" -> multiplication(firstNumber, secondNumber);
            case "/" -> {
                if (secondNumber != 0) {
                    yield division(firstNumber, secondNumber);
                } else {
                    System.out.println("На 0 делить нелья");
                    yield 0;
                }
            }
            default -> throw new IllegalStateException("Неверная операция: " + math);
        };

        while (true) {
            System.out.println("Текущий результат: " + result);
            System.out.println("Выберите операцию (+, -, *, /) или введите 'exit' для выхода:");

            math = scanner.next();

            if (math.equals("exit")) {
                break;
            }

            if (!math.matches("[+\\-*/]")) {
                System.out.println("Вы ввели некорректную операцию.");
                continue;
            }

            System.out.print("Введите число: ");
            double nextNumber = checkNumbers(scanner);

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
        }
        System.out.println("Итоговый результат: " + result);


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


