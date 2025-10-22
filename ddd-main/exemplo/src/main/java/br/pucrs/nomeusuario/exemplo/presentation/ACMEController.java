package br.pucrs.nomeusuario.exemplo.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.pucrs.nomeusuario.exemplo.application.dtos.ProdutoDTO;
import br.pucrs.nomeusuario.exemplo.application.usecases.ProdutosDisponiveisUC;
import br.pucrs.nomeusuario.exemplo.application.usecases.QuantidadeDisponivelProdutoUC;

@RestController
public class ACMEController {
    private ProdutosDisponiveisUC produtosDisponiveis;
    private QuantidadeDisponivelProdutoUC quantidadeProduto; 

    @Autowired
    public ACMEController(ProdutosDisponiveisUC produtosDisponiveis,
    QuantidadeDisponivelProdutoUC quantidadeProduto){
        this.produtosDisponiveis = produtosDisponiveis;
        this.quantidadeProduto = quantidadeProduto;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String mensagem(){
        return("Bem vindo a loja ACME!");
    }

    @GetMapping("produtos")
    @CrossOrigin(origins = "*")
    public List<ProdutoDTO> produtosDisponiveis(){
        return produtosDisponiveis.run();
    } 

    @GetMapping("quantidade/{id}")
    @CrossOrigin(origins = "*")
    public int quantidadeProduto(@PathVariable(value="id") long idProduto){
        return quantidadeProduto.run(idProduto);
    } 

}
