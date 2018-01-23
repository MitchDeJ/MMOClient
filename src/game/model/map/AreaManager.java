package game.model.map;

import java.util.ArrayList;
import java.util.List;

import game.model.entity.WorldObject;
import json.JSONArray;
import json.JSONObject;
import json.parser.JSONParser;
import json.parser.ParseException;

public class AreaManager {

	public static Area loadArea(String name, int width, int height, String tilesData, String objectsJSON) {
		
		List<Tile> tiles = parseTilesData(tilesData);
		List<WorldObject> objects = parseObjectsJSON(objectsJSON);
		
		return new Area(name, width, height, tiles, objects);
	}

	private static List<WorldObject> parseObjectsJSON(String objectsJSON) {
		//create the list
		List<WorldObject> objects = new ArrayList<WorldObject>();
		
		//Create json objects
	    JSONParser parser = new JSONParser();
		JSONArray array = null;
		
		// parse the json string
		try {
			array = (JSONArray) parser.parse(objectsJSON);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// loop through every object and add it
		for (Object o : array)
		{
			JSONObject object = (JSONObject) o;
			objects.add(new WorldObject
					(
							objects.size(),
							ObjectType.getType
							(
									Math.toIntExact((long) object.get("t"))
							),
							(double) object.get("x"),
							(double) object.get("y")
					));				
		}
		return objects;
	}

	private static List<Tile> parseTilesData(String tilesData) {
		List<Tile> tiles = new ArrayList<Tile>();	
		
		//parse tiles
		String[] tilesArray = tilesData.split("#");
		
		for(String tile : tilesArray) {
			tiles.add( // add a tile for every entry, parsing it's type
					new Tile(TileType.getType(Integer.parseInt(tile))) 
					 );
		}
		return tiles; //return the list
	}
	
}
