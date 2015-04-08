package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;
import source.Player;


/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, The Beggers Guild extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Scroll and 2>Place a Minion.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class TheBeggersGuild extends PlayerCardActions {
	
	// scroll
	// place minion
	public TheBeggersGuild(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (Select one player. they must give you two cards of their choice.)");
		actionList.add("Place a minion");
	}
	
	@Override
	public void scroll() {
		System.out.println("Select a player to take 2 player cards from that player");
		for (int i = 0; i < Helper.playerList.size(); i++) {
			if (!(Helper.playerList.get(i).getColor().equals(p.getColor()))) {
				System.out.println(i+"-for "+Helper.playerList.get(i).getColor()+" color player");
			}
		}
		Scanner input=new Scanner(System.in);
		int value=input.nextInt();
		Player temp=Helper.playerList.get(value);
		int x;
		for (int i = 0; i < 2; i++) {
			System.out.println("Message for "+temp.getColor()+" player: Select one of your card to give away");
			
			for (int k = 0; k < temp.playerCards.size(); k++) {
				if (!(temp.playerCards.get(k).used) &&
						!p.interruptCollection.contains(p.playerCards.get(i))) {
					System.out.println(k+" for "+temp.playerCards.get(k).playerCardName);
					
				}
			}
			x=input.nextInt();
			p.playerCards.add(temp.playerCards.get(x));
			temp.playerCards.get(x).used=true;
			
		}	
	}

	

	@Override
	public void startPlayerCardActions() {
		Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to play scroll action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform scroll
			if (value==1) {
				scroll();
			}
			break;
		} while (true);
		
		do {
			System.out.println("Want to play 'place a minion' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform place a minion
			if (value==1) {
				Helper.placeMinion(board, p);
			}
			break;
		} while (true);
		
	}

}
