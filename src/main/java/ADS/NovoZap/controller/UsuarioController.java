package ADS.NovoZap.controller;

import ADS.NovoZap.model.Usuario;
import ADS.NovoZap.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/criar")
    public String criarUsuario(@RequestParam String palavrasFingerprint,
                              @RequestParam String senha,
                              RedirectAttributes redirectAttributes) {
        try {
            Usuario usuario = usuarioService.criarUsuario(palavrasFingerprint, senha);
            redirectAttributes.addFlashAttribute("sucesso", 
                "Usuário criado com sucesso! Seu token é: " + usuario.getToken());
            return "redirect:/login";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao criar usuário: " + e.getMessage());
            return "redirect:/register";
        }
    }
    
    @PostMapping("/autenticar")
    public String autenticar(@RequestParam String token,
                           @RequestParam String senha,
                           RedirectAttributes redirectAttributes) {
        try {
            Usuario usuario = usuarioService.buscarPorToken(token)
                .orElseThrow(() -> new RuntimeException("Token inválido"));
            
            // Verificar se é senha de fachada
            if (usuarioService.verificarSenhaFachada(usuario, senha)) {
                usuarioService.ativarModoFachada(usuario);
                redirectAttributes.addFlashAttribute("info", "Modo fachada ativado");
                return "redirect:/fachada";
            }
            
            // Verificar senha normal
            if (usuarioService.verificarSenha(usuario, senha)) {
                usuarioService.atualizarUltimoAcesso(usuario);
                return "redirect:/dashboard";
            } else {
                throw new RuntimeException("Senha incorreta");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro na autenticação: " + e.getMessage());
            return "redirect:/login";
        }
    }
}