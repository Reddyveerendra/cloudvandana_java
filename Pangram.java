import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Pangram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        char[] charArray = str.toLowerCase().toCharArray();
        char[] uniqueChars = removeDuplicates(charArray);
        Arrays.sort(uniqueChars);

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String uniqueString = new String(uniqueChars);
        System.out.println(uniqueString);
        boolean isPangram = alphabet.equals(uniqueString);

        if (isPangram) {
            System.out.println("It's a pangram.");
        } else {
            System.out.println("It's not a pangram.");
        }
    }

    public static char[] removeDuplicates(char[] charArray) {
        Set<Character> set = new HashSet<>();
        List<Character> result = new ArrayList<>();

        for (char element : charArray) {
            if (Character.isLetter(element)) {
                if (set.add(element)) {
                    result.add(element);
                }
            }
        }

        char[] uniqueChars = new char[result.size()];

        for (int i = 0; i < result.size(); i++) {
            uniqueChars[i] = result.get(i);
        }

        return uniqueChars;
    }
}
