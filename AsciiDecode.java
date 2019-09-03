package Kattis;

public class AsciiDecode {
    public static void main(String[] args){
        String ascii = "84114117116104326510811997121115328710511011532";
        decodeHelper(ascii.toCharArray(),0,new StringBuilder());
    }

    private static void decodeHelper(char[] ascii, int ind, StringBuilder sb){
        if(ind == ascii.length){
            System.out.println(sb);
            return;
        }else{
            if(ind+2 <= ascii.length) {
                int ind2 = Character.getNumericValue(ascii[ind])*10+Character.getNumericValue(ascii[ind+1]);
                if((ind2 >=65 && ind2 <= 90) || (ind2 >= 97 && ind2 <= 99) || ind2==32){
                    sb.append((char)ind2);
                    decodeHelper(ascii,ind+2, sb);
                    sb.setLength(sb.length()-1);
                }
            }else{
                return;
            }
            if(ind+3 <= ascii.length){
                int ind3 = Character.getNumericValue(ascii[ind])*100+Character.getNumericValue(ascii[ind+1])*10+Character.getNumericValue(ascii[ind+2]);
                if(ind3 >= 100 && ind3 <= 122){
                    sb.append((char)ind3);
                    decodeHelper(ascii,ind+3, sb);
                    sb.setLength(sb.length()-1);
                }
            }else{
                return;
            }
        }
    }
}
