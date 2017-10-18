package be.pxl.lambdaexpressions.opdracht3;

import java.util.ArrayList;
import java.util.function.Predicate;

public class GameCollection {
	private ArrayList<VideoGame> videoGameCollection = new ArrayList<VideoGame>();
	
	public void addGame(VideoGame game){
		videoGameCollection.add(game);
	}
	
	public ArrayList<VideoGame> selectGames(Predicate<String> filter){
		ArrayList<VideoGame> videoGameFilter = new ArrayList<VideoGame>();
		for(int i = 0; i < videoGameCollection.size(); i++){
			if(filter.test(videoGameCollection.get(i).getName())){
				videoGameFilter.add(videoGameCollection.get(i));
			} else if (filter.test(String.valueOf(videoGameCollection.get(i).getPrice()))){
				videoGameFilter.add(videoGameCollection.get(i));
			}
		}	
		return videoGameFilter;
	}
}