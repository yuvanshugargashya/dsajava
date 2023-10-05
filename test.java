import java.util.*;
public class test {
    static class student{
        int roll;
        String name;
        public student(int r , String s){
            this.roll = r;
            this.name =s;
        }
    }
    public static String compress(char[] chars) {
        //int i = chars.length;
        StringBuilder sb = new StringBuilder("");
        //int j=0;
        String s = String.valueOf(chars);
        for(int j=0;j<s.length();j++){
            Integer count=1;
            
            if(j<s.length()-1 && s.charAt(j)== s.charAt(j+1) ){
                count++;
                j++;

            }
            sb.append(s.charAt(j));
            if(count>1){
                sb.append(count.toString());
            }
            

        }
        return sb.toString();
        
    }
    public static String compression(String str){
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
        return sb.toString();
    }
    public static void main(String args[]){
        /*ArrayList<student> list = new ArrayList<>();
        list.add(new student(2,"ram"));
        list.add(new student(1,"mohan"));
        list.add(new student(5, "jan"));
        list.add(new student(4, "jak"));
        Collections.sort(list, new Comparator<student>() {
            //@Override
            public int compare(student s1,student s2){
                return s1.roll-s2.roll;

            }
            
        });
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).roll);
        }*/

        /*char ch[] = {'a','a','a','b','b'};
        String s = "aaabb";
        System.out.println(compression(s));*/
        

        int i=4;
        while(i-->=0){
            System.out.println(i);
        }

    }
    
}
