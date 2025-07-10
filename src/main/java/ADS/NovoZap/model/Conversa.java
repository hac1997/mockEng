package ADS.NovoZap.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "conversas")
public class Conversa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    
    @Column(nullable = false)
    private String tokenDestinatario;
    
    @Column(nullable = false)
    private String chaveE2E;
    
    @Column(nullable = false)
    private LocalDateTime criadaEm;
    
    @Column(nullable = false)
    private boolean bloqueioScreenshot = false;
    
    @Column(nullable = false)
    private boolean ativa = true;
    
    @OneToMany(mappedBy = "conversa", cascade = CascadeType.ALL)
    private List<Mensagem> mensagens;

    // Constructors
    public Conversa() {
        this.criadaEm = LocalDateTime.now();
    }

    public Conversa(Usuario usuario, String tokenDestinatario, String chaveE2E) {
        this();
        this.usuario = usuario;
        this.tokenDestinatario = tokenDestinatario;
        this.chaveE2E = chaveE2E;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTokenDestinatario() {
        return tokenDestinatario;
    }

    public void setTokenDestinatario(String tokenDestinatario) {
        this.tokenDestinatario = tokenDestinatario;
    }

    public String getChaveE2E() {
        return chaveE2E;
    }

    public void setChaveE2E(String chaveE2E) {
        this.chaveE2E = chaveE2E;
    }

    public LocalDateTime getCriadaEm() {
        return criadaEm;
    }

    public void setCriadaEm(LocalDateTime criadaEm) {
        this.criadaEm = criadaEm;
    }

    public boolean isBloqueioScreenshot() {
        return bloqueioScreenshot;
    }

    public void setBloqueioScreenshot(boolean bloqueioScreenshot) {
        this.bloqueioScreenshot = bloqueioScreenshot;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }
}