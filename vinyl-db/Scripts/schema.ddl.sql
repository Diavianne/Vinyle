DROP TABLE IF EXISTS t_rentals;
DROP TABLE IF EXISTS t_vinyls;
DROP TABLE IF EXISTS t_employees;
DROP TABLE IF EXISTS t_customers;

-- Table des vinyles
CREATE TABLE t_vinyls (
    vinyl_id INT GENERATED ALWAYS AS IDENTITY,
    release_title VARCHAR(255),
    artist_name VARCHAR(255),
    vinyl_img VARCHAR(255),
    release_year VARCHAR(4),
    CONSTRAINT t_vinyls_pkey PRIMARY KEY (vinyl_id)
);

-- Table des disquaires
CREATE TABLE t_employees (
    employee_id INT GENERATED ALWAYS AS IDENTITY,
    employee_firstname VARCHAR(70),
    employee_lastname VARCHAR(70),
    employee_email VARCHAR(70),
    employee_password VARCHAR(60),
    CONSTRAINT t_employees_pkey PRIMARY KEY (employee_id),
    CONSTRAINT unique_employee_email UNIQUE (employee_email)
);

-- Table des clients
CREATE TABLE t_customers (
    customer_id INT GENERATED ALWAYS AS IDENTITY,
    customer_email VARCHAR(254),
    customer_name VARCHAR(100),
    customer_city VARCHAR(255),
    CONSTRAINT t_customers_pkey PRIMARY KEY (customer_id),
    CONSTRAINT unique_customers_email UNIQUE (customer_email)
);

-- Table des locations
CREATE TABLE t_rentals (
    rental_id INT GENERATED ALWAYS AS IDENTITY,
    vinyl_id INT,
    customer_id INT NOT NULL,
    employee_id INT,
    rental_date DATE NOT NULL,
    return_date DATE,
    CONSTRAINT t_rentals_pkey PRIMARY KEY (rental_id),
    CONSTRAINT fk_vinyl FOREIGN KEY (vinyl_id) REFERENCES t_vinyls(vinyl_id),
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES t_customers(customer_id),
    CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES t_employees(employee_id)
);
