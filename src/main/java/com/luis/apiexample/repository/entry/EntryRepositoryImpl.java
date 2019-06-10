package com.luis.apiexample.repository.entry;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.luis.apiexample.model.Entry;
import com.luis.apiexample.model.Entry_;
import com.luis.apiexample.repository.EntryFilter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

public class EntryRepositoryImpl implements EntryRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Entry> filter(EntryFilter entryFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Entry> criteria = builder.createQuery(Entry.class);
        Root<Entry> root = criteria.from(Entry.class);

        Predicate[] predicates = createRestrictions(entryFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Entry> query = manager.createQuery(criteria);
        addRestrictionsOfPagination(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(entryFilter));
    }

    private Predicate[] createRestrictions(EntryFilter entryFilter, CriteriaBuilder builder, Root<Entry> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(entryFilter.getDescription())) {
            predicates.add(builder.like(builder.lower(root.get(Entry_.description)), "%" + entryFilter.getDescription().toLowerCase() + "%"));
		}
		
		if (entryFilter.getdueDateFrom() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get(Entry_.dueDate), entryFilter.getdueDateFrom()));
		}
		
		if (entryFilter.getdueDateTo() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get(Entry_.dueDate), entryFilter.getdueDateTo()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
    }
    
    private void addRestrictionsOfPagination(TypedQuery<Entry> query, Pageable pageable) {
        int currentPage = pageable.getPageNumber();
		int totalPerPage = pageable.getPageSize();
		int firstPage = currentPage * totalPerPage;
		
		query.setFirstResult(firstPage);
		query.setMaxResults(totalPerPage);
    }

    private Long total(EntryFilter entryFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Entry> root = criteria.from(Entry.class);
		
		Predicate[] predicates = createRestrictions(entryFilter, builder, root);
		criteria.where(predicates);
		
        criteria.select(builder.count(root));
        
		return manager.createQuery(criteria).getSingleResult();
    }
}