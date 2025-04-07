package org.itstep.chat.dto.users;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto{
    @Schema(description = "Name must have from 8 to 32 chars")
    @Size(min = 8, max = 32)
    @NotBlank(message = "Name is mandatory")
    private String username;

    @Schema(description = "Email must be a valid email address")
    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Schema(description = "Name must have from 8 to 32 chars")
    @Size(min = 8, max = 32)
    @NotBlank(message = "Password is mandatory")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,32}$", message = "Password must include at least one uppercase letter, one lowercase letter, one digit, and one special character")
    private String password;
}
