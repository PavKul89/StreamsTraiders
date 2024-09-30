import java.util.Arrays;
import java.util.Comparator;
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

        System.out.println();

        //Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей)
        String allTransactionInYear = transactions.stream()
                .filter(t ->t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .map(t->t.toString())
                .collect(Collectors.joining(",\n"));

        System.out.println( "Транзакции за 2011 год:\n" + allTransactionInYear);
        System.out.println();


        //Вывести список неповторяющихся городов, в которых работают трейдеры.
        String cityWorkTraders = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println("Список городов, в которых работают трейдеры: " + cityWorkTraders);
        System.out.println();


        //Найти всех трейдеров из Кембриджа и отсортировать их по именам
        String cambridgeTraderNames = transactions.stream()
                .map(t -> t.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .map(trader -> trader.getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));

        System.out.println("Трейдеры из Кембриджа: " + cambridgeTraderNames);
        System.out.println();


        //Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном
        //порядке
        String allNameTraders = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));

        System.out.println("Список трейдеров: " + allNameTraders);
        System.out.println();


        //Выяснить, существует ли хоть один трейдер из Милана.
        boolean isHasMilansTraiders = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));

        if(isHasMilansTraiders){
            System.out.println("Трейдер из Милана есть") ;
        } else {
            System.out.println("Трейдера из Милана нет");
        }

        System.out.println();



        //Вывести суммы всех транзакций трейдеров из Кембриджа.
        int sumCambridgeTraiders = transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .mapToInt(Transaction::getValue) // получаем значения транзакций
                .sum();
        System.out.println("Cумма всех транзакций трейдеров из Кембриджа: "+ sumCambridgeTraiders + " миллиардов долларов");
        System.out.println();


        //Какова максимальная сумма среди всех транзакций?
        int maxSumAmongTransaction = transactions.stream()
                .mapToInt(t ->t.getValue())
                .max()
                .orElse(0);
        System.out.println("максимальная сумма среди всех транзакций : "+ maxSumAmongTransaction+ " миллиард долларов");
        System.out.println();

        //Найти транзакцию с минимальной суммой.
        int minSumAmongTransaction = transactions.stream()
                .mapToInt(t ->t.getValue())
                .min().
                orElse(0);
        System.out.println("транзакцию с минимальной суммой: " + minSumAmongTransaction + " миллионов долларов");

    }
}
