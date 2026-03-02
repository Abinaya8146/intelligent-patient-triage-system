// import java.sql.Connection;
// import java.sql.PreparedStatement;

// public class PatientDAO {

//     public static void savePatient(Patient patient) {

//         String query = "INSERT INTO patients VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";

//         try (Connection conn = DBConnection.getConnection();
//              PreparedStatement stmt = conn.prepareStatement(query)) {

//             stmt.setInt(1, patient.getId());
//             stmt.setString(2, patient.getName());
//             stmt.setInt(3, patient.getAge());
//             stmt.setDouble(4, patient.getOxygenLevel;());
//             stmt.setInt(5, patient.getHeartRate());
//             stmt.setDouble(6, patient.getTemperature());
//             stmt.setInt(7, patient.getBloodPressure());
//             stmt.setInt(8, patient.getriskScore());
//             stmt.setString(9, patient.getPriorityLevel());

//             stmt.executeUpdate();
//             System.out.println("Patient saved to database successfully!");

//         } catch (Exception e) {
//             System.out.println("Database Error: " + e.getMessage());
//         }
//     }
// }
// import java.sql.*;

// public class PatientDAO {

//     public static void savePatient(Patient patient) {

//         String sql = "INSERT INTO patients " +
//                 "(name, age, oxygen_level, heart_rate, temperature, blood_pressure, risk_score, priority_level) " +
//                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

//         try (Connection con = DBConnection.getConnection();
//              PreparedStatement pstmt = con.prepareStatement(sql)) {

//             pstmt.setString(1, patient.getName());
//             pstmt.setInt(2, patient.getAge());
//             pstmt.setDouble(3, patient.getOxygenLevel());
//             pstmt.setInt(4, patient.getHeartRate());
//             pstmt.setDouble(5, patient.getTemperature());
//             pstmt.setInt(6, patient.getBloodPressure());
//             pstmt.setInt(7, patient.getriskScore());
//             pstmt.setString(8, patient.getPriorityLevel());

//             pstmt.executeUpdate();
//             System.out.println("Saved to database successfully!");

//         } catch (Exception e) {
//             System.out.println("Database Error: " + e.getMessage());
//         }
//     }
// }
// import java.sql.*;

// public class PatientDAO {

//     private static final String URL =
//         "jdbc:mysql://localhost:3306/triage_db";
//     private static final String USER = "root";
//     private static final String PASS = "your_password";

//     public void insertPatient(Patient p) throws Exception {

//         Connection con = DriverManager.getConnection(URL, USER, PASS);

//         String sql = "INSERT INTO patients(name, age, gender, symptoms, heart_rate, temperature, blood_pressure, risk_score, priority_level) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

//         PreparedStatement ps = con.prepareStatement(sql);
//         ps.setString(1, p.getName());
//         ps.setInt(2, p.getAge());
//         ps.setString(3, p.getGender());
//         ps.setString(4, p.getSymptoms());
//         ps.setInt(5, p.getHeartRate());
//         ps.setDouble(6, p.getTemperature());
//         ps.setString(7, p.getBloodPressure());
//         ps.setDouble(8, p.getRiskScore());
//         ps.setString(9, p.getPriority());

//         ps.executeUpdate();
//         con.close();
//     }
// }
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    // Save a patient and return the DB-generated ID
    public static int savePatient(Patient patient) {
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
                        int generatedId = keys.getInt(1);
                        patient.setPatientId(generatedId); // Sync in-memory object with DB
                        return generatedId;
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("DB Error in savePatient: " + e.getMessage());
        }

        return -1; // if failed
    }

    // Retrieve all patients from DB
    public static List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients ORDER BY risk_score DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Patient p = new Patient(
                    rs.getInt("patient_id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getDouble("oxygen_level"),
                    rs.getInt("heart_rate"),
                    rs.getDouble("temperature"),
                    rs.getInt("blood_pressure")
                );
                p.setRiskScore(rs.getInt("risk_score"));
                p.setPriorityLevel(rs.getString("priority_level"));
                patients.add(p);
            }

        } catch (SQLException e) {
            System.out.println("DB Error in getAllPatients: " + e.getMessage());
        }

        return patients;
    }

    // Optional: Retrieve patient by ID
    public static Patient getPatientById(int id) {
        String sql = "SELECT * FROM patients WHERE patient_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Patient p = new Patient(
                        rs.getInt("patient_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getDouble("oxygen_level"),
                        rs.getInt("heart_rate"),
                        rs.getDouble("temperature"),
                        rs.getInt("blood_pressure")
                    );
                    p.setRiskScore(rs.getInt("risk_score"));
                    p.setPriorityLevel(rs.getString("priority_level"));
                    return p;
                }
            }

        } catch (SQLException e) {
            System.out.println("DB Error in getPatientById: " + e.getMessage());
        }
        return null;
    }
}
