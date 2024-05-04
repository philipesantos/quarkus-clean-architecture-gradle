package org.acme.boundaries.usecases.consumeproduct;

import io.smallrye.mutiny.Uni;

public interface ConsumeProductUseCase {
    Uni<ConsumeProductUseCaseOutput> execute(ConsumeProductUseCaseInput input);
}
