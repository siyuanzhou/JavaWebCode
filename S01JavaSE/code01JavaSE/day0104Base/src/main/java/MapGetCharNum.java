import java.util.HashMap;
import java.util.Scanner;

public class MapGetCharNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        HashMap<Character, Integer> map = getCharNum(line);
        System.out.println(map);
    }

    public static HashMap<Character, Integer> getCharNum(String line) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, count + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
