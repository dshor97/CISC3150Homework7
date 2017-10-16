public class UserIsADumbassException extends IllegalArgumentException {
    String message;
    public UserIsADumbassException(){
        System.out.println("UserIsADumbassException was thrown.");
    }
    public UserIsADumbassException(String message){
        System.out.println("UserIsADumbassException was thrown.");
        this.message = message;

    }
    public String toString() {
        String temp = new String();
        temp += message;
        return temp;
    }
}
