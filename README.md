# Vinyle

Projet Soutenance CDA

Vinyle est une application de gestion de discothèque de vinyles destinée aux professionnels du secteur musical. Elle permet de gérer le stock, les clients et les locations de vinyles dans une boutique physique, sur desktop ou tablette.

---

## Sommaire

- [Fonctionnalités](#fonctionnalités)
- [Architecture](#architecture)
- [Installation](#installation)
- [Base de données](#base-de-données)
- [Modèles de données](#modèles-de-données)
- [Contributeurs](#contributeurs)

---

## Fonctionnalités

- Ajouter, supprimer et consulter des vinyles
- Ajouter et consulter des clients
- Créer et gérer des locations (sorties temporaires du stock)
- Consulter les disques loués d’un client
- Authentification (disquaire)
- Interface responsive (desktop/tablette)

---

## Architecture

- **Frontend** : Angular (`vinyl-ui/`)
- **Backend** : Java Spring Boot (`vinyl-api/`)
- **Base de données** : SQL (scripts dans `vinyl-db/Scripts/`)

---

## Installation

### Prérequis

- Node.js & npm
- Angular CLI
- Java 17+
- Maven
- Un SGBD compatible SQL (ex : PostgreSQL)

### Lancer le frontend

```bash
cd vinyl-ui
npm install
ng serve
```

### Lancer le backend

```bash
cd vinyl-api
./mvnw spring-boot:run
```

### Base de données

- Les scripts DDL/DML sont dans `vinyl-db/Scripts/`.
- Exemple d’import :
  ```bash
  psql -U <user> -d <database> -f vinyl-db/Scripts/schema.ddl.sql
  ```

---

## Base de données

### Script DDL

Voir `vinyl-db/Scripts/schema.ddl.sql` pour la structure complète.

### Script DML

Voir `vinyl-db/Scripts/script.dml.sql` pour l’initialisation des données.

---

## Modèles de données

### Entités principales

- **Disquaire** (utilisateur)
- **Vinyle**
- **Client**
- **Location**

### MCD

![MCD](https://github.com/user-attachments/assets/c4e8e20e-4f40-4695-8ea0-7d08b800c7e7)

### MLD-R

![MLD-R](https://github.com/user-attachments/assets/213bb245-7178-4e27-8549-8715702dbac9)

---

## Contributeurs

- Émilie Barré

---

## Divers

- Persona, benchmark, SWOT, MOSCOW, gestion de projet (Gantt), UX/UI (maquettes, charte graphique, typo) disponibles sur demande ou dans
