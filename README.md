# Modul-1-Coding-Standard

## Reflection 1
I applied MVC separation (controller/service/repository/model) so each layer has a clear responsibility and is easier to maintain. I also used dependency injection to reduce coupling between components and make the code easier to test.

Clean code principles I applied include using descriptive names, keeping methods focused, and centralizing product operations in the service/repository layers. Lombok helps reduce boilerplate so the model stays readable.

Secure coding practices I applied include not trusting client-provided identifiers by generating `productId` on the server when it is missing, and keeping data operations encapsulated in the repository instead of exposing internal data structures.

Improvements to make the code better:
- Add validation for inputs (e.g., non-empty name, non-negative quantity) and handle validation errors properly.
- Avoid state-changing actions via `GET` (e.g., delete) and improve error handling for missing IDs.
