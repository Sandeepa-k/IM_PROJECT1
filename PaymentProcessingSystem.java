
package javabasic;


// Class for CreditCardPayment
class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;

    
    public CreditCardPayment(String cardNumber, String cardHolderName,
            String expiryDate) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
    }
    
   // Validate credit card details
    @Override
    public boolean validatePaymentDetails() {
       
        return cardNumber != null && cardNumber.length() == 16 &&
               cardHolderName != null && !cardHolderName.isEmpty() &&
               expiryDate != null;
    }
    
    @Override
    public boolean processPayment(double amount) {
        if (validatePaymentDetails()) {
            double transactionFee = calculateTransactionFee(amount);
            double totalAmount = amount + transactionFee;
            System.out.println("Credit Card Payment of Rs " + amount +
                               " processed with a fee of Rs " + transactionFee +
                               "\nTotal: Rs " + totalAmount);
            return true;
        }
        System.out.println("Invalid Credit Card Details.");
        return false;
    }
}

// Class for PayPalPayment
class PayPalPayment implements PaymentMethod {
  private String email;
    private String password;

  
    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

  
    @Override
    public boolean validatePaymentDetails() {
        
        return email != null && email.contains("@") && password != null && 
                !password.isEmpty();
    }

  
    @Override
    public boolean processPayment(double amount) {
        if (validatePaymentDetails()) {
            double transactionFee = calculateTransactionFee(amount);
            double totalAmount = amount + transactionFee;
            System.out.println("PayPal Payment of Rs " + amount +
                               " processed with a fee of Rs " + transactionFee +
                               "\nTotal: Rs " + totalAmount);
            return true;
        }
        System.out.println("Invalid PayPal Account Details.");
        return false;
    }

}

// Class for BitcoinPayment
class BitcoinPayment implements PaymentMethod {
     private String walletAddress;

   
    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

  
    @Override
    public boolean validatePaymentDetails() {
      
        return walletAddress != null && walletAddress.length() >= 26;
    }

    

    
    @Override
    public boolean processPayment(double amount) {
        if (validatePaymentDetails()) {
            double transactionFee = calculateTransactionFee(amount);
            double totalAmount = amount + transactionFee;
            System.out.println("Bitcoin Payment of Rs " + amount +
                               " processed with a fee of Rs " + transactionFee +
                               "\nTotal: Rs " + totalAmount);
            return true;
        }
        System.out.println("Invalid Bitcoin Wallet Address.");
        return false;
    }
}

//Test class for PaymentProcessingSystem
public class PaymentProcessingSystem {
    public static void main(String[] args) {
        
        PaymentMethod creditCard = new CreditCardPayment("1234567891234567", 
                "Sandeepa", "06/25");
        System.out.println("Credit Card Payment Status: " + 
                creditCard.processPayment(1000) + "\n");
       
        PaymentMethod paypal = new PayPalPayment("sandeepa@gmail.com",
                "123");
        System.out.println("PayPal Payment Status: " + 
                paypal.processPayment(2500) + "\n");
        
       PaymentMethod bitcoin = new BitcoinPayment("11hduhagaygyg5yugyaaaivfNa");
        System.out.println("Bitcoin Payment Status: " + 
                bitcoin.processPayment(20000));
    }
}
   

