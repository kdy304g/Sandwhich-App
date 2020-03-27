package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject sandwichObject = new JSONObject(json);
        String origin = sandwichObject.getString("placeOfOrigin");
        String description = sandwichObject.getString("description");
        String imagePath = sandwichObject.getString("image");
        JSONObject nameObject = sandwichObject.getJSONObject("name");
        String mainName = nameObject.getString("mainName");
        JSONArray subNames = nameObject.getJSONArray("alsoKnownAs");
        List<String> subNameList = new ArrayList<String>();
        for(int i = 0; i < subNames.length(); i++){
            subNameList.add(subNames.getString(i));
        }
        JSONArray ingredients = sandwichObject.getJSONArray("ingredients");
        List<String> ingredientList = new ArrayList<String>();
        for(int i = 0; i < ingredients.length(); i++){
            ingredientList.add(ingredients.getString(i));
        }
        return new Sandwich(mainName, subNameList, origin, description, imagePath, ingredientList);
    }

}
