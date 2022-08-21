
package com.alkemy.challenge.controller;

import com.alkemy.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.service.PeliculaService;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author alejandro
 */

@RestController
@RequestMapping("movies")
public class PeliculaController {
    
    @Autowired
    PeliculaService peliService;
    
   @PostMapping
    public ResponseEntity<PeliculaDTO> save(@RequestBody PeliculaDTO dto){ 
        PeliculaDTO guardardto = peliService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardardto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> getDetailsById(@PathVariable Long id){
        PeliculaDTO dto = this.peliService.getDetailsById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping()
    public ResponseEntity<List<PeliculaDTO>> getDetailsByFilters(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String genero,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ){
        List<PeliculaDTO> peliculas = this.peliService.getByFilters(titulo, genero, order);
        return ResponseEntity.ok(peliculas);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.peliService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDTO> update(@PathVariable Long id, @RequestBody PeliculaDTO dto){
        PeliculaDTO result = peliService.update(id, dto);
        return ResponseEntity.ok().body(result);
    }

}
