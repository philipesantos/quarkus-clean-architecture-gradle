package org.acme.entrypoints.restful.jakarta.getproducts;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.acme.boundaries.usecases.produceproducts.ProduceProductsUseCase;
import org.acme.boundaries.usecases.produceproducts.ProduceProductsUseCaseInput;

@Path("/products")
public class GetProductsEntrypoint {
    private final ProduceProductsUseCase produceProductsUseCase;

    public GetProductsEntrypoint(ProduceProductsUseCase produceProductsUseCase) {
        this.produceProductsUseCase = produceProductsUseCase;
    }

    @GET
    public Uni<GetProductsResponse> get() {
        return produceProductsUseCase.execute(new ProduceProductsUseCaseInput())
            .onItem().transform(output -> new GetProductsResponse(
                output.products()
                    .stream()
                    .map(product -> new GetProductsResponse.Product(
                        product.serial(),
                        product.name()
                    ))
                    .toList()
            ));
    }
}