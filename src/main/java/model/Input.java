package model;

public class Input {
    public static boolean correct ( String inputString ) {
        return (( inputString != null )&& ( inputString.trim().length()>0 ));
    }
}
