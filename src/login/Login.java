import java.util.Scanner; //import the scanner class

public class Login 
{
    String fName;
    String lName;
    String password;
    String username;
   
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in); //create a scanner class
        
        //variable declarations
        String usernameEntered;
        String passwordEntered;
        String firstName;
        String lastName;
        
        //input and output messages
        System.out.println("Enter a username: "); 
        usernameEntered = keyboard.nextLine(); 
        
        System.out.println("Enter a password: ");
        passwordEntered = keyboard.nextLine();
        
        System.out.println("Enter your first name: ");
        firstName = keyboard.nextLine();
        
        System.out.println("Enter your last name: ");
        lastName = keyboard.nextLine();
        System.out.println();
        
        Login user1 = new Login();
        String registrationResults = user1.registerUser(usernameEntered, passwordEntered, firstName, lastName); 
        System.out.println(registrationResults); 
        String loginResults = user1.returnLoginStatus(usernameEntered, passwordEntered, firstName, lastName);
        System.out.println(loginResults);
      
    } 
    
    public static boolean checkUserName(String username)
    {
        boolean underscore;
        underscore = username.contains("_"); 
        
        if(username.length() <= 5 && underscore == true){   
            return true;
        }
        return false; 
    } 
    
    public static boolean checkPasswordComplexity(String password) 
    {
      int uppercaseCount;
      int specialCharCount;
      int digitCount;
      int lowercaseCount;
      char ch; 
      
      uppercaseCount = 0;
      specialCharCount = 0;
      digitCount = 0;
      lowercaseCount = 0;
      
      //if the password is 8 or more characters
      if(password.length()>=8)
      {
          for(int i = 0; i < password.length(); i++) 
          {
              ch = password.charAt(i);
              if (Character.isUpperCase(ch))
                  uppercaseCount++; //count increases if there is a capital letter
              else if (Character.isLowerCase(ch))
                  lowercaseCount++; //count increases if there is a lowercase letter
              else if(Character.isDigit(ch))
                  digitCount++; //count increases if there is a number
              else
                  specialCharCount++;  //count increases if there is a special character
           }
          //conditions for password to be valid
          if (uppercaseCount != 0 && lowercaseCount != 0 &&
                  digitCount != 0 && specialCharCount !=0 ) 
          {
              return true;
          }
          else 
          {
              return false;
          }
    } 
      //if the password is fewer than 8 characters
     else 
      {
          return false; 
      } 
    }
    
    public String registerUser(String username, String password, String fName, String lName)
    {
        //variable declarations
        String outputMessageUsername;
        String outputMessagePassword;
        String registrationMessage;
        String outputMessage;
        
        //variable initializations
        outputMessage = ""; 
        registrationMessage = "";
        outputMessageUsername = "";
        outputMessagePassword = "";
        
        //if username is valid
        if (checkUserName(username)) 
        {
      
            outputMessageUsername = "Username successfully captured \n";
            this.username = username;
        }
        //if username is not valid
        else 
        {
            outputMessageUsername = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length. \n"; 
        }
        
        //if password is valid
        if(checkPasswordComplexity(password))
        {
            outputMessagePassword = "Password successfully captured \n";
            this.password = password;
            
        }
        //if password is not valid
        else
        {
            outputMessagePassword = "Password is not correctly formatted, please ensure that the passoword contains atleast 8 characters, a capital letter, a number and a special character.\n";
        }
        
        //if username and password are valid
        if (checkUserName(username) && checkPasswordComplexity(password)) 
        {
            registrationMessage = "You have been successfully registered.\n";
            this.fName = fName;
            this.lName = lName;
        }
        
        outputMessage = outputMessageUsername + outputMessagePassword + registrationMessage;
        return outputMessage; 
    }
    
    
    
    public Boolean loginUser(String username, String password) 
    {
        if (username.equals(this.username) && password.equals(this.password))
        {
            return true;
        }
        else
            return false;
    }
    
    public String returnLoginStatus(String username, String password, String fName, String lName) 
    {
        String outputMessage;
        
        //if login details & registration details match
        if (loginUser(username, password))
        {
            outputMessage = "Welcome " + fName + " " + lName + " , it is great to see you again. ";
        }
        //if login details and registration details do not match
        else 
        {
            outputMessage = "Username or password incorrect, please try again";
        }
        
        return outputMessage;
    }
}
