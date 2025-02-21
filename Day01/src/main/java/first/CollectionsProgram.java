package first;

import first.entities.MyFirstUser;

import java.util.*;

public class CollectionsProgram {
    public static void main(String[] args) {

        MyFirstUser user1 = new MyFirstUser("Yana", 8);
        MyFirstUser user2 = new MyFirstUser("Vova", 2);
        MyFirstUser user3 = new MyFirstUser("Alex", 7);
        MyFirstUser user4 = new MyFirstUser("Jill", 4);
        MyFirstUser user5 = new MyFirstUser("Viola", 5);
        MyFirstUser user6 = new MyFirstUser("Mikolay", 6);
        MyFirstUser user7 = new MyFirstUser("Felix", 3);
        MyFirstUser user8 = new MyFirstUser("Done", 1);

        Map<String, MyFirstUser> usersByName = new TreeMap<>();

        usersByName.put(user1.getName(), user1);
        usersByName.put(user2.getName(), user2);
        usersByName.put(user3.getName(), user3);
        usersByName.put(user4.getName(), user4);
        usersByName.put(user5.getName(), user5);
        usersByName.put(user6.getName(), user6);
        usersByName.put(user7.getName(), user7);
        usersByName.put(user8.getName(), user8);

        Map<Integer, MyFirstUser> usersByAge = new TreeMap<>();
        usersByAge.put(user1.getAge(), user1);
        usersByAge.put(user2.getAge(), user2);
        usersByAge.put(user3.getAge(), user3);
        usersByAge.put(user4.getAge(), user4);
        usersByAge.put(user5.getAge(), user5);
        usersByAge.put(user6.getAge(), user6);
        usersByAge.put(user7.getAge(), user7);
        usersByAge.put(user8.getAge(), user8);

        System.out.println("By name: ");
        for (Map.Entry<String, MyFirstUser> entry : usersByName.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        System.out.println("By Age: ");
        for (Map.Entry<Integer, MyFirstUser> entry : usersByAge.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }


//        ArrayDeque<MyFirstUser> users = new ArrayDeque<>();
//
//
//        users.add(user4);
//        users.add(user2);
//        users.add(user3);
//        users.add(user1);
//
//        users.pop();

//        Stack<MyFirstUser> users = new Stack<>();
//
//        users.push(user4);
//        users.push(user2);
//        users.push(user3);
//        users.push(user1);

//        ArrayList<MyFirstUser> users = new ArrayList<>();
//
//        users.add(user4);
//        users.add(user2);
//        users.add(user3);
//        users.add(user1);



    }


    private void arrayExample() {
//        // Array of MyFirstUser objects
//        MyFirstUser[] users = {user1, user2, user3, user4};
//
////        Arrays.stream(users)
////                .sorted()
////                .forEach(System.out::println);
//
//        String searchName = "Vova";
//
//        for (int i = 0; i < users.length; i++) {
//            if (users[i].getName().equals(searchName)) {
//                System.out.println("Found user: " + i + " => " + users[i]);
//                break;
//            }
//            System.out.println(users[i]);
//        }
//
////        for (MyFirstUser user : users) {
////            System.out.println(user);
////        }
    }
}
