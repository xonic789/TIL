package rachelblue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(br.readLine().trim());
            table.put(key, table.getOrDefault(key, 0) + 1);
        }

        String answer = table.entrySet().stream().filter(e -> e.getValue() == 1)
            .sorted(Comparator.comparingInt(
                Entry::getKey)).map(Entry::getKey).map(String::valueOf).collect(Collectors.joining(" "));

        System.out.println(answer);
    }

    public void test() {

    }

}
