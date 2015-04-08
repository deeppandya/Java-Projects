package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import source.Helper;
import source.MapBoard;
import source.Player;

public class InitializeTM {

	@Test
	public void test() {
		MapBoard board=new MapBoard();
		Player p=new Player(board,"red");
		Player p2=new Player(board,"yellow");
		Helper.playerList.add(p);
		Helper.playerList.add(p2);
		board.placeInitialPieces(p);
		board.placeInitialPieces(p2);
		assertTrue(board.getCityAreaByNumber(1).troublemarkers);
	}

}
