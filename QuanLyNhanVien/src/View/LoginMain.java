package View;

import Controller.Login;

import java.util.Scanner;

public class LoginMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login login = new Login();
        if(login.loginSystem()){
            System.out.println("Bạn đã đăng nhập thành công");
            System.out.println("Input your choice");
            int choice;
            do {
                System.out.println("1. Quản lý user");
                System.out.println("2, Quản lý thông tin");
                System.out.println("3. Exit");
                choice = sc.nextInt();
                switch (choice){
                    case 1:
                        UserMain userMain = new UserMain();
                        userMain.userMain();
                        break;
                    case 2:
                        MainStudent mainStudent = new MainStudent();
                        mainStudent.studentMain();
                        break;
                }
            }while (choice!=0);
        }
    }
}
