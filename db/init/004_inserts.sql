-- ================== CATEGORIAS ==================
INSERT INTO categorias(nome) VALUES
('Hambúrgueres'),
('Bebidas'),
('Acompanhamentos'),
('Molhos'),
('Sobremesas');

-- ================== PRODUTOS ==================
-- Hambúrgueres
INSERT INTO produtos(nome, descricao, preco, categoria_id) VALUES
('Clássico da Casa', 'Hambúrguer bovino com queijo, alface, tomate e maionese', 32.90, 1),
('Frango da Horta', 'Frango grelhado, alface, tomate e molho leve', 29.90, 1),
('Integral', 'Hambúrguer bovino e pão integral', 28.90, 1),
('Vegetal', 'Hambúrguer 100% vegetal com maionese da casa', 28.90, 1),
('Duplo Sabor', 'Dois hambúrgueres bovinos, queijo cheddar, bacon e maionese especial', 35.90, 1),
('Explosão de Queijo', 'Carne bovina, queijo prato, muçarela e cheddar, tudo derretendo', 33.90, 1),
('Bacon Crocante', 'Hambúrguer bovino, muito bacon, queijo e molho barbecue', 34.90, 1);

-- Bebidas
INSERT INTO produtos(nome, descricao, preco, categoria_id) VALUES
('Coca-Cola Tradicional', 'Lata 350 ml', 7.90, 2),
('Coca-Cola Zero', 'Lata 350 ml', 7.90, 2),
('Guaraná Tradicional', 'Lata 350 ml', 7.90, 2),
('Suco de Uva Aurora', 'Garrafinha de vidro 300 ml – 100% integral', 9.90, 2),
('Água Mineral Sem Gás', 'Garrafa 500 ml', 5.90, 2),
('Água Mineral Com Gás', 'Garrafa 500 ml', 5.90, 2),
('H2OH! Limão', 'Garrafa 500 ml', 6.90, 2),
('H2OH! Limoneto', 'Garrafa 500 ml', 6.90, 2);

-- Acompanhamentos
INSERT INTO produtos(nome, descricao, preco, categoria_id) VALUES
('Batata Frita Tradicional', '150 g ou 300 g', 10.90, 3),
('Batata Rústica', 'Com casca, levemente temperada com ervas', 11.90, 3),
('Batata Palito com Cheddar e Bacon', 'Porção individual', 14.90, 3),
('Onion Rings', 'Anéis de cebola empanados', 12.90, 3),
('Salada da Casa', 'Mix de folhas, tomate cereja e molho à parte', 9.90, 3),

-- Molhos
('Molhos Extras', 'Maionese temperada, barbecue, ketchup especial', 4.90, 4);

-- Sobremesas
INSERT INTO produtos(nome, descricao, preco, categoria_id) VALUES
('Brownie de Chocolate', 'Embalado em caixinha, com ou sem calda', 8.90, 5),
('Cookie Recheado', 'Chocolate ou doce de leite', 7.90, 5),
('Cheesecake no Pote', 'Frutas vermelhas ou maracujá', 9.90, 5),
('Açaí Tradicional no Copo', '300 ml – granola, banana e paçoca em potinhos separados', 16.90, 5);

-- ================== INGREDIENTES ==================
INSERT INTO ingredientes(nome, acucares, carboidratos, proteinas, sodio) VALUES
-- Pães e Carnes
('Hambúrguer Bovino', 0.0, 0.0, 20.0, 500.0),
('Frango Grelhado', 0.0, 0.0, 18.0, 400.0),  
('Legumes e Grãos', 1.0, 10.0, 3.0, 50.0),    
('Pão Tradicional', 2.0, 22.0, 4.0, 320.0),    
('Pão Integral',   2.0, 20.0, 5.0, 300.0),     
('Bacon',         0.0, 0.0, 5.0, 300.0),
-- Queijos
('Queijo',        0.0, 1.0, 7.0, 200.0),
('Queijo Branco', 0.0, 1.0, 6.0, 180.0),
('Cheddar',       0.0, 1.0, 7.0, 200.0),
('Queijo Prato',  0.0, 1.0, 7.0, 200.0),
('Muçarela',      0.0, 1.0, 7.0, 200.0),
-- Saladas / frutas
('Alface',        0.5, 1.0, 0.5, 5.0),
('Tomate',        1.0, 3.0, 0.5, 5.0),
('Abacaxi',      10.0, 13.0, 0.5, 1.0),
-- Molhos
('Maionese',          1.0, 1.0, 0.0, 150.0),
('Maionese de Ervas', 1.0, 1.0, 0.0, 140.0),
('Molho Leve',        1.0, 2.0, 0.5, 100.0),
('Molho Barbecue',    3.0, 5.0, 0.5, 200.0),
-- Acompanhamentos
('Batata',       0.5, 30.0, 3.0, 10.0),
('Cebola Empanada', 1.0, 20.0, 2.0, 150.0),
('Mix de Folhas', 0.5, 3.0, 1.0, 5.0),
-- Sobremesas
('Brownie Base',     25.0, 40.0, 4.0, 80.0),
('Cookie Massa',     20.0, 45.0, 4.0, 100.0),
('Recheio Doce de Leite', 25.0, 35.0, 2.0, 50.0),
('Cheesecake Base',  15.0, 20.0, 5.0, 60.0),
('Açaí Polpa',       12.0, 25.0, 2.0, 10.0),
('Granola',          5.0, 20.0, 3.0, 10.0),
('Banana',          12.0, 27.0, 1.0, 1.0),
('Frutas Vermelhas', 7.0, 15.0, 1.0, 2.0),
('Paçoca',           5.0, 8.0, 2.0, 50.0);

-- ================== PRODUTO_INGREDIENTE ==================
-- Hambúrgueres
INSERT INTO produto_ingrediente (produto_id, ingrediente_id) VALUES
-- Clássico da Casa
(1,1),(1,7),(1,12),(1,13),(1,15),
-- Frango da Horta
(2,2),(2,12),(2,13),(2,17),
-- Carne Magra
(3,1),(3,5),(3,12),(3,13),
-- Vegetal
(4,3),(4,5),(4,16),
-- Duplo Sabor
(5,1),(5,9),(5,6),(5,15),
-- Explosão de Queijo
(6,1),(6,10),(6,11),(6,9),(6,15),
-- Bacon Crocante
(7,1),(7,6),(7,7),(7,18);

-- Acompanhamentos
INSERT INTO produto_ingrediente (produto_id, ingrediente_id) VALUES
-- Batata Frita Tradicional
(16,19),
-- Batata Rústica
(17,19),
-- Batata Palito c/ Cheddar e Bacon
(18,19),(18,9),(18,6),
-- Onion Rings
(19,20),
-- Salada da Casa
(20,21),(20,13);

-- Molhos
INSERT INTO produto_ingrediente (produto_id, ingrediente_id) VALUES
(21,15),(21,18);

-- Sobremesas
INSERT INTO produto_ingrediente (produto_id, ingrediente_id) VALUES
-- Brownie de Chocolate
(22,22),
-- Cookie Recheado
(23,23),(23,24),
-- Cheesecake no Pote
(24,25),(24,29),
-- Açaí Tradicional
(25,26),(25,27),(25,28),(25,30);