package br.com.johnmota.rest.classes;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.johnmota.rest.excepitions.UnsuportedMathExceptions;


@RestController
public class MathController {

    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET )
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathExceptions("Please set a numeric value!");
        }

        return convertDouble(numberOne) + convertDouble(numberTwo);
    }

    @RequestMapping(value = "/subtract/{numberOne}/{numberTwo}", method=RequestMethod.GET )
    public Double subtract(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathExceptions("Please set a numeric value!");
        }

        if (isNumeric(numberOne) && isNumeric(numberTwo)) {
            if (Double.parseDouble(numberOne) < Double.parseDouble(numberTwo)) {
                throw new UnsuportedMathExceptions("O primeiro número deve ser menor que o segundo número!");
            }
        }

        return convertDouble(numberOne) - convertDouble(numberTwo);
    }

    @RequestMapping(value = "/divider/{numberOne}/{numberTwo}", method=RequestMethod.GET )
    public Double divider(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathExceptions("Please set a numeric value!");
        }
        if (isNumeric(numberOne) && isNumeric(numberTwo)) {
            if (Double.parseDouble(numberOne) < Double.parseDouble(numberTwo)) {
                throw new UnsuportedMathExceptions("O primeiro número deve ser menor que o segundo número!");
            }
        }

        return convertDouble(numberOne) / convertDouble(numberTwo);
    }

    @RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", method=RequestMethod.GET )
    public Double multiply(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathExceptions("Please set a numeric value!");
        }

        return convertDouble(numberOne) * convertDouble(numberTwo);
    }

    private Double convertDouble(String strNumber) {
        try {
            if(strNumber == null) return 0D;
            String number = strNumber.replaceAll(",", ".");
            if(isNumeric(number)) return Double.parseDouble(number);
            return 0D;
        } catch (NumberFormatException e) {
            throw new UnsupportedOperationException("Conversion to Double failed", e);
        }
        
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
}
