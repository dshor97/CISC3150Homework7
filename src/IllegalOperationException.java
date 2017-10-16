public class IllegalOperationException extends IllegalArgumentException {
    private String message;
    public IllegalOperationException(){
        System.out.println("An Illegal operation was performed.");
    }

    public IllegalOperationException(String message){
        System.out.println("An Illegal operation was performed.");
        this.message = message;
    }
    public String toString(){
        String string = new String();
        string += message;
        return string;
    }
}
