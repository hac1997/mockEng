package ADS.NovoZap.repository;

import ADS.NovoZap.model.Conversa;
import ADS.NovoZap.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ConversaRepository extends JpaRepository<Conversa, Long> {
    
    List<Conversa> findByUsuarioAndAtivaTrue(Usuario usuario);
    
    Optional<Conversa> findByUsuarioAndTokenDestinatarioAndAtivaTrue(Usuario usuario, String tokenDestinatario);
    
    List<Conversa> findByTokenDestinatarioAndAtivaTrue(String tokenDestinatario);
}