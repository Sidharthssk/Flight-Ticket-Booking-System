import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

class Users extends JFrame {

    String username;
    String email;
    String password;
    String phone_number;
    String gender;
    String age;
    String country;

    // Constructor for User
    Users(String username, String email, String password, String phone_number, String gender, String age,
            String country) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.gender = gender;
        this.age = age;
        this.country = country;
    }

    Users() {

    }

    Users(String username,String password){
        this.username = username;
        this.password = password;
    }

    //temporary constructor last kalayanam
    Users(String username, String gender, String age){
        this.username = username;
        this.gender = gender;
        this.age = age;
    }

    //for testing change at last
    static Users currentUser = new Users("Raghavan","male","69");

    static int authentication(int opt, Users user) {

        switch (opt) {
            case 1:
                int flag = 0;
                for (Users tempUser : users) {
                    if (tempUser.username.equals(user.username)) {
                        flag = 1;
                        currentUser = tempUser;
                    }
                }
                if (flag == 0) {
                    return 1;
                }
                if(user.username.equals(currentUser.username) && user.password.equals(currentUser.password)){
                    return 0;
                }
                else{
                    return -1;
                }

            case 2:
                users.add(user);
                return 0;
        }
        return 100;
    }

    // ArrayList for storing user data
    static ArrayList<Users> users = new ArrayList<>();

}
