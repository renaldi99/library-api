package com.enigma.libraryapi.specifcation;

import com.enigma.libraryapi.dto.MemberSearchDTO;
import com.enigma.libraryapi.entity.Member;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MemberSpecification {
    public static Specification<Member> getSpecification(MemberSearchDTO memberSearchDTO) {
        return new Specification<Member>() {
            @Override
            public Predicate toPredicate(Root<Member> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (!(memberSearchDTO.getSearchByFirstName() == null)) {
                    Predicate memberFirstNamePredicate = criteriaBuilder.like(root.get("firstName"), "%" + memberSearchDTO.getSearchByFirstName().toLowerCase() + "%");
                    predicates.add(memberFirstNamePredicate);
                }
                if (!(memberSearchDTO.getSearchByLastName() == null)) {
                    Predicate memberLastNamePredicate = criteriaBuilder.like(root.get("lastName"), "%" + memberSearchDTO.getSearchByLastName().toLowerCase() + "%");
                    predicates.add(memberLastNamePredicate);
                }
                if (!(memberSearchDTO.getSearchByStatus() == null)) {
                    Predicate memberStatusPredicate = criteriaBuilder.like(root.get("status"), "%" + memberSearchDTO.getSearchByStatus().toLowerCase() + "%");
                    predicates.add(memberStatusPredicate);
                }
                Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicate);
            }
        };
    }
}
