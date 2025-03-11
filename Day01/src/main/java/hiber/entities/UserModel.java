package hiber.entities;

import com.mongodb.lang.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity  // Говорит Hibernate, что это сущность
@Table(name = "users")  // Имя таблицы в БД

@Data // Adds getters, setters, equals, hashcode, toString
//@Getter
//@Setter
// @AllArgsConstructor // Adds constructor with all fields
@NoArgsConstructor // Adds constructor with no fields
@RequiredArgsConstructor
public class UserModel {

    @Override
    public int hashCode() {
        return Objects.hash(id, name); // Убедитесь, что все поля корректно обрабатываются
    }

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true,  fetch = FetchType.EAGER)
    private List<PostModel> posts = new ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentModel> comments = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)  // Двусторонняя связь
    @ToString.Exclude
    private UserProfileModel userProfile;

    @Id  // Первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Автоинкремент
    private Long id;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    @NonNull
    private String email;

    @Column(name = "password", nullable = false)
    @NonNull
    private String password;
}
