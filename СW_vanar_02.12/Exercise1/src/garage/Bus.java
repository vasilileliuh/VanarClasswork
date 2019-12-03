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

    public static class Wheels {

        public final static byte FRONT_LEFT = 1;
        public final static byte FRONT_RIGHT = 2;
        public final static byte BACK_LEFT_PRIMARY = 3;
        public final static byte BACK_LEFT_SECONDARY = 4;
        public final static byte BACK_RIGHT_PRIMARY = 5;
        public final static byte BACK_RIGHT_SECONDARY = 6;

        private static double frontLeftPSI = 0;
        private static double frontRightPSI = 0;
        private static double backLeftPrimaryPSI = 0;
        private static double backLeftSecondaryPSI = 0;
        private static double backRightPrimaryPSI = 0;
        private static double backRightSecondaryPSI = 0;

        final static double WHEEL_MIN_PRESSURE_PSI = 0.0;
        final static double FRONT_WHEEL_MAX_PRESSURE_PSI = 120.0;
        final static double REAR_PRIMARY_WHEEL_MAX_PRESSURE_PSI = 100.0;
        final static double REAR_SECONDARY_WHEEL_MAX_PRESSURE_PSI = 80.0;

        public static void setWheelPSI(double pressure, int whichWheel) {
            if (pressure < WHEEL_MIN_PRESSURE_PSI)
                System.err.println("Pressure lower than 0 PSI error");
            else if ((pressure > FRONT_WHEEL_MAX_PRESSURE_PSI && whichWheel == FRONT_LEFT)
                    || (pressure > FRONT_WHEEL_MAX_PRESSURE_PSI && whichWheel == FRONT_RIGHT)
                    || (pressure > REAR_PRIMARY_WHEEL_MAX_PRESSURE_PSI && whichWheel == BACK_LEFT_PRIMARY)
                    || (pressure > REAR_PRIMARY_WHEEL_MAX_PRESSURE_PSI && whichWheel == BACK_RIGHT_PRIMARY))
                System.err.println("Pressure higher than 120 PSI error");
            else if ((pressure > REAR_SECONDARY_WHEEL_MAX_PRESSURE_PSI && whichWheel == BACK_LEFT_SECONDARY)
                    || (pressure > REAR_SECONDARY_WHEEL_MAX_PRESSURE_PSI && whichWheel == BACK_RIGHT_SECONDARY))
                System.err.println("Pressure of rear inner wheel higher than 80 PSI error");
            else if (whichWheel < FRONT_LEFT || whichWheel > BACK_RIGHT_SECONDARY)
                System.err.println("Where is no such a wheel in the bus");
            else if (whichWheel == FRONT_LEFT)
                Wheels.frontLeftPSI = pressure;
            else if (whichWheel == FRONT_RIGHT)
                Wheels.frontRightPSI = pressure;
            else if (whichWheel == BACK_LEFT_PRIMARY)
                Wheels.backLeftPrimaryPSI = pressure;
            else if (whichWheel == BACK_LEFT_SECONDARY)
                Wheels.backLeftSecondaryPSI = pressure;
            else if (whichWheel == BACK_RIGHT_PRIMARY)
                Wheels.backRightPrimaryPSI = pressure;
            else
                Wheels.backRightSecondaryPSI = pressure;
        }

        public static double getWheelPSI(int whichWheel) {
            switch (whichWheel) {
                case FRONT_LEFT:
                    return frontLeftPSI;
                case FRONT_RIGHT:
                    return frontRightPSI;
                case BACK_LEFT_PRIMARY:
                    return backLeftPrimaryPSI;
                case BACK_LEFT_SECONDARY:
                    return backLeftSecondaryPSI;
                case BACK_RIGHT_PRIMARY:
                    return backRightPrimaryPSI;
                case BACK_RIGHT_SECONDARY:
                    return backRightSecondaryPSI;
                default:
                    System.err.println("Wrong wheel number");
                    return 0.0;
            }

        }

    }

    static int getRouteNumber() {
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

    public static boolean isGoodToGo() {
        if (seats >= 30)
            return isTyrePressureOk(Wheels.FRONT_LEFT, 95) && isTyrePressureOk(Wheels.FRONT_RIGHT, 95)
                    && isTyrePressureOk(Wheels.BACK_LEFT_PRIMARY, 95) && isTyrePressureOk(Wheels.BACK_LEFT_SECONDARY, 95)
                    && isTyrePressureOk(Wheels.BACK_RIGHT_PRIMARY, 95) && isTyrePressureOk(Wheels.BACK_RIGHT_SECONDARY, 95);
        else
            return isTyrePressureOk(Wheels.FRONT_LEFT, 95) && isTyrePressureOk(Wheels.FRONT_RIGHT, 95) &&
                    isTyrePressureOk(Wheels.BACK_LEFT_PRIMARY, 95) && isTyrePressureOk(Wheels.BACK_RIGHT_PRIMARY, 95);

    }

    public static boolean isTyrePressureOk(int wheel, double minPercentPressure) {
        if (wheel == Wheels.FRONT_LEFT)
            return Wheels.frontLeftPSI >= Wheels.FRONT_WHEEL_MAX_PRESSURE_PSI * minPercentPressure / 100;
        else if (wheel == Wheels.FRONT_RIGHT)
            return Wheels.frontRightPSI >= Wheels.FRONT_WHEEL_MAX_PRESSURE_PSI * minPercentPressure / 100;
        else if (wheel == Wheels.BACK_LEFT_PRIMARY)
            return Wheels.backLeftPrimaryPSI >= Wheels.REAR_PRIMARY_WHEEL_MAX_PRESSURE_PSI * minPercentPressure / 100;
        else if (wheel == Wheels.BACK_LEFT_SECONDARY)
            return Wheels.backLeftSecondaryPSI >= Wheels.REAR_SECONDARY_WHEEL_MAX_PRESSURE_PSI * minPercentPressure / 100;
        else if (wheel == Wheels.BACK_RIGHT_PRIMARY)
            return Wheels.backRightPrimaryPSI >= Wheels.REAR_PRIMARY_WHEEL_MAX_PRESSURE_PSI * minPercentPressure / 100;
        else if (wheel == Wheels.BACK_RIGHT_SECONDARY)
            return Wheels.backRightSecondaryPSI >= Wheels.REAR_SECONDARY_WHEEL_MAX_PRESSURE_PSI * minPercentPressure / 100;
        else
            return false;

    }

}
