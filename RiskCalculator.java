// public class RiskCalculator {

//     public static int calculateRisk(Patient patient) {

//         int score = 0;

//         if (patient.getOxygen() < 90)
//             score += 40;

//         if (patient.getHeartRate() > 120 || patient.getHeartRate() < 50)
//             score += 25;

//         if (patient.getTemperature() > 102)
//             score += 20;

//         if (patient.getBloodPressure() > 180)
//             score += 15;

//         if (patient.getAge() > 60)
//             score += 10;

//         return score;
//     }

//     public static String determinePriority(int score) {

//         if (score >= 70)
//             return "CRITICAL";
//         else if (score >= 40)
//             return "MODERATE";
//         else
//             return "STABLE";
//     }
// }
// import java.util.ArrayList;
// import java.util.List;

// public class RiskCalculator {

//     public static int calculateRiskScore(Patient p) {
//         int score = 0;

//         // Oxygen levels
//         if (p.getOxygenLevel() < 85) score += 40;
//         else if (p.getOxygenLevel() < 90) score += 25;
//         else if (p.getOxygenLevel() < 95) score += 10;

//         // Heart rate
//         if (p.getHeartRate() > 150 || p.getHeartRate() < 50) score += 40;
//         else if (p.getHeartRate() > 120) score += 25;
//         else if (p.getHeartRate() > 100) score += 10;

//         // Temperature
//         if (p.getTemperature() > 40) score += 30;
//         else if (p.getTemperature() > 39) score += 20;
//         else if (p.getTemperature() > 38) score += 10;

//         // Blood pressure
//         if (p.getBloodPressure() > 180) score += 30;
//         else if (p.getBloodPressure() > 150) score += 20;
//         else if (p.getBloodPressure() > 140) score += 10;

//         // Age factor
//         if (p.getAge() > 65) score += 15;

//         return score;
//     }

//     public static String getPriorityLevel(int score) {
//         if (score >= 80) return "CRITICAL";
//         if (score >= 50) return "URGENT";
//         if (score >= 25) return "OBSERVATION";
//         return "STABLE";
//     }

//     public static List<String> detectAlerts(Patient p) {
//         List<String> alerts = new ArrayList<>();

//         if (p.getOxygenLevel() < 90 && p.getHeartRate() > 120)
//             alerts.add("⚠ Possible Respiratory Distress");

//         if (p.getBloodPressure() > 160 && p.getAge() > 60)
//             alerts.add("⚠ High Cardiac Risk");

//         if (p.getTemperature() > 39 && p.getHeartRate() > 120)
//             alerts.add("⚠ Possible Severe Infection");

//         return alerts;
//     }
// }

import java.util.ArrayList;
import java.util.List;

public class RiskCalculator {

    public static int calculateRiskScore(Patient p) {
        int score = 0;

        if (p.getOxygenLevel() < 85) score += 40;
        else if (p.getOxygenLevel() < 90) score += 25;
        else if (p.getOxygenLevel() < 95) score += 10;

        if (p.getHeartRate() > 150 || p.getHeartRate() < 50) score += 40;
        else if (p.getHeartRate() > 120) score += 25;
        else if (p.getHeartRate() > 100) score += 10;

        if (p.getTemperature() > 40) score += 30;
        else if (p.getTemperature() > 39) score += 20;
        else if (p.getTemperature() > 38) score += 10;

        if (p.getBloodPressure() > 180) score += 30;
        else if (p.getBloodPressure() > 150) score += 20;
        else if (p.getBloodPressure() > 140) score += 10;

        if (p.getAge() > 65) score += 15;

        return score;
    }

   public static String determinePriority(int score) {
    if (score >= 90) return "CRITICAL";
    if (score >= 70) return "HIGH_RISK";
    if (score >= 50) return "URGENT";
    if (score >= 25) return "OBSERVATION";
    return "STABLE";
}

   public static List<String> detectAlerts(Patient p) {

    List<String> alerts = new ArrayList<>();

    if (p.getRiskScore() >= 90) {
        alerts.add("Immediate ICU Attention Required");
    }

    if (p.getOxygenLevel() < 90 && p.getHeartRate() > 120) {
        alerts.add("Respiratory Distress Detected");
    }

    if (p.getBloodPressure() > 160 && p.getAge() > 60) {
        alerts.add("High Cardiac Risk");
    }

    if (p.getTemperature() > 39 && p.getHeartRate() > 120) {
        alerts.add("Possible Severe Infection");
    }

    return alerts;
}
}
