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
('Frango da Horta', 'Frango grelhado, alface, tomate e molho leve', 28.90, 1),
('Cheese Leve', 'Carne, queijo branco, tomate e maionese de ervas', 29.90, 1),
('Carne Magra', 'Hambúrguer bovino com menos gordura e pão integral', 31.90, 1),
('Vegetal', 'Hambúrguer 100% vegetal com maionese de coentro', 28.90, 1),
('Duplo Sabor', 'Dois hambúrgueres bovinos, queijo cheddar, bacon e maionese especial', 37.90, 1),
('Explosão de Queijo', 'Carne bovina, queijo prato, muçarela e cheddar, tudo derretendo', 33.90, 1),
('Bacon Crocante', 'Hambúrguer bovino, muito bacon, queijo e molho barbecue', 35.90, 1);

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
('Açaí Tradicional no Copo', '300 ml – granola, banana e paçoca em potinhos separados', 16.90, 5),
('Açaí com Frutas Vermelhas', '300 ml – servido com morango, mirtilo e mel separados', 17.90, 5),
('Açaí Proteico', 'Açaí batido com whey de baunilha, potinhos de castanhas', 19.90, 5),
('Mousse de Maracujá ou Chocolate', 'Copinho 120 ml, pronto para colher', 6.90, 5);

-- ================== INGREDIENTES ==================
-- Pães e Carnes
INSERT INTO ingredientes(nome, acucares, carboidratos, proteinas, sodio) VALUES
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
('Paçoca',           5.0, 8.0, 2.0, 50.0),
('Whey Baunilha',    2.0, 3.0, 15.0, 50.0),
('Mousse Base',      12.0, 18.0, 3.0, 40.0);

-- ================== PRODUTO_INGREDIENTE ==================
-- Hambúrgueres
INSERT INTO produto_ingrediente (produto_id, ingrediente_id) VALUES
-- Clássico da Casa
(1,1),(1,7),(1,12),(1,13),(1,15),
-- Frango da Horta
(2,2),(2,12),(2,13),(2,17),
-- Cheese Leve
(3,1),(3,8),(3,13),(3,16),
-- Carne Magra
(4,1),(4,5),(4,12),(4,13),
-- Vegetal
(5,3),(5,5),(5,16),
-- Duplo Sabor
(6,1),(6,9),(6,6),(6,15),
-- Explosão de Queijo
(7,1),(7,10),(7,11),(7,9),(7,15),
-- Bacon Crocante
(8,1),(8,6),(8,7),(8,18);

-- Acompanhamentos
INSERT INTO produto_ingrediente (produto_id, ingrediente_id) VALUES
-- Batata Frita Tradicional
(17,19),
-- Batata Rústica
(18,19),
-- Batata Palito c/ Cheddar e Bacon
(19,19),(19,9),(19,6),
-- Onion Rings
(20,20),
-- Salada da Casa
(21,21),(21,13);

-- Molhos Extras (22)
INSERT INTO produto_ingrediente (produto_id, ingrediente_id) VALUES
(22,15),(22,18);

-- Sobremesas
INSERT INTO produto_ingrediente (produto_id, ingrediente_id) VALUES
-- Brownie de Chocolate
(23,22),
-- Cookie Recheado
(24,23),(24,24),
-- Cheesecake no Pote
(25,25),(25,29),
-- Açaí Tradicional
(26,26),(26,27),(26,28),(26,30),
-- Açaí com Frutas Vermelhas
(27,26),(27,29),
-- Açaí Proteico
(28,26),(28,31),(28,27),
-- Mousse de Maracujá ou Chocolate
(29,32);