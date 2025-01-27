

Ceci est un prototype.

# Vinyle
 Projet Soutenance CDA

Le projet Vinyle est un logiciel qui permet de gérer une discothèque de vinyles. L’application s'adresse aux professionnels du secteur musical. Il s’agit d’un logiciel de gestion de stock au format desktop ou tablette utilisable dans une boutique physique à l’instar d’un vidéo club.

## Principales fonctionnalités
- Créer un compte (disquaire non enregistré)
- S'authentifier (disquaire enregistré)
- Modifier son mot de passe (disquaire)
- Ajouter des disques (disquaire)
- Modifier l’état des disques (disquaire)
- Supprimer des disques (disquaire)
- Consulter les disques loués d’un client (disquaire)

## Acteurs (rôles)
- Disquaire (enregistré) : un utilisateur authentifié

## Divers
- Persona : utilisateur idéal avec son identité, culture, objectifs et frustrations
- Benchmark, SWOT, MOSCOW
- Gestion de projet (Diagramme de Gantt)
- UX - UI : maquettes , charte graphique, typo.

## Conception et modélisation de la base de données

### Dictionnaire des données

#### Entité : vinyl

| Attribut | Type | Longueur/précision | Obligatoire | Exemple |
| --- | --- | --- | --- | --- | 
| **Release** | Texte | 200 | Oui | La Salsa Du Démon |
| **Nom de l'artiste** | Texte | 200 | Oui | Le Grand Orchestre Du Splendid |
| Genre | Texte | 200 | Non | Pop |
| Année de sortie | Date | 10 | Non | 1980 |
| Label | Texte | 200 | Non | RCA – ZB 8585 |
| Image | Texte | 41 | Non | La Salsa Du Demon.jpeg |

#### Entité : client

| Attribut | Type | Longueur/précision | Obligatoire | Exemples |
| --- | --- | --- | --- | --- | 
| **Nom** | Texte | 100| Oui | Dee Jay |
| **e-mail** | Texte | 100| Oui | dee.jay@jolimail.io |
| adresse postale | Texte | 400| Non | 64 rue Condorcet |
| Ville | Texte | 100| Oui | Paris |
| **code postal** | Texte | 6 | Oui | 75009 |


### Modèle Conceptuel des Données (MCD)

<img width="744" alt="image" src="https://github.com/user-attachments/assets/c4e8e20e-4f40-4695-8ea0-7d08b800c7e7" />


- un vinyle peut etre LOUER par un client
- un client peut LOUER un vinyle
- un disquaire crée la LOCATION d'un vinyle par un client

### Modèle Logique des Données Relationnel (MLD-R)
<img width="768" alt="Capture d’écran 2025-01-20 à 15 03 55" src="https://github.com/user-attachments/assets/213bb245-7178-4e27-8549-8715702dbac9" />

### Modèle Physique des Données (MPD)
```sql

CREATE TABLE t_vinyls (
    vinyl_id INT GENERATED ALWAYS AS IDENTITY,
    release_title VARCHAR(255),
    release_year VARCHAR (4),
    artist_name VARCHAR (255),
    label_name VARCHAR (255),
    music_style VARCHAR(255),
    vinyl_img VARCHAR(41),
    CONSTRAINT t_vinyls_pkey PRIMARY KEY (vinyls_id),
	   CONSTRAINT t_vinyls_ukey UNIQUE (release_title)
);

```

## Implémentation de la base de données

### Script DDL de mise en place de la base de données
```sql

CREATE TABLE t_vinyls (
    vinyl_id INT GENERATED ALWAYS AS IDENTITY,
    release_title VARCHAR(255),
    release_year VARCHAR (4),
    artist_name VARCHAR (255),
    vinyl_img VARCHAR(41),
    CONSTRAINT t_vinyls_pkey PRIMARY KEY (vinyl_id)
);

----------------------------------------------------------------

CREATE TABLE t_employees (
    employee_id INT GENERATED ALWAYS AS IDENTITY,
    employee_firstname VARCHAR(70),
    employee_lastname VARCHAR (70),
    identifier VARCHAR (9),
    employee_password VARCHAR (6),
    CONSTRAINT t_employees_pkey PRIMARY KEY (employee_id),
	CONSTRAINT t_employees_ukey UNIQUE (identifier)
);

----------------------------------------------------------------

CREATE TABLE t_customers
(
    customer_id     INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    customer_email  VARCHAR(254),
    customer_name   VARCHAR(100),
    customer_address VARCHAR(255),
    CONSTRAINT t_customers_pkey PRIMARY KEY (customer_id)
);


----------------------------------------------------------------

CREATE TABLE t_rentals (
    rental_id INT GENERATED ALWAYS AS IDENTITY,
    rental_date DATE,
    return_date DATE,
    vinyl_id INT,
    customer_id INT,
    employee_id INT,
    CONSTRAINT t_rentals_pkey PRIMARY KEY (rental_id),
    CONSTRAINT fk_rentals_vinyl FOREIGN KEY (vinyl_id)
        REFERENCES t_vinyls (vinyl_id)
        ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT fk_rentals_customer FOREIGN KEY (customer_id)
        REFERENCES t_customers (customer_id)
        ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT fk_rentals_employee FOREIGN KEY (employee_id)
        REFERENCES t_employees (employee_id)
        ON DELETE SET NULL ON UPDATE CASCADE
);
```

### Script DML d'initialisation des données
```sql

```
