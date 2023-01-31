import java.util.Scanner;

public class CalcTwo {

            public static void main(String[] args)
                throws Exception {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите два числа арабские или римские");
            String expression = scanner.nextLine();
            System.out.println(pasce(expression));
        }

        public static String pasce(String expression) throws Exception {
            int number1, number2;
            String open;
            String result;
            boolean isRoman;
            String[] operands = expression.split("[+\\-*/]");
            if (operands.length != 2) throw new Exception("Должно быть два операнда");
            open = detectOperation(expression);
            if (open == null) throw new Exception("Не поддерживается математическая операция");
            // если оба числа римские
            if (Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) { // конвертируем оба числа в арабские для вычесления
                number1 = Roman.convertToArabian(operands[0]);
                number2 = Roman.convertToArabian(operands[1]);
                isRoman = true;
            }
            //если оба числа арабские
            else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands [1])) {
                number1 = Integer.parseInt(operands[0]);
                number2 = Integer.parseInt(operands[1]);
                isRoman = false;
            }
            //если одно число римское, а другое арабскоею
                else{
                    throw new Exception("Число должно быть в одном формате");
                }
                        if (number1 > 10 || number2 > 10) {
                throw new Exception("Числа должны быть от 1 до 10");
            }
            int arabian = calc(number1, number2, open);
            if (isRoman) {
                // если римское число получилосьменьшелибо равно нулю выдаётся ошибка
                if (arabian <= 0) {
                    throw new Exception("Римское число должно быть больше нуля");
                }
                //конвертируем операции из арабского в римское
                result = Roman.convertToRoman(arabian);
            } else {
                //конвертируем арабское число в тип String
                result = String.valueOf (arabian);
            }
            return result;
        }

        static String detectOperation(String Expression) {
            if (Expression.contains("+")) return "+";
            else if (Expression.contains("-")) return "-";
            else if (Expression.contains("*")) return "*";
            else if (Expression.contains("/")) return "/";
            else return null;
        }

        static int calc(int a, int b, String oper) {
            if (oper.equals("+")) return a + b;
            else if (oper.equals("-")) return a - b;
            else if (oper.equals("*")) return a * b;
            else return a / b;
        }
    }
    class  Roman{
        static String[] romanArray=new String[]{"0", "I", "II", "III", "IV","V", "VI", "VII", "VIII", "IX", "X", "XI",
                "XII", "XIII", "XIV", "XV", "XVI","XVII", "XVIII", "XIX", "XX", "XXI", "XXII","XXIII", "XXIV", "XXV",
        "XXVI","XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
        "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVII", "XLIX", "L", "LI", "LII", "LII",
        "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII",
        "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI",
        "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII",
        "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        public static boolean isRoman(String val){
            for(int i=0; i<romanArray.length; i++){
                if(val.equals(romanArray[i])){
                    return true;
                }
            }
            return false;
        }
        public static int convertToArabian(String roman){
            for(int i=0; i<romanArray.length; i++){
                if(roman.equals(romanArray[i])){
                    return i;
                }
            }
            return -1;
        }
        public static String convertToRoman(int arabian){
            return romanArray[arabian];
        }




    }



