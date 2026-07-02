CREATE DATABASE IF NOT EXISTS patasCloud_db;
USE patasCloud_db;

private List<Animal> animais = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();
    private List<Tutor> tutores = new ArrayList<>();
    private List<Atendimento> atendimentos = new ArrayList<>();
    private List<RegistroClinico> registrosClinicos = new ArrayList<>();
    private List<Exame> exames = new ArrayList<>();
    private List<Vacina> vacinas = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private List<Medicacao> medicacoes = new ArrayList<>();
    private Queue<Atendimento> filaAtendimento = new LinkedList<>();

CREATE TABLE animais(
  id_fornecedor int AUTO_INCREMENT PRIMARY KEY;
  
);

