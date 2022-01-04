package Model;

import java.io.Serializable;

public class User implements Serializable {
    private String account;
    private String pasword;
    private int role;

    public User(String account, String pasword, int role) {
        this.account = account;
        this.pasword = pasword;
        this.role = role;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", pasword='" + pasword + '\'' +
                ", role=" + role +
                '}';
    }
}
