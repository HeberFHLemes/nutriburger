CREATE TABLE produtos (
  id BIGSERIAL PRIMARY KEY,
  nome VARCHAR(20) NOT NULL,
  preco NUMERIC(10, 2) NOT NULL
  -- categoria VARCHAR(20) -- hamburguer, bebida, porcao, acompanhamento, combo
);

CREATE TABLE ingredientes (
  id BIGSERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  carboidratos NUMERIC(10, 2) NOT NULL,
  proteinas NUMERIC(10, 2) NOT NULL,
  acucares NUMERIC(10, 2) NOT NULL,
  sodio NUMERIC(10, 2) NOT NULL
);

CREATE TABLE produtos_ingredientes (
  id BIGSERIAL PRIMARY KEY,
  produto_id BIGINT NOT NULL,
  ingrediente_id BIGINT NOT NULL,
  FOREIGN KEY (produto_id) REFERENCES produtos(id) ON DELETE CASCADE,
  FOREIGN KEY (ingrediente_id) REFERENCES ingredientes(id) ON DELETE CASCADE
);

CREATE TABLE produtos_dados_nutricionais (
  id BIGSERIAL PRIMARY KEY,
  produto_id BIGINT UNIQUE NOT NULL,
  carboidratos NUMERIC(10, 2) NOT NULL,
  proteinas NUMERIC(10, 2) NOT NULL,
  acucares NUMERIC(10, 2) NOT NULL,
  sodio NUMERIC(10, 2) NOT NULL,
  -- sem_gluten BOOLEAN DEFAULT false,
  -- sem_lactose BOOLEAN DEFAULT false,
  FOREIGN KEY (produto_id) REFERENCES produtos(id) ON DELETE CASCADE
);