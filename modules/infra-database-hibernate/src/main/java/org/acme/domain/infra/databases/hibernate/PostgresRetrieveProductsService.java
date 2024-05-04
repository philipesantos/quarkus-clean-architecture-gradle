package org.acme.domain.infra.databases.hibernate;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.boundaries.services.retrieveproducts.RetrieveProductsService;
import org.acme.boundaries.services.retrieveproducts.RetrieveProductsServiceInput;
import org.acme.boundaries.services.retrieveproducts.RetrieveProductsServiceOutput;
import org.acme.domain.infra.databases.hibernate.repositories.ProductRepository;

@ApplicationScoped
public class PostgresRetrieveProductsService implements RetrieveProductsService {
    private final ProductRepository productRepository;

    @Inject
    public PostgresRetrieveProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Uni<RetrieveProductsServiceOutput> execute(RetrieveProductsServiceInput input) {
        return productRepository.findAll()
            .onItem().transform(entity -> new RetrieveProductsServiceOutput(
                    entity.stream()
                        .map(productEntity -> new RetrieveProductsServiceOutput.Product(
                            productEntity.getSerial(),
                            productEntity.getName()
                        ))
                        .toList()
            ));
    }
}
