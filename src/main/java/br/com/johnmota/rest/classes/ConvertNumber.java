package br.com.johnmota.rest.classes;

public class ConvertNumber {
  

  public static Double convertDouble(String strNumber) {
    try {
        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    } catch (NumberFormatException e) {
        throw new UnsupportedOperationException("Conversion to Double failed", e);
    }
    
}

public static boolean isNumeric(String strNumber) {
    if(strNumber == null) return false;
    String number = strNumber.replaceAll(",", ".");
    return number.matches("[-+]?[0-9]*\\.?[0-9]+");

}
}
