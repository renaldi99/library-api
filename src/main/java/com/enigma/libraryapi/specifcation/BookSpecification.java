package com.enigma.libraryapi.specifcation;

import com.enigma.libraryapi.dto.BookSearchDTO;
import com.enigma.libraryapi.entity.Book;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BookSpecification {
    public static Specification<Book> getSpecification(BookSearchDTO bookSearchDTO) {
        return new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (!(bookSearchDTO.getSearchByTitle() == null)) {
                    Predicate bookTitlePredicate = criteriaBuilder.like(root.get("title"), "%" + bookSearchDTO.getSearchByTitle().toLowerCase() + "%");
                    predicates.add(bookTitlePredicate);
                }
                if (!(bookSearchDTO.getSearchByAuthor() == null)) {
                    Predicate bookAuthorPredicate = criteriaBuilder.like(root.get("author"), "%" + bookSearchDTO.getSearchByAuthor().toLowerCase() + "%");
                    predicates.add(bookAuthorPredicate);
                }
                if (!(bookSearchDTO.getSearchByPublisher() == null)) {
                    Predicate bookPublisherPredicate = criteriaBuilder.like(root.get("publisher"), "%" + bookSearchDTO.getSearchByPublisher().toLowerCase() + "%");
                    predicates.add(bookPublisherPredicate);
                }
                Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicate);
            }
        };
    }
}
