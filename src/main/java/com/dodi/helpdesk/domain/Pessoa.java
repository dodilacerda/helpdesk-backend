package com.dodi.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CPF;

import com.dodi.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public abstract class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
//HashSet evita a exceção de ponteiro nulo
//O Set não permite dois valores iguais dentro da lista; permite apenas um único perfil para a pessoa.
//LocalDate.now() pega o momento atual em que a instância do objeto foi criada.
//O construtor da super classe(construtor sem os parâmentros)é quando se quer criar um objeto da classe sem atribuir valor(objeto vazio)
//HashCod And Equals faz comparação de seus objetos pelos valores de seus atributos, não pelo valor em memória
//map é um stream de modificação intermediário que modifica o fluxo de dados
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//o BD fica responsável por gerar o Id distinto para cada objeto diferente.
	protected Integer id;
	protected String nome;

	//A Anotation CPF já faz a valdação se o cpf existe.
	@CPF
	@Column(unique = true)//coluna única. Não vai existir dois cpfs com os mesmos valores.
	protected String cpf;
	
	@Column(unique = true)
	protected String email;
	protected String senha;
	
	@ElementCollection(fetch = FetchType.EAGER)//Quando o usário for chamado, ele carregará a lista de perfis.
	@CollectionTable(name = "PERFIS")//Cria uma tabela no BD chamada perfis
	protected Set<Integer> perfis = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/YYYY")
	protected LocalDate dataCriacao = LocalDate.now();
	
	public Pessoa() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	public Pessoa(Integer id, String nome, String cpf, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		addPerfil(Perfil.CLIENTE);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}	
	
}
