package Interface;

	import java.util.Random;

public class CourseCertification {
	interface Certification {
	  int feeForRegularCourse = 2000;
	  int feeForCrashCourse = 5000;
	  int serviceTaxPercentage = 1236;
	  int minimumDiscountPercentage = 10;

	  int calculateFee(int marks, boolean isCrashCourse);
	}

	class RRTechnicalCertification implements Certification {
	  private int registrationId;

	  public int generateRegistrationId(boolean isCrashCourse) {
	    Random random = new Random();
	    int id = random.nextInt(8999) + 1000;
	    if (isCrashCourse && id % 2 == 0) {
	      this.registrationId = id;
	    } else if (!isCrashCourse && id % 2 != 0) {
	      this.registrationId = id + 1001;
	    } else {
	      this.generateRegistrationId(isCrashCourse);
	    }
	    return this.registrationId;
	  }

	  public int calculateFee(int marks, boolean isCrashCourse) {
	    int discountPercentage = minimumDiscountPercentage;
	    if (marks >= 80) {
	      discountPercentage = 30;
	    } else if (marks >= 60) {
	      discountPercentage = 20;
	    } else if (marks >= 40) {
	      discountPercentage = 10;
	    }
	    int fee;
	    if (isCrashCourse) {
	      fee = feeForCrashCourse - (feeForCrashCourse * discountPercentage / 100);
	      fee += (fee * serviceTaxPercentage / 100);
	    } else {
	      fee = feeForRegularCourse * 6 - (feeForRegularCourse * 6 * discountPercentage / 100);
	    }
	    return fee;
	  }
	}

	class Main {
	  public static void main(String[] args) {
	    RRTechnicalCertification student = new RRTechnicalCertification();
	    int marks = 65;
	    int registrationId = student.generateRegistrationId(false);
	    int fee = student.calculateFee(marks, false);
	    System.out.println("Registration ID: " + registrationId);
	    System.out.println("Total Fee: " + fee);
	  }
	}


}
