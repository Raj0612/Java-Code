package DesignPatterns.Structural.Bridge.covidvaccine;

public class AdminUser extends User{
    public Center getVaccineCenter() {
        return vaccineCenter;
    }

    public Center vaccineCenter;

    public AdminUser(String userId, String userName, int age, String gender, IdType idType, String idNumber, Center center) {
        super(userId, userName, age, gender, idType, idNumber);
        vaccineCenter = center;
    }

    public static class Center{
        private String centerId;
        private String address;
        private int noOfVaccines;
        public void setNoOfVaccines(int noOfVaccines) {
            this.noOfVaccines = noOfVaccines;
        }
        private int noOfDozesGiven;
        public String getCenterId() {
            return centerId;
        }
        public String getAddress() {
            return address;
        }
        public int getNoOfVaccines() {
            return noOfVaccines;
        }
        public int getNoOfDozesGiven() {
            return noOfDozesGiven;
        }
        public Center(String centerId, String address, int noOfVaccines, int noOfDozesGiven) {
            this.centerId = centerId;
            this.address = address;
            this.noOfVaccines = noOfVaccines;
            this.noOfDozesGiven = noOfDozesGiven;
        }

        @Override
        public String toString() {
            return "Center{" +
                    "centerId='" + centerId + '\'' +
                    ", address='" + address + '\'' +
                    ", noOfVaccines=" + noOfVaccines +
                    ", noOfDozesGiven=" + noOfDozesGiven +
                    '}';
        }
    }
}
