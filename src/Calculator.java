import java.util.InputMismatchException;
import java.util.Scanner;

/*

Здравствуйте, в этой программе мы можем посчитать как Арабские, так и Римские числа с помощью операций + - * /(деление целочисленное).
На вход подается String типа: число операция число (2 + 2), (I + I). Калькулятор считает ТОЛЬКО 2 числа и ТОЛЬКО в одной системе счисления.

*/

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static int result;

    public static void main (String[] args) {
        System.out.println("Введите выражение [2 + 2] или два римских числа от I до X:[V + V] + Enter ");
        // Считываем строку userInput которую ввёл пользователь
        String userInput = scanner.nextLine();



        String[] blacks = userInput.split(" ",3); // разбиваю строку на 3 части
        // вытаскиваем числа и знак
        String num1 = blacks[0]; // первое число
        String oper = blacks[1]; // знак
        String num2 = blacks[2]; // второе число
        // переходим в метод для работы с римскими числами
        number1 = romanToNumber(num1);
        number2 = romanToNumber(num2);
        // проверка на  тип числа ( арабское или римское )
        if (number1 ==-1 && number2 ==-1) { // если мы тут, то число  арабское
            number1 = Integer.parseInt(num1);
            number2 = Integer.parseInt(num2);
            result = calculated(number1, number2, oper);// в метод подсчета
            System.out.printf("Результат для арабских цифр \n%d %s %d = %d",number1,oper,number2,result);
        } else if (number1 !=-1 && number2 !=-1){// если мы тут, то число римское
            result = calculated(number1, number2, oper);
            String resultRoman = convertNumToRoman(result);
            System.out.printf("Результат для римских цифр \n%s %s %s = %s",num1,oper,num2,resultRoman);
        } else System.out.println("Что то пошло не так ");// отсикаем примеры типа: I + 3 и тд
    }

    private static String convertNumToRoman (int numArabian) {// переводим арабские цифры в римские
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


    private static int romanToNumber (String roman) {// римские в арабские
        try {
            return switch (roman) {
                case "I" -> 1;
                case "II" -> 2;
                case "III" -> 3;
                case "IV" -> 4;
                case "V" -> 5;
                case "VI" -> 6;
                case "VII" -> 7;
                case "VIII" -> 8;
                case "IX" -> 9;
                case "X" -> 10;
                default -> -1;// возвращается если число НЕ римское
            };
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
    }

    public static int calculated (int number1, int number2, String oper) {// высчитываем результат с учетом знака
        return switch (oper) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "*" -> number1 * number2;
            case "/" -> number1 / number2;
            default -> throw new IllegalArgumentException("Не верный знак операции");
        };
    }
}