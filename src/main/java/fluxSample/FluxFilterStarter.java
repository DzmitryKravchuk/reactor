package fluxSample;

import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FluxFilterStarter {
    public static void main(String[] args) {
        // Взять рандомный список дат и отфильтровать его
        final LocalDate filtrationDate = LocalDate.of(2005, 1, 1);
        List<LocalDate> dateList = randomLocalDateList(10);
        System.out.println("notFilteredList: " + dateList);
        Flux<LocalDate> flux = Flux.fromIterable(dateList);
        List<LocalDate> filteredList = new ArrayList<>();
        flux.filter(date -> date.isAfter(filtrationDate)).subscribe(filteredList::add);
        System.out.println("filteredList: " + filteredList);
    }

    private static List<LocalDate> randomLocalDateList(int dateCount) {
        List<LocalDate> dateList = new ArrayList<>();
        while (dateCount > 0) {
            dateList.add(getRandomDate());
            dateCount--;
        }
        return dateList;
    }

    private static LocalDate getRandomDate() {
        long minDay = LocalDate.of(1986, 4, 26).toEpochDay();
        long maxDay = LocalDate.of(2021, 3, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

}
