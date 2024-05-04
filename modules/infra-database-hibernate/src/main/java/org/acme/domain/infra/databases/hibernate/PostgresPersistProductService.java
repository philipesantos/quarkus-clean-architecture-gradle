package org.acme.domain.infra.databases.hibernate;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.boundaries.services.persistproduct.PersistProductService;
import org.acme.boundaries.services.persistproduct.PersistProductServiceInput;
import org.acme.boundaries.services.persistproduct.PersistProductServiceOutput;
import org.acme.domain.infra.databases.hibernate.entities.ProductEntity;
import org.acme.domain.infra.databases.hibernate.repositories.ProductRepository;

@ApplicationScoped
public class PostgresPersistProductService implements PersistProductService {
    private final ProductRepository productRepository;

    @Inject
    public PostgresPersistProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Uni<PersistProductServiceOutput> execute(PersistProductServiceInput input) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(input.name());
        productEntity.setSerial(input.serial());
        return productRepository.insert(productEntity)
            .onItem().transform(entity -> new PersistProductServiceOutput(entity.getId()));
    }
}
