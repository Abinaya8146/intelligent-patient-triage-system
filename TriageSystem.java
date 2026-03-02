// import java.util.PriorityQueue;

// public class TriageSystem {

//     private PriorityQueue<Patient> patientQueue;
//     private int totalPatients = 0;
//     private int criticalCount = 0;

//     public TriageSystem() {
//         patientQueue = new PriorityQueue<>();
//     }

//     public void addPatient(Patient patient) {

//         int riskScore = RiskCalculator.calculateRisk(patient);
//         String priority = RiskCalculator.determinePriority(riskScore);

//         patient.setRiskScore(riskScore);
//         patient.setPriorityLevel(priority);

//         patientQueue.add(patient);
//         totalPatients++;

//         if (priority.equals("CRITICAL"))
//             criticalCount++;

//         System.out.println("\nPatient Added Successfully!");
//         System.out.println("Risk Score: " + riskScore);
//         System.out.println("Priority Level: " + priority);
//     }

//     public void viewNextPatient() {

//         if (patientQueue.isEmpty()) {
//             System.out.println("\nNo patients in queue.");
//             return;
//         }

//         Patient next = patientQueue.peek();
//         System.out.println("\nNext Patient for Treatment:");
//         System.out.println(next);
//     }

//     public void viewAllPatients() {

//         if (patientQueue.isEmpty()) {
//             System.out.println("\nNo patients waiting.");
//             return;
//         }

//         System.out.println("\nAll Waiting Patients:");
//         for (Patient p : patientQueue) {
//             System.out.println(p);
//         }
//     }

//     public void generateReport() {

//         System.out.println("\n--- Daily Report ---");
//         System.out.println("Total Patients: " + totalPatients);
//         System.out.println("Critical Patients: " + criticalCount);
//         System.out.println("Patients Currently Waiting: " + patientQueue.size());
//     }
// }
// import java.util.PriorityQueue;
// import java.sql.Connection;
// import java.sql.PreparedStatement;

// public class TriageSystem {

//     private PriorityQueue<Patient> patientQueue;
//     private int totalPatients = 0;
//     private int criticalCount = 0;

//     public TriageSystem() {
//         patientQueue = new PriorityQueue<>();
//     }

//     public void addPatient(Patient patient) {

//         int riskScore = RiskCalculator.calculateRisk(patient);
//         String priority = RiskCalculator.determinePriority(riskScore);

//         patient.setRiskScore(riskScore);
//         patient.setPriorityLevel(priority);

//         patientQueue.add(patient);
//         totalPatients++;

//         if (priority.equals("CRITICAL"))
//             criticalCount++;

//         // 🔹 DATABASE INSERT
//         try {
//             Connection con = DBConnection.getConnection();

//             String sql = "INSERT INTO patients " +
//                 "(patient_id, name, age, oxygen_level, heart_rate, temperature, blood_pressure, risk_score, priority_level) " +
//            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

//             PreparedStatement pstmt = con.prepareStatement(sql);

//             pstmt.setInt(1, patient.getId());
//             pstmt.setString(2, patient.getName());
//             pstmt.setInt(3, patient.getAge());
//             pstmt.setDouble(4, patient.getOxygen());
//             pstmt.setInt(5, patient.getHeartRate());
//             pstmt.setDouble(6, patient.getTemperature());
//             pstmt.setInt(7, patient.getBloodPressure());
//             pstmt.setInt(8, patient.getRiskScore());
//             pstmt.setString(9, patient.getPriorityLevel());

//             int rows = pstmt.executeUpdate();
//             System.out.println("Rows inserted into DB: " + rows);

//             con.close();

//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         System.out.println("\nPatient Added Successfully!");
//         System.out.println("Risk Score: " + riskScore);
//         System.out.println("Priority Level: " + priority);
//     }

//     public void viewNextPatient() {

//         if (patientQueue.isEmpty()) {
//             System.out.println("\nNo patients in queue.");
//             return;
//         }

//         Patient next = patientQueue.peek();
//         System.out.println("\nNext Patient for Treatment:");
//         System.out.println(next);
//     }

//     public void viewAllPatients() {

//         if (patientQueue.isEmpty()) {
//             System.out.println("\nNo patients waiting.");
//             return;
//         }

//         System.out.println("\nAll Waiting Patients:");
//         for (Patient p : patientQueue) {
//             System.out.println(p);
//         }
//     }

//     public void generateReport() {

//         System.out.println("\n--- Daily Report ---");
//         System.out.println("Total Patients: " + totalPatients);
//         System.out.println("Critical Patients: " + criticalCount);
//         System.out.println("Patients Currently Waiting: " + patientQueue.size());
//     }
// }
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.PriorityQueue;
// import java.util.logging.Logger;

// public class TriageSystem {

//     private PriorityQueue<Patient> patientQueue;
//     private int totalPatients = 0;
//     private int criticalCount = 0;
//     private static final Logger logger = Logger.getLogger(TriageSystem.class.getName());

//     public TriageSystem() {
//         patientQueue = new PriorityQueue<>();
//     }

//     public void addPatient(Patient patient) {

//         // Validate vitals
//         if (!isValidPatient(patient)) {
//             System.out.println("Error: Invalid patient vitals. Patient not added.");
//             return;
//         }

//         // Calculate risk and priority
//         int riskScore = RiskCalculator.calculateRisk(patient);
//         String priority = RiskCalculator.determinePriority(riskScore);
//         patient.setRiskScore(riskScore);
//         patient.setPriorityLevel(priority);

//         // Add to in-memory queue
//         patientQueue.add(patient);
//         totalPatients++;
//         if (priority.equals("CRITICAL")) criticalCount++;

//         // Insert into DB and retrieve generated patient_id
//         try (Connection con = DBConnection.getConnection()) {

//             String sql = "INSERT INTO patients "
//                     + "(name, age, oxygen_level, heart_rate, temperature, blood_pressure, risk_score, priority_level) "
//                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

//             try (PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
//                 pstmt.setString(1, patient.getName());
//                 pstmt.setInt(2, patient.getAge());
//                 pstmt.setDouble(3, patient.getOxygenLevel());
//                 pstmt.setInt(4, patient.getHeartRate());
//                 pstmt.setDouble(5, patient.getTemperature());
//                 pstmt.setInt(6, patient.getBloodPressure());
//                 pstmt.setInt(7, patient.getRiskScore());
//                 pstmt.setString(8, patient.getPriorityLevel());

//                 int rows = pstmt.executeUpdate();
//                 if (rows > 0) {
//                     // Retrieve auto-increment ID
//                     try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
//                         if (generatedKeys.next()) {
//                             int generatedId = generatedKeys.getInt(1);
//                             patient.setPatientId(generatedId); // Sync in-memory object with DB
//                         }
//                     }
//                     System.out.println("Patient saved to DB successfully.");
//                 }
//             }

//         } catch (SQLException e) {
//             logger.severe("Database Error: " + e.getMessage());
//             System.out.println("Warning: Patient added to memory but DB insert failed.");
//         }

//         System.out.println("\nPatient Added Successfully!");
//         System.out.println("Risk Score: " + riskScore);
//         System.out.println("Priority Level: " + priority);
//     }

//     // Validate vitals
//     private boolean isValidPatient(Patient p) {
//         if (p.getAge() <= 0 || p.getAge() > 120) return false;
//         if (p.getOxygenLevel() <= 0 || p.getOxygenLevel() > 100) return false;
//         if (p.getHeartRate() <= 0 || p.getHeartRate() > 220) return false;
//         if (p.getTemperature() <= 25 || p.getTemperature() > 45) return false;
//         if (p.getBloodPressure() <= 0 || p.getBloodPressure() > 300) return false;
//         return true;
//     }

//     public void viewNextPatient() {
//         if (patientQueue.isEmpty()) {
//             System.out.println("\nNo patients in queue.");
//             return;
//         }
//         System.out.println("\nNext Patient for Treatment:");
//         System.out.println(patientQueue.peek());
//     }

//     public void viewAllPatients() {
//         if (patientQueue.isEmpty()) {
//             System.out.println("\nNo patients waiting.");
//             return;
//         }
//         System.out.println("\nAll Waiting Patients:");
//         for (Patient p : patientQueue) System.out.println(p);
//     }

//     public void generateReport() {
//         System.out.println("\n--- Daily Report ---");
//         System.out.println("Total Patients: " + totalPatients);
//         System.out.println("Critical Patients: " + criticalCount);
//         System.out.println("Patients Currently Waiting: " + patientQueue.size());
//     }
// }
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.PriorityQueue;

// public class TriageSystem {

//     private PriorityQueue<Patient> patientQueue;
//     private int totalPatients = 0;
//     private int criticalCount = 0;

//     public TriageSystem() {
//         patientQueue = new PriorityQueue<>();
//     }

//     public void addPatient(Patient patient) {

//         // Validate
//         if (!isValidPatient(patient)) {
//             System.out.println("Invalid patient data. Try again.");
//             return;
//         }

//         // Risk calculation
//         int riskScore = RiskCalculator.calculateRiskScore(patient);
//         String priority = RiskCalculator.determinePriority(riskScore);
//         patient.setRiskScore(riskScore);
//         patient.setPriorityLevel(priority);

//         // In-memory queue
//         patientQueue.add(patient);
//         totalPatients++;
//         if (priority.equals("CRITICAL")) criticalCount++;

//         // Insert into DB
//         String sql = "INSERT INTO patients "
//                 + "(name, age, oxygen_level, heart_rate, temperature, blood_pressure, risk_score, priority_level) "
//                 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

//         try (Connection con = DBConnection.getConnection();
//              PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

//             pstmt.setString(1, patient.getName());
//             pstmt.setInt(2, patient.getAge());
//             pstmt.setDouble(3, patient.getOxygenLevel());
//             pstmt.setInt(4, patient.getHeartRate());
//             pstmt.setDouble(5, patient.getTemperature());
//             pstmt.setInt(6, patient.getBloodPressure());
//             pstmt.setInt(7, patient.getRiskScore());
//             pstmt.setString(8, patient.getPriorityLevel());

//             int rows = pstmt.executeUpdate();
//             if (rows > 0) {
//                 try (ResultSet keys = pstmt.getGeneratedKeys()) {
//                     if (keys.next()) {
//                         patient.setPatientId(keys.getInt(1));
//                     }
//                 }
//                 System.out.println("Patient saved to DB successfully.");
//             }

//         } catch (SQLException e) {
//             System.out.println("DB Error: " + e.getMessage());
//         }

//         System.out.println("\nPatient Added Successfully!");
//         System.out.println("Risk Score: " + riskScore);
//         System.out.println("Priority Level: " + priority);
//     }

//     private boolean isValidPatient(Patient p) {
//         return p.getAge() > 0 && p.getOxygenLevel() > 0 && p.getHeartRate() > 0 && p.getTemperature() > 25 && p.getBloodPressure() > 0;
//     }

//     public void viewNextPatient() {
//         if (patientQueue.isEmpty()) {
//             System.out.println("No patients in queue.");
//             return;
//         }
//         System.out.println("Next Patient for Treatment:");
//         System.out.println(patientQueue.peek());
//     }

//     public void viewAllPatients() {
//         if (patientQueue.isEmpty()) {
//             System.out.println("No patients waiting.");
//             return;
//         }
//         System.out.println("All Waiting Patients:");
//         for (Patient p : patientQueue) System.out.println(p);
//     }

//     public void generateReport() {
//         System.out.println("\n--- Daily Report ---");
//         System.out.println("Total Patients: " + totalPatients);
//         System.out.println("Critical Patients: " + criticalCount);
//         System.out.println("Patients Currently Waiting: " + patientQueue.size());
//     }
// }
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.PriorityQueue;

public class TriageSystem {

    private PriorityQueue<Patient> patientQueue;
    private int totalPatients = 0;
    private int criticalCount = 0;

    public TriageSystem() {
        patientQueue = new PriorityQueue<>();
    }

    public void addPatient(Patient patient) {

        // Validate patient
        if (!isValidPatient(patient)) {
            System.out.println("Invalid patient data. Try again.");
            return;
        }

        // Calculate risk
        int riskScore = RiskCalculator.calculateRiskScore(patient);
        String priority = RiskCalculator.determinePriority(riskScore);

        patient.setRiskScore(riskScore);
        patient.setPriorityLevel(priority);

        // Add to queue
        patientQueue.add(patient);
        totalPatients++;

        if (priority.equals("CRITICAL")) {
            criticalCount++;
        }

        // Insert into Database
        String sql = "INSERT INTO patients "
                + "(name, age, oxygen_level, heart_rate, temperature, blood_pressure, risk_score, priority_level) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, patient.getName());
            pstmt.setInt(2, patient.getAge());
            pstmt.setDouble(3, patient.getOxygenLevel());
            pstmt.setInt(4, patient.getHeartRate());
            pstmt.setDouble(5, patient.getTemperature());
            pstmt.setInt(6, patient.getBloodPressure());
            pstmt.setInt(7, patient.getRiskScore());
            pstmt.setString(8, patient.getPriorityLevel());

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                try (ResultSet keys = pstmt.getGeneratedKeys()) {
                    if (keys.next()) {
                        patient.setPatientId(keys.getInt(1));
                    }
                }
                System.out.println("Patient saved to DB successfully.");
            }

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }

        // Print patient summary
        System.out.println("\nPatient Added Successfully!");
        System.out.println("Risk Score: " + riskScore);
        System.out.println("Priority Level: " + priority);

        // ================= ALERT SECTION =================
        List<String> alerts = RiskCalculator.detectAlerts(patient);

        if (!alerts.isEmpty()) {
            System.out.println("\n--- ALERTS DETECTED ---");
            for (String alert : alerts) {
                System.out.println("ALERT! " + alert);
            }
            System.out.println("------------------------");
        }
    }

    private boolean isValidPatient(Patient p) {
        return p.getAge() > 0 &&
               p.getOxygenLevel() > 0 &&
               p.getHeartRate() > 0 &&
               p.getTemperature() > 25 &&
               p.getBloodPressure() > 0;
    }

    public void viewNextPatient() {

        if (patientQueue.isEmpty()) {
            System.out.println("No patients in queue.");
            return;
        }

        System.out.println("\nNext Patient for Treatment:");
        System.out.println(patientQueue.peek());
    }

    public void viewAllPatients() {

        if (patientQueue.isEmpty()) {
            System.out.println("No patients waiting.");
            return;
        }

        System.out.println("\nAll Waiting Patients:");
        for (Patient p : patientQueue) {
            System.out.println(p);
        }
    }

    public void generateReport() {

        System.out.println("\n--- Daily Report ---");
        System.out.println("Total Patients: " + totalPatients);
        System.out.println("Critical Patients: " + criticalCount);
        System.out.println("Patients Currently Waiting: " + patientQueue.size());
    }
}