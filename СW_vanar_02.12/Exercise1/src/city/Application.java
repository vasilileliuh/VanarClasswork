package city;

import garage.Bus;

public class Application {
    public static void main(String[] args) {

//        System.out.println("Route number = " + Bus.getRouteNumber());
        Bus.setRouteNumber(88);
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
        testCase1();
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
        System.out.println();

    }

    static void testWheelsBasic2() {
        System.out.println("testWheelsBasic2 method");

        // 3 working wheels within parameters
        Bus.Wheels.setWheelPSI(114, Bus.Wheels.FRONT_LEFT);
        Bus.Wheels.setWheelPSI(113, Bus.Wheels.FRONT_RIGHT);
        Bus.Wheels.setWheelPSI(95, Bus.Wheels.BACK_LEFT_PRIMARY);
        Bus.Wheels.setWheelPSI(75, Bus.Wheels.BACK_LEFT_SECONDARY);
        Bus.Wheels.setWheelPSI(94, Bus.Wheels.BACK_RIGHT_PRIMARY);
        Bus.Wheels.setWheelPSI(76, Bus.Wheels.BACK_RIGHT_SECONDARY);
        System.out.println("Tyre 1 pressure = " + Bus.Wheels.getWheelPSI(Bus.Wheels.FRONT_LEFT));
        System.out.println("Tyre 2 pressure = " + Bus.Wheels.getWheelPSI(Bus.Wheels.FRONT_RIGHT));
        System.out.println("Tyre 3 pressure = " + Bus.Wheels.getWheelPSI(Bus.Wheels.BACK_LEFT_PRIMARY));
        System.out.println("Tyre 4 pressure = " + Bus.Wheels.getWheelPSI(Bus.Wheels.BACK_LEFT_SECONDARY));
        System.out.println("Tyre 5 pressure = " + Bus.Wheels.getWheelPSI(Bus.Wheels.BACK_RIGHT_PRIMARY));
        System.out.println("Tyre 6 pressure = " + Bus.Wheels.getWheelPSI(Bus.Wheels.BACK_RIGHT_SECONDARY));
        System.out.printf("Is tyre 1 pressure within 95%% of %.0f PSI = %b%n",
                Bus.Wheels.FRONT_WHEEL_MAX_PRESSURE_PSI,
                Bus.isTyrePressureOk(Bus.Wheels.FRONT_LEFT, Bus.getMinPermittedPercentPressureAnyWheel()));
        System.out.printf("Is tyre 2 pressure within 95%% of %.0f PSI = %b%n",
                Bus.Wheels.FRONT_WHEEL_MAX_PRESSURE_PSI,
                Bus.isTyrePressureOk(Bus.Wheels.FRONT_RIGHT, Bus.getMinPermittedPercentPressureAnyWheel()));
        System.out.printf("Is tyre 3 pressure within 95%% of %.0f PSI = %b%n",
                Bus.Wheels.REAR_PRIMARY_WHEEL_MAX_PRESSURE_PSI,
                Bus.isTyrePressureOk(Bus.Wheels.BACK_LEFT_PRIMARY, Bus.getMinPermittedPercentPressureAnyWheel()));
        System.out.printf("Is tyre 4 pressure within 95%% of %.0f PSI = %b%n",
                Bus.Wheels.REAR_SECONDARY_WHEEL_MAX_PRESSURE_PSI,
                Bus.isTyrePressureOk(Bus.Wheels.BACK_LEFT_SECONDARY, Bus.getMinPermittedPercentPressureAnyWheel()));
        System.out.printf("Is tyre 5 pressure within 95%% of %.0f PSI = %b%n",
                Bus.Wheels.REAR_PRIMARY_WHEEL_MAX_PRESSURE_PSI,
                Bus.isTyrePressureOk(Bus.Wheels.BACK_RIGHT_PRIMARY, Bus.getMinPermittedPercentPressureAnyWheel()));
        System.out.printf("Is tyre 6 pressure within 95%% of %.0f PSI = %b%n",
                Bus.Wheels.REAR_SECONDARY_WHEEL_MAX_PRESSURE_PSI,
                Bus.isTyrePressureOk(Bus.Wheels.BACK_RIGHT_SECONDARY, Bus.getMinPermittedPercentPressureAnyWheel()));
    }

}
