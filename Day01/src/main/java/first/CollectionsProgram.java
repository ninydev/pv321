package first;

import first.entities.MyFirstUser;

public class CollectionsProgram {
    public static void main(String[] args) {

        MyFirstUser user1 = new MyFirstUser("John", 25);
        MyFirstUser user2 = new MyFirstUser("Jane", 30);
        MyFirstUser user3 = new MyFirstUser("Jack", 35);
        MyFirstUser user4 = new MyFirstUser("Jill", 40);

        // Array of MyFirstUser objects
        MyFirstUser[] users = {user1, user2, user3, user4};

        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i]);
        }

        for (MyFirstUser user : users) {
            System.out.println(user);
        }



    }
}
