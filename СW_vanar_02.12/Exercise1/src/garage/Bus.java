package garage;

public class Bus {

    final static int MAX_SEATS = 45;
    final static int MIN_SEATS = 0;

    private static int routeNumber = 77;
    private static int seats = 0;

    public static class LEDPanel {
        public static void showRoute() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 12; j++) {
                    if (i == 0 || i == 2)
                        System.out.print("#");
                    if ((i == 1 && j == 0) || (i == 1 && j == 11))
                        System.out.print("#");
                    if ((i == 1 && j == 8) || (i == 1 && j == 9) || (i == 1 && j == 10))
                        System.out.print("");
                    else if (i == 1)
                        System.out.print(" ");
                    if (i == 1 && j == 5)
                        System.out.print(getRouteNumber());


                }
                System.out.println();
            }
        }
    }

    public static int getRouteNumber() {
        return routeNumber;
    }

    public static void setRouteNumber(int number) {
        if (Bus.routeNumber == 77 || Bus.routeNumber == 88 || Bus.routeNumber == 99)
            routeNumber = number;
        else
            System.err.println("Wrong number");
    }

    public static int getSeats() {
        return seats;
    }

    public static void setSeats(int seats) {
        if (seats >= MIN_SEATS && seats <= MAX_SEATS)
            Bus.seats = seats;
    }

    public static void enterPassenger(int passengersNumber) {
        if ((passengersNumber <= 2 && passengersNumber > 0) && seats + passengersNumber <= MAX_SEATS)
            seats += passengersNumber;
        else
            System.err.println("Wrong number, only one or two passengers at once");
    }

    public static void exitPassenger(int passengersNumber) {
        if ((passengersNumber <= 2 && passengersNumber > 0) && seats - passengersNumber >= MIN_SEATS)
            seats -= passengersNumber;
        else
            System.err.println("Wrong number, only one or two passengers at once");
    }

}
