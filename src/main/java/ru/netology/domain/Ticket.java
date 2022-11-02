package ru.netology.domain;

public class Ticket implements Comparable <Ticket>{
    protected int id;
    protected String departure;
    protected String arrival;
    protected int price;
    protected int time;

    public Ticket(int id, String departure, String arrival, int price, int time) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }



    @Override
    public int compareTo(Ticket o) {
        return price - o.price;
    }
}
