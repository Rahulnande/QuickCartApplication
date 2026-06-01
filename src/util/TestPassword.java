package util;

import javax.swing.*;

public class TestPassword {

    public static void main(String[] args) {

        JPasswordField passwordField =
                new JPasswordField();

        int option =
                JOptionPane.showConfirmDialog(
                        null,
                        passwordField,
                        "Enter Password",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );

        if(option ==
                JOptionPane.OK_OPTION)
        {
            String password =
                    new String(
                            passwordField.getPassword()
                    );

            System.out.println(
                    "Password Entered : "
                    + password
            );
        }
    }
}
