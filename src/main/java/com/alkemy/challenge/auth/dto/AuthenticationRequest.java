
package com.alkemy.challenge.auth.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author alejandro
 */
@Getter
@Setter
public class AuthenticationRequest {
    private String username;
    private String password;
    
}
