CREATE TABLE categoria (
  id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  nome VARCHAR(25) NOT NULL
);

CREATE TABLE produto (
  id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  preco NUMERIC(10, 2) NOT NULL,
  -- porcao NUMERIC(10, 2),
  -- porcao_unidade VARCHAR(20),
  imagem_url VARCHAR(255),
  categoria_id INT NOT NULL,
  FOREIGN KEY (categoria_id) REFERENCES categoria(id) ON DELETE NO ACTION
);

CREATE TABLE ingrediente (
  id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  nome VARCHAR(100) NOT NULL
);

CREATE TABLE produto_ingrediente (
  produto_id INT NOT NULL,
  ingrediente_id INT NOT NULL,
  quantidade NUMERIC(10, 2) DEFAULT 1,
  PRIMARY KEY (produto_id, ingrediente_id),
  FOREIGN KEY (produto_id) REFERENCES produto(id) ON DELETE CASCADE,
  FOREIGN KEY (ingrediente_id) REFERENCES ingrediente(id) ON DELETE CASCADE
);

CREATE TABLE nutriente ( 
  id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  unidade_medida VARCHAR(20) DEFAULT 'UN'
);

CREATE TABLE produto_nutriente (
  produto_id INT NOT NULL,
  nutriente_id INT NOT NULL,
  dado_nutricional NUMERIC(10, 2) NOT NULL,
  PRIMARY KEY (produto_id, nutriente_id),
  FOREIGN KEY (produto_id) REFERENCES produto(id) ON DELETE CASCADE,
  FOREIGN KEY (nutriente_id) REFERENCES nutriente(id) ON DELETE CASCADE
);

CREATE TABLE ingrediente_nutriente (
  ingrediente_id INT NOT NULL,
  nutriente_id INT NOT NULL,
  dado_nutricional NUMERIC(10, 2) NOT NULL,
  PRIMARY KEY (ingrediente_id, nutriente_id),
  FOREIGN KEY (ingrediente_id) REFERENCES ingrediente(id) ON DELETE CASCADE,
  FOREIGN KEY (nutriente_id) REFERENCES nutriente(id) ON DELETE CASCADE
);