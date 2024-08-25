

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


### Modèle Logique des Données Relationnel (MLD-R)

### Modèle Physique des Données (MPD)
```sql

CREATE TABLE t_vinyls (
    vinyl_id INT PRIMARY KEY,
    release VARCHAR(255),
    release_year INT,
    artist_name VARCHAR (255),
    label_name VARCHAR (255),
    style VARCHAR(255),
    vinyl_img VARCHAR(41)
);

```

## Implémentation de la base de données

### Script DDL de mise en place de la base de données
```sql

```

### Script DML d'initialisation des données
```sql

```
