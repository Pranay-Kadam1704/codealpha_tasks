import java.util.Scanner;
public class BankAccount {
  String name;
  String acc_no;
  String type;
  int balance;
  Scanner sc = new Scanner(System.in);
  BankAccount(){
    System.out.print("Enter Customer Name :");
    name = sc.nextLine();
    System.out.print("Enter account number :");
    acc_no = sc.nextLine();
    System.out.print("Enter type of account :");
    type=sc.nextLine();
    System.out.print("Enter initial Balance :");
    balance = sc.nextInt();
    System.out.println();

  } 
  void Deposite(){
    System.out.println("Enter amount to be deposite :");
    int dep=sc.nextInt();
    balance=balance+dep;
    checkBalance();
  } 

  void withdraw(){
    System.out.println("Enter Amount to Withdrw :");
    int wid= sc.nextInt();
    if(wid<balance){
    balance = balance-wid;
    checkBalance();
  }
  else{
    System.out.println("Insufficient Balance");
    checkBalance();
  }
  }
  void checkBalance(){
    System.out.println("Available balance is :"+balance);
  }
  public static void main(String[] args) {
    int ch;
        try (Scanner cs = new Scanner(System.in)) {
            BankAccount b = new BankAccount();
            System.out.println("Select choice as per your requirement :-");
            System.out.println("1.deposite"+"\n"+"2.withdraw"+"\n"+"3.checkbalance"+"\n"+"4.Exit\n");
            do{
                System.out.println("Enter choice :");
                ch = cs.nextInt();
                switch (ch) {
                    case 1:b.Deposite();
                           break;
                    case 2:b.withdraw();
                           break;
                    case 3:b.checkBalance();
                           break;
                    case 4:System.out.println("Exit");
                     
                }
            }while(ch!=4);
        }
    }
    
  
}
