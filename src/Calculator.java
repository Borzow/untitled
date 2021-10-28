import java.util.InputMismatchException;
import java.util.Scanner;


public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static int result;

    public static void main (String[] args) {
        System.out.println("Введите выражение [2 + 2] или два римских числа от I до X:[V + V] + Enter ");
//      Считываем строку userInput которую ввёл пользователь
        String userInput = scanner.nextLine();
//      Создаём пустой символьный массив длиной 10 символов:  under_char


        String[] blacks = userInput.split(" ",3);
        String num1 = blacks[0];
        String oper = blacks[1];
        String num2 = blacks[2];
        number1 = romanToNumber(num1);
        number2 = romanToNumber(num2);
        if (result == -10000){
            System.out.println("Ошибка ");
        }
        else if (number1 < -10 && number2 < -10) {
            number1 = Integer.parseInt(num1);
            number2 = Integer.parseInt(num2);
            result = calculated(number1, number2, oper);
            System.out.printf("Результат для арабских цифр \n%d %s %d = %d",number1,oper,number2,result);
        } else {
            result = calculated(number1, number2, oper);
            String resultRoman = convertNumToRoman(result);
            System.out.printf("Результат для римских цифр \n%s %s %s = %s",num1,oper,num2,resultRoman);

        }


    }

    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }


    private static int romanToNumber (String roman) {
        try {
            switch (roman) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
                case "-I":
                    return -1;
                case "-II":
                    return -2;
                case "-III":
                    return -3;
                case "-IV":
                    return -4;
                case "-V":
                    return -5;
                case "-VI":
                    return -6;
                case "-VII":
                    return -7;
                case "-VIII":
                    return -8;
                case "-IX":
                    return -9;
                case "-X":
                    return -10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -11;
    }

    public static int calculated (int num1, int num2, String oper) {
        return switch (oper) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new IllegalArgumentException("Не верный знак операции");
        };
    }
}