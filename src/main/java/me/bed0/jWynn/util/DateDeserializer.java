package me.bed0.jWynn.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDeserializer implements JsonDeserializer<Date> {

    private static final SimpleDateFormat mainFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
    private static final SimpleDateFormat territoryFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String string = jsonElement.getAsString();
        try {
            return mainFormat.parse(string);
        } catch (ParseException ex) {
            ex.printStackTrace();
            try {
                return territoryFormat.parse(string);
            } catch (ParseException ex2) {
                throw new JsonParseException(ex2);
            }
        }
    }
}
