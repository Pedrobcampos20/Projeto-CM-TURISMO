package br.com.sgv.controller;

import br.com.sgv.model.Viagem;
import br.com.sgv.repository.ViagemRepository;
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
 * @brief class ViagemController
 */
@Controller
public class ViagemController {

    @Autowired
    private ViagemRepository viagemRepository;

    @GetMapping("/viagens")
    public String listar(Model model) {
        model.addAttribute("listaViagens", viagemRepository.findAll());
        return "gerenciar_viagem";
    }

    @GetMapping("/viagens/novo")
    public String novo(Model model) {
        model.addAttribute("viagem", new Viagem());
        return "editar_viagem";
    }

    @GetMapping("/viagens/{id}")
    public String editar(@PathVariable("id") long id, Model model) {
        Optional<Viagem> viagem = viagemRepository.findById(id);
        model.addAttribute("viagem", viagem.get());
        return "editar_viagem";
    }

    @PostMapping("/viagens")
    public String salvar(@Valid Viagem viagem, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_viagem";
        }
        viagemRepository.save(viagem);
        return "redirect:/viagens";
    }

    @DeleteMapping("/viagens/{id}")
    public String excluir(@PathVariable("id") long id) {
        viagemRepository.deleteById(id);
        return "redirect:/viagens";
    }
}
