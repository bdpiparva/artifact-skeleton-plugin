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

import com.example.artifact.annotation.ProfileField;
import com.example.artifact.annotation.Validatable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.example.artifact.utils.Util.GSON;

public class ArtifactPlanConfig implements Validatable {
    @Expose
    @SerializedName("filename")
    @ProfileField(key = "filename", required = true, secure = false)
    private String filename;

    public ArtifactPlanConfig() {
    }

    public ArtifactPlanConfig(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    @Override
    public String toString() {
        return toJSON();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArtifactPlanConfig)) return false;

        ArtifactPlanConfig that = (ArtifactPlanConfig) o;

        return filename != null ? filename.equals(that.filename) : that.filename == null;
    }

    @Override
    public int hashCode() {
        return filename != null ? filename.hashCode() : 0;
    }

    public static ArtifactPlanConfig fromJSON(String json) {
        return GSON.fromJson(json, ArtifactPlanConfig.class);
    }
}
