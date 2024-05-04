# Quarkus Clean Architecture Template

This template sets you up for quickly starting microservices projects. 
It features Quarkus and reactive programming, organized as a Gradle multi-project. 
Respecting clean architecture rules, inner modules are not accessible by outer modules unless you specifically add them as dependency.

### Known "issues"

- Even though the code is correct, IntelliJ appears unable to locate certain bean implementations and issues a warning: "no bean matches the injection point".
- To ensure smooth operation of reactive programming with Quarkus, Mutiny is included as a dependency of the use cases layer.
- To enable native build functionality, packages containing classes dependent on reflection must integrate Quarkus Core as a dependency to utilize the @RegisterForReflection annotation.

### Contributions

Contributions are always accepted, if you have a great idea on how to improve the template, let me know!