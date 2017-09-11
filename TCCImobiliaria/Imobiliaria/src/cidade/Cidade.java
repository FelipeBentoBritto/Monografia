package cidade;

public class Cidade {
private int id;
private String nome;
private String uf;

public Cidade (int id, String nome, String uf) {
	this.setId(id);
	this.setNome(nome);
	this.setUf(uf);
}

public int getId(){
	return id;
}

private void setId(int id) {
	this.id = id;
}

public String getNome(){
	return nome;
}

private void setNome(String nome) {
	this.nome = nome;
}

public String getUf(){
	return uf;
}

private void setUf(String uf) {
	this.uf = uf;
}
}
