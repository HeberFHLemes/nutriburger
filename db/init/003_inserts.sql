INSERT INTO produtos(nome, preco) VALUES
('X-Tudo', 32.90),
('X-Salada', 21.90),
('Coca-cola', 8.90),
('Pepsi', 7.90),
('Guaraná', 7.90),
('Batata-Frita', 10.90);

INSERT INTO ingredientes (nome, carboidratos, proteinas, acucares, sodio) VALUES
('Pão', 20.0, 5.0, 2.0, 300.0),
('Carne', 0.0, 20.0, 0.0, 500.0),
('Queijo', 1.0, 7.0, 0.0, 200.0),
('Molho', 2.0, 0.5, 1.0, 150.0),
('Batata', 30.0, 3.0, 0.5, 10.0),
('Óleo', 0.0, 0.0, 0.0, 0.0),
('Refrigerante', 10.0, 0.0, 10.0, 15.0),
('Alface', 5.0, 3.0, 0.5, 1.0);

-- X-Tudo { Pão + Carne + Queijo + Molho }
INSERT INTO produtos_ingredientes (produto_id, ingrediente_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4);

-- X-Salada { Pão + Carne + Molho + Salada }
INSERT INTO produtos_ingredientes (produto_id, ingrediente_id) VALUES
(2, 1),
(2, 2),
(2, 4),
(2, 8);

-- Batata Frita { Batata + Óleo }
INSERT INTO produtos_ingredientes (produto_id, ingrediente_id) VALUES
(6, 5),
(6, 6);

-- Pepsi/Coca-cola/Guaraná { Refrigerante }
INSERT INTO produtos_ingredientes (produto_id, ingrediente_id) VALUES
(3, 7),
(4, 7),
(5, 7);
