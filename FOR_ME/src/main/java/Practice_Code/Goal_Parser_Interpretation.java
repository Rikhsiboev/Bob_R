package Practice_Code;

public class Goal_Parser_Interpretation {
    public String interpret(String command) {
        String str =command;
        str= str.replace("()","o");
        str= str.replace(")","");
        str= str.replace("(","");
        return  str;
    }
}
