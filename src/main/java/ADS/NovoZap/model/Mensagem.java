package ADS.NovoZap.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mensagens")
public class Mensagem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "conversa_id", nullable = false)
    private Conversa conversa;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String conteudoCriptografado;
    
    @Column(nullable = false)
    private LocalDateTime enviadaEm;
    
    @Column
    private LocalDateTime expiraEm;
    
    @Column(nullable = false)
    private int tempoAutodestruicao; // em segundos
    
    @Column(nullable = false)
    private boolean lida = false;
    
    @Column(nullable = false)
    private boolean destruida = false;

    // Constructors
    public Mensagem() {
        this.enviadaEm = LocalDateTime.now();
    }

    public Mensagem(Conversa conversa, String conteudoCriptografado, int tempoAutodestruicao) {
        this();
        this.conversa = conversa;
        this.conteudoCriptografado = conteudoCriptografado;
        this.tempoAutodestruicao = tempoAutodestruicao;
        this.expiraEm = this.enviadaEm.plusSeconds(tempoAutodestruicao);
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conversa getConversa() {
        return conversa;
    }

    public void setConversa(Conversa conversa) {
        this.conversa = conversa;
    }

    public String getConteudoCriptografado() {
        return conteudoCriptografado;
    }

    public void setConteudoCriptografado(String conteudoCriptografado) {
        this.conteudoCriptografado = conteudoCriptografado;
    }

    public LocalDateTime getEnviadaEm() {
        return enviadaEm;
    }

    public void setEnviadaEm(LocalDateTime enviadaEm) {
        this.enviadaEm = enviadaEm;
    }

    public LocalDateTime getExpiraEm() {
        return expiraEm;
    }

    public void setExpiraEm(LocalDateTime expiraEm) {
        this.expiraEm = expiraEm;
    }

    public int getTempoAutodestruicao() {
        return tempoAutodestruicao;
    }

    public void setTempoAutodestruicao(int tempoAutodestruicao) {
        this.tempoAutodestruicao = tempoAutodestruicao;
    }

    public boolean isLida() {
        return lida;
    }

    public void setLida(boolean lida) {
        this.lida = lida;
    }

    public boolean isDestruida() {
        return destruida;
    }

    public void setDestruida(boolean destruida) {
        this.destruida = destruida;
    }
}