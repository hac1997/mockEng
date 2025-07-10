# Justificativa das Decisões de Projeto


### 1. Principais Decisões de Projeto

Desde o início do desenvolvimento, nosso grupo estabeleceu como prioridade máxima a segurança do sistema. Essa preocupação definiu uma série de decisões importantes, debatidas extensivamente em reuniões do grupo (realizamos entre 3 e 5 conversas dedicados exclusivamente a isso).

__As principais decisões foram:__

1. Método de Autenticação: Avaliamos diversas opções, incluindo senhas tradicionais, tokens e biometria. A escolha final levou em consideração fatores de segurança, usabilidade e compatibilidade. (Token unico, gerado automaticamente)
2. Criptografia: Estudamos algoritmos como bcrypt, pcrypt e argon2, optando por aquele que melhor atendia aos nossos requisitos de segurança e performance.
3. Protocolo de Internet: A adoção do protocolo Onion foi motivada por sua capacidade de anonimizar comunicações e proteger a identidade dos usuários. Essa escolha foi fortemente influenciada por entrevistas com especialistas, especialmente a contribuição do professor Odilson.
4. Escolha de Tecnologias: A seleção de ferramentas e frameworks levou em conta a familiaridade prévia dos membros com determinadas tecnologias, o que nos permitiu otimizar o tempo de desenvolvimento e reduzir a curva de aprendizado.
5. Entrevistas com Usuários e Especialistas: Nossas decisões foram respaldadas por dados coletados em entrevistas, destacando-se a recomendação do uso de autenticação segura feita pelo professor Mello (2FA/MFA).
6. Clases: Durante o tempo do projeto, estava sempre em constante mudança/adição, mas o concenso geral foi, quanto menor, melhor. Mensagems são efêmeras e só metadados são salvos (minimo).

### 2. Separação de Responsabilidades e Reuso

Adotamos práticas de engenharia de software voltadas à separação clara de responsabilidades e ao reuso de documetos/componentes para elaboração futura. O grupo foi organizado através de um grupo de Whatsapp central.

O projeto foi dividido entre os três membros de forma equilibrada, porem cada um teve parte individual seguinte:

- Jessé: responsável pelo Diagrama de Classes.
- Herick: encarregado do Diagrama de Arquitetura.
- Nicolas: elaborou o Diagrama de Casos de Uso.

Já a produção dos documentos técnicos foi um esforço conjunto. Todos os membros participaram ativamente da elaboração e revisão dos mesmos. 
O Documento de Arquitetura teve maior influência de dois membros, especialmente devido à discussão técnica sobre as tecnologias escolhidas, pois ambos tinham experiecia previa com tais tecnologias.
E por fim, tivemos diferentes preucupações em relação ao projeto:

|   Preucupação  | Consideração |
| -------- | ------- |
| Segurança  | Buscar ajuda de Individuos com experiencia (Mello/Odilson)    |
| Arquitetura | MVC (Conhecimento Geral) + Broker (Recomendado por professor - Arliones)     |
