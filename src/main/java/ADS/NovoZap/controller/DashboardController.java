package ADS.NovoZap.controller;

import ADS.NovoZap.model.Conversa;
import ADS.NovoZap.model.Usuario;
import ADS.NovoZap.service.ConversaService;
import ADS.NovoZap.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    
    @Autowired
    private ConversaService conversaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public String dashboard(@RequestParam(required = false) String token, Model model) {
        if (token != null) {
            Usuario usuario = usuarioService.buscarPorToken(token)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            
            List<Conversa> conversas = conversaService.listarConversas(usuario);
            
            model.addAttribute("usuario", usuario);
            model.addAttribute("conversas", conversas);
        }
        
        return "dashboard";
    }
    
    @GetMapping("/fachada")
    public String fachada(Model model) {
        // Dados falsos para o modo fachada
        model.addAttribute("conversasFalsas", List.of(
            "Conversa com João - Oi, como vai?",
            "Conversa com Maria - Reunião amanhã às 14h",
            "Conversa com Pedro - Vamos almoçar?"
        ));
        return "fachada";
    }
}