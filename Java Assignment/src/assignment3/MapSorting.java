package assignment3;

import java.util.*;

public class MapSorting {

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
        System.out.println("Before Sorting:" + map);
        sc.close();
        List<Map.Entry<String, Long>> list = new ArrayList<Map.Entry<String, Long>>(map.entrySet());
        Collections.sort(list, new  Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println("After Sorting:" + list);
    }
}
