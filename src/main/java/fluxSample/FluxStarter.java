package fluxSample;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;

public class FluxStarter {
    public static void main(String[] args) throws InterruptedException {
        // 10 секунд подряд выводить в консоль номер секунды
        Flux
                .<Integer>generate(sinc->{
                    sinc.next(getSecondNum());
                })
                .delayElements((Duration.ofMillis(1000)))
                .take(10)
                .subscribe(System.out::println);
        Thread.sleep(50000);
    }

    private static int getSecondNum() {
        LocalDateTime now = LocalDateTime.now();
        return now.getSecond();
    }
}
