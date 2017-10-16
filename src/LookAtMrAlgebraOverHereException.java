public class LookAtMrAlgebraOverHereException extends IllegalArgumentException {
    private String message;

    public LookAtMrAlgebraOverHereException(){
        System.out.println("LookAtMrAlgebraOverHereException was thrown.");
    }
    public LookAtMrAlgebraOverHereException(String message){
        System.out.println("LookAtMrAlgebraOverHereException was thrown.");
        this.message = message;
    }

    public String toString() {
        String temp = new String();
        temp += message;
        return temp;
    }
}
