package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import source.Helper;
import source.MapBoard;
import source.Player;

/***
 * 
 * @author c_sarvai
 *<p>
 *Junit class to test drawFromDeck method of Player Object.
 *Initially every user has 5 cards and it is removed from list once card is played.
 *drawFromDeck method shuffle the cards and assigns random cards to Player object.
 *So, total number of cards must be 5.
 *<br/>
 *<br/>
 *Checking whether total number of player cards is 5 or not.
 *
 *</p>
 */
public class DrawFromDeckTest {

	@Test
	public void test() {
		MapBoard board=new MapBoard();
		Player p=new Player(board);
		Helper.playerList.add(p);
		board.placeInitialPieces(p);
		p.playerCards.remove(0);
		p.playerCards.remove(0);
		p.playerCards.remove(0);
		p.drawFromDeck(board);
		assertEquals(5, p.playerCards.size());
		//Helper.removeTM(board);
	}

}
