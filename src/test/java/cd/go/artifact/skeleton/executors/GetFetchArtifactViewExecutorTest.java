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

import cd.go.artifact.skeleton.annotation.Validatable;
import cd.go.artifact.skeleton.model.FetchArtifactConfig;
import cd.go.artifact.skeleton.utils.Util;
import com.google.gson.Gson;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GetFetchArtifactViewExecutorTest extends ViewTest {

    @Test
    public void shouldRenderTheTemplateInJSON() throws Exception {
        GoPluginApiResponse response = getRequestExecutor().execute();

        Map<String, String> responseHash = new Gson().fromJson(response.responseBody(), HashMap.class);

        assertThat(response.responseCode()).isEqualTo(200);
        assertThat(responseHash).containsEntry("template", Util.readResource("/fetch-artifact.template.html"));
    }

    @Override
    protected Class<? extends Validatable> getConfigClass() {
        return FetchArtifactConfig.class;
    }

    @Override
    protected RequestExecutor getRequestExecutor() {
        return new GetFetchArtifactViewExecutor();
    }
}