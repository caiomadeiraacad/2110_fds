package br.pucrs.nomeusuario.exemplo.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.pucrs.nomeusuario.exemplo.domain.models.ProdutoModel;
import br.pucrs.nomeusuario.exemplo.domain.persistence.IProdutoRepositorio;
import br.pucrs.nomeusuario.exemplo.domain.services.ServicoDeEstoque;

@Component
public class EfetuarVendaUC {

    private IProdutoRepositorio produtoRepositorio;
    private ServicoDeEstoque servicoDeEstoque;

    @Autowired
    public EfetuarVendaUC(IProdutoRepositorio produtoRepositorio, ServicoDeEstoque servicoDeEstoque) {
        this.produtoRepositorio = produtoRepositorio;
        this.servicoDeEstoque = servicoDeEstoque;
    }

    public double run(long idProduto, int quantidadeDesejada) {
        int qtdDisponivel = servicoDeEstoque.qtdadeEmEstoque(idProduto);
        
        if (quantidadeDesejada <= 0 || quantidadeDesejada > qtdDisponivel) {
            return -1.0;
        }

        ProdutoModel produto = produtoRepositorio.consultaPorId(idProduto); 
        if (produto == null) {
            return -1.0; // Produto não encontrado (embora tenhamos estoque, o que seria estranho)
        }

        double custoFinal = produto.getPrecoUnitario() * quantidadeDesejada;

        if (quantidadeDesejada > 10) {
            custoFinal = custoFinal * 0.90;
        }
        custoFinal = custoFinal * 1.05;
        servicoDeEstoque.baixaEstoque(idProduto, quantidadeDesejada);
        return custoFinal;
    }
}