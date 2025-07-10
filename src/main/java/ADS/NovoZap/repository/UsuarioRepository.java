package ADS.NovoZap.repository;

import ADS.NovoZap.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findByToken(String token);
    
    Optional<Usuario> findByFingerprint(String fingerprint);
    
    boolean existsByToken(String token);
    
    boolean existsByFingerprint(String fingerprint);
}