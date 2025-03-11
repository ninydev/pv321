package hiber.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "comments")
public class CommentModel {

    @Id  // Первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Автоинкремент
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)  // Внешний ключ на posts
    private PostModel post;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private UserModel author;
}
