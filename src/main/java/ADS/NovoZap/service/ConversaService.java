package ADS.NovoZap.service;

import ADS.NovoZap.model.Conversa;
import ADS.NovoZap.model.Usuario;
import ADS.NovoZap.repository.ConversaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConversaService {
    
    @Autowired
    private ConversaRepository conversaRepository;
    
    @Autowired
    private CriptografiaService criptografiaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    public Conversa iniciarConversa(Usuario usuario, String tokenDestinatario) {
        // Verificar se o destinatário existe
        if (!usuarioService.tokenExiste(tokenDestinatario)) {
            throw new RuntimeException("Usuário destinatário não encontrado");
        }
        
        // Verificar se já existe uma conversa ativa
        Optional<Conversa> conversaExistente = conversaRepository
            .findByUsuarioAndTokenDestinatarioAndAtivaTrue(usuario, tokenDestinatario);
        
        if (conversaExistente.isPresent()) {
            return conversaExistente.get();
        }
        
        // Criar nova conversa com chave E2E
        String chaveE2E = criptografiaService.gerarChaveE2E();
        Conversa conversa = new Conversa(usuario, tokenDestinatario, chaveE2E);
        
        return conversaRepository.save(conversa);
    }
    
    public List<Conversa> listarConversas(Usuario usuario) {
        return conversaRepository.findByUsuarioAndAtivaTrue(usuario);
    }
    
    public Optional<Conversa> buscarConversa(Long id) {
        return conversaRepository.findById(id);
    }
    
    public void ativarBloqueioScreenshot(Conversa conversa) {
        conversa.setBloqueioScreenshot(true);
        conversaRepository.save(conversa);
    }
    
    public void desativarBloqueioScreenshot(Conversa conversa) {
        conversa.setBloqueioScreenshot(false);
        conversaRepository.save(conversa);
    }
    
    public void encerrarConversa(Conversa conversa) {
        conversa.setAtiva(false);
        conversaRepository.save(conversa);
    }
}