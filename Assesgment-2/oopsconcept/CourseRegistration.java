package OopsConcept;

	import java.util.Scanner;

	public class CourseRegistration {
	    int courseId;
	    int marks;
	    int courseFee;

	    public void validateMarks() {
	        if (marks < 65 || marks > 100) {
	            System.out.println("marks is less then 65.you are not eligible for admission.");
	        }
	    }

	    public void validateCourseId() {
	        if (courseId < 1001 || courseId > 1005) {
	            System.out.println("Invalid course id. Only course ids in the range of 1001 to 1005 are valid.");
	        }
	    }

	    public void calculateCourseFee() {
	        int discount = 0;
	        if (marks >= 90) {
	            discount = 15;
	        } else if (marks >= 80) {
	            discount = 10;
	        } else if (marks >= 70) {
	            discount = 5;
	        }

	        courseFee = (int) (10000 - (10000 * discount / 100));
	    }
	}

	 class Main {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter the course id: ");
	        int courseId = sc.nextInt();
	        System.out.print("Enter the marks: ");
	        int marks = sc.nextInt();

	        CourseRegistration cr = new CourseRegistration();
	        cr.courseId = courseId;
	        cr.marks = marks;

	        cr.validateMarks();
	        cr.validateCourseId();
	        cr.calculateCourseFee();

	        System.out.println("The course fee is: " + cr.courseFee);
	    }
	}


