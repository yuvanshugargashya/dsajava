import java.util.Stack;
public class stack2 {
    public static void reversestring(String str ){
        Stack<Character> st = new Stack<>();
        int idx = 0;
        while(idx<str.length()){
            st.push(str.charAt(idx));
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }

        str = sb.toString();
        System.out.println(str);
    }
    public static void stockspan(int stock[] , int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for(int i =1;i<stock.length;i++){
            int currprice = stock[i];
            while(!s.isEmpty() && currprice > stock[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevhigh = s.peek();
                span[i] = i-prevhigh;
            }

            s.push(i);
        }


    }
    public static boolean istrue(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '[' || ch == '{' || ch == '('){
                s.push(ch);
            }
            else{
                if(s.isEmpty()){
                    return false;
                }
                if((ch == ')' && s.peek() == '(') || (ch == '}' && s.peek() == '{') || (ch == ']' && s.peek() == '[') ){
                    s.pop();
                }
                else{
                    return false;
                }
            }

        }
        if(s.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean duplicate(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(ch == ')'){
                int count = 0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count <1){
                    return true;
                }
                else{
                    s.pop();
                }

            }
            else{
                s.push(ch);
            }

        }
        return false;
    }
    public static void maxareahist(int arr[]){
        int maxarea= 0;
        int nextsml[] = new int[arr.length];
        int nextsmr[] = new int[arr.length];

        Stack<Integer> s = new Stack<>();

        for(int i = arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextsmr[i] = arr.length;
            }
            else{
                nextsmr[i] = s.peek();
            }
            s.push(i);
        }

        s = new Stack<>();

         for(int i = 0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextsml[i] = -1;
            }
            else{
                nextsml[i] = s.peek();
            }
            s.push(i);
        }

        for(int i=0;i<arr.length;i++){
            int height = arr[i];
            int width = nextsmr[i] - nextsml[i] - 1;
            int currarea = height*width;

            maxarea = Math.max(currarea , maxarea);
        }
        System.out.println(maxarea);

    }
    public static void directorypath(String str){
        Stack<String> s = new Stack<>();
        String res= "/";
        for(int i=0;i<str.length();i++){
            String dir = "";
            while(i<str.length() && str.charAt(i)=='/'){
                i++;
            }
            while(i<str.length() && str.charAt(i) != '/'){
                dir += str.charAt(i);
                i++;
            }
            if(dir.equals("..")==true){
                if(!s.isEmpty()){
                    s.pop();

                }
                
            }
            if(dir.equals(".")==true){
                continue;
            }
            else if(dir.length() != 0){
                s.push(dir);
            }
        }
        Stack<String> s2 = new Stack<>();
        while(!s.isEmpty()){
            s2.push(s.pop());
        }
        while(!s2.isEmpty()){
            if(s2.size() != 1){
                res+= s2.pop()+"/";
            }
            else{
                res+=s2.pop();
            }
        }

        System.out.println(res);
    }
    
    public static void main(String args[]){
        //Stack<Character> st = new Stack<>();
        //reversestring("abc");
        /*Stack<Integer> st  = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        reversestack(st);
        //System.out.println(st);

        while(!st.empty()){
            System.out.println(st.peek());
            st.pop();
        }*/



        /*int stock[] = {100,80,60,70,60,85,100};
        int span[] = new int[stock.length];
        stockspan(stock, span);
        for(int i=0;i<span.length;i++){
            System.out.print(span[i]);
        }*/
        /*int arr[] = {6,8,0,1,2,3};
        Stack<Integer> s = new Stack<>();
        int nextgreater[]  = new int[arr.length];

        for(int i = arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextgreater[i] = -1;
            }
            else{
                nextgreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        //smaller left , cond reverse
        //on left side , loop reverse

        for(int i=0;i<nextgreater.length;i++){
            System.out.print(nextgreater[i]);
        }
        System.out.println();*/
        //String str= "({})[]]";
        //System.out.println(istrue(str));
        //System.out.println(duplicate("(a+b)"));
        //System.out.println(duplicate("((a+b))"));
        int hist[] = {2,1,5,6,2,3};
        maxareahist(hist);

    }
    
}
