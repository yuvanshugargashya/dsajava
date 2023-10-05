import java.util.*;
public class string {
    public static void compression(String str){
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<str.length();i++){
            Integer num =1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                num++;
                i++;
            }
            sb.append(str.charAt(i));
            if(num>1){
                sb.append(num.toString());
            }

        }
        System.out.println(sb);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        /*String str = "abcd";
        System.out.println(str);
        String nw = sc.nextLine();
        System.out.println(nw);*/
        StringBuilder sb = new StringBuilder("");
        for(char ch = 'a';ch<='z';ch++){
            if(ch == 'g'){
                continue;
            }
            sb.append(ch);
        }
        //System.out.println(sb);
        String str = "aaabbbbbcccccccdddd";
        compression(str);
        int n = 9;
        
    }
}
