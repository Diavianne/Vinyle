

CREATE TABLE t_employees;
(
    id                 BIGINT NOT NULL,
    employee_firstname VARCHAR(70),
    employee_lastname  VARCHAR(70),
    role               VARCHAR(60),
    identifier         VARCHAR(9),
    password           VARCHAR(6),
    manager            VARCHAR(60),
    CONSTRAINT pk_t_employees PRIMARY KEY (id)
);

--ALTER TABLE t_employees
   -- ADD CONSTRAINT uc_t_employees_identifier UNIQUE (identifier);