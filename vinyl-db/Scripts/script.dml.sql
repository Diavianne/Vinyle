INSERT INTO t_employees (employee_firstname, employee_lastname, employee_email, employee_password) VALUES 
('Virgin', 'Megastore', 'virgin.megastore@mail.fr', '$2a$12$wY3ODJIN1BcBOAEnaohuhOhf9oLColeI16b.7I.zPRqFawGDVIUxO'),
('Fanny', 'Nac', 'fnac@online.fr', '$2a$12$XH7VbD5f8z3sK6eLmP1Q2uVjKLmNOPRSTUVWXYZabcdefghijklm'),
('Gibert', 'Joseph', 'gi.jo@lemel.fr', '$2a$12$H5cju6t4YDS.zhWhW7m/ZOq3zG6dwVNEfvUEmLLMY/NJq3n6kc2hq');


INSERT INTO t_vinyls (release_title, artist_name, vinyl_img, release_year) VALUES
('Abbey Road', 'The Beatles', 'abbey_road.jpg', '1969'),
('Thriller', 'Michael Jackson', 'thriller.jpg', '1982');

INSERT INTO t_customers (customer_name, customer_email, customer_city)
VALUES 
('Dee Jay', 'dee.jay@jolimail.fr','Jonzac'),
('Vinylia Groove', 'vinylia.groove@melodymail.com', 'Paris'),
('Max Platine', 'max.platine@sonorama.fr', 'Champs/Marne');


--INSERT INTO t_rentals (vinyl_id, customer_id, employee_id, rental_date, return_date) VALUES
--(1, 1, 1, '2025-07-01', '2025-07-10'),
--(2, 2, 2, '2025-07-05', NULL);
