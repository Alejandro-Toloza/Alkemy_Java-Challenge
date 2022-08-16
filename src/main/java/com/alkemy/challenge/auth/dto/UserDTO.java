
package com.alkemy.challenge.auth.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author alejandro
 */
@Data
public class UserDTO {
    @Email(message = "Username must be an email")
    private String userName;
    @Size(min = 8)
    private String password;
}
