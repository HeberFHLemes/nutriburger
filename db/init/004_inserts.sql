INSERT INTO categorias(nome) VALUES
('Sanduíches'),
('Bebidas'),
('Acompanhamentos'),
('Molhos'),
('Combos'),
('Sobremesas');

INSERT INTO produtos(nome, descricao, preco, categoria_id) VALUES
('X-Tudo', 'O mais completo', 32.90, 1),
('X-Salada', 'O mais saudável', 21.90, 1),
('Coca-cola', 'Garrafa de Coca-Cola - 600ml', 8.90, 2),
('Pepsi', 'Garrafa de Pepsi - 600ml', 7.90, 2),
('Guaraná', 'Garrafa de Guaraná - 600ml', 7.90, 2),
('Batata-Frita', 'Porção de batata-frita, o acompanhamento perfeito!', 10.90, 3);

INSERT INTO ingredientes (nome, acucares, carboidratos, proteinas, sodio) VALUES
('Pão', 2.0, 20.0, 5.0, 300.0),
('Carne', 0.0, 0.0, 20.0, 500.0),
('Queijo', 0.0, 1.0, 7.0, 200.0),
('Molho', 1.0, 2.0, 0.5, 150.0),
('Batata', 0.5, 30.0, 3.0, 10.0),
('Óleo', 0.0, 0.0, 0.0, 0.0),
('Refrigerante', 10.0, 10.0, 0.0, 15.0),
('Alface', 0.5, 5.0, 3.0, 1.0);

-- X-Tudo { Pão + Carne + Queijo + Molho }
INSERT INTO produto_ingrediente (produto_id, ingrediente_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4);

-- X-Salada { Pão + Carne + Molho + Salada }
INSERT INTO produto_ingrediente (produto_id, ingrediente_id) VALUES
(2, 1),
(2, 2),
(2, 4),
(2, 8);

-- Batata Frita { Batata + Óleo }
INSERT INTO produto_ingrediente (produto_id, ingrediente_id) VALUES
(6, 5),
(6, 6);

-- Pepsi/Coca-cola/Guaraná { Refrigerante }
INSERT INTO produto_ingrediente (produto_id, ingrediente_id) VALUES
(3, 7),
(4, 7),
(5, 7);