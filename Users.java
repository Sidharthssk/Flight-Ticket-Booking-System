import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

class Users extends JFrame implements Serializable{

    String username;
    String email;
    String password;
    String phone_number;
    String gender;
    String age;
    String country;
    String relation;

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

    Users(String username, String gender, String age, String relation){
        this.username = username;
        this.gender = gender;
        this.age = age;
        this.relation = relation;
    }

    //for testing change at last
    static Users currentUser = new Users("Raghavan","male");

    int authentication(int opt, Users user) {

        switch (opt) {
            case 1:
                int flag = 0;
                if(user.username.equals("admin") && user.password.equals("admin737")){
                    return 2;
                }
                for (Users tempUser : usersList) {
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
                try(ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(new File("users.txt"),true))){
                    obj.writeObject(user);
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                usersList.add(user);
                return 0;
        }
        return 100;
    }

    // ArrayList for storing user data
    static ArrayList<Users> usersList = new ArrayList<>();

}
