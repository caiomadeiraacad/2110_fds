package br.pucrs.nomeusuario.exemplo.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.pucrs.nomeusuario.exemplo.domain.services.ServicoDeEstoque;

@Component
public class QuantidadeDisponivelProdutoUC {
    private ServicoDeEstoque servicoEstoque;

    @Autowired
    public QuantidadeDisponivelProdutoUC(ServicoDeEstoque servicoEstoque){
        this.servicoEstoque = servicoEstoque;
    }

    public int run(long idProduto){
        return servicoEstoque.qtdadeEmEstoque(idProduto);
    }
}