package util;

import java.security.MessageDigest;

public class PasswordUtil {

    public static String encryptPassword(
            String password)
    {
        try {

            MessageDigest md =
                    MessageDigest.getInstance(
                            "SHA-256"
                    );

            byte[] hashBytes =
                    md.digest(
                            password.getBytes()
                    );

            StringBuilder sb =
                    new StringBuilder();

            for(byte b : hashBytes)
            {
                sb.append(
                        String.format(
                                "%02x",
                                b
                        )
                );
            }

            return sb.toString();
        }

        catch(Exception e)
        {
            System.out.println(
                    "Password Encryption Failed"
            );

            return null;
        }
    }
}