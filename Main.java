// import java.util.Scanner;

// public class Main {

//     public static void main(String[] args) {

//         Scanner scanner = new Scanner(System.in);
//         TriageSystem triageSystem = new TriageSystem();
//         int patientIdCounter = 1;

//         while (true) {

//             System.out.println("\n==== Intelligent Patient Triage System ====");
//             System.out.println("1. Add Patient");
//             System.out.println("2. View Next Emergency Case");
//             System.out.println("3. View All Waiting Patients");
//             System.out.println("4. Generate Report");
//             System.out.println("5. Exit");
//             System.out.print("Enter choice: ");

//             int choice = scanner.nextInt();

//             switch (choice) {

//                 case 1:
//                     scanner.nextLine(); // consume newline

//                     System.out.print("Enter Patient Name: ");
//                     String name = scanner.nextLine();

//                     System.out.print("Enter Age: ");
//                     int age = scanner.nextInt();

//                     System.out.print("Enter Oxygen Level: ");
//                     double oxygen = scanner.nextDouble();

//                     System.out.print("Enter Heart Rate: ");
//                     int heartRate = scanner.nextInt();

//                     System.out.print("Enter Temperature: ");
//                     double temp = scanner.nextDouble();

//                     System.out.print("Enter Blood Pressure: ");
//                     int bp = scanner.nextInt();

//                     Patient patient = new Patient(
//                             patientIdCounter++, name, age,
//                             oxygen, heartRate, temp, bp
//                     );

//                     triageSystem.addPatient(patient);
//                     break;

//                 case 2:
//                     triageSystem.viewNextPatient();
//                     break;

//                 case 3:
//                     triageSystem.viewAllPatients();
//                     break;

//                 case 4:
//                     triageSystem.generateReport();
//                     break;

//                 case 5:
//                     System.out.println("Exiting System...");
//                     scanner.close();
//                     System.exit(0);

//                 default:
//                     System.out.println("Invalid choice. Try again.");
//             }
//         }
//     }
// }

// import java.util.Scanner;

// public class Main {

//     public static void main(String[] args) {

//         Scanner scanner = new Scanner(System.in);
//         TriageSystem triageSystem = new TriageSystem();
//         int patientIdCounter = 1; // still used for in-memory ID

//         while (true) {

//             System.out.println("\n==== Intelligent Patient Triage System ====");
//             System.out.println("1. Add Patient");
//             System.out.println("2. View Next Emergency Case");
//             System.out.println("3. View All Waiting Patients");
//             System.out.println("4. Generate Report");
//             System.out.println("5. Exit");
//             System.out.print("Enter choice: ");

//             int choice = scanner.nextInt();

//             switch (choice) {
//                 case 1:
//                     scanner.nextLine(); // consume newline

//                     System.out.print("Enter Patient Name: ");
//                     String name = scanner.nextLine();

//                     int age = readInt(scanner, "Enter Age (1-120): ", 1, 120);
//                     double oxygen = readDouble(scanner, "Enter Oxygen Level (1-100): ", 1, 100);
//                     int heartRate = readInt(scanner, "Enter Heart Rate (1-220): ", 1, 220);
//                     double temp = readDouble(scanner, "Enter Temperature (25-45): ", 25, 45);
//                     int bp = readInt(scanner, "Enter Blood Pressure (1-300): ", 1, 300);

//                     Patient patient = new Patient(
//                             patientIdCounter++, name, age,
//                             oxygen, heartRate, temp, bp
//                     );

//                     triageSystem.addPatient(patient);
//                     break;

//                 case 2:
//                     triageSystem.viewNextPatient();
//                     break;

//                 case 3:
//                     triageSystem.viewAllPatients();
//                     break;

//                 case 4:
//                     triageSystem.generateReport();
//                     break;

//                 case 5:
//                     System.out.println("Exiting System...");
//                     scanner.close();
//                     System.exit(0);

//                 default:
//                     System.out.println("Invalid choice. Try again.");
//             }
//         }
//     }

//     // ✅ Input helpers
//     private static int readInt(Scanner sc, String prompt, int min, int max) {
//         int value;
//         while (true) {
//             System.out.print(prompt);
//             value = sc.nextInt();
//             if (value >= min && value <= max) break;
//             System.out.println("Invalid input. Try again.");
//         }
//         return value;
//     }

//     private static double readDouble(Scanner sc, String prompt, double min, double max) {
//         double value;
//         while (true) {
//             System.out.print(prompt);
//             value = sc.nextDouble();
//             if (value >= min && value <= max) break;
//             System.out.println("Invalid input. Try again.");
//         }
//         return value;
//     }
// }
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TriageSystem triageSystem = new TriageSystem();

        while (true) {
            System.out.println("\n==== Intelligent Patient Triage System ====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Next Emergency Case");
            System.out.println("3. View All Waiting Patients");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
              System.out.print("Enter Patient Name: ");
            String name = scanner.nextLine();

            int age;
             while (true) {
             System.out.print("Enter Age (1-120): ");
             age = scanner.nextInt();
             if (age >= 1 && age <= 120) break;
             System.out.println("Invalid Age! Please enter between 1 and 120.");
    }

    double oxygen;
    while (true) {
        System.out.print("Enter Oxygen Level (1-100): ");
        oxygen = scanner.nextDouble();
        if (oxygen >= 1 && oxygen <= 100) break;
        System.out.println("Invalid Oxygen Level! Enter between 1 and 100.");
    }

    int hr;
    while (true) {
        System.out.print("Enter Heart Rate (1-220): ");
        hr = scanner.nextInt();
        if (hr >= 1 && hr <= 220) break;
        System.out.println("Invalid Heart Rate! Enter between 1 and 220.");
    }

    double temp;
    while (true) {
        System.out.print("Enter Temperature (25-45): ");
        temp = scanner.nextDouble();
        if (temp >= 25 && temp <= 45) break;
        System.out.println("Invalid Temperature! Enter between 25 and 45.");
    }

    int bp;
    while (true) {
        System.out.print("Enter Blood Pressure (1-300): ");
        bp = scanner.nextInt();
        if (bp >= 1 && bp <= 300) break;
        System.out.println("Invalid Blood Pressure! Enter between 1 and 300.");
    }

    scanner.nextLine(); // clear buffer

    Patient patient = new Patient(0, name, age, oxygen, hr, temp, bp);
    triageSystem.addPatient(patient);
    break;
                 case 2:
                    triageSystem.viewNextPatient();
                    break;

                case 3:
                    triageSystem.viewAllPatients();
                    break;

                case 4:
                    triageSystem.generateReport();
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}