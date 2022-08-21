package com.alkemy.challenge.repository.specification;

import com.alkemy.challenge.dto.PeliculaFilterDTO;
import com.alkemy.challenge.entity.PeliculaEntity;
import com.alkemy.challenge.entity.PersonajeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
@Component
public class PeliculaSpecification {
    public Specification<PeliculaEntity> getByFilters(PeliculaFilterDTO filtersDTO){
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.hasLength(filtersDTO.getTitulo())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("titulo")),
                                "%" + filtersDTO.getTitulo().toLowerCase() + "%"
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

            if(!CollectionUtils.isEmpty(filtersDTO.getPersonajes())){
                Join<PersonajeEntity, PeliculaEntity> join = root.join("personajes", JoinType.INNER);
                Expression<String> personajesId = join.get("id");
                predicates.add(personajesId.in(filtersDTO.getPersonajes()));
            }



            query.distinct(true);

            String orderByField = "titulo";

            query.orderBy(filtersDTO.isASC() ?
                    criteriaBuilder.asc(root.get(orderByField)) :
                    criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };


    }
}
