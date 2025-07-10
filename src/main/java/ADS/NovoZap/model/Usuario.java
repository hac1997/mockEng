package ADS.NovoZap.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String token;
    
    @Column(nullable = false)
    private String fingerprint;
    
    @Column(nullable = false)
    private String senhaHash;
    
    @Column
    private String senhaFachada;
    
    @Column(nullable = false)
    private LocalDateTime criadoEm;
    
    @Column
    private LocalDateTime ultimoAcesso;
    
    @Column(nullable = false)
    private boolean ativo = true;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Conversa> conversas;

    // Constructors
    public Usuario() {
        this.criadoEm = LocalDateTime.now();
    }

    public Usuario(String token, String fingerprint, String senhaHash) {
        this();
        this.token = token;
        this.fingerprint = fingerprint;
        this.senhaHash = senhaHash;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public String getSenhaFachada() {
        return senhaFachada;
    }

    public void setSenhaFachada(String senhaFachada) {
        this.senhaFachada = senhaFachada;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Conversa> getConversas() {
        return conversas;
    }

    public void setConversas(List<Conversa> conversas) {
        this.conversas = conversas;
    }
}