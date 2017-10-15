//( ( 2 * 32 ) - 23 + 6 / 3 + 12 % 2 )

import java.util.Stack;

public class Calculator {

    public static Stack<String> postFixStk = new Stack();

    public static void main(String[] args){
        String expression = new String();

        String[] s = new String[args.length];
        for(int x = 0; x<args.length;x++){
            s[x] = new String(args[x]);
        }
    /*
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

        */
        for(int i = 0; i < s.length; i++){
            expression += s[i];
        }

        System.out.println(expression);

        makePostfix(s);

        System.out.println(postFixStk);

        System.out.println(solve(postFixStk));


    }

    public static void makePostfix(String [] a){
        Stack<String> operations = new Stack();
        Stack<String> temp = new Stack();

        for(int i = 0; i < a.length ; i++){
            if(a[i] == "+" || a[i] == "-" || a[i] == "*" || a[i] == "/" || a[i] == "%"){
                if(operations.isEmpty()) {
                    operations.add(a[i]);
                }
                else{
                    if(precedence(operations.peek()) > precedence(a[i]) && operations.peek() != "(") {
                        temp.add(operations.pop());
                        operations.add(a[i]);
                    }
                    else{
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
                        temp.add(operations.pop());

                    }
                }
            }
            else{
                temp.add(a[i]);
            }
        }
        while(!temp.isEmpty()){
            postFixStk.add(temp.pop());
        }
        System.out.println("Finished changing to postfix.");

    }

    public static int precedence(String a){
        if(a == "+" || a == "-"){
            return 0;
        }
        else if(a == "/" || a == "*" || a == "%"){
            return 1;
        }
        else if(a == "("){
            return 2;
        }
        else{
            return -1;
        }
    }

    public static double add(double a, double b){
        return a + b;
    }

    public static double subtract(double a, double b){
        return a - b;
    }

    public static double multiply(double a, double b){
        return a * b;
    }

    public static double divide(double a, double b) throws Exception{
        if(b == 0.0){
            throw new IllegalOperationException();
        }
        return a / b;

    }

    public static double modulo(double a, double b){
        return a % b;
    }

    public static double solve(Stack<String> a){
        Stack<String> ans = new Stack();
        Double temp;
        double one;
        double two;
        try {
            while (!postFixStk.isEmpty()) {
                if (precedence(a.peek()) == -1) {
                    ans.add(a.pop());
                } else if (a.peek() == "+") {
                    a.pop();
                    one = Double.parseDouble(ans.pop());
                    two = Double.parseDouble(ans.pop());
                    temp = add(one, two);
                    ans.add(temp.toString());
                } else if (a.peek() == "-") {
                    a.pop();
                    one = Double.parseDouble(ans.pop());
                    two = Double.parseDouble(ans.pop());
                    temp = subtract(two, one);
                    ans.add(temp.toString());
                } else if (a.peek() == "*") {
                    a.pop();
                    one = Double.parseDouble(ans.pop());
                    two = Double.parseDouble(ans.pop());
                    temp = multiply(one, two);
                    ans.add(temp.toString());
                } else if (a.peek() == "/") {
                    a.pop();
                    one = Double.parseDouble(ans.pop());
                    two = Double.parseDouble(ans.pop());
                    temp = divide(two, one);
                    ans.add(temp.toString());
                } else if (a.peek() == "%") {
                    a.pop();
                    one = Double.parseDouble(ans.pop());
                    two = Double.parseDouble(ans.pop());
                    temp = modulo(two, one);
                    ans.add(temp.toString());
                }
            }
                return Double.parseDouble(ans.pop());
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
