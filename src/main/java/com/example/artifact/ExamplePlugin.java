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

package com.example.artifact;

import com.example.artifact.executors.PublishArtifactExecutor;
import com.thoughtworks.go.plugin.api.GoApplicationAccessor;
import com.thoughtworks.go.plugin.api.GoPlugin;
import com.thoughtworks.go.plugin.api.GoPluginIdentifier;
import com.thoughtworks.go.plugin.api.annotation.Extension;
import com.thoughtworks.go.plugin.api.exceptions.UnhandledRequestTypeException;
import com.thoughtworks.go.plugin.api.logging.Logger;
import com.thoughtworks.go.plugin.api.request.GoPluginApiRequest;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import static com.example.artifact.Constants.PLUGIN_IDENTIFIER;

@Extension
public class ExamplePlugin implements GoPlugin {
    public static final Logger LOG = Logger.getLoggerFor(ExamplePlugin.class);
    private GoApplicationAccessor accessor;

    @Override
    public void initializeGoApplicationAccessor(GoApplicationAccessor accessor) {
        this.accessor = accessor;
    }

    @Override
    public GoPluginApiResponse handle(GoPluginApiRequest request) {
        try {
            switch (Request.fromString(request.requestName())) {
                case REQUEST_STORE_CONFIG_METADATA:
                    return null;
                case REQUEST_STORE_CONFIG_VIEW:
                    return null;
                case REQUEST_STORE_CONFIG_VALIDATE:
                    return null;
                case REQUEST_PUBLISH_ARTIFACT_METADATA:
                    return null;
                case REQUEST_PUBLISH_ARTIFACT_VIEW:
                    return null;
                case REQUEST_PUBLISH_ARTIFACT_VALIDATE:
                    return null;
                case REQUEST_FETCH_ARTIFACT_METADATA:
                    return null;
                case REQUEST_FETCH_ARTIFACT_VIEW:
                    return null;
                case REQUEST_FETCH_ARTIFACT_VALIDATE:
                    return null;
                case REQUEST_PUBLISH_ARTIFACT:
                    return new PublishArtifactExecutor(request).execute();
                default:
                    throw new UnhandledRequestTypeException(request.requestName());
            }
        } catch (Exception e) {
            LOG.error("Error while executing request " + request.requestName(), e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public GoPluginIdentifier pluginIdentifier() {
        return PLUGIN_IDENTIFIER;
    }
}
