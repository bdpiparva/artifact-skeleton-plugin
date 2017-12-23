package com.example.artifact.executors;

import com.example.artifact.annotation.ConfigMetadata;
import com.example.artifact.annotation.MetadataHelper;
import com.example.artifact.model.ArtifactPlanConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.List;

public class GetPublishArtifactConfigMetadataExecutor implements RequestExecutor {
    private static final Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public GoPluginApiResponse execute() throws Exception {
        final List<ConfigMetadata> storeConfigMetadata = MetadataHelper.getMetadata(ArtifactPlanConfig.class);
        return new DefaultGoPluginApiResponse(200, GSON.toJson(storeConfigMetadata));
    }
}

