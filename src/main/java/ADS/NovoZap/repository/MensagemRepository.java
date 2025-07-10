package ADS.NovoZap.repository;

import ADS.NovoZap.model.Mensagem;
import ADS.NovoZap.model.Conversa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
    
    List<Mensagem> findByConversaAndDestruidaFalseOrderByEnviadaEmDesc(Conversa conversa);
    
    @Query("SELECT m FROM Mensagem m WHERE m.expiraEm <= :agora AND m.destruida = false")
    List<Mensagem> findMensagensExpiradas(LocalDateTime agora);
    
    void deleteByConversaAndDestruidaFalse(Conversa conversa);
}