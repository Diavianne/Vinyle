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

![MCD](https://github.com/user-attachments/assets/c4e8e20e-4f40-4695-8ea0-7d08b800c7e7)

### MLD-R

![MLD-R](https://github.com/user-attachments/assets/213bb245-7178-4e27-8549-8715702dbac9)

---

## Contributeurs

- Émilie Barré

---
