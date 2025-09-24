CREATE INDEX idx_produto_categoria ON produto(categoria_id);

CREATE INDEX idx_produto_ingrediente_produto ON produto_ingrediente(produto_id);
CREATE INDEX idx_produto_ingrediente_ingrediente ON produto_ingrediente(ingrediente_id);

CREATE INDEX idx_produto_nutriente ON produto_nutriente(produto_id);
CREATE INDEX idx_nutriente_produto ON produto_nutriente(nutriente_id);

CREATE INDEX idx_ingrediente_nutriente ON ingrediente_nutriente(ingrediente_id);
CREATE INDEX idx_nutriente_ingrediente ON ingrediente_nutriente(nutriente_id);