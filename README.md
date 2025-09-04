# Vinyle

Projet Soutenance CDA

Le projet **Vinyle** est un logiciel destiné à la gestion d’une collection de disques vinyles, conçu pour les rendre accessibles à un public spécialisé. Il s’adresse aux professionnels du secteur musical et propose une solution de gestion de stock disponible sur ordinateur ou tablette. L’application est conçue pour être utilisée dans une boutique physique, à la manière d’un vidéoclub.

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
- PostgreSQL

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

## Conception et modélisation de la base de données

### Dictionnaire des données

#### Entité : disquaire (utilisateur par défaut)

| Attribut         | Type  | Longueur/précision | Obligatoire | Exemples            |
| ---------------- | ----- | ------------------ | ----------- | ------------------- |
| **Pénom**        | Texte | 100                | Oui         | Dee Jay             |
| **Nom**          | Texte | 100                | Oui         | Dee Jay             |
| **e-mail**       | Texte | 100                | Oui         | dee.jay@jolimail.io |
| **mot de passe** | Texte | 8                  | oui         | aZerty!9            |

#### Entité : vinyl

| Attribut             | Type  | Longueur/précision | Obligatoire | Exemple                        |
| -------------------- | ----- | ------------------ | ----------- | ------------------------------ |
| **Release**          | Texte | 200                | Oui         | La Salsa Du Démon              |
| **Nom de l'artiste** | Texte | 200                | Oui         | Le Grand Orchestre Du Splendid |
| Année de sortie      | Date  | 10                 | Non         | 1980                           |
| Image                | Texte | 41                 | Non         | UUID.jpeg                      |

#### Entité : client

| Attribut   | Type  | Longueur/précision | Obligatoire | Exemples            |
| ---------- | ----- | ------------------ | ----------- | ------------------- |
| **Nom**    | Texte | 100                | Oui         | Dee Jay             |
| **e-mail** | Texte | 100                | Oui         | dee.jay@jolimail.io |
| Ville      | Texte | 400                | Non         | Paris               |

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

<img width="672" height="638" alt="Capture d’écran 2025-08-23 à 15 38 20" src="https://github.com/user-attachments/assets/8f4b4272-f8d2-41de-8758-a6f4e85d1747" />


### MLD-R

<img width="729" height="659" alt="Capture d’écran 2025-06-20 à 00 07 41" src="https://github.com/user-attachments/assets/c1c11548-148d-4460-97cb-f607a685136b" />


---

## Contributeurs

- Émilie Barré

---
