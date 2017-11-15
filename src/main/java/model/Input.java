package model;

/* проверка того, что введенное значение не является пустой строкой
и не состоит из одних пробелов
 */
public class Input {
    public static boolean correct ( String inputString ) {
        return (( inputString != null )&& ( inputString.trim().length()>0 ));
    }
}
