package model.service;

import java.util.ArrayList;
import java.util.List;

import model.entity.Animal;
import model.entity.Atendimento;
import model.entity.Exame;
import model.entity.Funcionario;
import model.entity.Medicacao;
import model.entity.Produto;
import model.entity.RegistroClinico;
import model.entity.Tutor;
import model.entity.Vacina;
import model.enums.StatusAtendimento;


public class ClinicaVeterinaria {

    private List<Animal> animais = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();
    private List<Tutor> tutores = new ArrayList<>();
    private List<Atendimento> atendimentos = new ArrayList<>();
    private List<RegistroClinico> registrosClinicos = new ArrayList<>();
    private List<Exame> exames = new ArrayList<>();
    private List<Vacina> vacinas = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private List<Medicacao> medicacoes = new ArrayList<>();


    public ClinicaVeterinaria(){

    }

    public boolean isCpfCadastrado(String cpf){
      for (Tutor tutor : tutores) {
        String cpfRegistro = tutor.getCpf();
        if (cpfRegistro.equals(cpf)){
          return true;
        }
      }
      return false;
    }

    // animais services

    public int buscarProximoIdAnimalService(){
      int maiorId = 0;

      for (Animal  animal: animais) {

        int idAtual = animal.getId();

        if(idAtual > maiorId){
          maiorId = idAtual;
        }
        
      }
      return maiorId + 1;

    }

    
    public void adicionarAnimalService(Animal data){

      data.setId(buscarProximoIdAnimalService());

      this.animais.add(data);

    }
    
    public Animal procurarAnimaisPorIdService(int id){

       Animal resultado = animais.stream().filter(a -> a.getId()== id).findFirst().orElse(null);
      return resultado;
      
    }

    public List<Animal> procurarAnimaisPorNomeService(String nome, Boolean animalAtivo){

      List<Animal> resultado = animais.stream().filter(a -> a.getNome().equalsIgnoreCase(nome)).toList();
      return resultado;

    }
    public List<Animal> procurarAnimaisPorTutorService(int idTutor, Boolean animalAtivo ){

      List<Animal> resultado = animais.stream().filter(a -> a.getTutor().getId() == idTutor).toList();
      return resultado;

    }
    
    public List<Animal> listarAnimaisCadastrados(Boolean animalAtivo){

      List<Animal> lista = animais.stream().filter(a-> a.isAnimalAtivo() == animalAtivo).toList();
      return lista;

    }

    //funcionarios services

    public int buscarProximoIdFuncionarioService(){
      int maiorId = 0;

      for (Funcionario  funcionario: funcionarios) {

        int idAtual = funcionario.getId();

        if(idAtual > maiorId){
          maiorId = idAtual;
        }
        
      }
      return maiorId + 1;

    }
    
    public int adicionarFuncionarioService(Funcionario data){
      if(isCpfCadastrado(data.getCpf())){

        System.out.println("Não foi possível adicionar esse Usuário. CPF já cadastrado no banco de dados");
        return -1;
      } else {

        data.setId(buscarProximoIdFuncionarioService());
        this.funcionarios.add(data);
        return data.getId();
      }


    }

    public Funcionario procurarFuncionarioPorCPFservice(String cpf){

      Funcionario resultado = funcionarios.stream().filter(a -> a.getCpf().equals(cpf)).findFirst().orElse(null);
      
      return resultado;
    }

    public Funcionario procurarFuncionarioPorIdService(int id){

      Funcionario resultado = funcionarios.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
      
      return resultado;



    }

    public List<Funcionario> listarFuncionariosCadastrados(Boolean entidadeAtiva){

      List<Funcionario> lista = funcionarios.stream().filter(a-> a.isPessoaAtiva() == entidadeAtiva).toList();
      return lista;

    }


  // tutor services
  
    public int buscarProximoIdTutorService(){
      int maiorId = 0;

      for (Tutor  tutor: tutores) {

        int idAtual = tutor.getId();

        if(idAtual > maiorId){
          maiorId = idAtual;
        }
        
      }
      return maiorId + 1;

    }

    public List<Atendimento> listarAtendimentosCadastrados(Boolean entidadeAtiva){

      List<Atendimento> lista = atendimentos.stream().toList();
      return lista;

    }


    public int adicionarTutorService(Tutor data){

      if(isCpfCadastrado(data.getCpf())){

        System.out.println("Não foi possível adicionar esse Usuário. CPF já cadastrado no banco de dados");
        return -1;
      } else {

        data.setId(buscarProximoIdTutorService());
        this.tutores.add(data);
        return data.getId();

      }


    }

    public Tutor procurarTutorPorIdService(int id){

      Tutor resultado = tutores.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
      return resultado;
    }

    public Tutor procurarTutorPorCPFservice(String cpf){

      Tutor resultado = tutores.stream().filter(a -> a.getCpf().equals(cpf)).findFirst().orElse(null);
      
      return resultado;
    }

    public List<Tutor> listarTutoresCadastrados(Boolean entidadeAtiva){

      List<Tutor> lista = tutores.stream().filter(a-> a.isPessoaAtiva() == entidadeAtiva).toList();
      return lista;

    }


    //atendimentos

    public int buscarProximoIdAtendimentoService(){
      int maiorId = 0;

      for (Atendimento  a: atendimentos) {

        int idAtual = a.getId();

        if(idAtual > maiorId){
          maiorId = idAtual;
        }
        
      }
      return maiorId + 1;

    }

    public Atendimento procurarAtendimentoPorIdService(int id){

      Atendimento resultado = atendimentos.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
      return resultado;
    }


    public int adicionarAtendimentoService(Atendimento data){

      data.setId(buscarProximoIdAtendimentoService());

      this.atendimentos.add(data);
      return data.getId();

    }


    public void adicionarRegistroClinicoService(RegistroClinico data){

      this.registrosClinicos.add(data);

    }
    public void adicionarExameService(Exame data){

      this.exames.add(data);

    }
    public void adicionarVacinaService(Vacina data){

      this.vacinas.add(data);

    }
    public void adicionarMedicacaoService(Medicacao data){

      this.medicacoes.add(data);

    }
    public void adicionarProdutoService(Produto data){

      this.produtos.add(data);

    }

    // funcionarios

    public Boolean login(String cpf, String senha){

      Funcionario resultado = funcionarios.stream().filter(funcionarioAtual-> funcionarioAtual.getCpf().equals(cpf)).findFirst().orElse(null);


      if(resultado == null){
        return false;
      }

      if(!(resultado.getSenha().equals(senha))){

        return false;

      }
      return true;

    }
    

  
}
