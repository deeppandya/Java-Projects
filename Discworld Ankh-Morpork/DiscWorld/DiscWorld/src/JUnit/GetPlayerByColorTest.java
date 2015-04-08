package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import source.Helper;
import source.MapBoard;
import source.Player;

public class GetPlayerByColorTest {

	@Test
	public void test() {
		MapBoard board=new MapBoard();
		Player p=new Player(board,"red");
		Helper.playerList.add(p);
		Player temp=Helper.getPlayerByColor("red");
		assertEquals("red", temp.getColor());
	}

}
