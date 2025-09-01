package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

class CarrinhoTest {

    private Carrinho carrinho;

    @BeforeEach
    void setup() {
        carrinho = new Carrinho();
    }

    @Test
    @DisplayName("Deve inicializar com zero itens e valor total zero")
    void deveInicializarComZeroItens() {
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Deve esvaziar o carrinho com sucesso")
    void deveEsvaziarOCarrinho() {
        carrinho.addItem(new Produto("Item 1", 10.0));
        carrinho.addItem(new Produto("Item 2", 20.0));
        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Deve adicionar um item ao carrinho")
    void deveAdicionarUmItem() {
        carrinho.addItem(new Produto("Banana", 5.0));
        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Deve adicionar múltiplos itens ao carrinho")
    void deveAdicionarMultiplosItens() {
        carrinho.addItem(new Produto("Pão", 8.0));
        carrinho.addItem(new Produto("Leite", 12.0));
        assertEquals(2, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Deve calcular o valor total para um item")
    void deveCalcularValorTotalUmItem() {
        carrinho.addItem(new Produto("Câmera", 500.0));
        assertEquals(500.0, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Deve calcular o valor total para múltiplos itens")
    void deveCalcularValorTotalMultiplosItens() {
        carrinho.addItem(new Produto("Livro", 35.50));
        carrinho.addItem(new Produto("Caneta", 2.0));
        assertEquals(37.50, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Deve remover um item existente do carrinho")
    void deveRemoverItemExistente() throws ProdutoNaoEncontradoException {
        Produto produtoA = new Produto("Café", 15.0);
        carrinho.addItem(produtoA);
        carrinho.addItem(new Produto("Açúcar", 7.50));
        assertEquals(2, carrinho.getQtdeItems());

        carrinho.removeItem(produtoA);

        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar remover um item inexistente")
    void deveLancarExcecaoAoRemoverItemInexistente() {
        Produto produtoInexistente = new Produto("Televisão", 1500.0);

        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(produtoInexistente);
        });
    }

    @Test
    @DisplayName("Cenário completo: adicionar, remover e verificar valores")
    void cenarioCompleto() throws ProdutoNaoEncontradoException {
        Produto produto1 = new Produto("Fone", 50.0);
        Produto produto2 = new Produto("Mouse", 30.0);

        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(80.0, carrinho.getValorTotal());

        carrinho.removeItem(produto1);

        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(30.0, carrinho.getValorTotal());
    }
}