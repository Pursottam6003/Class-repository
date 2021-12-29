/**
* <h1>Bank loan Enquiry!</h1>
*
* @author  Pursottam Sah
* @version 2.0
* @since   2021 -12-28
*/

import java.util.Scanner;
public class Bank_loan
{   
    public static void main(String args[])
    {   
        System.out.println(" <<<<<<<<<<<<<<<<<  Welcome to Loan Enquiry System >>>>>>>>>>>>>>>");
        System.out.println("Hello User are you a defaulter  Y/N ");
        Scanner Sc = new Scanner(System.in);
        String input;
        /**
         * Data type String helps in getting input 
         * 
         */
        input= Sc.next();

        boolean defaulter;

        if(input.equals("Y ") || input.equals("y"))
        {   
            /**
             * checking the condition wheather it is defaulter or not 
             */
            defaulter=true;
        }
        else 
        {
            defaulter = false;
        }

        System.out.println("Your Occupation");
        System.out.println("1 for 'Govt. Employee'\n2 for 'Farmer'\n3 for 'Others'\n: ");
        /**
         * Trying to get the correct occupation according to the question 
         * 1. for govt enmployee 2. for farmer adn 3. for others
         */
        input = Sc.next();
        String Occupation;
        if (input.equals("1")) {
            Occupation= "Govt Employee";
        } else if (input.equals("2")) {
            Occupation= "farmer";
        } else {
            Occupation= "Others";
        }
        /**
         * Trying to check wheather it is highly educated or not 
         */
        System.out.println("Are you highly educated write Y/N");
        input = Sc.next();
        boolean HighlyEducated;
        if(input.equals("Y ") || input.equals("y"))
        {
            HighlyEducated=true;
        }
        else 
        {
            HighlyEducated = false;
        }
        /**
         * Income of the user in rupees
         */
        System.out.println("Please enter your income in rupees");
        int income = Sc.nextInt();

        /**
         * Minimum account balace in the bank 
         */
        System.out.println("What is your minimum account balance");
        int bal = Sc.nextInt();

        /**
         * Having fixed deposite or not if yes how much 
         */
        System.out.println("Enter your fixed deposite if you have otherwise write 0");
        int fd= Sc.nextInt();
        
        Sc.close();
        /**
         * Created an object of class User and passed the parameters of constructor 
         * @param  parameters used defaulter, Occupation, HighlyEducated, income, bal, fd
         */
        User Pursottam = new User(defaulter, Occupation, HighlyEducated, income, bal, fd);
        
        /**
         * Created an object of LoanEnquiry as enquiry and passing the parameters of nomral intest and exrta intrest
         * @param 9.50f, 2.0f
         */
        LoanEnquiry enquiry = new LoanEnquiry(9.50f, 2.0f);

        /**
         * Passing the object of class user into the method 
         * @param pursottam -as object 
         */
        float result=enquiry.Eligible(Pursottam);
        if(result !=-1)
        {
            System.out.println(" Based on your responeses ");
            System.out.println(" Congratulations ! you are eliblie to avial the loan at intrest " +result);
        }
        else 
        {
            System.out.println("Sorry !  you are not eligible");
        }
    }
}

class User
{
    boolean defaulter;
    String Occupation;
    boolean HighlyEdulcated;
    int income;
    int fixed_deposite;
    int balance;
    
    /**
     * 
     * @param defaulter
     * @param Occupation
     * @param HighlyEducated
     * @param income
     * @param balance
     * @param fixed_deposite
     */
    User(Boolean defaulter, String Occupation, boolean HighlyEducated,int income,int balance, int fixed_deposite)
    {
        this.defaulter=defaulter;
        this.Occupation=Occupation;
        this.income=income;
        this.fixed_deposite=fixed_deposite;
        this.HighlyEdulcated=HighlyEducated;
        this.balance=balance;
    }
}

class LoanEnquiry
{   
    float normal_intrest;
    float extra_int=0;
    /**
     * Constructor for intialisitng the normal intrest and  extra inrest 
     * @param normal_intrest
     * @param extra_int
     */
    LoanEnquiry (float normal_intrest,float extra_int)
    {
        this.normal_intrest=normal_intrest;
        this.extra_int=extra_int;
    }
    /**
     * Checking the parameters with the help of  nested if -else cases and returns the output as float data type  
     * @param   parameters 1:Occupation, 2: income 3: fixed deposite 4: Eduacation 5:Min _account balance 
     * @return  the rate of intrest as float data type  
     */
    float Eligible(User u)
    {   
        float Rateofintrest=normal_intrest;
        if(u.defaulter)
        {    
            if(u.Occupation.equals("Govt Employee"))
            {
                return -1;
            }
    
            else if(u.Occupation.equals("farmer"))
            {
                if(u.income <=100000)
                {
                 
                    Rateofintrest =6.0f;
                }
            }
            if(u.HighlyEdulcated)
            {
                if(u.income >1000000)
                {
                    Rateofintrest =10.50f;
                }

            }
            Rateofintrest+=2.0f;

        }


        else
        {
            if(u.Occupation.equals("farmer"))
            {
                if(u.income <100000)
                {
                    Rateofintrest= 6.0f;
                }

            }
            
            if(u.HighlyEdulcated)
            {
                if(u.income >1000000)
                {
                    Rateofintrest= 10.50f;
                }

                else
                {
                    Rateofintrest= normal_intrest;
                }
            }
            else
            {
                Rateofintrest= normal_intrest;
            } 
            
        }
        if(u.fixed_deposite >=5000000 && u.balance>=1000000)
        {   
            Rateofintrest =Rateofintrest-1.0f;
          
        }

        return Rateofintrest;

    }
}