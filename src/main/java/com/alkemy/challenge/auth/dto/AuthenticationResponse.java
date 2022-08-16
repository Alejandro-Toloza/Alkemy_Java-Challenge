
package com.alkemy.challenge.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author alejandro
 */
@Getter
@Setter
@AllArgsConstructor
public class AuthenticationResponse {
    private String jwt;
}
