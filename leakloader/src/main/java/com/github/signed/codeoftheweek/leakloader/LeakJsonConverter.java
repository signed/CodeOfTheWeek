package com.github.signed.codeoftheweek.leakloader;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class LeakJsonConverter {

    Leak getLeakForJSon(String leakAsJsonString) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Secret.class, new SecretJsonAdapter());
        return builder.create().fromJson(leakAsJsonString, Leak.class);
    }

    public String getJsonForLeak(Leak leak) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Secret.class, new SecretJsonAdapter());
        return builder.create().toJson(leak);
    }

    private static class SecretJsonAdapter implements JsonSerializer<Secret>, JsonDeserializer<Secret> {
        @Override
        public Secret deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return Secret.Secret(jsonElement.getAsString());
        }

        @Override
        public JsonElement serialize(Secret secret, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(secret.toString());
        }
    }
}