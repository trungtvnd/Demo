package Controller;


import java.util.Scanner;

public class Login {
    public Login() {
    }



    public  boolean loginSystem(){
        Scanner sc = new Scanner(System.in);
        UserManagement userManagement = new UserManagement();
        System.out.println("Nhập Account"); String acc = sc.nextLine();
        System.out.println("Nhập psw: "); String psw = sc.nextLine();
        for (int i = 0; i < userManagement.userArrayList.size(); i++) {
            if(acc.equals(userManagement.userArrayList.get(i).getAccount()) && psw.equals(userManagement.userArrayList.get(i).getPasword()) && userManagement.userArrayList.get(i).getRole() == 3){
                System.out.println("Đăng nhập thành công, bạn là admin");
                return true;
            }
        }return  false;

    }
}
