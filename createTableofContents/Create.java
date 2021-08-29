package createTableofContents;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Create {

    public static void main(String[] args) throws IOException {
        File file = new File("md.md");
        List<String> list = new ArrayList<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
        while (true){
            String line = br.readLine();

            if (line == null){
                break;
            }

            list.add(line);
        }

        System.out.println(list);

    }
}
