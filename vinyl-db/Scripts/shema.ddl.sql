DROP TABLE IF EXISTS t_vinyls;
DROP TABLE IF EXISTS t_employees;
DROP TABLE IF EXISTS t_customers;
DROP TABLE IF EXISTS t_rentals;

----------------------------------------------------------------


CREATE TABLE t_vinyls (
    vinyl_id INT GENERATED ALWAYS AS IDENTITY,
    release_title VARCHAR(255),
    release_year VARCHAR (4),
    artist_name VARCHAR (255),
    vinyl_img VARCHAR(41),
    CONSTRAINT t_vinyls_pkey PRIMARY KEY (vinyl_id)
);


SELECT * FROM t_vinyls;

--TRUNCATE TABLE t_vinyls;

----------------------------------------------------------------

CREATE TABLE t_employees (
    employee_id INT GENERATED ALWAYS AS IDENTITY,
    employee_firstname VARCHAR(70),
    employee_lastname VARCHAR (70),
    employee_password VARCHAR (6),
    CONSTRAINT t_employees_pkey PRIMARY KEY (employee_id)
);

SELECT * FROM t_employees;

----------------------------------------------------------------



CREATE TABLE t_customers
(
    customer_id     INT GENERATED ALWAYS AS IDENTITY,
    customer_email  VARCHAR(254),
    customer_name   VARCHAR(100),
    customer_address VARCHAR(255),
    CONSTRAINT t_customers_pkey PRIMARY KEY (customer_id)
);

SELECT * FROM t_customers;