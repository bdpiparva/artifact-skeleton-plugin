/*
 * Copyright 2017 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.artifact.executors;

import com.example.artifact.model.ArtifactPlan;
import com.example.artifact.model.ArtifactStoreConfig;
import com.example.artifact.model.PublishArtifactConfig;
import com.example.artifact.model.ResponseMetadata;
import com.thoughtworks.go.plugin.api.request.GoPluginApiRequest;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.List;

import static com.example.artifact.ExamplePlugin.LOG;
import static java.lang.String.format;

public class PublishArtifactExecutor implements RequestExecutor {
    private List<PublishArtifactConfig> publishArtifactConfigs;

    public PublishArtifactExecutor(GoPluginApiRequest request) {
        this.publishArtifactConfigs = PublishArtifactConfig.fromJSONList(request.requestBody());
    }

    @Override
    public GoPluginApiResponse execute() {
        publish(publishArtifactConfigs);
        return DefaultGoPluginApiResponse.success(new ResponseMetadata().toJSON());
    }

    private void publish(List<PublishArtifactConfig> publishArtifactConfigs) {
        if (publishArtifactConfigs == null || publishArtifactConfigs.isEmpty()) {
            LOG.info("No artifact to publish.");
            return;
        }

        LOG.info("Publishing artifact to system out.");
        for (PublishArtifactConfig publishArtifactConfig : publishArtifactConfigs) {
            publishArtifactsToArtifactStore(publishArtifactConfig);
        }
    }

    private void publishArtifactsToArtifactStore(PublishArtifactConfig publishArtifactConfig) {
        final ArtifactStoreConfig artifactStoreConfig = publishArtifactConfig.getArtifactStoreConfig();
        final List<ArtifactPlan> artifactPlans = publishArtifactConfig.getArtifactPlans();

        for (ArtifactPlan artifactPlan : artifactPlans) {
            publishArtifact(artifactStoreConfig, artifactPlan);
        }
    }

    private void publishArtifact(ArtifactStoreConfig artifactStoreConfig, ArtifactPlan artifactPlan) {
        try {
            LOG.info(format("Uploading artifact %s to artifact store %s.", artifactPlan, artifactStoreConfig.getDummyField()));
            //TODO: Upload artifact to artifact store.
            LOG.info(format("Artifact %s is successfully uploaded to artifact store %s.", artifactPlan, artifactStoreConfig.getDummyField()));
        } catch (Exception e) {
            LOG.error(format("Failed to upload artifact %s to artifact store %s.", artifactPlan, artifactStoreConfig.getDummyField()));
            //TODO: fail the job since upload artifact is failed ?
        }
    }

}
