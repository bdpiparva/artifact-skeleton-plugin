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

package cd.go.artifact.skeleton.model;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PublishArtifactConfigTest {

    @Test
    public void shouldDeserializeRequestBody() {
        final String json = "[\n" +
                "  {\n" +
                "    \"configuration\": {\n" +
                "      \"DummyField\": \"Bar\"\n" +
                "    },\n" +
                "    \"id\": \"s3-store\",\n" +
                "    \"artifact_plans\": [\n" +
                "      {\n" +
                "        \"configuration\": {\n" +
                "          \"filename\": \"plugin.zip\"\n" +
                "        },\n" +
                "        \"id\": \"installers\",\n" +
                "        \"storeId\": \"s3-store\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"configuration\": {\n" +
                "          \"filename\": \"junit.xml\"\n" +
                "        },\n" +
                "        \"id\": \"test-reports\",\n" +
                "        \"storeId\": \"s3-store\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";

        final List<PublishArtifactConfig> publishArtifactConfigs = PublishArtifactConfig.fromJSONList(json);

        assertThat(publishArtifactConfigs).hasSize(1);

        final PublishArtifactConfig publishArtifactConfig = publishArtifactConfigs.get(0);
        assertThat(publishArtifactConfig.getId()).isEqualTo("s3-store");
        assertThat(publishArtifactConfig.getArtifactStoreConfig()).isEqualTo(new ArtifactStoreConfig("Bar"));

        assertThat(publishArtifactConfig.getArtifactPlans()).hasSize(2);
        assertThat(publishArtifactConfig.getArtifactPlans()).containsExactlyInAnyOrder(
                new ArtifactPlan("installers", "s3-store", new ArtifactPlanConfig("plugin.zip")),
                new ArtifactPlan("test-reports", "s3-store", new ArtifactPlanConfig("junit.xml"))
        );
    }
}