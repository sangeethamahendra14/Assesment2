package Wallet;


	public class User {
	    private double walletBalance;

	    public User(double walletBalance) {
	        this.walletBalance = walletBalance;
	    }

	    public boolean makePayment(double billAmount) {
	        if (walletBalance >= billAmount) {
	            walletBalance -= billAmount;
	            return true;
	        }
	        return false;
	    }

	    public double getWalletBalance() {
	        return walletBalance;
	    }
	}

	class KYCUser extends User {
	    private double rewardPoints;

	    public KYCUser(double walletBalance) {
	        super(walletBalance);
	    }

	    @Override
	    public boolean makePayment(double billAmount) {
	        boolean paymentSuccess = super.makePayment(billAmount);
	        if (paymentSuccess) {
	            rewardPoints += 0.1 * billAmount;
	        }
	        return paymentSuccess;
	    }

	    public double getRewardPoints() {
	        return rewardPoints;
	    }
	}

	class EPayWallet {
	    public static void processPaymentByUser(User user, double billAmount) {
	        boolean paymentSuccess = user.makePayment(billAmount);
	        if (paymentSuccess) {
	            System.out.println("Payment successful, remaining wallet balance: " + user.getWalletBalance());
	        } else {
	            System.out.println("Insufficient balance, payment failed");
	        }
	        if (user instanceof KYCUser) {
	            KYCUser kycUser = (KYCUser) user;
	            System.out.println("Reward points: " + kycUser.getRewardPoints());
	        }
	    }
	}

	 class Tester {
	    public static void main(String[] args) {
	        User user1 = new User(100);
	        EPayWallet.processPaymentByUser(user1, 50);
	        
	        KYCUser kycUser1 = new KYCUser(200);
	        EPayWallet.processPaymentByUser(kycUser1, 100);
	    }
	}

