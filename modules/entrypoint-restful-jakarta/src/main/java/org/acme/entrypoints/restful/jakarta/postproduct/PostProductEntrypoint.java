package org.acme.entrypoints.restful.jakarta.postproduct;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.acme.boundaries.usecases.consumeproduct.ConsumeProductUseCase;
import org.acme.boundaries.usecases.consumeproduct.ConsumeProductUseCaseInput;
import org.acme.entrypoints.restful.jakarta.Routes;

@Path(Routes.PRODUCTS)
public class PostProductEntrypoint {
    private final ConsumeProductUseCase consumeProductUseCase;

    public PostProductEntrypoint(ConsumeProductUseCase consumeProductUseCase) {
        this.consumeProductUseCase = consumeProductUseCase;
    }

    @POST
    public Uni<PostProductResponse> post(PostProductRequest input) {
        return consumeProductUseCase.execute(new ConsumeProductUseCaseInput(input.name()))
            .onItem().transform(output -> new PostProductResponse(output.id()));
    }
}