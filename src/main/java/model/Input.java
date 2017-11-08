package model;

/**
 * Created by Seyvach Serg on 08.11.2017.
 */
public class Input {
    public static boolean correct ( String inputString ) {
        return (( inputString != null )&& ( inputString.trim().length()>0 ));
    }
}
