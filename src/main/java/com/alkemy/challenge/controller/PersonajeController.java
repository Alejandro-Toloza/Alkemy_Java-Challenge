
package com.alkemy.challenge.controller;

import com.alkemy.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.service.PersonajeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alejandro
 */
@RestController
@RequestMapping("personajes")
public class PersonajeController {
    
    @Autowired
    PersonajeService personajeService;

    
    @GetMapping("/{id}")
    public ResponseEntity<PersonajeDTO> getDetailsById(@PathVariable Long id){
        PersonajeDTO dto = this.personajeService.getDetailsById(id);
        return ResponseEntity.ok(dto);
    }
    
    
    @PostMapping
    public ResponseEntity<PersonajeDTO> save(@RequestBody PersonajeDTO dto){
        
        PersonajeDTO guardardto = personajeService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardardto);
    }
    
    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> findAll(){
        
        List<PersonajeDTO> personajes = personajeService.getAllPersonajes();
        return ResponseEntity.status(HttpStatus.CREATED).body(personajes);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.personajeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    
    /*@PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id){
        PersonajeDTO dtoTraer = personajeService.getOne(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoTraer); 
    }
    */
    
}
