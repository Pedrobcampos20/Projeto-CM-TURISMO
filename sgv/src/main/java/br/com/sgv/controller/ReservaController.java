package br.com.sgv.controller;

import br.com.sgv.model.Item;
import br.com.sgv.model.Reserva;
import br.com.sgv.repository.ViagemRepository;
import br.com.sgv.repository.ReservaRepository;
import jakarta.validation.Valid;
import java.util.Iterator;
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
 * @date 23/11/2024
 * @brief class ReservaController
*/

@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private ViagemRepository viagemRepository;
    private Reserva reserva;

    @GetMapping("/vendas")
    public String listarReservas(Model model) {
        model.addAttribute("listaReservas", reservaRepository.findAll());
        return "gerenciar_reservas";
    }

    @GetMapping("/vendas/novo")
    public String novo(Model model) {
        reserva = new Reserva();
        reservaRepository.save(reserva);
        model.addAttribute("listaViagens", viagemRepository.findAll());
        model.addAttribute("reserva", reserva);
        model.addAttribute("item", new Item());
        return "editar_reserva";
    }

    @GetMapping("/vendas/{id}")
    public String editar(@PathVariable("id") long idVenda, Model model) {
        Optional<Reserva> busca = reservaRepository.findById(idVenda);
        reserva = busca.get();
        model.addAttribute("reserva", reserva);
        model.addAttribute("item", new Item());
        model.addAttribute("listaViagens", viagemRepository.findAll());
        return "editar_reserva";
    }

    @PostMapping("/vendas")
    public String salvar(@Valid Reserva reserva, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_reserva";
        }
        this.reserva.setDataVenda(reserva.getDataVenda());
        reservaRepository.save(this.reserva);
        return "redirect:/vendas";
    }
    
    @PostMapping("/vendas/itens")
    public String adicionarItem(@Valid Item item, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_reserva";
        }
        if (item.getViagem() != null){
            reserva.adicionarItem(item);
            item.setReserva(reserva);
            reservaRepository.save(reserva);
        }
        String url = "redirect:/vendas/"+reserva.getId();
        return url;
    }

    @GetMapping("/vendas/itens/{id}")
    public String removerItem(@PathVariable("id") long id) {
        Item aux = null;
        Iterator<Item> iterator = reserva.getListaItens().iterator();
        while (iterator.hasNext()){
            Item i = iterator.next();
            if (i.getId() == id){
                aux = i;
                break;
            }
        }
        if (aux != null){
            reserva.removerItem(aux);
            aux.setReserva(null);
            reservaRepository.save(reserva);
        }
        String url = "redirect:/vendas/"+reserva.getId();
        return url;
    }
    
    @DeleteMapping("/vendas/{id}")
    public String excluir(@PathVariable("id") long id) {
        reservaRepository.deleteById(id);
        return "redirect:/vendas";
    }
}

/** coloquei comentario para testes */