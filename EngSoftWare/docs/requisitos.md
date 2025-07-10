# Aplicativo de Mensagens Seguras - Requisitos Funcionais e Não Funcionais  

## 1. Requisitos Funcionais  

### **1.1 Mensagens Autodestrutivas (Efêmeras)**  
- Temporizador configurável para apagamento automático (ex.: 5 seg, 1 min, 1 hora, 24 horas).  

### **1.2 Bloqueio de Captura de Tela**  
- Impedir ou alertar sobre tentativas de screenshot para proteger conteúdo sensível.  

### **1.3 Autenticação do Usuário**  
- Sistema de login seguro com verificação de identidade obrigatória.  

### **1.4 Chats 1:1 e em Grupo**  
- Suporte a conversas privadas individuais e em grupos com o mesmo nível de segurança.  

### **1.5 Chamadas de Voz Criptografadas**  
- Chamadas com criptografia ponta-a-ponta (E2EE) para comunicação privada.  

### **1.6 Segurança Obrigatória por Usuário**  
- Configurações de segurança obrigatórias (ex.: autenticação em duas etapas / 2FA).  

### **1.7 Chaves de Segurança Únicas**  
- Chaves temporárias e únicas para ações críticas (login, troca de dispositivo, etc.).  

### **1.8 Usuário com Modo Fachada**
- Se usuario for coagido, ele pode utilizar uma senha falsa que ele recebe, e caso utilizada, conversas falsas sao criadas ou sao apagadas para manter confiabilidade
---

## 2. Requisitos Não Funcionais  

### **2.1 Segurança e Privacidade**  
- **Criptografia Ponta-a-Ponta (E2EE):** Mensagens só podem ser lidas por remetente e destinatário.  
- **Sem Armazenamento em Nuvem:** As mensagens nunca são guardadas em servidores externos (apenas no dispositivo).  
- **Verificação de Identidade Rigorosa:** Cadastro em etapas (telefone, e-mail, biometria) para evitar contas falsas.  
- **Política "Zero Acesso":** Garantia de que nem os desenvolvedores acessam as mensagens.
- **Onion rede:** comunicação é encriptada em camadas (como uma cebola) e passa por 3 nós aleatórios (relays). Cada nó remove uma camada de criptografia e repassa. Nenhum nó sabe toda a rota. O nó de entrada vê seu IP, o de saída vê o destino, mas ninguém conecta os dois.

### **2.2 Controle de Acesso**  
- **Senha/PIN Obrigatório:** Autenticação forte para abrir o aplicativo.  
- **Login Biométrico:** Suporte a impressão digital ou reconhecimento facial.  
- **Senha Descartável (OTP):** Necessária para operações sensíveis (ex.: recuperação de conta).  

### **2.3 Melhorias de Privacidade**  
- **Modo Invisível:** Sem status de online/offline ou confirmações de leitura.  
- **Notificações Mínimas:** Evitar expor informações sensíveis em notificações.  
- **Alertas de Segurança do Dispositivo:** Avisos sobre sistema desatualizado, root/jailbreak ou riscos de hardware.  

### **2.4 Plataforma e Usabilidade**  
- **Suporte Multiplataforma:** Android, iOS e opcionalmente desktop (Windows/macOS).  
- **Botão "Pânico":** Apaga todas as conversas instantaneamente em caso de risco.  
- **Sistema por Convite:** Cadastro restrito para evitar infiltrações.  
