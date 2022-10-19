package br.me.desafio3.minisistemadecadastro.config;

import br.me.desafio3.minisistemadecadastro.models.Endereco;
import br.me.desafio3.minisistemadecadastro.models.Fornecedor;
import br.me.desafio3.minisistemadecadastro.models.Usuario;
import br.me.desafio3.minisistemadecadastro.repository.FornecedorRepository;
import br.me.desafio3.minisistemadecadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioReposiroty;
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    public void run(String... arg0) throws Exception {


        usuarioReposiroty.deleteAll();
        fornecedorRepository.deleteAll();

        Usuario salo = new Usuario("1", "salo@salo.com", "1111");
        Usuario amanda = new Usuario("2", "amanda@amanda.com", "2222");
        Usuario hugo = new Usuario("3", "hugo@hugo.com", "3333");

        usuarioReposiroty.saveAll(Arrays.asList(salo, amanda, hugo));

        List<String> l1 = new ArrayList<>();
        l1.add("1111111111");
        l1.add("2222222222");
        l1.add("3333333333");


        Endereco e1 = new Endereco(null, "cep", "logradouro", "numero","comp", "bairro" , "cidade", "estaedo");


		Fornecedor f1 = new Fornecedor(null, "fornecedor1", "contato1", "1email@email.com","true","111111111", l1, e1, "testando descricao1") ;
		Fornecedor f2 = new Fornecedor(null, "fornecedor2", "contato2", "2email@email.com","cnpj","111111111", l1, e1 , "testando descricao2") ;
		Fornecedor f3 = new Fornecedor(null, "fornecedor3", "contato3", "3email@email.com","cpf","111111111", l1, e1, "testando descricao3") ;

		fornecedorRepository.saveAll(Arrays.asList(f1,f2,f3));
    }

}
