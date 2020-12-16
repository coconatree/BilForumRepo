package Utility;

import APIConnection.APIConnection;

import java.io.IOException;

public class EmailConfirmation
{
    private static final String GET_EMAIl_CODE_URL = "http://localhost:8080/mail/";

    /*******************************************************************************************/

    private String code;

    /*******************************************************************************************/

    public void setCode(String email)
    {
        /**
         * try
         *         {
         *             // this.code = APIConnection.sendGET(String.format("%s/%s", GET_EMAIl_CODE_URL, email)).body().toString();
         *         }
         *         catch (IOException e)
         *         {
         *             e.printStackTrace();
         *         }
         *         catch (InterruptedException e)
         *         {
         *             e.printStackTrace();
         *         }*/
    }

    /*******************************************************************************************/

    public boolean emailConfirmation(String userEnteredCode)
    {
        return (this.code.equals(userEnteredCode)) ? true : false;
    }
}
