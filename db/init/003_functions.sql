CREATE OR REPLACE FUNCTION calcular_dados_nutricionais()
RETURNS TRIGGER AS $$
DECLARE
  p_id INT;
  valor_base NUMERIC;
BEGIN
  p_id := NEW.produto_id;
  valor_base := 100.0;
  /* 
    Os dados nutricionais de um produto serão calculados com a soma do valor total de 
    todos os ingredientes do produto, para cada nutriente, considerando a quantidade 
    de cada ingrediente utilizada no produto e o valor base de 100g para um dado nutricional.
   */
  INSERT INTO produto_nutriente (produto_id, nutriente_id, dado_nutricional)
  SELECT
    pi.produto_id AS produto_id,
    n.id AS nutriente_id,
    SUM(idn.dado_nutricional * (pi.quantidade / valor_base)) AS dado_total
  FROM produto_ingrediente pi
  JOIN ingrediente_nutriente idn
    ON idn.ingrediente_id = pi.ingrediente_id
  JOIN nutriente n
    ON n.id = idn.nutriente_id
  WHERE pi.produto_id = p_id
  GROUP BY pi.produto_id, n.id
  ON CONFLICT (produto_id, nutriente_id)
  DO UPDATE SET dado_nutricional = EXCLUDED.dado_nutricional;

  RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_dados_nutricionais
AFTER INSERT OR UPDATE OR DELETE ON produto_ingrediente
FOR EACH ROW
EXECUTE FUNCTION calcular_dados_nutricionais();