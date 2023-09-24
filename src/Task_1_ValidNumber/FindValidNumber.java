package Task_1_ValidNumber;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/*public class FindValidNumber {
    public void number(String fileName) throws IOException {

        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        String s = br.readLine();
        while (s!=null){
            format1(s);
            format2(s);
            s = br.readLine();
        }
    }
    private static void format1(String g){
        char [] ch= g.toCharArray();
        boolean b = false;
        boolean y = ch[0] == '(' || ch[4] == ')' || ch[5] == ' ' || ch[9] == '-';

        if (ch.length==14){
            for (int i = 0; i < ch.length; i++) {
                if  (i==0||i==4||i==5||i==9){
                    continue;
                }
                if ((byte)ch[i]>47&&(byte)ch[i]<58){
                    b=true;
                } else {
                    b=false;
                    break;
                }
            }
            if (y&&b){
                System.out.println(g);
            }
        }
    }
    private static void format2(String g){
        char [] ch= g.toCharArray();
        boolean b = false;
        boolean y = ch[3] == '-' && ch[7] == '-';

        if (ch.length==12){
            for (int i = 0; i < ch.length; i++) {
                if  (i==3||i==7){
                    continue;
                }
                if ((byte)ch[i]>47&&(byte)ch[i]<58){
                    b=true;
                } else {
                    b=false;
                    break;
                }
            }
            if (b&&y){
                System.out.println(g);
            }
        }
    }
}*/
public class FindValidNumber {
    public void numberWithRegEx(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String s;
        Pattern pattern = Pattern.compile("(\\(\\d{3}\\)|\\d{3})(\\s|-)\\d{3}-\\d{4}");
        while ((s = bufferedReader.readLine()) != null) {
            if (pattern.matcher(s).matches()) {
                System.out.println(s);
            }
        }
    }
}