package be.pxl.lambdaexpressions.opdracht3;

import java.util.ArrayList;
import java.util.function.Predicate;

public class GameBrowser {
	private GameCollection collection;
	
	public GameBrowser(GameCollection collection){
		this.collection = collection;
	}
	
	public ArrayList<VideoGame> showGamesForSearch(String search){
		ArrayList<VideoGame> collectionFilter;
		Predicate<String> filter = new Predicate<String>(){
			@Override
			public boolean test(String t) {
				if(t.contains(search.toLowerCase())){
					return true;
				} else {
					return false;
				}		
			}			
		};
		collectionFilter = collection.selectGames(filter);		
		return collectionFilter;
	}
	
	public ArrayList<VideoGame> showFreeGames(){
		ArrayList<VideoGame> collectionFilter;
		collectionFilter = collection.selectGames(string -> string.equals("0.0"));	
		return collectionFilter;
	}
	
	public ArrayList<VideoGame> showGamesInGenre(String genre){
		ArrayList<VideoGame> collectionFilter;
		collectionFilter = collection.selectGames(string -> string.equals(genre));	
		return collectionFilter;
	}
}
