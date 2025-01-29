public class MovieBookingSystem {
    static ArrayList<Movie> movies = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        movies.add(new Movie("Inception", 50, 12.5));
        movies.add(new Movie("Avengers", 30, 10.0));
        movies.add(new Movie("Titanic", 20, 8.5));

        while (true) {
            System.out.println("\nMovie Ticket Booking System");
            System.out.println("1. View Movies");
            System.out.println("2. Book Tickets");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewMovies();
                    break;
                case 2:
                    bookTickets();
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.out.println("Thank you for using the system!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    static void viewMovies() {
        System.out.println("\nAvailable Movies:");
        for (int i = 0; i < movies.size(); i++) {
            System.out.print((i + 1) + ". ");
            movies.get(i).display();
        }
    }

    static void bookTickets() {
        viewMovies();
        System.out.print("Enter movie number: ");
        int movieIndex = sc.nextInt() - 1;
        if (movieIndex < 0 || movieIndex >= movies.size()) {
            System.out.println("Invalid movie selection!");
            return;
        }

        System.out.print("Enter number of tickets: ");
        int tickets = sc.nextInt();
        Movie selectedMovie = movies.get(movieIndex);

        if (tickets > 0) {
            selectedMovie.bookTickets(tickets);
            bookings.add(new Booking(selectedMovie.title, tickets));
        } else {
            System.out.println("Invalid number of tickets!");
        }
    }

    static void viewBookings() {
        System.out.println("\nYour Bookings:");
        if (bookings.isEmpty()) {
            System.out.println("No bookings made yet.");
            return;
        }
        for (Booking booking : bookings) {
            booking.showBooking();
        }
    }
}