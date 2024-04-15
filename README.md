# Projet Spring Boot

Ce projet Spring Boot présente les fonctionnalités suivantes :

1. **Authentification avec Spring Security et JWT :**
   - Utilisation de Spring Security pour l'authentification.
   - Utilisation de JSON Web Tokens (JWT) pour l'authentification stateless.
   - Stockage des utilisateurs dans PostgreSQL avec JPA.

2. **Utilisation de JPA avec PostgreSQL :**
   - Intégration de JPA pour l'accès aux données.
   - Utilisation de PostgreSQL comme base de données.

3. **Utilisation de Spring Compose :**
   - Configuration d'un fichier `docker-compose.yml`.
   - Connexion automatique au conteneur Docker de la base de données.

4. **CRUD pour les entités Reservation, Utilisateur et Chambres :**
   - Opérations CRUD pour manipulation des données.

5. **Recherche de Chambre :**
   - Implémentation d'un mécanisme de recherche de chambre.

6. **Documentation avec Swagger OpenAPI :**
   - Génération automatique de documentation interactive de l'API avec Swagger OpenAPI.

7. **Tests avec Postman :**
   - Utilisation de Postman pour les tests d'intégration et de validation des fonctionnalités.

8. **Architecture MVC :**
   - Adoption du modèle MVC pour une séparation claire des responsabilités.

9. **API REST :**
   - Conception et développement d'une API RESTful.

10. **Implémentation d'un Frontend Admin avec React Admin et Platform Admin :**
    - Utilisation de React Admin pour l'interface admin.
    - Intégration de "platform admin" pour une séparation frontend-backend.
    - Utilisation de Swagger et OpenAPI pour une synchronisation automatique entre les parties.

## TODO
- [X] Ajouter une interface responsive pour l'admin avec react
- [ ] Ajouter une interface client pour la réservation de chambres.
- [ ] Dockerisation de l'application.
