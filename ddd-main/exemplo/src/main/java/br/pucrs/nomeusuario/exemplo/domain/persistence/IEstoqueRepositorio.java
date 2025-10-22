package br.pucrs.nomeusuario.exemplo.domain.persistence;

import java.util.List;
import br.pucrs.nomeusuario.exemplo.domain.models.ProdutoModel;

public interface IEstoqueRepositorio {
    List<ProdutoModel> todos();
    List<ProdutoModel> todosComEstoque();
    int quantidadeEmEstoque(long codigo);
    void baixaEstoque(long codProd, int qtdade);
}