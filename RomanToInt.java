import java.util.Scanner;

public class RomanToInt {
    public int romanToInt(String s) {
        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char currentSymbol = s.charAt(i);
            int currentValue = getValue(currentSymbol);

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }

    public int getValue(char symbol) {
        switch (symbol) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("Invalid Roman numeral: " + symbol);
        }
    }

    public static void main(String[] args) {
        RomanToInt converter = new RomanToInt();
        Scanner scan = new Scanner(System.in);
        String romanNumeral = scan.nextLine();
        int result = converter.romanToInt(romanNumeral);
        System.out.println("Roman numeral " + romanNumeral + " is equal to " + result);
    }
}
