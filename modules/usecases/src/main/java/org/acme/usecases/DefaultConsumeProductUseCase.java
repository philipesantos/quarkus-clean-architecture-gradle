package org.acme.usecases;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.boundaries.services.persistproduct.PersistProductService;
import org.acme.boundaries.services.persistproduct.PersistProductServiceInput;
import org.acme.boundaries.usecases.consumeproduct.ConsumeProductUseCase;
import org.acme.boundaries.usecases.consumeproduct.ConsumeProductUseCaseInput;
import org.acme.boundaries.usecases.consumeproduct.ConsumeProductUseCaseOutput;
import org.acme.domain.Factory;
import org.acme.domain.Product;
import org.acme.domain.Specification;

@ApplicationScoped
public class DefaultConsumeProductUseCase implements ConsumeProductUseCase {
    private final PersistProductService productService;

    @Inject
    public DefaultConsumeProductUseCase(PersistProductService productService) {
        this.productService = productService;
    }


    @Override
    public Uni<ConsumeProductUseCaseOutput> execute(ConsumeProductUseCaseInput input) {
        Product product = Factory.findAvailable().manufacture(new Specification(input.name()));
        return productService.execute(new PersistProductServiceInput(product.serial(), input.name()))
            .onItem().transform(output -> new ConsumeProductUseCaseOutput(output.id()));
    }
}
