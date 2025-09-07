INSERT INTO t_employees (employee_firstname, employee_lastname, employee_email, employee_password) VALUES 
('Virgin', 'Megastore', 'virgin.megastore@mail.fr', '$2a$12$wY3ODJIN1BcBOAEnaohuhOhf9oLColeI16b.7I.zPRqFawGDVIUxO'),
('Fanny', 'Nac', 'fnac@online.fr', '$2a$12$XH7VbD5f8z3sK6eLmP1Q2uVjKLmNOPRSTUVWXYZabcdefghijklm'),
('Gibert', 'Joseph', 'gi.jo@lemel.fr', '$2a$12$H5cju6t4YDS.zhWhW7m/ZOq3zG6dwVNEfvUEmLLMY/NJq3n6kc2hq');


INSERT INTO t_vinyls (release_title, artist_name, vinyl_img, release_year) VALUES
('Abbey Road', 'The Beatles', '22630075-d48d-4968-8a02-a156dc57c639.jpg', '1969'),
('Thriller', 'Michael Jackson', 'b7e2c1a2-9f3b-4e2a-8c1a-7e2c1a2b7e2c.png', '1982'),
('Joe le taxi', 'Vanessa Paradis', 'e3f1c2b4-7a8d-4c1e-9b2a-8e2f1c2b4e3f.jpeg', '1987');

INSERT INTO t_customers (customer_name, customer_email, customer_city)
VALUES 
('Dee Jay', 'dee.jay@jolimail.fr','Jonzac'),
('Vinylia Groove', 'vinylia.groove@melodymail.com', 'Paris'),
('Max Platine', 'max.platine@sonorama.fr', 'Champs/Marne');


--INSERT INTO t_rentals (vinyl_id, customer_id, employee_id, rental_date, return_date) VALUES
--(1, 1, 1, '2025-07-01', '2025-07-10'),
--(2, 2, 2, '2025-07-05', NULL);
