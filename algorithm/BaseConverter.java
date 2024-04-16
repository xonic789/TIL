package algorithm;


//바이트 진법 변환 클래스
// 2 -> 10
// 10 -> 2
// 
public class BaseConverter {

    // convert binary to decimal
    private int bin2Dec(String s){
        int a = 128;
        int dec = 0;
        for (int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            dec += a * (tmp - '0');
            a /= 2;
        }
        return dec;
    }

    // convert decimal to binaryString
    public String dec2bin(int dec){
        String bin = "";
        int a = 128;
        int tag = 0;
        // 1바이트 이진수로 나누기!
        while (a > 0){
            // a 로 나눈 몫을 태그로 사용.
            tag = dec / a;
            // 앞에서 부터 채워나가기 때문에, bin + tag를 해준다.
            bin = bin + tag;

            // 이미 나눠 몫을 사용했기 때문에 나머지 연산하여 dec에 저장.
            dec %= a;

            // a도 128 -> 64 -> 32 순으로 줄어들어야 하기 때문에 나눠줌.
            a /= 2;
        }
        return bin;
    }

    // covert decimal to hexString
    public String dec2hex(String str){
        int dec = Integer.parseInt(str);
        int bytes = 255;
        String hexNum = "";
        int tag = 0;
        while (bytes != 0){
            tag = dec % 16;
            dec /= 16;
            hexNum = getHexTag(tag) + hexNum;
            bytes /= 16;
        }
        return hexNum;
    }


    // convert binary to hexString
    public String bin2hex(String str){
        int dec = bin2Dec(str);
        int bytes = 255;
        String hexNum = "";
        int tag = 0;
        while (bytes != 0){
            tag = dec % 16;
            dec /= 16;
            hexNum = getHexTag(tag) + hexNum;
            bytes /= 16;
        }
        return hexNum;
    }


    /**
     *
     * @param tag (hex code)
     * @return
     */
    private String getHexTag(int tag){
        String tmp;
        switch (tag){
            case 10:
                tmp = "A";
                break;
            case 11:
                tmp = "B";
                break;
            case 12:
                tmp = "C";
                break;
            case 13:
                tmp = "D";
                break;
            case 14:
                tmp = "E";
                break;
            case 15:
                tmp = "F";
                break;
            default:
                tmp = tag + "";
        }
        return tmp;
    }

    public static void main(String[] args){
        System.out.println(new BaseConverter().dec2bin(1));

    }
}