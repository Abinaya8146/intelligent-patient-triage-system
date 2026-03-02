//  public class Patient implements Comparable<Patient> {

//     private int patientId;
//     private String name;
//     private int age;
//     private double oxygenLevel;
//     private int heartRate;
//     private double temperature;
//     private int bloodPressure;
//     private int riskScore;
//     private String priorityLevel;

//     public Patient(int patientId, String name, int age,
//                    double oxygenLevel, int heartRate,
//                    double temperature, int bloodPressure) {

//         this.patientId = patientId;
//         this.name = name;
//         this.age = age;
//         this.oxygenLevel = oxygenLevel;
//         this.heartRate = heartRate;
//         this.temperature = temperature;
//         this.bloodPressure = bloodPressure;
//     }

//     // Getters
//     public int getPatientId() { return patientId; }
//     public String getName() { return name; }
//     public int getAge() { return age; }
//     public double getOxygenLevel() { return oxygenLevel; }
//     public int getHeartRate() { return heartRate; }
//     public double getTemperature() { return temperature; }
//     public int getBloodPressure() { return bloodPressure; }
//     public int getRiskScore() { return riskScore; }
//     public String getPriorityLevel() { return priorityLevel; }

//     // Setters for risk and priority
//     public void setRiskScore(int riskScore) {
//         this.riskScore = riskScore;
//     }

//     public void setPriorityLevel(String priorityLevel) {
//         this.priorityLevel = priorityLevel;
//     }

//     // PriorityQueue sorting (Higher risk first)
//     @Override
//     public int compareTo(Patient other) {
//         return Integer.compare(other.riskScore, this.riskScore);
//     }

//     @Override
//     public String toString() {
//         return "ID: " + patientId +
//                 " | Name: " + name +
//                 " | Age: " + age +
//                 " | Risk Score: " + riskScore +
//                 " | Priority: " + priorityLevel;
//     }
// }
// public class Patient implements Comparable<Patient> {

//     private int patientId; // will match DB auto-increment ID
//     private String name;
//     private int age;
//     private double oxygenLevel;
//     private int heartRate;
//     private double temperature;
//     private int bloodPressure;
//     private int riskScore;
//     private String priorityLevel;

//     // Constructor (in-memory ID optional; DB will override after insert)
//     public Patient(int patientId, String name, int age, double oxygen,
//                    int heartRate, double temperature, int bloodPressure) {
//         this.patientId = patientId;
//         this.name = name;
//         this.age = age;
//         this.oxygenLevel = oxygen;
//         this.heartRate = heartRate;
//         this.temperature = temperature;
//         this.bloodPressure = bloodPressure;
//     }

//     // ===== GETTERS =====
//     public int getId() { return patientId; }
//     public String getName() { return name; }
//     public int getAge() { return age; }
//     public double getOxygen() { return oxygenLevel; }
//     public int getHeartRate() { return heartRate; }
//     public double getTemperature() { return temperature; }
//     public int getBloodPressure() { return bloodPressure; }
//     public int getRiskScore() { return riskScore; }
//     public String getPriorityLevel() { return priorityLevel; }

//     // ===== SETTERS =====
//     public void setPatientId(int id) { this.patientId = id; } // Important for DB auto-increment
//     public void setRiskScore(int riskScore) { this.riskScore = riskScore; }
//     public void setPriorityLevel(String priorityLevel) { this.priorityLevel = priorityLevel; }

//     // PriorityQueue: higher risk first
//     @Override
//     public int compareTo(Patient other) {
//         return Integer.compare(other.riskScore, this.riskScore);
//     }

//     @Override
//     public String toString() {
//         return "ID: " + patientId +
//                 ", Name: " + name +
//                 ", Age: " + age +
//                 ", Oxygen: " + oxygenLevel +
//                 ", HR: " + heartRate +
//                 ", Temp: " + temperature +
//                 ", BP: " + bloodPressure +
//                 ", Risk: " + riskScore +
//                 ", Priority: " + priorityLevel;
//     }
// }
// public class Patient {
//     private int id;
//     private String name;
//     private int age;
//     private int oxygenLevel;
//     private int heartRate;
//     private int temperature;
//     private int bloodPressure;
//     private int riskScore;
//     private String priorityLevel;

//     // Constructor for new patient (without id)
//     public Patient(String name, int age, int oxygenLevel, int heartRate, int temperature, int bloodPressure) {
//         this.name = name;
//         this.age = age;
//         this.oxygenLevel = oxygenLevel;
//         this.heartRate = heartRate;
//         this.temperature = temperature;
//         this.bloodPressure = bloodPressure;
//     }

//     // Constructor with all fields (for reading from DB)
//     public Patient(int id, String name, int age, int oxygenLevel, int heartRate, int temperature, int bloodPressure, int riskScore, String priorityLevel) {
//         this.id = id;
//         this.name = name;
//         this.age = age;
//         this.oxygenLevel = oxygenLevel;
//         this.heartRate = heartRate;
//         this.temperature = temperature;
//         this.bloodPressure = bloodPressure;
//         this.riskScore = riskScore;
//         this.priorityLevel = priorityLevel;
//     }

//     // Getters
//     public String getName() { return name; }
//     public int getAge() { return age; }
//     public int getOxygenLevel() { return oxygenLevel; }
//     public int getHeartRate() { return heartRate; }
//     public int getTemperature() { return temperature; }
//     public int getBloodPressure() { return bloodPressure; }
// }
public class Patient implements Comparable<Patient> {

    private int patientId; // DB auto-increment
    private String name;
    private int age;
    private double oxygenLevel;
    private int heartRate;
    private double temperature;
    private int bloodPressure;
    private int riskScore;
    private String priorityLevel;

    public Patient(int patientId, String name, int age, double oxygen,
                   int heartRate, double temperature, int bloodPressure) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.oxygenLevel = oxygen;
        this.heartRate = heartRate;
        this.temperature = temperature;
        this.bloodPressure = bloodPressure;
    }

    // ===== GETTERS =====
    public int getId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getOxygenLevel() { return oxygenLevel; }
    public int getHeartRate() { return heartRate; }
    public double getTemperature() { return temperature; }
    public int getBloodPressure() { return bloodPressure; }
    public int getRiskScore() { return riskScore; }
    public String getPriorityLevel() { return priorityLevel; }

    // ===== SETTERS =====
    public void setPatientId(int id) { this.patientId = id; }
    public void setRiskScore(int riskScore) { this.riskScore = riskScore; }
    public void setPriorityLevel(String priorityLevel) { this.priorityLevel = priorityLevel; }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.riskScore, this.riskScore); // Higher risk first
    }

    @Override
    public String toString() {
        return "ID: " + patientId +
                ", Name: " + name +
                ", Age: " + age +
                ", Oxygen: " + oxygenLevel +
                ", HR: " + heartRate +
                ", Temp: " + temperature +
                ", BP: " + bloodPressure +
                ", Risk: " + riskScore +
                ", Priority: " + priorityLevel;
    }
}