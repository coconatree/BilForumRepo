package Utility;

public class PasswordValidation {

    public static boolean isValid( String password ){

        boolean hasNum = false;
        boolean hasCap = false;
        boolean hasLow = false;
        char c ;

        if ( password.length() < 8 || password.length() > 20  )
            return false ;
        if ( !password.matches( "[A-Za-z1-9]+"))
            return false;

        for ( int i = 0 ; i < password.length() ; i++)
        {
            c = password.charAt(i) ;
            if ( Character.isUpperCase( c ))
                hasCap = true ;
            else if ( Character.isLowerCase( c ))
                hasLow = true ;
            else if (Character.isDigit( c ))
                hasNum = true ;
            if ( hasCap && hasLow && hasNum)
                return true ;
        }
        return false ;
    }
}
