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

import cd.go.artifact.skeleton.annotation.ProfileField;
import cd.go.artifact.skeleton.annotation.Validatable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static cd.go.artifact.skeleton.utils.Util.GSON;

public class FetchArtifactConfig implements Validatable {
    @Expose
    @SerializedName("source")
    @ProfileField(key = "source", required = true, secure = false)
    private String source;

    @Expose
    @SerializedName("destination")
    @ProfileField(key = "destination", required = true, secure = false)
    private String destination;

    public FetchArtifactConfig() {
    }

    public FetchArtifactConfig(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return this.source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FetchArtifactConfig)) return false;

        FetchArtifactConfig that = (FetchArtifactConfig) o;

        return source != null ? source.equals(that.source) : that.source == null;
    }

    @Override
    public int hashCode() {
        return source != null ? source.hashCode() : 0;
    }

    public static FetchArtifactConfig fromJSON(String json) {
        return GSON.fromJson(json, FetchArtifactConfig.class);
    }
}
