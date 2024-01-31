package br.com.johnmota.rest.classes;


public class SimpleMath {
  
  public Double sum(Double numberOne,Double numberTwo) {
    return numberOne + numberTwo;
  }
  public Double subtract(Double numberOne, Double numberTwo) {
    return numberOne - numberTwo;
  }
  public Double divider(Double numberOne, Double numberTwo) throws Exception {
    return numberOne / numberTwo;
  }
  public Double multiply(Double numberOne, Double numberTwo) {
    return numberOne * numberTwo;
  }
}
