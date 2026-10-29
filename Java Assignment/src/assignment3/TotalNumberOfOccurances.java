package assignment3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*Write a program to find the total number of occurrences of a word inside a Statement.

Eg. “people love to love people”
Output : people : 2
love:  2
to : 1
*/
public class TotalNumberOfOccurances {

    public static Map<String, Long> calculateOccurances(String words)
    {
        String[] wordArray = words.split(" ");
        Map<String, Long> map = new HashMap<String, Long>();
        for (String word : wordArray) {
            if (map.get(word) == null) {
                map.put(word, 1L);
            }
            else
            {
                map.put(word, map.get(word) + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of occurrences: ");
        String input = sc.nextLine();
        Map<String, Long> map = calculateOccurances(input);
        System.out.println("Occurences:" + map);
        sc.close();

    }
}
