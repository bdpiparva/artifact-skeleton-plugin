package com.example.artifact.executors;

import com.example.artifact.annotation.ConfigMetadata;
import com.example.artifact.annotation.MetadataHelper;
import com.example.artifact.model.ArtifactPlanConfig;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.List;

import static com.example.artifact.utils.Util.GSON;

public class GetPublishArtifactConfigMetadataExecutor implements RequestExecutor {
    public GoPluginApiResponse execute() {
        final List<ConfigMetadata> metadata = MetadataHelper.getMetadata(ArtifactPlanConfig.class);
        return DefaultGoPluginApiResponse.success( GSON.toJson(metadata));
    }
}

