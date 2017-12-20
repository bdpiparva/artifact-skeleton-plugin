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

package com.example.artifact.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import static com.example.artifact.utils.Util.GSON;

public class PublishArtifactConfig {
    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("configuration")
    private ArtifactStoreConfig artifactStoreConfig;

    @Expose
    @SerializedName("artifact_plans")
    private List<ArtifactPlan> artifactPlans;

    public static List<PublishArtifactConfig> fromJSONList(String requestBody) {
        return GSON.fromJson(requestBody, new TypeToken<List<PublishArtifactConfig>>() {
        }.getType());
    }

    public static PublishArtifactConfig fromJSON(String json) {
        return GSON.fromJson(json, PublishArtifactConfig.class);
    }

    public String getId() {
        return id;
    }

    public ArtifactStoreConfig getArtifactStoreConfig() {
        return artifactStoreConfig;
    }

    public List<ArtifactPlan> getArtifactPlans() {
        return artifactPlans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PublishArtifactConfig)) return false;

        PublishArtifactConfig that = (PublishArtifactConfig) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (artifactStoreConfig != null ? !artifactStoreConfig.equals(that.artifactStoreConfig) : that.artifactStoreConfig != null)
            return false;
        return artifactPlans != null ? artifactPlans.equals(that.artifactPlans) : that.artifactPlans == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (artifactStoreConfig != null ? artifactStoreConfig.hashCode() : 0);
        result = 31 * result + (artifactPlans != null ? artifactPlans.hashCode() : 0);
        return result;
    }
}
