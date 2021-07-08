package algorithm.Programmers;

public class 캐시 {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int n = cities.length;
        String[] cache = new String[cacheSize];

        for (int i = 0; i < n; i++){

            int pos = -1;
            String city = cities[i].toUpperCase();
            for (int j = 0; j < cacheSize; j++){
                if (cache[j] != null){
                    if (cache[j].equals(city)) pos = j;
                }
            }
            // cache miss
            if (pos == -1){
                answer += 5;
                for (int j = cacheSize - 1; j >= 1; j--){
                    cache[j] = cache[j - 1];
                }
                cache[0] = city;
            }else {
                // cache hit
                answer += 1;
                for (int j = pos; j >= 1; j--){
                    cache[j] = cache[j - 1];
                }
                cache[0] = city;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int cacheSize = 3;

        System.out.println(new 캐시().solution(cacheSize,cities));
    }
}
