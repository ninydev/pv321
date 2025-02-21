package first;

import first.entities.MyFirstUser;

import java.util.Map;
import java.util.TreeMap;

public class MyFirstUserRepository {
    private final Map<String, MyFirstUser> usersByName = new TreeMap<>();
    private final Map<Integer, MyFirstUser> usersByAge = new TreeMap<>();

    public void put(MyFirstUser user) {
        usersByName.put(user.getName(), user);
        usersByAge.put(user.getAge(), user);
    }

    public void remove(MyFirstUser user) {
        usersByName.remove(user.getName());
        usersByAge.remove(user.getAge());
    }

    public void removeByName(String name) {
        MyFirstUser user = usersByName.get(name);
        usersByName.remove(name);
        usersByAge.remove(user.getAge());
    }

    public void removeByAge(int age) {
        MyFirstUser user = usersByAge.get(age);
        usersByAge.remove(age);
        usersByName.remove(user.getName());
    }


}
