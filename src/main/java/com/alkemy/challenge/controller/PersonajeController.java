
package com.alkemy.challenge.controller;

import com.alkemy.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.service.PersonajeService;
import java.util.List;
import java.util.Set;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alejandro
 */
@RestController
@RequestMapping("characters")
public class PersonajeController {
    
    @Autowired
    PersonajeService personajeService;
    
    @GetMapping("/{id}")
    public ResponseEntity<PersonajeDTO> getDetailsById(@PathVariable Long id){
        PersonajeDTO dto = this.personajeService.getDetailsById(id);
        return ResponseEntity.ok(dto);
    }
    
    @GetMapping()
    public ResponseEntity<List<PersonajeDTO>> getDetailsByFilters(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String imagen,
            @RequestParam(required = false) Set<Long> peliculas,
            @RequestParam(required = false, defaultValue = "ASC") String order
            ){
        List<PersonajeDTO> personajes = this.personajeService.getByFilters(nombre, imagen, peliculas, order);
        return ResponseEntity.ok(personajes);
    }
    @PostMapping
    public ResponseEntity<PersonajeDTO> save(@RequestBody PersonajeDTO dto){
        PersonajeDTO guardardto = personajeService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardardto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.personajeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    };

    
    @PutMapping("/{id}")
    public ResponseEntity<PersonajeDTO> update(@PathVariable Long id, @RequestBody PersonajeDTO dto){
        PersonajeDTO result = personajeService.update(id, dto);
        return ResponseEntity.ok().body(result); 
    }
    
    
}
