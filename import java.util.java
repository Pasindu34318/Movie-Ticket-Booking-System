import java.util.ArrayList;
import java.util.Scanner;

class Movie {
    String title;
    int availableSeats;
    double price;

    Movie(String title, int availableSeats, double price) {
        this.title = title;
        this.availableSeats = availableSeats;
        this.price = price;
    }

    void bookTickets(int seats) {
        if (seats <= availableSeats) {
            availableSeats -= seats;
            System.out.println(seats + " tickets booked successfully for " + title);
        } else {
            System.out.println("Not enough seats available!");
        }
    }

    void display() {
        System.out.println(title + " - Seats: " + availableSeats + ", Price: $" + price);
    }
}

class Booking {
    String movieName;
    int seats;

    Booking(String movieName, int seats) {
        this.movieName = movieName;
        this.seats = seats;
    }

    void showBooking() {
        System.out.println("Movie: " + movieName + " | Seats: " + seats);
    }
}

