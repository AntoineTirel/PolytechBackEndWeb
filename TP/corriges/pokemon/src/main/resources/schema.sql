DROP TABLE IF EXISTS pokemon;
DROP TABLE IF EXISTS type;

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
