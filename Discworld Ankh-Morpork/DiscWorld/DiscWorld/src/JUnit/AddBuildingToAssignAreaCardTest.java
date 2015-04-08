package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import source.Helper;
import source.MapBoard;
import source.Player;

/***
 * 
 * @author c_sarvai
 *
 *<p>
 * JUnit test class to test addBuilding method.
 * Adding a new building, it stores city area into player object.
 * <br/>
 * <br/>
 * Checking whether that city area size is one or not. If test runs successfully, it will add an area.
 * </p>
 * 
 */

public class AddBuildingToAssignAreaCardTest {

	
	@Test
	public void test() {
		MapBoard board=new MapBoard();
		Player p=new Player(board,"red");
		Helper.playerList.add(p);
		board.placeInitialPieces(p);
		board.cityAreaObejctList.get(0).addBuilding(p.getColor());
		//System.out.println(p.getCityAreasConquered().get(0).name);
		assertEquals(1,p.getCityAreasConquered().size()); 
	}

}
