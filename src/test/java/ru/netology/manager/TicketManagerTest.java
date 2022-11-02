package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;
import ru.netology.manager.TicketManager;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(11, "Orenburg", "Ufa", 4000, 15);
    Ticket ticket2 = new Ticket(12, "Samara", "London", 2200, 10);
    Ticket ticket3 = new Ticket(13, "Berlin", "Lugansk", 2000, 1);
    Ticket ticket4 = new Ticket(14, "Berlin", "Lugansk", 3000, 2);
    Ticket ticket5 = new Ticket(15, "Berlin", "Lugansk", 1000, 20);

    @Test
    void shouldNoAdd() {

        Ticket[] expected = {};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAdd() {
        manager.add(ticket1);
        Ticket[] expected = {ticket1};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddAll() {
        manager.add(ticket1);
        manager.add(ticket2);
        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBy1endSort() {
        manager.add(ticket3);
        manager.add(ticket2);
        manager.add(ticket1);
        manager.add(ticket4);
        manager.add(ticket5);

        String departure = "Berlin";
        String arrival = "Lugansk";
        Ticket[] expected = {ticket5, ticket3, ticket4};
        Ticket[] actual = manager.searchBy(departure, arrival);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBy2() {
        manager.add(ticket3);
        manager.add(ticket2);
        manager.add(ticket1);
        manager.add(ticket4);
        manager.add(ticket5);

        String departure = "Berlin";
        String arrival = "London";
        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy(departure, arrival);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBy3() {
        manager.add(ticket3);
        manager.add(ticket2);
        manager.add(ticket1);
        manager.add(ticket4);
        manager.add(ticket5);

        String departure = "Keln";
        String arrival = "Penza";
        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy(departure, arrival);
        assertArrayEquals(expected, actual);
    }


}
