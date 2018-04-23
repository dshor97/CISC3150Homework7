import java.util.Stack;

public class Calculator {

    public static Stack<String> postFixStk = new Stack();

    public static void main(String[] args){
        try {
            String expression = new String();

            String[] s = new String[args.length + 2];
            s[0] = new String("(");
            s[args.length + 1] = new String(")");
            for (int x = 1; x < args.length + 1; x++) {
                s[x] = new String(args[x-1]);
            }

            for (int i = 0; i < s.length; i++) {
                expression += s[i];
            }

            System.out.println(expression);

            makePostfix(s);

            System.out.println(postFixStk);

            System.out.println(solve(postFixStk));
        }catch(Exception e){
            System.out.println(e);
        }


    }

    public static void makePostfix(String [] a) throws LookAtMrAlgebraOverHereException,UserIsADumbassException,IllegalOperationException{
        Stack<String> operations = new Stack();
        Stack<String> temp = new Stack();
        String string = new String();

        for(int i = 0; i < a.length ; i++){

            if(a[i].equals("+") || a[i].equals("-") || a[i].equals("*") || a[i].equals("/") || a[i].equals("%")){
                if(operations.isEmpty()) {
                    operations.add(a[i]);
                }
                else{
                    if(precedence(operations.peek()) > precedence(a[i]) && !operations.peek().equals("(")) {
                        temp.add(operations.pop());
                        operations.add(a[i]);
                    }
                    else{
                        operations.add(a[i]);
                    }
                }
            }
            else if(a[i].equals("(")){
                operations.add(a[i]);
            }
            else if(a[i].equals(")")){
                boolean isPar = false;
                while(!isPar){
                    if(operations.isEmpty()){
                        throw new UserIsADumbassException("There is an extra Parenthesis in your expression.");
                    }
                    if(operations.peek().equals("(")){
                        operations.pop();
                        isPar = true;
                    }
                    else{
                        temp.add(operations.pop());

                    }
                }
            }
            else{
                char[] test = a[i].toCharArray();
                for(int z = 0;z<test.length;z++){
                    if(test[z] == '0' || test[z] == '1' ||test[z] == '2' ||test[z] == '3' ||test[z] == '4' ||test[z] == '5' ||test[z] == '6' ||test[z] == '7' ||test[z] == '8' ||test[z] == '9' || test[z] == '.' || test[z] == '-'){ }
                    else{
                        throw new UserIsADumbassException("There is an illegal term in your expression. \n" +
                                "The illegal term is " + a[i]);
                    }
                }
                temp.add(a[i]);
            }
        }
        while(!temp.isEmpty()){
            postFixStk.add(temp.pop());
        }
        System.out.println("Finished changing to postfix.");

    }

    public static int precedence(String a){
        if(a.equals("+") || a.equals("-")){
            return 0;
        }
        else if(a.equals("*") || a.equals("/")|| a.equals("%")){
            return 1;
        }
        else if(a.equals("(") || a.equals(")")){
            return 2;
        }
        else return -1;
    }

    public static double add(double a, double b){
        return a + b;
    }

    public static double subtract(double a, double b){
        return add(a,b * -1);
    }

    public static double multiply(double a, double b){
        return a * b;
    }

    public static double divide(double a, double b) throws IllegalOperationException{
        if(b == 0.0){
            throw new IllegalOperationException("There is a division by zero in your expression.\n" +
                    "Fix this error to get a result.");
        }
        return a / b;

    }

    public static double modulo(double a, double b) throws IllegalOperationException{
        if(b == 0.0){
            throw new IllegalOperationException("There is a modulo by zero in your expression.\n" +
                "Fix this error to get a result.");
        }
        return a % b;
    }

    public static double solve(Stack<String> a) throws LookAtMrAlgebraOverHereException, IllegalOperationException{
        Stack<String> ans = new Stack();
        Double temp;
        double one;
        double two;
            while (!postFixStk.isEmpty()) {
                if (precedence(a.peek()) == -1) {

                    ans.add(a.pop());
                } else if (a.peek().equals("+")) {
                    a.pop();
                    one = Double.parseDouble(ans.pop());
                    two = Double.parseDouble(ans.pop());
                    temp = add(one, two);
                    ans.add(temp.toString());
                } else if (a.peek().equals("-")) {
                    a.pop();
                    one = Double.parseDouble(ans.pop());
                    two = Double.parseDouble(ans.pop());
                    temp = subtract(two, one);
                    ans.add(temp.toString());
                } else if (a.peek().equals("*")) {
                    a.pop();
                    one = Double.parseDouble(ans.pop());
                    two = Double.parseDouble(ans.pop());
                    temp = multiply(one, two);
                    ans.add(temp.toString());
                } else if (a.peek().equals("/")) {
                    a.pop();
                    one = Double.parseDouble(ans.pop());
                    two = Double.parseDouble(ans.pop());
                    temp = divide(two, one);
                    ans.add(temp.toString());
                } else if (a.peek().equals("%")) {
                    a.pop();
                    one = Double.parseDouble(ans.pop());
                    two = Double.parseDouble(ans.pop());
                    temp = modulo(two, one);
                    ans.add(temp.toString());
                }
            }
            if(ans.size() > 1){
                throw new LookAtMrAlgebraOverHereException("This is an incomplete expression. \n " +
                        "Fix the expression and try again.");
            }
                return Double.parseDouble(ans.pop());
    }
}
