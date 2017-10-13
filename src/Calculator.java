//( 2 * 32 ) - 23 + 6 / 3 + 12 % 2

public class Calculator {
    public static void main(String[] args){
        String equation = new String();

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
            equation += s[i];
        }

        System.out.println(equation);
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
