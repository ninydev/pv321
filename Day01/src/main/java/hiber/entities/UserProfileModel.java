package hiber.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="user_profiles")

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class UserProfileModel {

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
