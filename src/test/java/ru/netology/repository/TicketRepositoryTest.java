package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

public class TicketRepositoryTest {

    Ticket ticket1 = new Ticket(11, "Orenburg", "Ufa", 1000, 15);
    Ticket ticket2 = new Ticket(12, "Samara", "London", 1200, 10);
    Ticket ticket3 = new Ticket(13, "Berlin", "Lugansk", 2000, 1);
    Ticket ticket4 = new Ticket(14, "Minsk", "Kiev", 3000, 2);
    Ticket ticket5 = new Ticket(15, "Astana", "Omsk", 4000, 20);

    @Test
    public void testTicket1() {
        TicketRepository repository = new TicketRepository();
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.removeById(ticket2.getId());

        Ticket[] expected = {ticket1, ticket3};
        Ticket[] actual = repository.getTickets();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testTicket2() {
        TicketRepository repository = new TicketRepository();
        repository.save(ticket1);

        Ticket[] expected = {ticket1};
        Ticket[] actual = repository.getTickets();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testTicket3() {
        TicketRepository repository = new TicketRepository();

        Ticket[] expected = {};
        Ticket[] actual = repository.getTickets();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testRemoveID13() {
        TicketRepository repository = new TicketRepository();
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.removeById(12);

        Ticket[] expected = {ticket1, ticket3};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(actual, expected);
    }
}
