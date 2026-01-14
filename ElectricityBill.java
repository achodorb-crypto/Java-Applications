import java.util.Scanner;

enum CustomerType {
    REGULAR, BUSINESS, VIP
}

public class ElectricityBill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter units consumed: ");
        int units = scanner.nextInt();

        System.out.println("Select customer type:");
        System.out.println("1. REGULAR");
        System.out.println("2. BUSINESS");
        System.out.println("3. VIP");
        int typeChoice = scanner.nextInt();
        CustomerType type = switch (typeChoice) {
            case 1 -> CustomerType.REGULAR;
            case 2 -> CustomerType.BUSINESS;
            case 3 -> CustomerType.VIP;
            default -> {
                System.out.println("Invalid choice, defaulting to REGULAR");
                yield CustomerType.REGULAR;
            }
        };

        double totalBill = calculateBill(units, type);
        printBillBreakdown(name, units, type, totalBill);
    }

    static double calculateBill(int units, CustomerType type) {
        double bill = 0;
        if (units <= 100) bill = units * 30;
        else if (units <= 300) bill = 100 * 30 + (units - 100) * 25;
        else bill = 100 * 30 + 200 * 25 + (units - 300) * 20;

        double discount = switch (type) {
            case REGULAR -> 0;
            case BUSINESS -> 0.05;
            case VIP -> 0.10;
        };
        return bill * (1 - discount);
    }

    static void printBillBreakdown(String name, int units, CustomerType type, double totalBill) {
        System.out.println("\nBill for " + name + " (" + type + ")");
        int remainingUnits = units;
        int block = 0;
        while (remainingUnits > 0) {
            int blockUnits = Math.min(50, remainingUnits);
            double blockRate = getRateForUnits(units - remainingUnits + blockUnits);
            double blockCost = blockUnits * blockRate;
            System.out.println("Units " + (units - remainingUnits + 1) + "-" + (units - remainingUnits + blockUnits) + ": ₦" + blockCost);
            remainingUnits -= blockUnits;
            block++;
        }
        System.out.println("Total bill: ₦" + totalBill);
    }

    static double getRateForUnits(int units) {
        if (units <= 100) return 30;
        else if (units <= 300) return 25;
        else return 20;
    }
}