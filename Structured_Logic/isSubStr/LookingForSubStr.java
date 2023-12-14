package isSubStr;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LookingForSubStr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a string:");
        String str = scan.nextLine();

        System.out.println("Digite a substring:");
        String substr = scan.nextLine();

        scan.close();

        int occurrences = countOccurrences(str, substr);

        System.out.println("A substring aparece " + occurrences + " vezes em " + str);

        listCharsWithCount(str, substr);
    }

    private static int countOccurrences(String str, String substr) {
        int count = 0;
        int index = str.indexOf(substr);

        while (index != -1) {
            count++;
            index = str.indexOf(substr, index + 1);
        }

        return count;
    }

    private static void listCharsWithCount(String str, String substr) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (char c : substr.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }


        System.out.println("Caracteres e suas contagens na string original e na substring:");
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println("Caractere: " + entry.getKey() + ", Contagem: " + entry.getValue());
        }
    }
}
