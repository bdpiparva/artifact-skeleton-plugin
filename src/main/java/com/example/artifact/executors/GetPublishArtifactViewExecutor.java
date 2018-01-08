package com.example.artifact.executors;

import com.example.artifact.utils.Util;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

public class GetPublishArtifactViewExecutor implements RequestExecutor {
    private static final Gson GSON = new Gson();

    @Override
    public GoPluginApiResponse execute() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("template", Util.readResource("/publish-artifact.template.html"));
        return DefaultGoPluginApiResponse.success( GSON.toJson(jsonObject));
    }

}

