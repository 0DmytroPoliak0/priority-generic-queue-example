// PrintingJob class to represent a printing job
public class PrintingJob {
        //variables for our entity
        private int jobID;
        private String user;
        private int urgency;
        private int numberOfPages;

        // constructor
        public PrintingJob(int jobID, String user, int urgency, int numberOfPages){
            this.jobID = jobID;
            this.user = user;
            this.urgency = urgency;
            this.numberOfPages = numberOfPages;
        }

        // getters methods, no need in setters, since we not gonna modify our information later

        public int getJobID(){
            return jobID;
        }

        public String getUser(){
            return user;
        }

        public int getUrgency(){
            return urgency;
        }

        public int getNumberOfPages(){
            return numberOfPages;
        }


}


