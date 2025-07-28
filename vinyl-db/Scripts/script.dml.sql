INSERT INTO t_employees (employee_firstname, employee_lastname, employee_email, employee_password) VALUES
('Alice', 'Martin', 'alice.martin@example.com', 'password1'),
('Bob', 'Durand', 'bob.durand@example.com', 'password2');

INSERT INTO t_vinyls (release_title, artist_name, vinyl_img, release_year) VALUES
('Abbey Road', 'The Beatles', 'abbey_road.jpg', '1969'),
('Thriller', 'Michael Jackson', 'thriller.jpg', '1982');

INSERT INTO t_customers (customer_email, customer_name, customer_city) VALUES
('client1@email.com', 'Jean Dupont', 'Paris'),
('client2@email.com', 'Marie Dubois', 'Lyon');

INSERT INTO t_rentals (vinyl_id, customer_id, employee_id, rental_date, return_date) VALUES
(1, 1, 1, '2024-07-01', '2024-07-10'),
(2, 2, 2, '2024-07-05', NULL);