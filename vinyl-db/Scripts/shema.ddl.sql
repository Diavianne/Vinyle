DROP TABLE IF EXISTS t_vinyls;


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


SELECT * FROM t_vinyls;

