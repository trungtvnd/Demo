package Controller;

import Model.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManagement {
    public static final String PATH_NAME_USER = "C:\\TRUNGTV\\HOC TAP\\JAVA\\TUHOC\\QuanLyNhanVien\\src\\Data\\saveUser.txt";
    ArrayList<User> userArrayList = new ArrayList<>();

    public UserManagement() {
        this.userArrayList = readUserFile(PATH_NAME_USER);
    }
    public void createUser(Scanner sc){
        sc.nextLine();
        System.out.println("Input Account name: "); String acc = sc.nextLine();
        System.out.println("Input password: "); String psw = sc.nextLine();
        System.out.println("Input Role: (1/2/3)"); int role = sc.nextInt();
        User user = new User(acc, psw, role);
        userArrayList.add(user);
        writeUserToFile(PATH_NAME_USER);
    }

    public void displayUser(){
        for (User user:userArrayList) {
            System.out.println(user);
        }
    }


    public void writeUserToFile(String path){
        File file = new File(path);
        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for (User user :userArrayList) {
                oos.writeObject(user);
            }
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<User> readUserFile(String path){
        File file = new File(path);
        try {

            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            User user;
            while (true){
                Object obj = ois.readObject();
                if(obj == null){
                    break;
                }else {
                    user = (User) obj;
                    userArrayList.add(user);
                }
            }

            ois.close();
        } catch (Exception e) {
            System.err.println();
        }return userArrayList;
    }
}
