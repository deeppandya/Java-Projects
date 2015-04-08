package PlayerCards;

import java.util.ArrayList;
import java.util.Scanner;

import source.Helper;
/**
 * 
 * @author p_pandy
 * <p> Player card,from Green cards, Nobby Nobbs extends the PlayerCardActions.
 * It overrides two methods of the PlayerCardAction. It has two events to do  1>Scroll and 2>Play Another Card.
 * </p>
 * @see scroll()
 * @see startPlayerCardActions() 
 *
 */
public class NobbyNobbs extends PlayerCardActions {
	
	//scroll
	// play another card
	
	public NobbyNobbs(String name) {
		playerCardName=name;
		actionList=new ArrayList<String>();
		actionList.add("Scroll - (Take $3 from player of your choice)");
		actionList.add("Play Another Card");
	}
	
	@Override
	public void scroll() {
		//Implement scroll
		System.out.println("Please Select a player to ask for $3\n");
		for (int i = 0; i < Helper.playerList.size(); i++) {
			if(!(Helper.playerList.get(i).getColor().equals(p.getColor())))
			{
				System.out.println((i)+" for "+Helper.playerList.get(i).getColor()+" color player");
			}
		}
		Scanner input=new Scanner(System.in);

		do
		{
			int value=input.nextInt();
			if(value>=0 || value<Helper.playerList.size()-1)
			{
				if(Helper.payToBank(3, Helper.playerList.get(value)))
				{
					Helper.takeFromBank(3, p);
					return;
				}
			}
			else
			{
				System.out.println("wrong Choice");
			}
		}while(true);
	}

	

	@Override
	public void startPlayerCardActions() {
		Scanner input=new Scanner(System.in);
		
		do {
			System.out.println("Want to play 'Scroll' action?\n1-yes\n2-No");
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
			System.out.println("Want to play 'Play Another Card' action?\n1-yes\n2-No");
			int value=input.nextInt();
			
			if (!((value==1)||(value==2))) {
				System.out.println("Wrong choice");
				continue;
			}
			//perform Play Another Card
			if (value==1) {
				//Play another card
				p.displayUnusedCards(board);
			}
			break;
		} while (true);
		
	}

}
