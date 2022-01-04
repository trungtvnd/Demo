package View;

import Controller.UserManagement;
import Model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMain {
    public  void userMain() {
        UserManagement userManagement = new UserManagement();
        Scanner sc = new Scanner(System.in);

        int choice;
        do{
            System.out.println("-------------------\n");
            System.out.println("============MENU============");
            System.out.println("" +
                    "1. Add User\n" +
                    "2. Display user\n" +
                    "3. Read data user\n" +

                    "");
            System.out.println("In put your choice: ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    userManagement.createUser(sc);
                    break;
                case 2:
                    userManagement.displayUser();
                    break;
                case 3:
                    ArrayList<User> userArrayList = userManagement.readUserFile(UserManagement.PATH_NAME_USER);
//                    userArrayList.forEach(System.out::println);
                    break;

            }
    }while (choice!=0);
}}
