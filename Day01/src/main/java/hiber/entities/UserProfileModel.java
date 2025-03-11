package hiber.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name="user_profiles")

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class UserProfileModel {

    @Override
    public int hashCode() {
        return Objects.hash(id, phoneNumber); // Убедитесь, что все поля корректно обрабатываются
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)  // Внешний ключ на таблицу users
    @ToString.Exclude
    private UserModel user;


    @Column(name = "address")
    @NonNull
    private String address;

    @Column(name = "phone_number", unique = true)
    @NonNull
    private String phoneNumber;


}
