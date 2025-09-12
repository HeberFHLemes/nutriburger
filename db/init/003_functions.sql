CREATE OR REPLACE FUNCTION calcular_dados_nutricionais()
RETURNS TRIGGER AS $$
DECLARE
    p_id INT;
BEGIN
    IF TG_OP = 'DELETE' THEN
        p_id := OLD.produto_id;
    ELSE
        p_id := NEW.produto_id;
    END IF;

    INSERT INTO produtos_dados_nutricionais (produto_id, carboidratos, proteinas, acucares, sodio)
    SELECT
        pi.produto_id,
        SUM(i.carboidratos) AS carboidratos,
        SUM(i.proteinas) AS proteinas,
        SUM(i.acucares) AS acucares,
        SUM(i.sodio) AS sodio
    FROM produtos_ingredientes pi
    JOIN ingredientes i ON pi.ingrediente_id = i.id
    WHERE pi.produto_id = p_id
    GROUP BY pi.produto_id
    ON CONFLICT (produto_id) DO UPDATE
    SET
        carboidratos = EXCLUDED.carboidratos,
        proteinas = EXCLUDED.proteinas,
        acucares = EXCLUDED.acucares,
        sodio = EXCLUDED.sodio;
    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_dados_nutricionais
AFTER INSERT OR UPDATE OR DELETE ON produtos_ingredientes
FOR EACH ROW
EXECUTE FUNCTION calcular_dados_nutricionais();