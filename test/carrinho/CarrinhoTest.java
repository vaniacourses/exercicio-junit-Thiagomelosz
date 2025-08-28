package carrinho;

import calculadora.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.*;

public class CarrinhoTest {

    private Carrinho carr;

    @BeforeEach
    public void inicializa() {
        carr = new Carrinho();
    }

    @DisplayName("Teste Add Item no Carrinh")
    @Test
    public void addItemCarrinho() {
        Produto produto = new Produto("cafifa", 0.80);
        carr.addItem(produto);
        int result = carr.getQtdeItems();

        assertEquals(1,result);
    }

    @DisplayName("Teste add dois itens no carrinho")
    @Test
    public void add2ItensCarrinho() {
        Produto produto = new Produto("carretilha",15);
        Produto produto1 = new Produto("linha chilena",25);
        carr.addItem(produto1);
        carr.addItem(produto);

        int result = carr.getQtdeItems();

        assertEquals(2,result);
    }

    @DisplayName("Remover item do carrinho")
    @Test
    public void removeItemCarrinho() throws ProdutoNaoEncontradoException {
        Produto produto = new Produto("Raia",0.50);
        Produto produto1 = new Produto("linha laser",25);
        carr.addItem(produto1);
        carr.addItem(produto);

        int result = carr.getQtdeItems();

        assertEquals(2,result);

        carr.removeItem(produto);

        int result1 = carr.getQtdeItems();

        assertEquals(1,result1);
    }

}
