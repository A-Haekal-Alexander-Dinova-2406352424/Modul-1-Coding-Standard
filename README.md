# Modul-1-Coding-Standard

## Reflection 1
I applied MVC separation (controller/service/repository/model) so each layer has a clear responsibility and is easier to maintain. I also used dependency injection to reduce coupling between components and make the code easier to test.

Clean code principles I applied include using descriptive names, keeping methods focused, and centralizing product operations in the service/repository layers. Lombok helps reduce boilerplate so the model stays readable.

Secure coding practices I applied include not trusting client-provided identifiers by generating `productId` on the server when it is missing, and keeping data operations encapsulated in the repository instead of exposing internal data structures.

Improvements to make the code better:
- Add validation for inputs (e.g., non-empty name, non-negative quantity) and handle validation errors properly.
- Avoid state-changing actions via `GET` (e.g., delete) and improve error handling for missing IDs.

## Reflection 2
1. Writing unit tests makes me more confident when refactoring because I can quickly verify that core behaviors still work. The number of unit tests in a class depends on how many distinct behaviors and edge cases the class has; the goal is to cover meaningful scenarios (happy paths, edge cases, and failure cases) rather than chasing an arbitrary number. To make sure tests are enough, I can use code coverage as a guide and review uncovered branches/conditions, but 100% coverage still does not guarantee the absence of bugs because tests can miss incorrect requirements, lack important assertions, or fail to cover real-world interactions and data combinations.

2. Copying the same setup procedures and instance variables into every functional test suite is repetitive and makes the code harder to maintain (e.g., if the base URL setup changes, every class must be updated). This can introduce duplication, inconsistent configurations, and larger test files that are harder to read. Improvements include extracting shared setup into a base test class or a reusable helper method, using constants/utilities for common selectors and URLs, and applying DRY while still keeping each test case focused and readable.
