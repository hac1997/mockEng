# Arquitetura do Sistema - HJN: Sistema de Comunicação Ultra-Segura

## Arquitetura Adotada

### Padrão Arquitetural: MVC + Broker

O sistema é estruturado em camadas bem definidas:

- **Camada de Apresentação (View)**: Responsável pela interface com o usuário, entrega e exibição de mensagens. Implementada com tecnologias web/mobile modernas.
  
- **Camada de Controle (Controller)**: Gerencia a lógica de aplicação, autenticação, criptografia e controle de sessões.
  
- **Camada de Serviço/Negócio (Service)**: Lógica de segurança, protocolos de comunicação e controle de mensagens autodestrutivas.
  
- **Camada de Persistência (Model)**: Armazenamento temporário de dados sensíveis com políticas de exclusão automática e criptografia em repouso. - So mantém Metadados

- **Broker**: Permite comuinição entre consumidor e produtor, através de tópicos. Não há conhecimento entre sistema e informação & há menor latência.
---

## Tecnologias e Frameworks

- **Linguagem Principal**: Java | Javascript ou Kotlin
- **Framework Web**: Spring Boot | React Native ou Kotlin
- **Segurança & Autenticação**:
  - Spring Security
  - Autenticação 2FA + Biometria
  - etc... (outras dependencias)
- **Criptografia**:
  - AES-256 para dados em repouso
  - Protocolos Signal para comunicação (bcrypt, salt + pepper - hashing, ETEE)
- **Banco de Dados**: PostgreSQL (com dados criptografados em nível de aplicação)
- **Rede Anônima**: Integração com a rede Tor
- **Broker**: Kafka + Zookeeper
---

## Justificativas Técnicas

- **Java + Spring Boot**: Fornece um ecossistema robusto e seguro, com excelente suporte a frameworks de segurança, controle de autenticação e modularização em microserviços.
  
- **AES-256 + Signal Protocol**: São padrões amplamente reconhecidos por sua segurança e resistência contra ataques modernos. A combinação fornece criptografia de ponta a ponta com confidencialidade forte.

- **Rede Tor**: Garante anonimato na origem e no destino da comunicação, dificultando rastreamento.

- **Mensagens Autodestrutivas**: Essenciais para garantir que nenhuma informação sensível permaneça armazenada após sua visualização.

- **Fingerprint como Passkey**: Introduz um nível adicional de verificação de identidade baseado em elementos fora do controle do sistema, útil em contextos de troca de chaves offline.

- **Camada de Coerção e Autodestruição**: Proporciona segurança sob ameaça, protegendo o usuário mesmo em cenários de pressão ou sequestro.

- **Kafka + Zookeeper Broker**: Há experiencia previa do time com esses. 

---

## Relação com os Objetivos do Sistema

| Objetivo                                     | Componente / Tecnologia                       |
|---------------------------------------------|-----------------------------------------------|
| Comunicação segura                           | AES-256, Signal, Spring Security              |
| Mensagens autodestrutivas                    | Serviço TTL, Banco com políticas de expurgo   |
| Anonimato completo                           | Rede Tor, criptografia ponta a ponta          |
| Anticoerção e destruição total               | Senha de emergência, wipe instantâneo         |
| Fingerprint para prova de identidade         | Passkey derivado de Fingerprint do usuário    |
| Bloqueio de prints e rastreadores            | Anti-Print e sensores nativos                 |

---
