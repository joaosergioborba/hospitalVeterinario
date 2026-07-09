# 🐾 Patas Cloud - Hospital Veterinário

**📢 DOCUMENTAÇÃO COMPLETA DISPONÍVEL:** O **Manual de Operação da Recepção**, o **Dicionário de Operações de Tela** e a **Especificação de Requisitos de Software (SRS)** estão totalmente disponíveis no arquivo PDF **`Software_Requirements_Specification (2).pdf`** incluído neste repositório. Consulte-o para entender as regras de negócio, fluxos de uso e padrões da interface.

---

Sistema de gerenciamento clínico veterinário desenvolvido como projeto prático para a disciplina de Programação Orientada a Objetos.

## 🎯 Objetivo do Projeto

O foco do software é centralizar o histórico dos pacientes, além de otimizar o processo de entrada de animais e o atendimento realizado pelos médicos veterinários. O projeto foi construído através de entregas semanais, refletindo a prática dos conteúdos teóricos lecionados.

## ✨ Funcionalidades (Escopo Principal)

O sistema foi desenhado para atender ao fluxo principal de sucesso da clínica, contemplando:

- **Módulo Recepção:** Cadastro e gerenciamento de Tutores e Pacientes (animais).
- **Gestão de Equipe:** Cadastro de funcionários, com obrigatoriedade de informar a especialidade ao registrar um veterinário.
- **Agendamento e Fila de Espera:** Agendamento de consultas (por data) e realização de _check-in_. O atendimento médico obedece à ordem de chegada.
- **Módulo Consultório:** Acesso do veterinário aos próximos pacientes da fila e registro de prontuários médicos (inserção de diagnóstico, peso, temperatura, prescrições e anotações clínicas).

**Nota sobre o Centro de Diagnósticos:** A solicitação de exames e medicações pelo médico está prevista, mas a execução e gestão destes no "Centro de Diagnósticos" é um fluxo adicional fora do MVP atual.

## 🚫 O que o sistema NÃO faz (Escopo Negativo)

Para garantir a viabilidade desta versão, as seguintes funcionalidades estão fora do escopo:

- Interface de autoatendimento para tutores.
- Painel eletrônico/interface de chamada de paciente.
- Agendamento de consultas por horário (apenas a data é registrada).
- Manual do sistema e ajuda integrados direto nas interfaces (disponibilizado apenas no PDF externo).
- Acesso ao sistema controlado/restrito por tipo de funcionário.
- Edição ou exclusão de dados após a conclusão e fechamento da tela de cadastro.

## 🚀 Tecnologias Utilizadas

- **Linguagem:** Java 17
- **Interface Gráfica:** Java Swing com FlatLaf
- **Infraestrutura:** Docker (Banco de Dados)
- **Versionamento:** Git e GitHub

## ⚙️ Como Executar

O sistema já conta com uma carga inicial de dados (tutores, animais e funcionários pré-cadastrados) para facilitar testes e validação das funcionalidades.

1. Clone o repositório.
2. Inicie o banco de dados utilizando o Docker Compose.
3. Execute o script `init.sql`.
4. Abra o projeto no VS Code.
5. Execute a classe principal `App.java`.

## 🔐 Credenciais de Acesso (Testes)

Para acessar os módulos do sistema (Recepção ou Consultório), utilize a credencial padrão configurada para avaliação acadêmica:

- **Usuário / Senha:** `123456`

## 👨‍💻 Desenvolvido por

- Eloisa Franco (202421901024)
- João Sérgio Borba (202421901037)
