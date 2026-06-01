package model;

public class User {

    private String userId;
    private String fullName;
    private String username;
    private String password;
    private String role;
    
   

    // Constructor
    public User(String userId,
                String fullName,
                String username,
                String password,
                String role)
    {
        this.userId = userId;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // Setters
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {

        String hiddenPassword = "";

        for(int i = 0;
            i < 8;
            i++)
        {
            hiddenPassword += "*";
        }

        return "User [userId="
                + userId
                + ", fullName="
                + fullName
                + ", username="
                + username
                + ", password="
                + hiddenPassword
                + ", role="
                + role
                + "]";
    }
}