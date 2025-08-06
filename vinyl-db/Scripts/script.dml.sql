INSERT INTO t_employees (employee_firstname, employee_lastname, employee_email, employee_password) VALUES 
('Virginie', 'Megastore', 'virginie.megastore@vinyllegacy.fr', 'Vinyl4Life'),
('Fanny', 'Nac', 'fanny.nac@fnacmail.fr', 'FnacRules90'),
('Joséphine', 'Gibert', 'josephine.gibert@libraudio.fr', 'GibertDisco1');


INSERT INTO t_vinyls (release_title, artist_name, vinyl_img, release_year) VALUES
('Abbey Road', 'The Beatles', 'abbey_road.jpg', '1969'),
('Thriller', 'Michael Jackson', 'thriller.jpg', '1982');

INSERT INTO t_customers (customer_name, customer_email, customer_city)
VALUES 
('Dee Jay', 'dee.jay@jolimail.fr', '64 rue Condorcet, 98015 City'),
('Vinylia Groove', 'vinylia.groove@melodymail.com', '12 avenue du Saphir, 75008 Paris'),
('Max Platine', 'max.platine@sonorama.fr', '7 impasse du Tempo, 77420 Champs');


INSERT INTO t_rentals (vinyl_id, customer_id, employee_id, rental_date, return_date) VALUES
(1, 1, 1, '2024-07-01', '2024-07-10'),
(2, 2, 2, '2024-07-05', NULL);