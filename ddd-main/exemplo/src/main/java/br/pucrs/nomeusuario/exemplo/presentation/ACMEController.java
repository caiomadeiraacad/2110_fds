package br.pucrs.nomeusuario.exemplo.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.pucrs.nomeusuario.exemplo.application.dtos.ProdutoDTO;
import br.pucrs.nomeusuario.exemplo.application.usecases.EfetuarVendaUC;
import br.pucrs.nomeusuario.exemplo.application.usecases.ProdutosDisponiveisUC;
import br.pucrs.nomeusuario.exemplo.application.usecases.QuantidadeDisponivelProdutoUC;

@RestController
public class ACMEController {
    private ProdutosDisponiveisUC produtosDisponiveis;
    private QuantidadeDisponivelProdutoUC quantidadeProduto; 
    private EfetuarVendaUC efetuarVenda;

    @Autowired
    public ACMEController(ProdutosDisponiveisUC produtosDisponiveis,
    QuantidadeDisponivelProdutoUC quantidadeProduto, EfetuarVendaUC efetuarVenda){
        this.produtosDisponiveis = produtosDisponiveis;
        this.quantidadeProduto = quantidadeProduto;
        this.efetuarVenda = efetuarVenda;
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

    @GetMapping("venda")
    @CrossOrigin(origins = "*")
    public double efetuarVenda(@RequestParam(value = "idProduto") long idProduto,
                               @RequestParam(value = "quantidade") int quantidade) 
    {
        return efetuarVenda.run(idProduto, quantidade);
    }
    
}
