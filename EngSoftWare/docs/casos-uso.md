## 1.0: Usuário se autentica via fingerprint - (SPRINT 1)
<pre>
Ator Principal: Usuário
Atores Secundários: Servidor de tokens
Meta no Contexto: Gerar token seguro baseado em fingerprint para autenticação
Pré-condições:
    1. Aplicativo instalado/configurado
    2. Fingerprint registrada no dispositivo
Fluxo Principal:
    1. Usuário abre aplicativo
    2. Sistema verifica se o usuário ja tem um Token
Se Houver: 
    3. Entra no app
    4. Usuário pode compartilhar token via canal seguro (QR code, email, etc)

Exceções: 
    E1: usuario não tem passkey
    1. Usuário escolhe um conjunto de palavras para ser sua fingerprint
    2. Sistema valida fingerprint e gera token criptografado
    3. Token armazenado localmente e vinculado à sessão
Prioridade: Alta
Frequência de Uso: baixa
Canais de Interação: Interface do aplicativo
</pre>
## Caso de Uso 1.1: Definir mensagem autodestrutiva - (SPRINT 1)
<pre>
Ator Principal: Usuário autenticado
Atores Secundários: Destinatário, Sistema de temporizador
Meta no Contexto: Mensagens apagadas automaticamente após período configurável
Fluxo Principal:
    1. Usuário digita mensagem
    2. Seleciona ícone "Temporizador"
    3. Escolhe tempo (5s-24h)
    4. Envia mensagem
    5. Sistema exibe contagem regressiva
    5. Mensagem apagada após término
Exceções:
    E1: Destinatário offline → Temporizador inicia na entrega
    E2: Erro no servidor → Apaga localmente
    E3: Temporizador Falhas → Roda temporizador novamente
Prioridade: Alta
Frequência de Uso: Alta
Canais de Interação: Interface do chat
Questões em Aberto: Limite máximo de tempo?
</pre>
## Caso de Uso 1.2: Iniciar chat 1:1 ou em grupo - (SPRINT 1)
<pre>
Ator Principal: Usuário autenticado
Atores Secundários: Outros usuários, Sistema de criptografia
Meta no Contexto: Iniciar chat 1:1 ou em grupo de forma segura, sem erro
Fluxo Principal:
    1. Obtem o token do outro usuario (ou envia a sua via um canal seguro)
    2. Insere o token e autentica o usuario via fingerprint
    3. Seleciona "Novo Chat"
    4. Escolhe:
        1:1 → Cria sala criptografada
        Grupo → Gera sala criptografada permitindo adicionar outros usuarios
Exceções:
    E1: Usuario inexistente -> exibe mensagem de erro
    E2: Usuário não é oquem diz ser (autenticado via fingerprint) -> exibe mensagem de perigo

Prioridade: Alta
Frequência de Uso: Muito alta
Questões em Aberto: Número máximo no grupo?
</pre>
## Caso de Uso 1.3: Bloquear captura de tela - (SPRINT 1)
<pre>
Ator Principal: Usuário autenticado
Meta no Contexto: Não permitir captura de tela
Fluxo Principal:
    1. Ativa "Bloquear screenshots" na conversa
    2. Ao qualquer usuario tentar printar a conversa:
        Bloqueia o printScreen
        Exibe mensagem de alerta para o outro usuario
        Registra tentativas
        Conversa bloqueada se exceder limite de tentativas
Exceções:
    E1: Dispositivo root → Alerta vulnerabilidade
    E2: Foto com câmera → Sem alternativas
Prioridade: Média-Alta
Frequência de Uso: Média
Questões em Aberto: Notificar remetente? - Não
</pre>

## Caso de Uso 1.4: Ativar modo fachada - (SPRINT 1)
<pre>
Ator Principal: Usuário coagido
Fluxo Principal:
    1. Insere senha falsa
    2. Sistema:
        Apaga conversas reais
        Exibe chats fictícios
Exceções:
   E1: falha -> aplicativo comprometido
Prioridade: Alta
Frequência de Uso: Muito baixa
</pre>

## Caso de Uso 1.5: Chamada de voz criptografada
<pre>
Ator Principal: Dois Usuários autenticados
Fluxo Principal:
    1. Seleciona "Chamada de Voz"
    2. Estabelece conexão E2EE
    3. Roteia via Tor (opcional)
    4. So guarda metadados minimos
Exceções:
   E1: bloqueado por grupo -> desbloquear nas configurações de conversa
Prioridade: Média-Alta
</pre>

## Caso de Uso 1.6: Acessar aplicativo invisível
<pre>
Ator Principal: Usuario
Fluxo Principal:
    1. Abre app de chamada nativo
    2. Digita código secreto na discagem (ex: *#1234#)
    3. Abre app
Exceções:
    E1: Usuario não tem codigo definido
    1. Deixa o aplicativo visivel junto aos demais
    2. ao acessar, exibe opção de criar codigo secreto
    3. ao criar, aplicativo fica invisivel e somente acessivel via código
Prioridade: Média
Frequência de Uso:Alta (toda vez/aplicativo invisivél)
</pre>
