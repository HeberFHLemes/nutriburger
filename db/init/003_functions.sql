CREATE OR REPLACE FUNCTION calcular_dados_nutricionais()
RETURNS TRIGGER AS $$
DECLARE
  p_id INT;
BEGIN
  
  p_id := NEW.produto_id;

  INSERT INTO produto_dados_nutricionais (produto_id, acucares, carboidratos, proteinas, sodio)
  SELECT
    pi.produto_id,
    SUM(i.acucares) AS acucares,
    SUM(i.carboidratos) AS carboidratos,
    SUM(i.proteinas) AS proteinas,
    SUM(i.sodio) AS sodio
  FROM produto_ingrediente pi
  JOIN ingredientes i ON pi.ingrediente_id = i.id
  WHERE pi.produto_id = p_id
  GROUP BY pi.produto_id
  ON CONFLICT (produto_id) DO UPDATE
  SET
    acucares = EXCLUDED.acucares,
    carboidratos = EXCLUDED.carboidratos,
    proteinas = EXCLUDED.proteinas,
    sodio = EXCLUDED.sodio;

  RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_dados_nutricionais
AFTER INSERT OR UPDATE ON produto_ingrediente
FOR EACH ROW
EXECUTE FUNCTION calcular_dados_nutricionais();