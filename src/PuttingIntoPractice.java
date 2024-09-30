import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //Вывести суммы всех транзакций трейдеров из Кембриджа.
        int sumCambridgeTraiders = transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .mapToInt(Transaction::getValue) // получаем значения транзакций
                .sum();
        System.out.println(sumCambridgeTraiders);



        //Какова максимальная сумма среди всех транзакций?
        int maxSumAmongTransaction = transactions.stream().mapToInt(t ->t.getValue()).max().orElse(0);
        System.out.println(maxSumAmongTransaction);

    }
}
