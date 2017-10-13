//( 2 * 32 ) - 23 + 6 / 3 + 12 % 2

import java.util.Stack;

public class Calculator {

    public static Stack<String> postFixStk = new Stack();

    public static void main(String[] args){
        String expression = new String();

        String[] s = new String [17];
        s[0] = "(";
        s[1] = "(";
        s[2] = "2";
        s[3] = "*";
        s[4] = "32";
        s[5] = ")";
        s[6] = "-";
        s[7] = "23";
        s[8] = "+";
        s[9] = "6";
        s[10] = "/";
        s[11] = "3";
        s[12] = "+";
        s[13] = "12";
        s[14] = "%";
        s[15] = "2";
        s[16] = ")";

        for(int i = 0; i < s.length; i++){
            expression += s[i];
        }

        System.out.println(expression);

        makePostfix(s);

        System.out.println(postFixStk);

    }

    public static void makePostfix(String [] a){
        Stack<String> operations = new Stack();
        for(int i = 0; i < a.length ; i++){
            if(a[i] == "+" || a[i] == "-" || a[i] == "*" || a[i] == "/" || a[i] == "%"){
                if(operations.isEmpty()) {
                    operations.add(a[i]);
                }
                else{
                    if(precidence(operations.peek()) > precidence(a[i])){
                        postFixStk.add(operations.pop());
                        operations.add(a[i]);
                    }
                }
            }
            else if(a[i] == "("){
                operations.add(a[i]);
            }
            else if(a[i] == ")"){
                boolean isPar = false;
                while(!isPar){
                    if(operations.peek() == "("){
                        operations.pop();
                        isPar = true;
                    }
                    else{
                        postFixStk.add(operations.pop());

                    }
                }
            }
            else{
                postFixStk.add(a[i]);
            }
        }

    }

    public static int precidence(String a){
        if(a == "+" || a == "-"){
            return 1;
        }
        else if(a == "/" || a == "*" || a == "%"){
            return 2;
        }
        else{
            return 0;
        }
    }

    public static void add(double a, double b){

    }

    public static void subtract(double a, double b){

    }

    public static void multiply(double a, double b){

    }

    public static void divide(double a, double b) throws Exception{
        if(b == 0.0){
            throw new IllegalOperationException();
        }

    }

    public static void modulo(double a, double b){

    }

    public static void perenthasis(){

    }
}
