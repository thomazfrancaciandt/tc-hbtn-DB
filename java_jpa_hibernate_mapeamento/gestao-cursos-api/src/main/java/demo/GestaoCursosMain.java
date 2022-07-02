package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestaoCursosMain {
    public static void main(String[] args) {

        AlunoModel alunoModel = new AlunoModel();
        List<Aluno> alunos;
        CursoModel cursoModel = new CursoModel();
        List<Curso> cursos;

        Telefone telefone1 = new Telefone();
        telefone1.setDdd("11");
        telefone1.setNumero("94758-6640");

        Telefone telefone2 = new Telefone();
        telefone2.setDdd("15");
        telefone2.setNumero("94137-8161");

        Telefone telefone3 = new Telefone();
        telefone3.setDdd("67");
        telefone3.setNumero("94758-8893");

        Telefone telefone4 = new Telefone();
        telefone4.setDdd("21");
        telefone4.setNumero("94137-9877");


        Endereco endereco1 = new Endereco();
        endereco1.setLogradouro("Rua");
        endereco1.setEndereco("dos Pimpolhos");
        endereco1.setNumero("189");
        endereco1.setBairro("Jaquaribe");
        endereco1.setCidade("Osasco");
        endereco1.setEstado("SP");
        endereco1.setCep("04778080");

        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro("Avenida");
        endereco2.setEndereco("Cerejeiras");
        endereco2.setNumero("899");
        endereco2.setBairro("Tuparis");
        endereco2.setCidade("Cosmopolis");
        endereco2.setEstado("Sergipe");
        endereco2.setCep("08555080");

        //Criando aluno

        Aluno aluno1 = new Aluno();
        aluno1.setNomeCompleto("Thomaz Nascimento");
        aluno1.setMatricula("0001");
        aluno1.setNascimento(LocalDate.of(1993,10,21));
        aluno1.setEmail("nacimento@email.com");
        aluno1.setTelefones(new ArrayList<Telefone>(List.of(telefone1,telefone2)));
        aluno1.setEnderecos(new ArrayList<Endereco>(List.of(endereco1)));
        alunoModel.create(aluno1);

        Aluno aluno2 = new Aluno();
        aluno2.setNomeCompleto("Paulo Silva");
        aluno2.setMatricula("0002");
        aluno2.setNascimento(LocalDate.of(2002,10,11));
        aluno2.setEmail("silva@email.com");
        aluno2.setTelefones(new ArrayList<Telefone>(List.of(telefone3,telefone4)));
        aluno2.setEnderecos(new ArrayList<Endereco>(List.of(endereco2)));
        alunoModel.create(aluno2);
        System.out.println("***** Criando Aluno *****");
        System.out.println(aluno1);
        System.out.println(aluno2);

        //Buscando aluno

        Aluno buscarAlunoPorId1 = new Aluno();
        buscarAlunoPorId1.setId(1L);
        buscarAlunoPorId1 = alunoModel.findById(buscarAlunoPorId1);

        Aluno buscarAlunoPorId2 = new Aluno();
        buscarAlunoPorId2.setId(2L);
        buscarAlunoPorId2 = alunoModel.findById(buscarAlunoPorId2);

        System.out.println("***** Buscar Aluno *****");
        System.out.println(buscarAlunoPorId1);
        System.out.println(buscarAlunoPorId2);


        //Deletando aluno
        Aluno deletandoAluno1 = new Aluno();
        deletandoAluno1.setId(1L);
        alunoModel.delete(deletandoAluno1);

        System.out.println("***** Deletando Aluno *****");
        System.out.println(deletandoAluno1);

        //Buscando aluno
        alunos = alunoModel.findAll();
        System.out.println("***** Buscando Aluno *****");
        System.out.println(alunos);

        //Buscar todos os alunos
        alunos = alunoModel.findAll();
        System.out.println("***** Buscando todos os Alunos *****");
        System.out.println(alunos);


        //Atualizando aluno
        Aluno atualizarAluno1 = new Aluno();
        atualizarAluno1.setId(2L);
        atualizarAluno1 = alunoModel.findById(atualizarAluno1);
        atualizarAluno1.setNomeCompleto("Paulo Silva Santos");
        atualizarAluno1.getTelefones().forEach(telefone -> {if (telefone.getId() == 1L) {
            telefone.setNumero("94340-4640");
            System.out.println("***** Atualizando Aluno *****");
        }
        });
        alunoModel.update(atualizarAluno1);
        System.out.println(atualizarAluno1);


        //Criando professor
        Professor professor1 = new Professor();
        professor1.setNomeCompleto("Silva Cruz");
        professor1.setEmail("cruz@email.com");
        professor1.setMatricula("1001");

        Professor professor2 = new Professor();
        professor2.setNomeCompleto("Luiz Hora");
        professor2.setEmail("hora@email.com");
        professor2.setMatricula("1002");

        //Incluindo material do curso
        MaterialCurso materialCurso1 = new MaterialCurso();
        materialCurso1.setUrl("https://thedevconf.com/tdc/2022/index.html");
        MaterialCurso materialCurso2 = new MaterialCurso();
        materialCurso2.setUrl("https://start.spring.io/");
        MaterialCurso materialCurso3 = new MaterialCurso();
        materialCurso3.setUrl("https://loiane.training/");

        //Criando cursos com professores e material dos cursos
        Curso curso1 = new Curso();
        curso1.setNome("JPA + Hibernate");
        curso1.setSigla("JPA");
        curso1.setMaterialCurso(materialCurso1);
        curso1.setProfessor(professor2);

        Curso curso2 = new Curso();
        curso2.setNome("Spring Boot");
        curso2.setSigla("SPB");
        curso2.setMaterialCurso(materialCurso2);
        curso2.setProfessor(professor2);

        Curso curso3 = new Curso();
        curso3.setNome("Angular");
        curso3.setSigla("ANG");
        curso3.setMaterialCurso(materialCurso3);
        curso3.setProfessor(professor2);

        cursoModel.create(curso1);
        cursoModel.create(curso2);
        cursoModel.create(curso3);

        System.out.println("***** Criando Cursos *****");
        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(curso3);


        //Buscar cursos
        Curso procuraCurso1 = new Curso();
        procuraCurso1.setId(1L);
        procuraCurso1 = cursoModel.findById(procuraCurso1);
        System.out.println("***** Busca Curso *****");
        System.out.println(procuraCurso1);

        //Deletando curso
        Curso deletaCurso = new Curso();
        deletaCurso.setId(2L);
        cursoModel.delete(deletaCurso);
        System.out.println("***** Deleta Curso *****");
        System.out.println(deletaCurso);

        //Atualizando curso
        Curso atualizarCurso1 = new Curso();
        atualizarCurso1.setId(3L);
        atualizarCurso1 = cursoModel.findById(atualizarCurso1);
        atualizarCurso1.setNome("GitHub");
        atualizarCurso1.getMaterialCurso().setUrl("http://codetheelephant.com/como-enviar-um-projeto-local-para-o-github/");
        cursoModel.update(atualizarCurso1);
        System.out.println("***** Curso Atualizado *****");
        System.out.println(atualizarCurso1);

        //Buscando todos os cursos
        cursos = cursoModel.findAll();
        System.out.println("***** Buscando todos Cursos *****");
        System.out.println(cursos);

        //Add aluno atualizado ao curso
        atualizarCurso1 = cursoModel.findById(atualizarCurso1);
        atualizarAluno1 = alunoModel.findById(atualizarAluno1);
        atualizarCurso1.setAlunos(new ArrayList<Aluno>(List.of(atualizarAluno1)));
        cursoModel.update(atualizarCurso1);

        System.out.println("***** Aluno x Curso *****");
        System.out.println(atualizarCurso1);

        //Buscando todos os cursos atualizado
        cursos = cursoModel.findAll();
        System.out.println("***** Buscando todos Cursos atualizado *****");
        System.out.println(cursos);





































    }
}
