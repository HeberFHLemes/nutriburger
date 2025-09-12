CREATE TABLE categorias (
  id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  nome VARCHAR(25) NOT NULL
);

CREATE TABLE produtos (
  id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  preco NUMERIC(10, 2) NOT NULL,
  imagem_url VARCHAR(255) NOT NULL,
  categoria_id INT,
  FOREIGN KEY (categoria_id) REFERENCES categorias(id) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE ingredientes (
  id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  acucares NUMERIC(10, 2) NOT NULL,
  carboidratos NUMERIC(10, 2) NOT NULL,
  proteinas NUMERIC(10, 2) NOT NULL,
  sodio NUMERIC(10, 2) NOT NULL
);

CREATE TABLE produto_ingrediente (
  produto_id INT NOT NULL,
  ingrediente_id INT NOT NULL,
  PRIMARY KEY (produto_id, ingrediente_id),
  FOREIGN KEY (produto_id) REFERENCES produtos(id) ON DELETE CASCADE,
  FOREIGN KEY (ingrediente_id) REFERENCES ingredientes(id) ON DELETE CASCADE
);

CREATE TABLE produto_dados_nutricionais (
  id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  produto_id INT UNIQUE NOT NULL,
  acucares NUMERIC(10, 2) NOT NULL,
  carboidratos NUMERIC(10, 2) NOT NULL,
  proteinas NUMERIC(10, 2) NOT NULL,
  sodio NUMERIC(10, 2) NOT NULL,
  FOREIGN KEY (produto_id) REFERENCES produtos(id) ON DELETE CASCADE
);