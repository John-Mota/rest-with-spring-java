package br.com.johnmota.rest.classes;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.johnmota.rest.excepitions.UnsuportedMathExceptions;




@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    private SimpleMath math = new SimpleMath();

   @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET )
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!ConvertNumber.isNumeric(numberOne) || !ConvertNumber.isNumeric(numberTwo)) {
            throw new UnsuportedMathExceptions("Please set a numeric value!");
        }

        return math.sum(ConvertNumber.convertDouble(numberOne), ConvertNumber.convertDouble(numberTwo));
    }

    @RequestMapping(value = "/subtract/{numberOne}/{numberTwo}", method=RequestMethod.GET )
    public Double subtract(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!ConvertNumber.isNumeric(numberOne) || !ConvertNumber.isNumeric(numberTwo)) {
            throw new UnsuportedMathExceptions("Please set a numeric value!");
        }

        if (ConvertNumber.isNumeric(numberOne) && ConvertNumber.isNumeric(numberTwo)) {
            if (Double.parseDouble(numberOne) < Double.parseDouble(numberTwo)) {
                throw new UnsuportedMathExceptions("O primeiro número deve ser menor que o segundo número!");
            }
        }

        return math.subtract(ConvertNumber.convertDouble(numberOne), ConvertNumber.convertDouble(numberTwo));
    }

    @RequestMapping(value = "/divider/{numberOne}/{numberTwo}", method=RequestMethod.GET )
    public Double divider(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!ConvertNumber.isNumeric(numberOne) || !ConvertNumber.isNumeric(numberTwo)) {
            throw new UnsuportedMathExceptions("Please set a numeric value!");
        }
        if (ConvertNumber.isNumeric(numberOne) && ConvertNumber.isNumeric(numberTwo)) {
            if (Double.parseDouble(numberOne) < Double.parseDouble(numberTwo)) {
                throw new UnsuportedMathExceptions("O primeiro número deve ser Maior que o segundo número!");
            }
        }

        return math.divider(ConvertNumber.convertDouble(numberOne), ConvertNumber.convertDouble(numberTwo));
    }

    @RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", method=RequestMethod.GET )
    public Double multiply(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if (!ConvertNumber.isNumeric(numberOne) || !ConvertNumber.isNumeric(numberTwo)) {
            throw new UnsuportedMathExceptions("Please set a numeric value!");
        }

        return math.multiply(ConvertNumber.convertDouble(numberOne), ConvertNumber.convertDouble(numberTwo));
    }
    
}
