# 🐾 Patas Cloud - Hospital Veterinário

> ### 📢 DOCUMENTAÇÃO COMPLETA DISPONÍVEL
>
> [cite_start]O **Manual de Operação da Recepção** [cite: 9, 366][cite_start], o **Dicionário de Operações de Tela** [cite: 9, 355] [cite_start]e a **Especificação de Requisitos de Software (SRS)** [cite: 1] estão totalmente disponíveis no arquivo PDF **`Software_Requirements_Specification (2).pdf`** incluído neste repositório. [cite_start]Consulte-o para entender as regras de negócio, fluxos de uso e padrões da interface[cite: 9].

[cite_start]Sistema de gerenciamento clínico veterinário desenvolvido como projeto prático para a disciplina de Programação Orientada a Objetos[cite: 13, 17].

## 🎯 Objetivo do Projeto

[cite_start]O foco do software é centralizar o histórico dos pacientes, além de otimizar o processo de entrada de animais e o atendimento realizado pelos médicos veterinários[cite: 18]. [cite_start]O projeto foi construído através de entregas semanais, refletindo a prática dos conteúdos teóricos lecionados[cite: 14, 15].

## ✨ Funcionalidades (Escopo Principal)

O sistema foi desenhado para atender ao fluxo principal de sucesso da clínica, contemplando:

- [cite_start]**Módulo Recepção:** Cadastro e gerenciamento de Tutores e Pacientes (animais)[cite: 32].
- [cite_start]**Gestão de Equipe:** Cadastro de funcionários, com obrigatoriedade de informar a especialidade ao registrar um veterinário[cite: 34, 47].
- [cite_start]**Agendamento e Fila de Espera:** Agendamento de consultas (por data) e realização de _check-in_[cite: 35, 36, 69]. [cite_start]O atendimento médico obedece à ordem de chegada[cite: 49].
- [cite_start]**Módulo Consultório:** Acesso do veterinário aos próximos pacientes da fila e registro de prontuários médicos (inserção de diagnóstico, peso, temperatura, prescrições e anotações clínicas)[cite: 37, 70].

> [cite_start]**Nota sobre o Centro de Diagnósticos:** A solicitação de exames e medicações pelo médico está prevista [cite: 71][cite_start], mas a execução e gestão destes no "Centro de Diagnósticos" é um fluxo adicional fora do MVP atual[cite: 86, 87].

## 🚫 O que o sistema NÃO faz (Escopo Negativo)

[cite_start]Para garantir a viabilidade desta versão, as seguintes funcionalidades estão fora do escopo[cite: 20]:

- [cite_start]Interface de autoatendimento para tutores[cite: 21].
- [cite_start]Painel eletrônico/interface de chamada de paciente[cite: 22].
- [cite_start]Agendamento de consultas por horário (apenas a data é registrada)[cite: 23, 36].
- [cite_start]Manual do sistema e ajuda integrados direto nas interfaces (disponibilizado apenas no PDF externo)[cite: 24].
- [cite_start]Acesso ao sistema controlado/restrito por tipo de funcionário[cite: 27].
- [cite_start]Edição ou exclusão de dados após a conclusão e fechamento da tela de cadastro[cite: 25, 26].

## 🚀 Tecnologias Utilizadas

- **Linguagem:** Java 17
- **Interface Gráfica:** Java Swing com FlatLaf
- **Infraestrutura:** Docker (Banco de Dados)
- **Versionamento:** Git e GitHub

## ⚙️ Como Executar

[cite_start]O sistema já conta com uma carga inicial de dados (tutores, animais e funcionários pré-cadastrados) para facilitar testes e validação das funcionalidades[cite: 130, 131].

1. Clone o repositório.
2. Inicie o banco de dados utilizando o Docker Compose.
3. Execute o script `init.sql`.
4. Abra o projeto no VS Code.
5. Execute a classe principal `App.java`.

## 🔐 Credenciais de Acesso (Testes)

[cite_start]Para acessar os módulos do sistema (Recepção ou Consultório)[cite: 74, 80], utilize a credencial padrão configurada para avaliação acadêmica:

- **Usuário / Senha:** `123456`

## 👨‍💻 Desenvolvido por

- [cite_start]Eloisa Franco (202421901024) [cite: 4]
- [cite_start]João Sérgio Borba (202421901037) [cite: 5]
