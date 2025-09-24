-- ================== CATEGORIAS ==================
INSERT INTO categoria(nome) VALUES
('Hambúrgueres'),
('Bebidas'),
('Acompanhamentos'),
('Molhos'),
('Sobremesas');

-- ================== PRODUTOS ==================
-- Hambúrgueres
INSERT INTO produto(nome, descricao, preco, imagem_url, categoria_id) VALUES
('Especial da Casa', 'Dois hambúrgueres bovinos, o dobro de queijo, o dobro de bacon, alface, tomate e maionese', 38.90, 'hamburgueres/especial_da_casa', 1),
('Frango da Horta', 'Frango grelhado, alface, tomate e molho leve', 29.90, 'logo', 1),
('Integral', 'Hambúrguer bovino e pão integral', 28.90, 'logo', 1),
('Vegetal', 'Hambúrguer 100% vegetal com maionese da casa', 28.90, 'hamburgueres/vegetal', 1),
('Duplo Sabor', 'Dois hambúrgueres bovinos, queijo cheddar, bacon e maionese especial', 35.90, 'hamburgueres/duplo_sabor', 1),
('Explosão de Queijo', 'Carne bovina, queijo prato, muçarela e cheddar, tudo derretendo', 33.90, 'logo', 1),
('Duplo Bacon', 'Hambúrguer bovino, muito bacon, queijo e molho barbecue', 34.90, 'hamburgueres/duplo_bacon', 1);

-- Bebidas
INSERT INTO produto(nome, descricao, preco, imagem_url, categoria_id) VALUES
('Coca-Cola®', 'Lata 350 ml - Tradicional ou Zero', 7.90, 'bebidas/coca', 2),
('Guaraná® Tradicional', 'Lata 350 ml', 7.90, 'bebidas/guarana', 2),
('Suco de Uva Aurora®', 'Garrafinha de vidro 300 ml – 100% integral', 9.90, 'bebidas/aurora_vidro', 2),
('Água Mineral Crystal®', 'Garrafa 500 ml - Com ou sem gás', 5.90, 'bebidas/agua', 2),
('H2OH!®', 'Garrafa 500 ml - Limão ou Limoneto', 6.90, 'bebidas/h2oh', 2);

-- Acompanhamentos
INSERT INTO produto(nome, descricao, preco, imagem_url, categoria_id) VALUES
('Batata Frita Tradicional', '150 g', 10.90, 'acompanhamentos/batata_tradicional', 3),
('Batata Rústica', 'Com casca, levemente temperada com ervas', 11.90, 'acompanhamentos/batata_rustica', 3),
('Batata Frita com Cheddar e Bacon', 'Porção - 300 g', 15.90, 'acompanhamentos/batata_e_molhos', 3),
('Onion Rings', 'Anéis de cebola empanados', 12.90, 'acompanhamentos/onion_rings', 3),
('Salada da Casa', 'Mix de folhas, tomate cereja e molho à parte', 9.90, 'acompanhamentos/salada', 3);

-- Molhos
INSERT INTO produto(nome, descricao, preco, categoria_id) VALUES
('Molhos Extras', 'Maionese temperada, barbecue, ketchup especial', 4.90, 4);

-- Sobremesas
INSERT INTO produto(nome, descricao, preco, imagem_url, categoria_id) VALUES
('Brownie de Chocolate', 'Embalado em caixinha, com ou sem calda', 8.90, 'sobremesas/brownie', 5),
('Cookie Recheado', 'Chocolate ou doce de leite', 7.90, 'sobremesas/cookie', 5),
('Cheesecake no Pote', 'Frutas vermelhas ou maracujá', 9.90, 'sobremesas/cheesecake', 5),
('Açaí Tradicional no Copo', '300 ml – granola, banana e paçoca em potinhos separados', 16.90, 'sobremesas/acai', 5);

-- ================== INGREDIENTES ==================
INSERT INTO ingrediente(nome) VALUES
('Hambúrguer Bovino'),
('Frango Grelhado'),
('Legumes e Grãos'),
('Pão Tradicional'),
('Pão Integral'),
('Bacon'),
('Queijo'),
('Queijo Branco'),
('Cheddar'),
('Queijo Prato'),
('Muçarela'),
('Alface'),
('Tomate'),
('Abacaxi'),
('Maionese'),
('Maionese de Ervas'),
('Molho Leve'),
('Molho Barbecue'),
('Batata'),
('Cebola Empanada'),
('Mix de Folhas'),
('Brownie Base'),
('Cookie Massa'),
('Recheio Doce de Leite'),
('Cheesecake Base'),
('Açaí Polpa'),
('Granola'),
('Banana'),
('Frutas Vermelhas'),
('Paçoca');

-- ================== NUTRIENTES ==================
INSERT INTO nutriente(nome, unidade_medida) VALUES
('Calorias', 'kcal'),
('Carboidratos', 'g'),
('Açúcares Totais', 'g'),
('Proteínas', 'g'),
('Gorduras Totais', 'g'),
('Fibras Alimentares', 'g'),
('Sódio', 'mg');