package br.com.sgv.controller;

import br.com.sgv.model.Historico;
import br.com.sgv.repository.HistoricoRepository;
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
 * @brief class HistoricoController
 */
@Controller
public class HistoricoController {

    @Autowired
    private HistoricoRepository historicoRepository;

    @GetMapping("/historico")
    public String listar(Model model) {
        model.addAttribute("listaHistorico", historicoRepository.findAll());
        return "gerenciar_historico";
    }

    @GetMapping("/historico/novo")
    public String novo(Model model) {
        model.addAttribute("hisTorico", new Historico());
        return "editar_historico";
    }

    @GetMapping("/historico/{id}")
    public String editar(@PathVariable("id") long id, Model model) {
        Optional<Historico> hisTorico = historicoRepository.findById(id);
        model.addAttribute("hisTorico", hisTorico.get());
        return "editar_historico";
    }

    @PostMapping("/historico")
    public String salvar(@Valid Historico hisTorico, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_historico";
        }
        historicoRepository.save(hisTorico);
        return "redirect:/historico";
    }

    @DeleteMapping("/historico/{id}")
    public String excluir(@PathVariable("id") long id) {
        historicoRepository.deleteById(id);
        return "redirect:/historico";
    }
}
