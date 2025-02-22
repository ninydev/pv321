package files;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// for bin - implements Serializable

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppConfigEntity
{
    public String name;
    public int value;
    public String email;
    public String password;
}
