package utils;

abstract class Funcionario extends Pessoa {
  int ID;
  double Salario;
  String dataInicio;
  String cargo;

  public int getID() {
    return this.ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public double getSalario() {
    return this.Salario;
  }

  public void setSalario(double Salario) {
    this.Salario = Salario;
  }

  public String getDataInicio() {
    return this.dataInicio;
  }

  public void setDataInicio(String dataInicio) {
    this.dataInicio = dataInicio;
  }

  public String getCargo() {
    return this.cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public void buscarFuncionario(int id){

  }

  public void registrarVenda(){
    
  }
}
