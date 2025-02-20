package first.entities;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class MyFirstUser {

    @NonNull
    private String name;

    private int age;

}




//    // C#
//    public String name {get; set };
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "MyFirstUser{" +
//                "name='" + name + '\'' +
//                '}';
//    }