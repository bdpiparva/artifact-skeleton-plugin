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

import cd.go.artifact.skeleton.model.ArtifactPlanConfig;
import cd.go.artifact.skeleton.annotation.MetadataValidator;
import cd.go.artifact.skeleton.annotation.ValidationResult;
import com.thoughtworks.go.plugin.api.request.GoPluginApiRequest;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

public class ValidatePublishArtifactConfigExecutor implements RequestExecutor {
    private final ArtifactPlanConfig artifactPlanConfig;

    public ValidatePublishArtifactConfigExecutor(GoPluginApiRequest request) {
        artifactPlanConfig = ArtifactPlanConfig.fromJSON(request.requestBody());
    }

    @Override
    public GoPluginApiResponse execute() {
        final ValidationResult validationResult = new MetadataValidator().validate(artifactPlanConfig);
        return DefaultGoPluginApiResponse.success(validationResult.toJSON());
    }
}
