
package com.alkemy.challenge.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author alejandro
 */
@Getter
@Setter
public class Mensaje {
    
    private String msj;

    public Mensaje() {
    }

    public Mensaje(String msj) {
        this.msj = msj;
    }
    
    
}
