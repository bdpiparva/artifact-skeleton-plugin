/*
 * Copyright 2018 ThoughtWorks, Inc.
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

package cd.go.artifact.skeleton.executors;

import cd.go.artifact.skeleton.model.ArtifactPlan;
import cd.go.artifact.skeleton.model.ArtifactStoreConfig;
import cd.go.artifact.skeleton.model.PublishArtifactConfig;
import cd.go.artifact.skeleton.model.PublishArtifactResponse;
import com.thoughtworks.go.plugin.api.request.GoPluginApiRequest;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.List;

import static cd.go.artifact.skeleton.ExamplePlugin.LOG;
import static java.lang.String.format;

public class PublishArtifactExecutor implements RequestExecutor {
    private List<PublishArtifactConfig> publishArtifactConfigs;
    private final PublishArtifactResponse publishArtifactResponse;

    public PublishArtifactExecutor(GoPluginApiRequest request) {
        this.publishArtifactConfigs = PublishArtifactConfig.fromJSONList(request.requestBody());
        publishArtifactResponse = new PublishArtifactResponse();
    }

    @Override
    public GoPluginApiResponse execute() {
        publish(publishArtifactConfigs);
        return DefaultGoPluginApiResponse.success(publishArtifactResponse.toJSON());
    }

    private void publish(List<PublishArtifactConfig> publishArtifactConfigs) {
        if (publishArtifactConfigs == null || publishArtifactConfigs.isEmpty()) {
            publishArtifactResponse.addError("No artifact to publish.");
            throw new RuntimeException("Implement me!");
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
        LOG.info(format("Uploading artifact using %s to artifact store with id `%s`.", artifactPlan, artifactPlan.getStoreId()));
        throw new RuntimeException("Implement me!");
    }

}
