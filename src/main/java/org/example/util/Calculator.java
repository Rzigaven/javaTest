package org.example.util;

import java.util.Scanner;

public class Calculator {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // boolean check = false;
        int firstNumber = 0, secondNumber = 0;
        System.out.print("Введите первое число: ");
        firstNumber = check(scanner); // а тут check(scanner, firstNumber) было всегда 0

        System.out.print("Введите второе число: ");
        secondNumber = check(scanner); // а тут check(scanner, secondNumber) было всегда 0

        System.out.println("Введите арифметическое действие: ");
        String math = scanner.nextLine();
        math = scanner.nextLine();

        switch (math) {
            case "+" :
                res(sum(firstNumber,secondNumber));
                break;
            case "-" :
                res(minus(firstNumber,secondNumber));
                break;
            case "*" :
                res(multiplication(firstNumber,secondNumber));
                break;
            case "/" :
                if(secondNumber != 0) {
                    res(division(firstNumber,secondNumber));
                }
                else System.out.println("На 0 делить нелья");
                break;
            default :
                System.out.println("Вы ввели некорректную операцию");
                break;
        }


    }

      int sum(int x,int y) {
        return x + y;
    }
      int minus(int x, int y) {
        return x - y;
    }

      int multiplication(int x, int y) {
        return x * y;
    }

      int division(int x, int y) {
        return x / y;
    }

      void res(int result) {
        System.out.println("Ваш результат равен: " + result);
    }

      int check(Scanner scanner) { // я тут делал так public static int check(Scanner scanner, int x)
        if(scanner.hasNextInt())
            return scanner.nextInt(); // тут так x = scanner.nextInt()
        else {
            System.out.println("Вы ввели не число, введите число");
            System.exit(0);
            return 0;
        }

    }
}


