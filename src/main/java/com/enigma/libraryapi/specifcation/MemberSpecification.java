package com.enigma.libraryapi.specifcation;

import com.enigma.libraryapi.dto.MemberSearchDTO;
import com.enigma.libraryapi.entity.Member;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
                if (!(memberSearchDTO.getSearchByDateOfBirth() == null)) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String modifiedDateFormated = simpleDateFormat.format(memberSearchDTO.getSearchByDateOfBirth());

                    Predicate createDatePredicate = criteriaBuilder.equal(criteriaBuilder.function("TO_CHAR", String.class, root.get("dateOfBirth"),
                            criteriaBuilder.literal("yyyy-MM-dd")), modifiedDateFormated);
                    predicates.add(createDatePredicate);
                }
                Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicate);
            }
        };
    }
}
