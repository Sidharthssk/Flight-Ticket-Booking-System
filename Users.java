import java.util.ArrayList;
import java.util.Scanner;

class Users {

    String name;
    String email;
    String password;
    long phone_number;
    String gender;
    String age;
    String country;

    // Constructor for User
    Users(String name, String email, String password, long phone_number, String gender, String age, String country) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.gender = gender;
        this.age = age;
        this.country = country;
    }

    Users() {

    }

    static Users authentication() {
        Scanner sc = new Scanner(System.in);
        Users u = new Users();
        int final_flag = 0;
        while (final_flag == 0) {
            System.out.println();
            System.out.println("1. Login      2. SignUp");
            // switch case for login and signup
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Enter your email");
                    String email1 = sc.next();
                    System.out.println("Enter your password");
                    String password1 = sc.next();
                    int flag = 0;

                    // Takes out the user from the arraylist

                    for (Users user : users) {
                        if (user.email.equals(email1)) {
                            flag = 1;
                            u = user;
                        }
                    }

                    // check if email and password is correct
                    if (flag == 0) {
                        System.out.println("User doesn't exist. Please SignUp ");
                    } 
                    else {
                        if (email1.equals(u.email) && password1.equals(u.password)) {
                            System.out.println("Login Successful");
                            final_flag = 1;
                        } 
                        else {
                            System.out.println("Login Failed. Please check your email and password.");
                        }
                    }

                    break;
                case 2:
                    System.out.println("Enter your name");
                    String name = sc.next();
                    System.out.println("Enter your email");
                    String email = sc.next();
                    System.out.println("Enter your password");
                    String password = sc.next();
                    System.out.println("Enter your phone number");
                    long phone_number = sc.nextLong();
                    System.out.println("Enter your gender");
                    String gender = sc.next();
                    System.out.println("Enter your age");
                    String age = sc.next();
                    System.out.println("Enter your country");
                    String country = sc.next();
                    // create new user
                    Users user = new Users(name, email, password, phone_number, gender, age, country);
                    // add user to arraylist
                    users.add(user);
                    System.out.println("SignUp Successful.");
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
        return u;
    } 

    // ArrayList for storing user data
    static ArrayList<Users> users = new ArrayList<>();

}
