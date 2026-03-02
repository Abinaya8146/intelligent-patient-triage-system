// import java.util.List;

// public class ReportService {

//     public static void generateReport(List<Patient> patients) {

//         int total = patients.size();
//         int critical = 0;
//         int urgent = 0;
//         int totalScore = 0;

//         for (Patient p : patients) {
//             totalScore += p.getRiskScore();
//             if (p.getPriorityLevel().equals("CRITICAL")) critical++;
//             if (p.getPriorityLevel().equals("URGENT")) urgent++;
//         }

//         System.out.println("\n===== DAILY TRIAGE REPORT =====");
//         System.out.println("Total Patients: " + total);
//         System.out.println("Critical Cases: " + critical);
//         System.out.println("Urgent Cases: " + urgent);
//         System.out.println("Average Risk Score: " + (total == 0 ? 0 : totalScore / total));
//     }
// }
// import java.util.*;

// public class ReportService {

//     public static void generateReport(List<Patient> patients) {

//         if (patients.isEmpty()) {
//             System.out.println("\nNo patient data available for report.");
//             return;
//         }

//         int critical = 0;
//         int urgent = 0;
//         int observation = 0;
//         int stable = 0;
//         int totalRisk = 0;
//         int highestRisk = 0;
//         String highestRiskPatient = "";

//         for (Patient p : patients) {

//             totalRisk += p.getriskScore();

//             if (p.getriskScore() > highestRisk) {
//                 highestRisk = p.getriskScore();
//                 highestRiskPatient = p.getName();
//             }

//             switch (p.getPriorityLevel()) {
//                 case "CRITICAL" -> critical++;
//                 case "URGENT" -> urgent++;
//                 case "OBSERVATION" -> observation++;
//                 case "STABLE" -> stable++;
//             }
//         }

//         double avgRisk = (double) totalRisk / patients.size();

//         System.out.println("\n=========== TRIAGE ANALYTICS REPORT ===========");
//         System.out.println("Total Patients Evaluated : " + patients.size());
//         System.out.println("-----------------------------------------------");
//         System.out.println("Critical Cases           : " + critical);
//         System.out.println("Urgent Cases             : " + urgent);
//         System.out.println("Observation Cases        : " + observation);
//         System.out.println("Stable Cases             : " + stable);
//         System.out.println("-----------------------------------------------");
//         System.out.println("Average Risk Score       : " + String.format("%.2f", avgRisk));
//         System.out.println("Highest Risk Score       : " + highestRisk);
//         System.out.println("Highest Risk Patient     : " + highestRiskPatient);
//         System.out.println("===============================================\n");

//         if (critical > 0) {
//             System.out.println("ALERT:Immediate medical escalation required!");
//         }
//     }
// }
import java.util.List;

public class ReportService {

    public static void generateReport(List<Patient> patients) {

        if (patients.isEmpty()) {
            System.out.println("\nNo patient data available.");
            return;
        }

        int critical = 0;
        int totalRisk = 0;

        for (Patient p : patients) {
            totalRisk += p.getRiskScore();
            if (p.getPriorityLevel().equals("CRITICAL"))
                critical++;
        }

        double avgRisk = (double) totalRisk / patients.size();

        System.out.println("\n=========== TRIAGE REPORT ===========");
        System.out.println("Total Patients: " + patients.size());
        System.out.println("Critical Cases: " + critical);
        System.out.println("Average Risk Score: " + avgRisk);
        System.out.println("=====================================");
    }
}
