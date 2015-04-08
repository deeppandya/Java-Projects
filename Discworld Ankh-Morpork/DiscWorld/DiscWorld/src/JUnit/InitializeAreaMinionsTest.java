package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import source.Helper;
import source.MapBoard;
import source.Player;

public class InitializeAreaMinionsTest {

	@Test
	public void test() {
		MapBoard board=new MapBoard();
		Player p=new Player(board,"red");
		Helper.playerList.add(p);
		board.placeInitialPieces(p);
		System.out.println(board.getCityAreaByNumber(1).minions.get("red"));
		assertTrue(board.getCityAreaByNumber(1).minions.get("red")==1);
		
	}

}
