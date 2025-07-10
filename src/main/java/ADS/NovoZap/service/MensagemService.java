package ADS.NovoZap.service;

import ADS.NovoZap.model.Conversa;
import ADS.NovoZap.model.Mensagem;
import ADS.NovoZap.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MensagemService {
    
    @Autowired
    private MensagemRepository mensagemRepository;
    
    @Autowired
    private CriptografiaService criptografiaService;
    
    public Mensagem enviarMensagem(Conversa conversa, String conteudo, int tempoAutodestruicao) {
        String conteudoCriptografado = criptografiaService.criptografar(conteudo, conversa.getChaveE2E());
        
        Mensagem mensagem = new Mensagem(conversa, conteudoCriptografado, tempoAutodestruicao);
        return mensagemRepository.save(mensagem);
    }
    
    public List<Mensagem> listarMensagens(Conversa conversa) {
        return mensagemRepository.findByConversaAndDestruidaFalseOrderByEnviadaEmDesc(conversa);
    }
    
    public String descriptografarMensagem(Mensagem mensagem) {
        return criptografiaService.descriptografar(
            mensagem.getConteudoCriptografado(), 
            mensagem.getConversa().getChaveE2E()
        );
    }
    
    public void marcarComoLida(Mensagem mensagem) {
        mensagem.setLida(true);
        mensagemRepository.save(mensagem);
    }
    
    @Scheduled(fixedRate = 30000) // Executa a cada 30 segundos
    @Transactional
    public void destruirMensagensExpiradas() {
        LocalDateTime agora = LocalDateTime.now();
        List<Mensagem> mensagensExpiradas = mensagemRepository.findMensagensExpiradas(agora);
        
        for (Mensagem mensagem : mensagensExpiradas) {
            mensagem.setDestruida(true);
            mensagem.setConteudoCriptografado("DESTRUÍDA");
            mensagemRepository.save(mensagem);
        }
    }
    
    public void destruirTodasMensagens(Conversa conversa) {
        mensagemRepository.deleteByConversaAndDestruidaFalse(conversa);
    }
}