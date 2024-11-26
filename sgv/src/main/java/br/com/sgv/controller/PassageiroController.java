package br.com.sgv.controller;

import br.com.sgv.model.Passageiro;
import br.com.sgv.repository.PassageiroRepository;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Pedro Baptista <pedrobcampos20@hotmail.com>
 * @date 15/11/2024
 * @brief class PassageiroController
 */
@Controller
public class PassageiroController {

    @Autowired
    private PassageiroRepository passageiroRepository;

    @GetMapping("/passageiros")
    public String listar(Model model) {
        model.addAttribute("listaPessoasFisicas", passageiroRepository.findAll());
        return "gerenciar_passageiros";
    }

    @GetMapping("/passageiros/novo")
    public String novo(Model model) {
        model.addAttribute("passaGeiro", new Passageiro());
        return "editar_passageiros";
    }

    @GetMapping("/passageiros/{id}")
    public String editar(@PathVariable("id") long id, Model model) {
        Optional<Passageiro> passaGeiro = passageiroRepository.findById(id);
        model.addAttribute("passaGeiro", passaGeiro.get());
        return "editar_passageiros";
    }

    @PostMapping("/passageiros")
    public String salvar(@Valid Passageiro passaGeiro, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_passageiros";
        }
        passageiroRepository.save(passaGeiro);
        return "redirect:/passageiros";
    }

    @DeleteMapping("/passageiros/{id}")
    public String excluir(@PathVariable("id") long id) {
        passageiroRepository.deleteById(id);
        return "redirect:/passageiros";
    }
}
