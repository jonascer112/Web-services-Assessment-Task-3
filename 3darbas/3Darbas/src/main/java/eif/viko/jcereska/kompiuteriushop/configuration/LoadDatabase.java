package eif.viko.jcereska.kompiuteriushop.configuration;

import eif.viko.jcereska.kompiuteriushop.OrderRepository;
import eif.viko.jcereska.kompiuteriushop.model.Order;
import eif.viko.jcereska.kompiuteriushop.model.Customer;
import eif.viko.jcereska.kompiuteriushop.model.Computer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(OrderRepository repository){

        Computer computer1 = new Computer("Zaidimu kompiuteris I5-13600k/f Rtx3080 16gb", "I5-13600k/f Rtx3080 16gb", "2022", 1200.00);
        Customer customer1 = new Customer("Tomas", "Kandis");
        Order order1 = new Order("2023-08-16", List.of(customer1), List.of(computer1));

        Computer computer2 = new Computer( "Ryzen 7 3700x, Rtx 2070 Super Oc ir 16 GB RAM", "Ryzen 7 3700x, Rtx 2070 Super Oc ir 16 GB RAM", "2019", 750.00);

        Customer customer01 = new Customer("MIgruotas", "Lokys");

        Customer customer02 = new Customer("Julius", "Sviesmetis");

        Order order2 = new Order("2023-04-10", List.of(customer01,customer02), List.of(computer2));


        return args -> {
            log.info("Loading" + repository.save(order1));
            log.info("Loading" + repository.save(order2));
        };

    }
}