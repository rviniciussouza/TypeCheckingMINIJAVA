public class ErrorMsg {
    public boolean errorFound;

    ErrorMsg() {
        errorFound = false;
    }

    void complain(String msg) {
        errorFound = true;
        System.out.println("Error: " + msg);
    }
}
