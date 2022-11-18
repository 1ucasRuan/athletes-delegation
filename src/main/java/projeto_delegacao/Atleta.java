package projeto_delegacao;

import java.io.Serializable;

public class Atleta implements Serializable{//classe do tipo atleta(numero,nome.categoria)

	private String numero;
	private String nome;
	private String categoria;

	public Atleta(String numero, String nome, String categoria){
		this.numero = numero;
		this.nome = nome;
		this.categoria = categoria;
	}

	public Atleta (){
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String toString () {
            String retorno;

            retorno =  "--------------------------" +
                        "Categoria: " + this.getCategoria() +
                        "--------------------------\n" +
			"Nome: " + this.getNome() +  "\n" +
			"Número: " + this.getNumero() + "\n";
            return retorno;
	}	
}
