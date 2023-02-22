package Bob.R.solid.singleResponsibility.example.good;

public class SecurityFilter {

    public static boolean authenticate() {
        // Check authentication
        return true;
    }

    public static boolean authorization() {
        // Check authorization
        return true;
    }

}
