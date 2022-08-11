
package com.alkemy.challenge.controller;

import com.alkemy.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.service.PeliculaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alejandro
 */

@RestController
@RequestMapping("peliculas")
public class PeliculaController {
    
    
    @Autowired
    PeliculaService peliService;
    
   @PostMapping
    public ResponseEntity<PeliculaDTO> save(@RequestBody PeliculaDTO dto){ 
        PeliculaDTO guardardto = peliService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardardto);
    }
    
    
    @GetMapping
    public ResponseEntity<List<PeliculaDTO>> findAll(){
        
        List<PeliculaDTO> personajes = peliService.getAllPeliculas();
        return ResponseEntity.status(HttpStatus.CREATED).body(personajes);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.peliService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    
}
