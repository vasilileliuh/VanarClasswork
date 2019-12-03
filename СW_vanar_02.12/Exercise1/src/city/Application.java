package city;

import garage.Bus;

public class Application {
    public static void main(String[] args) {

//        System.out.println("Route number = " + Bus.getRouteNumber());
//        Bus.setRouteNumber(88);
        Bus.LEDPanel.showRoute();
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
        testCaseVasili();
        testWheelsBasic();
        testWheelsBasic2();


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

    public static void testCaseVasili() {
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

    static void testWheelsBasic() {
        // 4 working wheels within parameters
        Bus.Wheels.setWheelPSI(115, Bus.Wheels.FRONT_LEFT);
        Bus.Wheels.setWheelPSI(115, Bus.Wheels.FRONT_RIGHT);
        Bus.Wheels.setWheelPSI(100, Bus.Wheels.BACK_LEFT_PRIMARY);
        Bus.Wheels.setWheelPSI(100, Bus.Wheels.BACK_RIGHT_PRIMARY);
        Bus.Wheels.setWheelPSI(0, Bus.Wheels.BACK_LEFT_SECONDARY);
        Bus.Wheels.setWheelPSI(0, Bus.Wheels.BACK_RIGHT_SECONDARY);

        // Too many passengers
        Bus.setSeats(40);
        System.out.println(Bus.isGoodToGo());
        // false

        //less passengers
        Bus.setSeats(29);
        System.out.println(Bus.isGoodToGo());
        //true

        //pressurizing back wheels
        Bus.Wheels.setWheelPSI(80, Bus.Wheels.BACK_LEFT_SECONDARY);
        Bus.Wheels.setWheelPSI(80, Bus.Wheels.BACK_RIGHT_SECONDARY);

        //full bus
        Bus.setSeats(45);
        System.out.println(Bus.isGoodToGo());
        //true

    }

    static void testWheelsBasic2() {

        // 4 working wheels within parameters
        Bus.Wheels.setWheelPSI(115, Bus.Wheels.FRONT_LEFT);
        Bus.Wheels.setWheelPSI(115, Bus.Wheels.FRONT_RIGHT);
        Bus.Wheels.setWheelPSI(100, Bus.Wheels.BACK_LEFT_PRIMARY);
        Bus.Wheels.setWheelPSI(100, Bus.Wheels.BACK_RIGHT_PRIMARY);
        Bus.Wheels.setWheelPSI(0, Bus.Wheels.BACK_LEFT_SECONDARY);
        Bus.Wheels.setWheelPSI(0, Bus.Wheels.BACK_RIGHT_SECONDARY);
        System.out.println("Tyre 1 pressure = " + Bus.Wheels.getWheelPSI(1));
        System.out.println("Tyre 2 pressure = " + Bus.Wheels.getWheelPSI(2));
        System.out.println("Tyre 3 pressure = " + Bus.Wheels.getWheelPSI(3));
        System.out.println("Tyre 4 pressure = " + Bus.Wheels.getWheelPSI(4));
        System.out.println("Tyre 5 pressure = " + Bus.Wheels.getWheelPSI(5));
        System.out.println("Tyre 6 pressure = " + Bus.Wheels.getWheelPSI(6));
        System.out.println("Tyre 1 " + Bus.isTyrePressureOk(1, 95.0));
        System.out.println("Tyre 2 " + Bus.isTyrePressureOk(2, 95.0));
        System.out.println("Tyre 3 " + Bus.isTyrePressureOk(3, 95.0));
        System.out.println("Tyre 4 " + Bus.isTyrePressureOk(4, 95.0));
        System.out.println("Tyre 5 " + Bus.isTyrePressureOk(5, 95.0));
        System.out.println("Tyre 6 " + Bus.isTyrePressureOk(6, 95.0));
    }

}
