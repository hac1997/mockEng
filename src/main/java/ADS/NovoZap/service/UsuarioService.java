package ADS.NovoZap.service;

import ADS.NovoZap.model.Usuario;
import ADS.NovoZap.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private CriptografiaService criptografiaService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public Usuario criarUsuario(String palavrasFingerprint, String senha) {
        String token = criptografiaService.gerarToken();
        String fingerprint = criptografiaService.gerarFingerprint(palavrasFingerprint);
        String senhaHash = passwordEncoder.encode(senha);
        
        Usuario usuario = new Usuario(token, fingerprint, senhaHash);
        return usuarioRepository.save(usuario);
    }
    
    public Optional<Usuario> buscarPorToken(String token) {
        return usuarioRepository.findByToken(token);
    }
    
    public boolean verificarSenha(Usuario usuario, String senha) {
        return passwordEncoder.matches(senha, usuario.getSenhaHash());
    }
    
    public boolean verificarSenhaFachada(Usuario usuario, String senha) {
        if (usuario.getSenhaFachada() == null) {
            return false;
        }
        return passwordEncoder.matches(senha, usuario.getSenhaFachada());
    }
    
    public void definirSenhaFachada(Usuario usuario, String senhaFachada) {
        usuario.setSenhaFachada(passwordEncoder.encode(senhaFachada));
        usuarioRepository.save(usuario);
    }
    
    public void atualizarUltimoAcesso(Usuario usuario) {
        usuario.setUltimoAcesso(LocalDateTime.now());
        usuarioRepository.save(usuario);
    }
    
    public boolean tokenExiste(String token) {
        return usuarioRepository.existsByToken(token);
    }
    
    public void ativarModoFachada(Usuario usuario) {
        // Implementar lógica para apagar conversas reais e mostrar dados falsos
        usuario.setAtivo(false);
        usuarioRepository.save(usuario);
    }
}