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

import com.example.artifact.annotation.MetadataValidator;
import com.example.artifact.annotation.ValidationResult;
import com.example.artifact.model.ArtifactStoreConfig;
import com.thoughtworks.go.plugin.api.request.GoPluginApiRequest;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

public class ValidateArtifactStoreExecutor implements RequestExecutor {
    private final ArtifactStoreConfig artifactStoreConfig;

    public ValidateArtifactStoreExecutor(GoPluginApiRequest request) {
        artifactStoreConfig = ArtifactStoreConfig.fromJSON(request.requestBody());
    }

    @Override
    public GoPluginApiResponse execute() {
        final ValidationResult validationResult = new MetadataValidator().validate(artifactStoreConfig);
        return DefaultGoPluginApiResponse.success(validationResult.toJSON());
    }
}
