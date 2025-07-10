## Caso de Uso 1: Enviar Mensagem Autodestrutiva
### Ator Principal
Usuário autenticado

### Atores Secundários
- Usuário destinatário
- Interface

### Meta no Contexto
Enviar mensagem que se autodestrói após período configurável.

### Pré-Condições
1. Remetente e destinatário estão autenticados (conexão segura, após a troca de tokens por um canal seguro)
2. Remetente possui conexão com internet
3. Acesso ao App instalado

### Fluxo Principal
1. O usuário insere ou envia o token
2. Usuário abre chat 1:1 com destinatário
3. Usuário seleciona opção "Temporizador autodestrutivo"
4. Usuário escolhe intervalo (5s, 1min, 1h, 24h)
6. Usuário digita e envia mensagem
7. Sistema exibe ícone de temporizador na mensagem
8. Destinatário recebe mensagem com contagem regressiva visível
9. Mensagem é apagada automaticamente quando o tempo expira

### Exceções
- **E1:** Falha na configuração do tempo → Mantém duração padrão
- **E2:** Destinatário offline → Mensagem na fila com temporizador iniciando na entrega
- **E3:** App fechado → Sistema gerencia exclusão em background

### Prioridade
Alta (Funcionalidade central)

### Frequência de Uso
Muito Alta (Uso frequente)

### Canais de Interação
- Interface do aplicativo (primário)

### Questões em Aberto
- Deve haver limite máximo de duração?

---

## Caso de Uso 2: Bloquear Captura de Tela
### Ator Principal
Usuário autenticado

### Atores Secundários
- Sistema operacional do dispositivo
- Serviço de monitoramento de segurança

### Meta no Contexto
Impedir captura não autorizada de conteúdo sensível.

### Pré-Condições
1. Usuário visualizando conteúdo protegido
2. App rodando na tela

### Fluxo Principal
1. Usuário abre mensagem com conteúdo sensível
2. Sistema ativa proteção contra screenshots
3. Usuário tenta capturar tela:
   - **Android:** Tela fica em branco na captura
   - **iOS:** Recebe notificação "Captura bloqueada" - 
4. Sistema registra tentativa no log de segurança
5. Convera apagada

### Exceções
- **E1:** Dispositivo com root/jailbreak → Exibe alerta de vulnerabilidade
- **E2:** Foto física com outra câmera → Notifica "Proteção física necessária"

### Prioridade
Média-Alta

### Frequência de Uso
Média (Ativado apenas para conteúdos sensíveis)

### Canais de Interação
- Alertas no aplicativo
- Vibração do dispositivo

### Questões em Aberto
- Deve notificar o remetente sobre tentativas? sim

---

## Caso de Uso 3: Ativar Modo Fachada
### Ator Principal
Usuário sob coerção

### Atores Secundários
- Serviço de emergência (opcional)
- Contatos pré-definidos
- Pessoa coagindo

### Meta no Contexto
Proteger conversas reais ao inserir senha falsa.

### Pré-Condições
1. Usuário configurou senha secundária
2. App instalado e ativo

### Fluxo Principal
1. Usuário insere senha falsa no login
2. Sistema:
   - Apaga todas as conversas reais
   - Exibe conversas fictícias pré-configuradas
   - Envia alerta silencioso para contatos de emergência (opcional)
3. Interface continua operacional sem sinal de ativação do modo

### Exceções
- **E1:** Falha na exclusão → Sobrescreve dados com lixo criptográfico
- **E2:** Sem conexão → Marca conteúdo para exclusão quando online

### Prioridade
Alta (Segurança física do usuário)

### Frequência de Uso
Baixa (Situações excepcionais)

### Canais de Interação
- Login do aplicativo
- SMS/email para contatos de emergência (configurável) (algum serviço que não deixa rastro)

### Questões em Aberto
- Como treinar usuários para usar o recurso sob estresse?
- Deve incluir localização falsa no modo fachada?
  
