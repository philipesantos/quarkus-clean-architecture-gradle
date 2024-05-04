package org.acme.usecases;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.boundaries.services.retrieveproducts.RetrieveProductsService;
import org.acme.boundaries.services.retrieveproducts.RetrieveProductsServiceInput;
import org.acme.boundaries.usecases.produceproducts.ProduceProductsUseCase;
import org.acme.boundaries.usecases.produceproducts.ProduceProductsUseCaseInput;
import org.acme.boundaries.usecases.produceproducts.ProduceProductsUseCaseOutput;

@ApplicationScoped
public class DefaultProduceProductsUseCase implements ProduceProductsUseCase {
    private final RetrieveProductsService retrieveProductsService;

    @Inject
    public DefaultProduceProductsUseCase(RetrieveProductsService retrieveProductsService) {
        this.retrieveProductsService = retrieveProductsService;
    }

    @Override
    public Uni<ProduceProductsUseCaseOutput> execute(ProduceProductsUseCaseInput input) {
        return retrieveProductsService.execute(new RetrieveProductsServiceInput())
            .onItem().transform(output -> new ProduceProductsUseCaseOutput(
                output.products()
                    .stream()
                    .map(product -> new ProduceProductsUseCaseOutput.Product(
                        product.serial(),
                        product.name()
                    ))
                    .toList()
            ));
    }
}
