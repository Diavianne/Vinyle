DROP TABLE IF EXISTS t_vinyls;
DROP TABLE IF EXISTS t_employees;

CREATE TABLE t_vinyls (
    vinyl_id INT GENERATED ALWAYS AS IDENTITY,
    release_title VARCHAR(255),
    release_year VARCHAR (4),
    artist_name VARCHAR (255),
    label_name VARCHAR (255),
    music_style VARCHAR(255),
    vinyl_img VARCHAR(41),
    CONSTRAINT t_vinyls_pkey PRIMARY KEY (vinyl_id),
	CONSTRAINT t_vinyls_ukey UNIQUE (release_title)
);


SELECT * FROM t_vinyls;

--TRUNCATE TABLE t_vinyls;

CREATE TABLE t_employees (
    employee_id INT GENERATED ALWAYS AS IDENTITY,
    employee_firstname VARCHAR(70),
    employee_lastname VARCHAR (70),
    employee_job VARCHAR (60),
    identifier VARCHAR (9),
    employee_password VARCHAR (6),
    manager VARCHAR(70),
    CONSTRAINT t_employees_pkey PRIMARY KEY (employee_id),
	CONSTRAINT t_employees_ukey UNIQUE (identifier)
);

SELECT * FROM t_employees;