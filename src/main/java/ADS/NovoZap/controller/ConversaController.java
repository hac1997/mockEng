package ADS.NovoZap.controller;

import ADS.NovoZap.model.Conversa;
import ADS.NovoZap.model.Mensagem;
import ADS.NovoZap.model.Usuario;
import ADS.NovoZap.service.ConversaService;
import ADS.NovoZap.service.MensagemService;
import ADS.NovoZap.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/conversa")
public class ConversaController {
    
    @Autowired
    private ConversaService conversaService;
    
    @Autowired
    private MensagemService mensagemService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/iniciar")
    public String iniciarConversa(@RequestParam String tokenUsuario,
                                 @RequestParam String tokenDestinatario,
                                 RedirectAttributes redirectAttributes) {
        try {
            Usuario usuario = usuarioService.buscarPorToken(tokenUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            
            Conversa conversa = conversaService.iniciarConversa(usuario, tokenDestinatario);
            
            return "redirect:/conversa/" + conversa.getId() + "?token=" + tokenUsuario;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao iniciar conversa: " + e.getMessage());
            return "redirect:/dashboard?token=" + tokenUsuario;
        }
    }
    
    @GetMapping("/{id}")
    public String visualizarConversa(@PathVariable Long id,
                                   @RequestParam String token,
                                   Model model) {
        try {
            Usuario usuario = usuarioService.buscarPorToken(token)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            
            Conversa conversa = conversaService.buscarConversa(id)
                .orElseThrow(() -> new RuntimeException("Conversa não encontrada"));
            
            List<Mensagem> mensagens = mensagemService.listarMensagens(conversa);
            
            model.addAttribute("usuario", usuario);
            model.addAttribute("conversa", conversa);
            model.addAttribute("mensagens", mensagens);
            model.addAttribute("mensagemService", mensagemService);
            
            return "conversa";
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            return "dashboard";
        }
    }
    
    @PostMapping("/{id}/enviar")
    public String enviarMensagem(@PathVariable Long id,
                                @RequestParam String token,
                                @RequestParam String conteudo,
                                @RequestParam(defaultValue = "300") int tempoAutodestruicao,
                                RedirectAttributes redirectAttributes) {
        try {
            Conversa conversa = conversaService.buscarConversa(id)
                .orElseThrow(() -> new RuntimeException("Conversa não encontrada"));
            
            mensagemService.enviarMensagem(conversa, conteudo, tempoAutodestruicao);
            
            return "redirect:/conversa/" + id + "?token=" + token;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao enviar mensagem: " + e.getMessage());
            return "redirect:/conversa/" + id + "?token=" + token;
        }
    }
    
    @PostMapping("/{id}/bloquear-screenshot")
    public String bloquearScreenshot(@PathVariable Long id,
                                   @RequestParam String token,
                                   RedirectAttributes redirectAttributes) {
        try {
            Conversa conversa = conversaService.buscarConversa(id)
                .orElseThrow(() -> new RuntimeException("Conversa não encontrada"));
            
            conversaService.ativarBloqueioScreenshot(conversa);
            redirectAttributes.addFlashAttribute("sucesso", "Bloqueio de screenshot ativado");
            
            return "redirect:/conversa/" + id + "?token=" + token;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao ativar bloqueio: " + e.getMessage());
            return "redirect:/conversa/" + id + "?token=" + token;
        }
    }
}