package org.acme.domain.infra.databases.hibernate.repositories;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.acme.domain.infra.databases.hibernate.entities.ProductEntity;
import org.hibernate.reactive.mutiny.Mutiny;

import java.util.List;

@ApplicationScoped
public class ProductRepository {
    private final Mutiny.SessionFactory sessionFactory;

    @Inject
    public ProductRepository(Mutiny.SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Uni<List<ProductEntity>> findAll() {
        return sessionFactory.withStatelessSession(session -> {
            CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
            CriteriaQuery<ProductEntity> cq = cb.createQuery(ProductEntity.class);
            Root<ProductEntity> rootEntry = cq.from(ProductEntity.class);
            CriteriaQuery<ProductEntity> all = cq.select(rootEntry);
            return session.createQuery(all).getResultList();
        });
    }

    public Uni<ProductEntity> insert(ProductEntity productEntity) {
        return sessionFactory.withStatelessSession(session -> session.insert(productEntity))
            .onItem().transform(v -> productEntity);
    }
}
