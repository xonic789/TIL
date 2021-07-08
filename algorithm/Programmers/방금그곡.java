package algorithm.Programmers;

public class 방금그곡 {

    private String[] codes = {"A#", "C#", "D#", "F#", "G#"};
    private String[] change = {"H", "I", "J", "K", "L"};
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m = change(m);

        for (String musicInfo : musicinfos){
            String[] infos = musicInfo.split(",");
            int time = getRunningTime(infos[0].split(":"),infos[1].split(":"));
            String music = infos[2];
            String code = infos[3];
            code = change(code);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < time; i++){
                sb.append(code.charAt(i % code.length()));
            }
            if (sb.toString().indexOf(m) != -1){
                answer = music;
                break;
            }
        }
        if (answer.equals("")){
            return "(None)";
        }


        return answer;
    }

    public String change(String code){
        for (int i = 0; i < codes.length; i++){
            if (code.contains(codes[i])){
                code = code.replace(codes[i],change[i]);
            }
        }
        return code;
    }

    public int getRunningTime(String[] start, String[] end){

        int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
        int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);

        return endTime - startTime;
    }

    public static void main(String[] args) {
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(new 방금그곡().solution("ABC",musicinfos));
    }
}
