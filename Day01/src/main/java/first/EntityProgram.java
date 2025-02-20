package first;

import first.entities.MyFirstUser;

public class EntityProgram {

    public static void main(String[] args) {
        MyFirstUser user = new MyFirstUser();
        user.setName("John");
        System.out.println(user);
    }
}
