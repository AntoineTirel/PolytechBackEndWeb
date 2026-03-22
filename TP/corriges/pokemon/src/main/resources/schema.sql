DROP TABLE IF EXISTS pokemon_weaknesses;
DROP TABLE IF EXISTS pokemon_resistances;
DROP TABLE IF EXISTS pokemon;
DROP TABLE IF EXISTS type;
DROP TABLE IF EXISTS trainer;

CREATE TABLE IF NOT EXISTS type (
    id SMALLINT PRIMARY KEY,
    typeName VARCHAR(50) UNIQUE
);

CREATE TABLE IF NOT EXISTS pokemon (
    id SMALLINT PRIMARY KEY,
    description VARCHAR NOT NULL,
    name VARCHAR(100) NOT NULL,
    generation SMALLINT NOT NULL,
    type1 VARCHAR(50) NOT NULL,
    type2 VARCHAR(50),
    FOREIGN KEY (type1) REFERENCES type(typeName),
    FOREIGN KEY (type2) REFERENCES type(typeName)
);

CREATE TABLE IF NOT EXISTS pokemon_weaknesses (
    pokemon_id SMALLINT NOT NULL,
    type_id SMALLINT NOT NULL,
    PRIMARY KEY (pokemon_id, type_id),
    FOREIGN KEY (pokemon_id) REFERENCES pokemon(id),
    FOREIGN KEY (type_id) REFERENCES type(id)
);

CREATE TABLE IF NOT EXISTS pokemon_resistances (
    pokemon_id SMALLINT NOT NULL,
    type_id SMALLINT NOT NULL,
    PRIMARY KEY (pokemon_id, type_id),
    FOREIGN KEY (pokemon_id) REFERENCES pokemon(id),
    FOREIGN KEY (type_id) REFERENCES type(id)
);

CREATE TABLE IF NOT EXISTS trainer (
    trainer_id SMALLINT PRIMARY KEY,
    trainer_name VARCHAR(50) NOT NULL,
    pokemon_id1 SMALLINT NOT NULL,
    pokemon_id2 SMALLINT,
    pokemon_id3 SMALLINT,
    pokemon_id4 SMALLINT,
    pokemon_id5 SMALLINT,
    pokemon_id6 SMALLINT,
    FOREIGN KEY (pokemon_id1) REFERENCES pokemon(id),
    FOREIGN KEY (pokemon_id2) REFERENCES pokemon(id),
    FOREIGN KEY (pokemon_id3) REFERENCES pokemon(id),
    FOREIGN KEY (pokemon_id4) REFERENCES pokemon(id),
    FOREIGN KEY (pokemon_id5) REFERENCES pokemon(id),
    FOREIGN KEY (pokemon_id6) REFERENCES pokemon(id)
);