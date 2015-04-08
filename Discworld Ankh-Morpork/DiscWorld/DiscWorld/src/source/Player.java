package source;
import java.awt.CardLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import PersonalityCards.PersonalityCardParent;
import PlayerCards.PlayerCardActions;

/**
 * 
 * <p>
 * <b>Player Class</b> 
 * <p>It contains details of players, like their resources like player name, color, personalityCard, minion, building, their turn
 * It also implements the Serializable class which is use to save the state of the game.
 * </p> 
 * @param cardName -7 Personality card name  
 * @param winningConditions - winning Condition given on card of personalities
 * @param playermoney1 - 1$ coins used by players 
 * @param playermoney5 - 5$ coins used by players
 * @param minions -Number of minions used
 * @param buildings -Number of buildings build
 * @param color -Color given to players and theirs minions, buildings
 * @param turn - Player turn to play card and game
 *</p>
 */
public class Player implements Serializable{
	
	
	
	
	public ArrayList<PlayerCardActions> playerCards;
	public PersonalityCardParent personalityCard;
	private int playermoney,loan;
	//public HashMap<Integer, Integer> minions;	//key=city area number && value=total no of minions in that area
	private int totalminions,totalbuildings;
	private String color;
	private boolean turn;
	private ArrayList<CityArea> cityAreasConquered;
	public ArrayList<PlayerCardActions> interruptCollection;
	
	public Player(MapBoard board,String c){
		
		color=c;
		
		Random random=new Random();
		// set the personality card name 
		//int value=random.nextInt(Helper.personalitySet.size());
		int value=1;
		personalityCard=null;
		//Helper.personalitySet.remove(Helper.personalitySet.get(value));
		
		
		/* initialize pieces and money */
		totalminions=12;
		totalbuildings=6;
		playermoney=10;
		Helper.setBankmoney(Helper.getBankmoney()-10);
		turn=false;
		cityAreasConquered=new ArrayList<CityArea>();
		loan=0;
		
		
		
		playerCards=new ArrayList<PlayerCardActions>();
		interruptCollection=new ArrayList<PlayerCardActions>();
		/*initiate 5 player cards randomly from the deck of cards*/
		/*for (int i = 0; i < 5; i++) {
			PlayerCardActions temp=Helper.getRandomPlayerCard();
			temp.p=this; 
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
		}*/
	}
	
	
	public Player(MapBoard board) {
		
		/* set the color */
		color=Helper.colortemp.get(0);
		Helper.colortemp.remove(0);
		
		//temp load
		/*if (color.equals("red")) {
			for (int i = 0; i < Helper.personalitySet.size(); i++) {
				if (Helper.personalitySet.get(i).cardName.equals("Lord Vetinari")) {
					personalityCard=Helper.personalitySet.get(i);
					Helper.personalitySet.remove(Helper.personalitySet.get(i));
					break;
				}
			}
		}else if (color.equals("yellow")) {
			for (int i = 0; i < Helper.personalitySet.size(); i++) {
				if (Helper.personalitySet.get(i).cardName.equals("Chrysoprase")) {
					personalityCard=Helper.personalitySet.get(i);
					Helper.personalitySet.remove(Helper.personalitySet.get(i));
					break;
				}
			}
		}else if (color.equals("green")) {
			for (int i = 0; i < Helper.personalitySet.size(); i++) {
				if (Helper.personalitySet.get(i).cardName.equals("Dragon King of Arms")) {
					personalityCard=Helper.personalitySet.get(i);
					Helper.personalitySet.remove(Helper.personalitySet.get(i));
					break;
				}
			}
		}else if (color.equals("blue")) {
			for (int i = 0; i < Helper.personalitySet.size(); i++) {
				if (Helper.personalitySet.get(i).cardName.equals("Lord de Worde")) {
					personalityCard=Helper.personalitySet.get(i);
					Helper.personalitySet.remove(Helper.personalitySet.get(i));
					break;
				}
			}
		}*/
		
		Random random=new Random();
		// set the personality card name 
		int value=random.nextInt(Helper.personalitySet.size());
		personalityCard=Helper.personalitySet.get(value);
		Helper.personalitySet.remove(Helper.personalitySet.get(value));
		
		
		/* initialize pieces and money */
		totalminions=12;
		totalbuildings=6;
		playermoney=10;
		Helper.setBankmoney(Helper.getBankmoney()-10);
		turn=false;
		cityAreasConquered=new ArrayList<CityArea>();
		loan=0;
		
		
		
		playerCards=new ArrayList<PlayerCardActions>();
		interruptCollection=new ArrayList<PlayerCardActions>();
		/*initiate 5 player cards randomly from the deck of cards*/
		for (int i = 0; i < 5; i++) {
			PlayerCardActions temp=Helper.getRandomPlayerCard();
			temp.p=this; 
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
		}
		
		//tempload
		/*if (color.equals("red")) {
			PlayerCardActions temp=Helper.getTempGreenCard("Captain Carrot");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("FreshStartClub");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("Mr Pin & Mr Tulip");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("Shonky Shop");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("The Peeled Nuts");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("The Thieves' Guild");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			
			
		}else if (color.equals("yellow")) {
			
			PlayerCardActions temp=Helper.getTempGreenCard("Inigo Skimmer");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("Modo");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("Queen Molly");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("The Duckman");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("The Dysk");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			
			
			
		}else if (color.equals("green")) {
			
			PlayerCardActions temp=Helper.getTempGreenCard("Dr Cruces");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("Foul Ole Ron");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("Mr Boggis");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("Mrs Cake");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("Sergeant Angua");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			
			
			
			
			
			
		}else if (color.equals("blue")) {
			
			PlayerCardActions temp=Helper.getTempGreenCard("Gaspode");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("Mr Gryle");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("Rincewind");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("Sacharissa Cripslock");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("The Opera House");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			temp=Helper.getTempGreenCard("Zorgo the Retro-phernologist");
			temp.p=this;
			temp.board=board;
			playerCards.add(temp);
			if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
				interruptCollection.add(temp);
			}
			Helper.playerCardSet.remove(temp);
			
			
		}*/
	}
	
	/**
	 * <p> Gets the Object of personality card's parent.</p>
	 * 
	 * @return PersonalityCardParent Object
	 * 
	 * @see PersonalityCardParent
	 */
	
	public PersonalityCardParent getPersonalityCard() {
		return personalityCard;
	}

	/**
	 * <p> sets the personality card object</p>
	 * @param PersonalityCardParent object
	 */
	
	public void setPersonalityCard(PersonalityCardParent personalityCard) {
		this.personalityCard = personalityCard;
	}
	
	/**
	 * <p> Gets the list of city areas.</p>
	 * @return ArrayList<CityArea>
	 */
	public ArrayList<CityArea> getCityAreasConquered() {
		return cityAreasConquered;
	}

	/**
	 * <p> sets the list as city area list</p>
	 * @param ArrayList<CityArea> object
	 */
	
	public void setCityAreasConquered(ArrayList<CityArea> cityAreasConquered) {
		this.cityAreasConquered = cityAreasConquered;
	}
	
	/**
	 * <p> Gets the loan amount. It has integer type.</p>
	 * @return intvariable
	 */
	
	public int getLoan() {
		return loan;
	}
	
	/**
	 * <p> sets the loan amount in loan variable. It has integer type.</p>
	 * @param loan variable
	 */
	
	public void setLoan(int loan) {
		this.loan = loan;
	}
	
	
	/**
	 * <p> Gets the $1 from player. It has integer type.</p>
	 * @return the playermoney1 variable
	 */
	public int getPlayermoney() {
		return playermoney;
	}
	/**
	 * <p> sets the $1 as player money. It has integer type.</p>
	 * @param playermoney variable
	 */
	public void setPlayermoney(int playermoney) {
		this.playermoney = playermoney;
	}
	
	/**
	 *  <p> Total number of minions</p>
	 * @return The value of total minions
	 */
	public int getTotalminions() {
		return totalminions;
	}
	/**
	 * <p> Sets value of the minions, total number of minion.</p>
	 * @param totalminions 
	 */
	public void setTotalminions(int totalminions) {
		this.totalminions = totalminions;
	}
	/**
	 * <p> Gets the total number of building</p>
	 * @return totalbuildings
	 */
	public int getTotalbuildings() {
		return totalbuildings;
	}
	/**
	 * <p>Sets the value of the building, total number of building.</p>
	 * @param totalbuildings
	 */
	public void setTotalbuildings(int totalbuildings) {
		this.totalbuildings = totalbuildings;
	}
	/**
	 * <p>Gets the color for player, minion, building.</p>
	 * @return color - string name of color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * <p>sets the color of the player,minion,building.</p>
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * <p>checks whose turn it is.</p>
	 * @return true 
	 */
	public boolean isTurn() {
		return turn;
	}
	/**
	 * <p>sets the turn of player.</p>
	 * @param turn
	 */
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	/**
	 * <b>public void showPlayer()</b>
	 * <p>Prints all details of player.
	 * Details like Personality card name, color, 1$/5$ coin, number of minions and buildings, player turn.
	 *  </p>
	 */
	public boolean showPlayer(){
		
		System.out.println("\t"+color+"\t   "+playermoney+"\t      \t"+totalminions+"  \t"+totalbuildings+"   \t\t"+personalityCard.cardName);
		return true;
	}
	
	/**
	 * <p>Displays all unused cards</p> 
	 */
	public void displayUnusedCards(MapBoard board){
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\t\tSelect card to play                                  |");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("\n");
		int local=0;
		Scanner input=new Scanner(System.in);
		ArrayList<Integer> temp=new ArrayList<>();
		for (int i = 0; i < playerCards.size(); i++) {
			if (!(playerCards.get(i).used)) {
				System.out.println("\tPress \""+(i)+"\"");
				playerCards.get(i).showPlayerCardDetails();
				System.out.println();
				local++;
				temp.add(i);
			}
		}
		
		do{
			int j=input.nextInt();
			
			if(!(temp.contains(j))){
				System.out.println("<<<<<---Wrong choice--->>>>>\n");
				continue;
			}
			
			//perform action specific to player card
			playerCards.get(j).used=true;
			playerCards.get(j).startPlayerCardActions();
			break;
		}while(true);
		
		
		//discard used cards at the end of each turn
		discardUsedCards();
		if(Start.temparea.size()>0)
		{
			System.out.println("--------------------------------------------------------------");
			System.out.println("|     <<<<  Do you want to perform cityarea card ?  >>>>     |");
			System.out.println("--------------------------------------------------------------");
			System.out.println("|            1. YES                                          |");
			System.out.println("|            2. No                                           |");
			System.out.println("--------------------------------------------------------------");
		
			do
			{
				int value=input.nextInt();
				if(value==1)
				{
					//Start.PerformPlayerCard(board, this);
					Start.CheckCityAreaCard(board, this);
					break;
				}
				else if(value==2)
				{
					break;
				}
				else
				{
					System.out.println("<<<<<---Wrong Choice.--->>>>\n");
					continue;
				}
			}
			while(true);
		}
		
	}
	public void discardUsedCards() {
		Iterator it=playerCards.iterator();
		while(it.hasNext()){
			PlayerCardActions temp=((PlayerCardActions)it.next());
			if (temp.used) {
				it.remove();
				Helper.playerCardSetDiscarded.add(temp);
			}
		}
	}
	//draw cards from the deck at the start of each turn
	public void drawFromDeck(MapBoard board){
		discardUsedCards();
		int temp1=5-playerCards.size();
		for (int i = 0; i < temp1; i++) {
			if(Helper.playerCardSet.size()>0)
			{
				PlayerCardActions temp=Helper.getRandomPlayerCard();
				temp.p=this; 
				temp.board=board;
				playerCards.add(temp);
				if (temp.playerCardName.equals("Gaspode")||temp.playerCardName.equals("FreshStartClub")||temp.playerCardName.equals("Wallace Sonky")) {
					interruptCollection.add(temp);
				}
			}
		}
	}
	
	public void removePlayerCardFromSet(String name){
		for (int i = 0; i < playerCards.size(); i++) {
			if (playerCards.get(i).playerCardName.equals(name)) {
				playerCards.get(i).used=true;
				//playerCards.remove(i);
				return;
			}
		}
	}
	
}

