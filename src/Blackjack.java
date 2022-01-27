import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Blackjack{

	private int[] cardYou = new int[5];
	private int sumYou = 0;
	private int numYourCard = 1;  // 0 1
	
    
    private int[] cardComputer = new int[2] ;
    private int sumComputer = 0;	
    
    
    private String winner;
    
    public Blackjack(){
        //Initialize game data
        Random rand = new Random();
        
        //Player
        
        
        
        cardYou[0] = rand.nextInt(11)+1;        
        cardYou[1] = rand.nextInt(11)+1;
        //Dealer
        
        cardComputer[0] = rand.nextInt(11)+1 ;
        cardComputer[1] = rand.nextInt(11)+1 ;
        
        
        //Sum
        
        sumYou =  cardYou[0];
        sumComputer = cardComputer[0]+cardComputer[1];

        
        //Check both 11
        if(sumYou==22){
            cardYou[1] = 1;
            
            sumYou=12;

        }
        
        
        
        if(sumComputer==22){
        
            cardComputer[1] = 1;
            sumYou=12;
        }
    }    
    
    public void showYouCard(){
        System.out.print("You: ");
        for(int value:cardYou) 
        {
        	System.out.print(value+" ");
        }
        
        System.out.println();
        
    }
    
    public void showComputerCard(){
        System.out.print("Computer: ");
        for(int value:cardComputer)
        {
        	System.out.print(value+" ");
        }
        System.out.println();
        
    }
    
    public void showSumCard(){
        System.out.println("Sum of your cards = "+sumYou);
        System.out.println("Sum of computer card = "+sumComputer);

    }
    
    public void addMoreCard()
    {
    	
    	Random rand = new Random();
    	cardYou[numYourCard] = rand.nextInt(11)+1;
    	
    }
    
    public void checkWinner(){
    	
    	if(sumYou>21)
    	{
    		winner = "Computer";
    	}
    	
    	else if(sumComputer == 21)
    	{
    		winner = "Computer";
    	}
    	
    	else if(sumYou == 21)
    	{
    		winner = "You";
    	}
    	
    	else if(sumYou>sumComputer){
            winner = "You";
        }
        else {
            winner = "Computer";
        }
        
    }
    
    public boolean isEnd()
    {
    	
    	sumYou = sumYou + cardYou[numYourCard];
    	// System.out.println(sumYou); // check
    	if(sumYou > 21)
    	{
    		
    		return true;
    	}
    	
    	else if(sumYou == 21 || sumComputer == 21)
    	{
    		return true;
    	}
    	
    	if (numYourCard == 4)
    	{
    		return true;
    	}
    	
    	
    	
    	System.out.print("Want another card? (y/n)...");
    	Scanner keyboard = new Scanner(System.in);
    	char input = keyboard.next().charAt(0);
    	    	
    	if (input == 'y')
    	{
    		numYourCard++;
    		return false;
    	}
    	
    	else
    	{
    		
    		return true;    		
    	}
    	
    }

public String getWinner(){
		return winner;
        

    }

    
    public static void main(String[] args){
    	Blackjack bj = new Blackjack();                
        
    	while (true) {
    		
	        bj.showYouCard();
	        System.out.println("Computer: ? ?");
	        System.out.println();
	        
	        
	        if(bj.isEnd() == true)
	        {
	        	break; // exit the loop
	        }
	        
	        bj.addMoreCard();
	        
    	}
    	
    	bj.showYouCard();
    	bj.showComputerCard();
    	System.out.println();
        bj.showSumCard();
        bj.checkWinner();
        System.out.println("The winner is "+bj.getWinner());
    }       
}
