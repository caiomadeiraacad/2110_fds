package br.pucrs.nomeusuario.exemplo.domain.persistence;

import java.util.List;
import br.pucrs.nomeusuario.exemplo.domain.models.ProdutoModel;

public interface IProdutoRepositorio {
    List<ProdutoModel> todos();
    ProdutoModel consultaPorId(long codigo);
}
