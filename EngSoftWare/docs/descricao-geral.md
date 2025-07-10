# HJN - Sistema de Comunicação Ultra-Segura

**Desenvolvido por:** Herick, Jessé, Nicolas  

## Visão Geral
O HJN é um aplicativo de comunicação com alto nível de sigilo projetado para proteger conversas sensíveis. Utilizando criptografia de ponta a ponta e protocolos de segurança avançados, garantimos que suas mensagens permaneçam confidenciais e inacessíveis a terceiros.

## Motivação
_privacidade_

## Stakeholders e Requisitos

### Stakeholders Primários
1. **Empresários/Executivos**
   - Requisitos:
     - Comunicação segura
     - Autodestruição de mensagens

2. **Políticos/Diplomatas**
   - Requisitos:
     - Proteção contra espionagem
     - Mensagens autodestrutivas 
     - Modo Fachada

3. **Organizações Criminosas**
   - Requisitos:
     - Anonimato total
     - Rastreamento impossível
     - Destruição de metadados
     - Canais ocultos de comunicação

## Funcionalidades Principais
-  **FingerPrint para criação de Passkey**: cada conta terá uma passkey de acesso unico, porém gerada com uma fingerprint definida pelo usuário para confiança e identidade em um ambiente hostil (caso dois usuarios tenham que trocar chaves via outros meios, terão como prova de identidade as fingerprints um dos outros).
-  **Criptografia Militar**: Algoritmos AES-256 e protocolos Signal
-  **Auto-Destruição**: Mensagens apagadas após tempo configurável (instantâneo a 24h)
-  **Anti-Print**: Detecção e bloqueio de capturas de tela
-  **Autenticação Forte**: Biometria + Senha + 2FA
-  **Rede Anônima**: Roteamento através da rede Tor
-  **Resiliência a coresão**: Apaga todas as conversas instantaneamente caso insira uma senha falsa e exibe mensagens falsas

## Considerações Éticas
O HJN é desenvolvido para proteger direitos fundamentais à privacidade. Qualquer uso para atividades ilegais é explicitamente desencorajado.
