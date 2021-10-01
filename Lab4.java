import java.util.Scanner;

public class Lab4 
{
    public static void main(String[] args) 
    {
        Scanner Sc =new Scanner(System.in);

        System.out.println(" First enter your  details we will verify soon\n \n");
        System.out.println("Name :");
        String name= Sc.next();
        System.out.println("\n");
        System.out.println("Account No :");
        long Acc_no= Sc.nextLong();
        System.out.println("\n");

        System.out.println("Phone :");
        long phone= Sc.nextLong();
        System.out.println("\n");

        System.out.println("Your address ");
        String place= Sc.next();

        System.out.println("\n");

        System.out.println("Your Occupation");
        String Occupation= Sc.next();

        System.out.println("\n");
        System.out.println("Your balance in account is ");
        double balance= Sc.nextFloat();
        System.out.println("\n");
        System.out.println("Do you have the locker system if yes type -- locker otherwise no-locker");
        String security= Sc.next();

        Bank b1 = new Bank("STATE BANK OF INDIA ", "3456GHSID");

        Customer c1 = new Customer();
        c1.Cust(Acc_no, name, place ,phone, balance, Occupation,security);

        double x = c1.Eligible();

        System.out.println( "As per your details we are happy to tell you that you have got the loan at an intrest of "+x+"%");

        Sc.close();

    }
}

class Bank 
{
    String IFSC;
   
    String Name;

    Bank(String name, String code) {
        this.Name = name;
        this.IFSC = code;
        
    }
}

class Customer
{
    String name;
    long account_number;
    String Address;
    long con_no;
    String Bank_services;
    double bal;
    String Occupation;

    public void Cust(long x, String name, String address, long count, double b, String o, String ser) {
        this.account_number = x;
        this.bal = b;
        this.Address = address;
        this.con_no = count;
        this.Occupation = o;
        this.name = name;
        this.Bank_services = ser;

    }

    public double Eligible()
    {
        if (bal >= 500000 && bal <= 1000000 && Occupation != "farmer" && Bank_services != "locker") 
        {
            return (double) 8.0;
        }

        else if (bal <= 50000 && Bank_services != "locker" && Occupation != "farmer")
        {
            return (double) 7.0;
        }
        else if (bal >= 50000 && Bank_services != "locker" && Occupation != "farmer")
        {
            return (double) 6.50;
        }

        else
        {
            return (double) 6.0;
        }
    }
}