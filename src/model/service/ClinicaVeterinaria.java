package model.service;

import java.util.ArrayList;
import java.util.List;

import model.entity.Animal;
import model.entity.Atendimento;
import model.entity.Exame;
import model.entity.Funcionario;
import model.entity.Medicacao;
import model.entity.Produto;
import model.entity.Recepcionista;
import model.entity.RegistroClinico;
import model.entity.Tutor;
import model.entity.Vacina;
import model.entity.Veterinario;

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

    public void adicionarAnimalService(Animal data){

      this.animais.add(data);

    }
    
    public Animal procurarAnimaisPorIdService(int id, Boolean animalAtivo){

       Animal resultado = animais.stream().filter(a -> a.getTutor().getId() == id).findFirst().orElse(null);
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
    
    
    public void adicionarFuncionarioService(Funcionario data){
      if(isCpfCadastrado(data.getCpf())){

        System.out.println("Não foi possível adicionar esse Usuário. CPF já cadastrado no banco de dados");
      } else {

        this.funcionarios.add(data);
      }


    }
    public void adicionarTutorService(Tutor data){

      if(isCpfCadastrado(data.getCpf())){

      } else {
        System.out.println("Não foi possível adicionar esse Usuário. CPF já cadastrado no banco de dados");

      }

      this.tutores.add(data);

    }


    public Tutor procurarTutorPorIdService(int id){

      Tutor resultado = tutores.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
      
      return resultado;



    }
    public void adicionarAtendimentoService(Atendimento data){

      this.atendimentos.add(data);

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
