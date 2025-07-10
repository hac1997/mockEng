# __Respostas__

### __Odilson__:
1- Qual a melhor arquitetura de rede para minimizar vazamentos?
Cara, isso é um tema bem amplo com várias respostas possíveis. (abaixo)

1. Segmentação da rede: É possível usar VLANs, se um segmento é invadido talvez os demais não sejam. DMZ: isolar servidores voltados para o exterior, Internet, dos voltados para o interior, Intranet. Sempre protegidos por firewalls com diferentes características: interior vs exterior.
2. Controle de Acesso Rigoroso: Ter uma política de autenticação de usuário com o que há de mais moderno, por exemplo, duplo fator etc. Tudo deve ser monitorado e registrado.
3. Criptografia de Dados: Dependendo das necessidades de segurança os discos devem ser criptografados e servidores de arquivos com boas políticas de grupo e controle de acesso.

Em resumo, a "melhor" arquitetura de rede para minimizar vazamentos é aquela que implementa uma combinação estratégica dessas camadas de segurança, de acordo com o tipo de rede e usuários dessas camadas de segurança.

2- Que técnicas de ofuscação de tráfego poderiam camuflar a comunicação como tráfego comum?
Uma das principais abordagens é o tunelamento, introduzindo dados maliciosos em protocolos "pouco monitorados", por exemplo, o ICMP ou HTTP.

3- Como balancear latência e anonimato em um sistema que prioriza sigilo absoluto?
Uma opção é o próprio tunelamento. Outras são as tradicionais VPNs e Proxies, mas neste caso deveria haver um conhecimento da localização dos servidores, escolhendo os "mais próximos"... Lembre-se que esses tópicos são praticamente antagônicos: geralmente, um aumento no anonimato implica em um aumento na latência.

Espero ter ajudado, abraços

### __Mello__
1 - como negar as informações que estão dentro do app de forma segura e coerente
bomba lógica - tem ferramentas pra ver se os arquivos foram deletados - destruição de prova - cruzar fronteiras one passowrd bloqueartemporariamente - pode definir o tempo de bloqueio

2 - segunda pergunta:  se faz sentido não haver login com uma chave unica - 
Nao ter logins - gerar chaves públicas não associadas a users ou que não possam idenficá-los - vai ter que identificar os users ou metadados
Ver as normativas para apps de comunicação e elemento seguro celular

3-Como proteger os usuarios de dispositivos comprometidos?
autenticação continua do usuário
