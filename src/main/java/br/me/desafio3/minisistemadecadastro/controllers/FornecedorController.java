package br.me.desafio3.minisistemadecadastro.controllers;

import br.me.desafio3.minisistemadecadastro.models.Fornecedor;
import br.me.desafio3.minisistemadecadastro.repository.FornecedorRepository;
import br.me.desafio3.minisistemadecadastro.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/fornecedor")
public class FornecedorController {

        @Autowired
        private FornecedorService fornecedorService;
        @Autowired
        private FornecedorRepository fornecedorRepository;

        @GetMapping("/novo")
        public String adicionarFornecedor(Model model) {
            model.addAttribute("fornecedor", new Fornecedor());
            return "/cadastro-fornecedor";
        }


        @PostMapping("/salvar")
        public String salvarFornecedor(Fornecedor fornecedor, RedirectAttributes attributes) {
                  fornecedorService.insert(fornecedor);
            attributes.addFlashAttribute("mensagem", "Fornecedor salvo com sucesso!");
            return "redirect:/fornecedor/novo";
        }

        @RequestMapping("/lista")
    public  String lista(Model model){
            model.addAttribute("lista", fornecedorRepository);
            return "/auth/lista/lista";
        }
//    @RequestMapping(value = "fornecedor", params = {"addRepresentante"})
//    public ModelAndView addRepresentante(Fornecedor fornecedor) {
//        ModelAndView mv = new ModelAndView("add-fornecedor-form");
//        fornecedor.getRepresentante().add(new Representante());
//        return mv;


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    @RequestMapping(method= RequestMethod.GET)
//    public ResponseEntity<List<Fornecedor>> findAll() {
//        List<Fornecedor> list = fornecedorService.findAll();
//        List<Fornecedor> listaFornecedor = list.stream().map(x -> new Fornecedor(x)).collect(Collectors.toList());
//        return ResponseEntity.ok().body(listaFornecedor);
//    }
//
//    @RequestMapping(value="/{id}", method=RequestMethod.GET)
//    public ResponseEntity<Fornecedor> findById(@PathVariable String id) {
//        Fornecedor obj = fornecedorService.findById(id);
//        return ResponseEntity.ok().body(new Fornecedor(obj));
//    }

//    @RequestMapping(method=RequestMethod.POST)
//    public ResponseEntity<Void> insert(@RequestBody Fornecedor obj) {
//        Fornecedor fornecedor = fornecedorService.insert(obj);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
//
//    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
//    public ResponseEntity<Void> delete(@PathVariable String id) {
//        fornecedorService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
//    public ResponseEntity<Void> update(@RequestBody Fornecedor obj, @PathVariable String id) {
//        Fornecedor fornecedor = fornecedorService.update(obj);
//        obj.setId(id);
//
//        return ResponseEntity.noContent().build();
//    }

}
