package city;

import garage.Bus;

public class Application {
    public static void main(String[] args) {

//        System.out.println("Route number = " + Bus.getRouteNumber());
//        Bus.setRouteNumber(88);
//        Bus.LEDPanel.showRoute();
//        System.out.println(Bus.getSeats());
//        Bus.setSeats(3);
//        System.out.println(Bus.getSeats());
//        Bus.enterPassenger(2);
//        System.out.println(Bus.getSeats());
//        Bus.exitPassenger(2);
//        System.out.println(Bus.getSeats());
//        Bus.exitPassenger(2);
//        System.out.println(Bus.getSeats());
//        Bus.exitPassenger(2);
//        System.out.println(Bus.getSeats());
//        testCase1();
        testVasili();

    }

    public static void testCase1() {
        Bus.setSeats(40);
        Bus.enterPassenger(5);
        Bus.enterPassenger(2);
        Bus.enterPassenger(2);
        Bus.enterPassenger(2);
        Bus.exitPassenger(50);
        Bus.exitPassenger(1);
        System.out.println(Bus.getSeats());
    }

    public static void testVasili() {
        Bus.setSeats(2);
        for (int i = 0; i < 45; i++) {
            Bus.enterPassenger(1);
        }
        System.out.println(Bus.getSeats());
        Bus.setSeats(0);
        for (int i = 0; i < 25; i++) {
            Bus.enterPassenger(2);
        }
        System.out.println(Bus.getSeats());
        Bus.setSeats(11);
        Bus.enterPassenger(3);
        Bus.enterPassenger(2);
        Bus.exitPassenger(3);
        Bus.enterPassenger(2);
        Bus.enterPassenger(2);
        Bus.exitPassenger(45);
        Bus.exitPassenger(1);
        System.out.println(Bus.getSeats());
        Bus.setSeats(5);
        Bus.exitPassenger(2);
        Bus.exitPassenger(2);
        Bus.exitPassenger(1);
        Bus.exitPassenger(1);
        System.out.println(Bus.getSeats());
    }


}
