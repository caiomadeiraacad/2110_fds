package br.pucrs.nomeusuario.exemplo.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.pucrs.nomeusuario.exemplo.application.dtos.ProdutoDTO;
import br.pucrs.nomeusuario.exemplo.domain.services.ServicoDeEstoque;

@Component
public class ProdutosDisponiveisUC {
    private ServicoDeEstoque servicoEstoque;

    @Autowired
    public ProdutosDisponiveisUC(ServicoDeEstoque servicoEstoque){
        this.servicoEstoque = servicoEstoque;
    }

    public List<ProdutoDTO> run(){
        return servicoEstoque.produtosDisponiveis().stream()
            .map(p->ProdutoDTO.fromModel(p))
            .toList();
    }
}
