package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    protected TicketRepository repository;


    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] searchBy(String departure, String arrival) {
        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу продукты
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, departure, arrival)) {
                int length = result.length + 1;
                Ticket[] tmp = new Ticket[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Ticket ticket, String departure, String arrival) {
        if (!ticket.getDeparture().equals(departure)) {
            return false;
        }
        if (!ticket.getArrival().equals(arrival)) {
            return false;
        } else {
            return true;
        }

    }
}
