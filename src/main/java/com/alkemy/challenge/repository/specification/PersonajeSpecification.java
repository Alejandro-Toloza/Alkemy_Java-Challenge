
package com.alkemy.challenge.repository.specification;

import com.alkemy.challenge.dto.PersonajeFilterDTO;
import com.alkemy.challenge.entity.PeliculaEntity;
import com.alkemy.challenge.entity.PersonajeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;


/**
 *
 * @author alejandro
 */
@Component
public class PersonajeSpecification {
    
    public Specification<PersonajeEntity> getByFilters(PersonajeFilterDTO filtersDTO){
        return (root, query, criteriaBuilder) -> {
            
            List<Predicate> predicates = new ArrayList<>();
            
            if(StringUtils.hasLength(filtersDTO.getNombre())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("nombre")),
                                "%" + filtersDTO.getNombre().toLowerCase() + "%"
                                )
                );
            }
            
            if(StringUtils.hasLength(filtersDTO.getImagen())){
                predicates.add(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("imagen")),
                                "%" + filtersDTO.getImagen().toLowerCase() + "%"
                                )
                );
            }
            
            if(!CollectionUtils.isEmpty(filtersDTO.getPeliculas())){
                Join<PeliculaEntity, PersonajeEntity> join = root.join("peliculas", JoinType.INNER);
                Expression<String> peliculasId = join.get("id");
                predicates.add(peliculasId.in(filtersDTO.getPeliculas()));
            }
            
            
            
            query.distinct(true);
            
            String orderByField = "nombre";
            
            query.orderBy(filtersDTO.isASC() ? 
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
                    );
            
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            
        };
        
        
    }
    
}
