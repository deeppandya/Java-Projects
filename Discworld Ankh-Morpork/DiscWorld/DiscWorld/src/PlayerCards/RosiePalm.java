package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;
import source.Player;

/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, The Roise Palm extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do 1>Place a Minion and 2>Scroll.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class RosiePalm extends PlayerCardActions {
	
	// place minion
	// scroll
	public RosiePalm (String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Place a Minion");
		actionList.add("Scroll - ('Choose one player.\n\t\t\tGive them one of your cards.\n\t\t\tThey must give you $2 in return')");
	}
	
	@Override
	public void scroll() {
		System.out.println("Select a player to give one of your card and get $2 in return");
		for (int i = 0; i < Helper.playerList.size(); i++) {
			if (!(Helper.playerList.get(i).getColor().equals(p.getColor()))) {
				System.out.println(i+"-for "+Helper.playerList.get(i).getColor()+" color player");
			}
		}
		Scanner input=new Scanner(System.in);
		int value=input.nextInt();
		Player temp=Helper.playerList.get(value);
		if(Helper.payToBank(2, temp)){
			Helper.takeFromBank(2, p);
			System.out.println("You got $2 from selected player");
			
			for (int i = 0; i < p.playerCards.size(); i++) {
				if (!(p.playerCards.get(i).used) &&
						!p.interruptCollection.contains(p.playerCards.get(i))	) {
					p.playerCards.get(i).used=true;
					temp.playerCards.add(p.playerCards.get(i));
					System.out.println("One player card given to selected player");
					return;
				}
			}
		}else{
			System.out.println("Not enough fund with the selected player");
		}
		
	}


	@Override
	public void startPlayerCardActions() {
		Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to play 'Place a Minion' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform Place a Minion
			if (value==1) {
				Helper.placeMinion(board, p);
			}
			break;
		} while (true);
		
		do {
			System.out.println("Want to play 'Scroll' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform Scroll
			if (value==1) {
				scroll();
			}
			break;
		} while (true);
		
	}

}
