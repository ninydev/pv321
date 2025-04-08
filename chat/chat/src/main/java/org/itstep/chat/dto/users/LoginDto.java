package org.itstep.chat.dto.users;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginDto {

    @Schema(description = "Email must be a valid email address")
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email format")
    private String email;

    @Schema(description = "Password must have from 8 to 32 chars")
    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, max = 32)
    @NotBlank(message = "Password is mandatory")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,32}$",
            message = "Password must include at least one uppercase letter, one lowercase letter, one digit, and one special character")
    private String password;
}
