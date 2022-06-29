package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class AdministrativoApp {
    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(BigDecimal.valueOf(300.0));
        p1.setQuantidade(100);
        p1.setStatus(true);

        // 1) Criando um produto
        produtoModel.create(p1);

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        //3) Buscando um produto pelo id
        Produto p2 = produtoModel.findById(1);
        System.out.println("Produto encontrado : " + p2.getNome());

        //4) Atualizando um produto
        p2.setNome("TV LED");
        produtoModel.update(p2);

        //5) Deletando um produto
        produtoModel.delete(p2.getId());


        PessoaModel pessoaModel = new PessoaModel();

        //1) Criando uma pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Antonio Augusto");
        pessoa.setEmail("antonio@email.com.br");
        pessoa.setTelefone("(11) 91234-5678");
        pessoa.setCpf("000.000.000-00");

        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.set(Calendar.YEAR, 1990);
        dataNascimento.set(Calendar.MONTH, Calendar.FEBRUARY);
        dataNascimento.set(Calendar.DAY_OF_MONTH, 25);
        pessoa.setIdade(31);
        pessoa.setDataNascimento(dataNascimento);

        pessoaModel.create(pessoa);

        //2) Buscando todas as pessoas na base de dados
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas : " + pessoas.size());

        //3) Buscando uma pessoa pelo id
        Pessoa pessoa2 = pessoaModel.findById(1);
        System.out.println("Pessoa encontrada : " + pessoa2.getNome());

        //4) Atualizando uma pessoa
        pessoa2.setNome("Antonio Augusto");
        pessoaModel.update(pessoa2);

        //5) Deletando uma pessoa
        pessoaModel.delete(pessoa2.getId());
    }
}