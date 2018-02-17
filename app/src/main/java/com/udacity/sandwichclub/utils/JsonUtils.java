package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = new Sandwich();

        try {
            JSONObject sandwichJson = new JSONObject(json);

            //name
            JSONObject sandwichNameJson = sandwichJson.getJSONObject("name");

                // mainName
                sandwich.setMainName(sandwichNameJson.getString("mainName"));

            Log.v("JsonUtils", "mainName: " + sandwichNameJson.getString("mainName"));

                // alsoKnownAs
                JSONArray alsoKnownAs = sandwichNameJson.getJSONArray("alsoKnownAs");
                int alsoKnownAsLength = alsoKnownAs.length();
                if (alsoKnownAsLength > 0) {
                    List<String> names = new ArrayList<>();
                    for (int i = 0; i < alsoKnownAsLength; i++) {
                        names.add(alsoKnownAs.getString(i));
                    }
                    sandwich.setAlsoKnownAs(names);
                }

            // placeOfOrigin
            sandwich.setPlaceOfOrigin(sandwichJson.getString("placeOfOrigin"));

            // description
            sandwich.setDescription(sandwichJson.getString("description"));

            // image
            sandwich.setImage(sandwichJson.getString("image"));

            // ingredients
            JSONArray ingredients = sandwichJson.getJSONArray("ingredients");
            int ingredientsLength = ingredients.length();
            if (ingredientsLength > 0) {
                List<String> names = new ArrayList<>();
                for (int i = 0; i < ingredientsLength; i++) {
                    names.add(ingredients.getString(i));
                }
                sandwich.setIngredients(names);
            }

        } catch (JSONException e) {
            Log.e("JsonUtils", "Problem parsing the sandwich JSON", e);
        }

        return sandwich;
    }
}
