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

public class ArtifactStoreConfig implements Validatable {
    @Expose
    @SerializedName("DummyField")
    @ProfileField(key = "DummyField", required = true, secure = false)
    private String dummyField;

    public ArtifactStoreConfig() {
    }

    public ArtifactStoreConfig(String dummyField) {
        this.dummyField = dummyField;
    }

    public String getDummyField() {
        return dummyField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArtifactStoreConfig)) return false;

        ArtifactStoreConfig that = (ArtifactStoreConfig) o;

        return dummyField != null ? dummyField.equals(that.dummyField) : that.dummyField == null;
    }

    @Override
    public int hashCode() {
        return dummyField != null ? dummyField.hashCode() : 0;
    }

    public static ArtifactStoreConfig fromJSON(String json) {
        return GSON.fromJson(json, ArtifactStoreConfig.class);
    }
}
