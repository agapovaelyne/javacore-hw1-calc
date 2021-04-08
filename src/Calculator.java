import java.util.function.*;

public class Calculator {

    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;

    /*
    1 - Можно проработать кейс с делением на 0 без применения исключений (тогда и в main их ловить не будем).
    При этом в результате операции возвращается значение делимого или иное значение


    BinaryOperator<Integer> devide = (x, y) ->  {
        if (y != 0)
            return x / y;
        else {
            System.out.println("Операция не произведена - На ноль делить нельзя!");
            return x;
        }
    };

    2 - Или так (без уведомления об ошибке)
     BinaryOperator<Integer> devide = (x, y) ->  y != 0 ? x/y : x;
    */


    //3 - Можно проработать кейс с делением на 0, выбросив исключение, которое обработаем в Main
    BinaryOperator<Integer> devide = (x, y) ->  {
        if (y != 0)
            return x / y;
        else {
            throw new ArithmeticException("На ноль делить нельзя!");
        }
    };



    UnaryOperator<Integer> pow = x -> x * x;
    //здесь вместо > использовала >=, чтобы предусмотреть кейс x==0
    UnaryOperator<Integer> abs = x -> x >= 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;
}
