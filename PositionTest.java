package ttt7;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PositionTest {

	@Test
	public void testNew() throws Exception{
		
		Position position = new Position();
		assertEquals('x',position.turn);
		assertEquals(
				  "    "
				+ "    "
				+ "    "
				+ "    ",position.toString());
				
	}
	
	@Test
	   public void testMove() throws Exception {
		
			Position position = new Position().move(1);
			

			assertEquals('o',position.turn);
			assertEquals(
					" x  "
				   +"    "
				   +"    "
				   +"    ",position.toString());
}

	@Test
	   public void testUnmove() throws Exception {
		
			Position position = new Position().move(1).unmove(1);
			

			assertEquals('x',position.turn);
			assertEquals(
					 "    "
					+"    "
					+"    "
					+"    ",position.toString());
}
	
	public void testPossibleMoves() throws Exception {
		List<Integer> list = new  ArrayList<>();
		for(int i =0 ; i <Position.SIZE;i++)
		{
			list.add(i);
		}
		
		list.remove(new Integer(1));
		list.remove(new Integer(2));
		assertEquals(list, new Position().move(1).possibleMoves());
		
		
	}
	
	
public void testIsWinFOR() throws Exception {
		
		assertFalse(new Position().isWinFor('x'));
		
		assertTrue(new Position(
				"xxxx"
			   +"    "
			   +"    "
			   +"    ", 'x').isWinFor('x'));
		assertTrue(new Position(
				"x   "
			  + "x   "
			  + "x   "
			  + "x   ", 'x').isWinFor('x'));
		assertTrue(new Position(
			    "o   "
		      + " o  "
		      + "  o "
		      + "   o", 'x').isWinFor('o'));
		assertTrue(new Position(
				"   o"
			  + "  o "
			  + " o  "
			  + "o   ", 'x').isWinFor('o'));
		
	
		

}

public void testMinimax() throws Exception {
	assertEquals( 12, new Position(
			"xxxx"
		  + "    "
		  + "    "
		  + "    ", 'x').minimax());
	assertEquals(-12, new Position(
			"oooo"
		  + "    "
		  + "    "
		  + "    ", 'o').minimax());
	assertEquals( 0, new Position(
			"xoxx"
		   +"oxox"
		   +"ooox"
		   +"xxoo", 'x').minimax());
	assertEquals( 12, new Position(
			"xxxx"
		  + "    "
		  + "    "
		  + "    ", 'x').minimax());
	assertEquals(-12, new Position(
			"oooo"
		  + "    "
		  + "    "
		  + "    ", 'o').minimax());
	assertEquals( 0, new Position().move(1).minimax());
	


}

@Test
public void testBestMove() throws Exception {
	
	assertEquals(2 , new Position(
			"xx x"
		  + "    "
		  + "    "
		  + "    ", 'x').bestMove());
	assertEquals(2 , new Position(
			"oo o"
		  + "    "
		  + "    "
		  + "    ", 'o').bestMove());
	
}

@Test
public void testisGameEnd() throws Exception {
	
	assertFalse(new Position().isGameEnd());
	assertTrue(new Position(
			  "xxxx"
			+ "    "
			+ "    "
			+ "    ", 'x').isGameEnd());
	
	assertTrue(new Position(
			  "x   "
			+ "x   "
			+ "x   "
			+ "x   ", 'x').isGameEnd());
	assertTrue(new Position(
			  "oooo"
			+ "    "
			+ "    "
			+ "    ", 'x').isGameEnd());
	assertTrue(new Position(
			  "o   "
			+ "o   "
			+ "o   "
			+ "o   ", 'o').isGameEnd());
	
	assertTrue(new Position(
			  "xoxx"
		     +"oxox"
		     +"ooxo"
		     +"xooo", 'x').isGameEnd());
}

}