package utils;

abstract class Pessoa {
  String nome;
  String endereco;
  String cidade;
  String estado;
  String celular;
  String email;

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getCidade() {
    return this.cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return this.estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getCelular() {
    return this.celular;
  }

  public void setCelular(String celular) {
    this.celular = celular;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "{" +
      " nome='" + getNome() + "'" +
      ", endereco='" + getEndereco() + "'" +
      ", cidade='" + getCidade() + "'" +
      ", estado='" + getEstado() + "'" +
      ", celular='" + getCelular() + "'" +
      ", email='" + getEmail() + "'" +
      "}";
  }
}
