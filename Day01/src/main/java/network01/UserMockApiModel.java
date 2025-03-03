package network01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMockApiModel {
        private String createdAt;
        private String name;
        private String avatar;
        private String email;
        private String id;
}
