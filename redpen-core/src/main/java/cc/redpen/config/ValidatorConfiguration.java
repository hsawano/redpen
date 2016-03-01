/**
 * redpen: a text inspection tool
 * Copyright (c) 2014-2015 Recruit Technologies Co., Ltd. and contributors
 * (see CONTRIBUTORS.md)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cc.redpen.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Configuration for Validators.
 */
public class ValidatorConfiguration implements Serializable, Cloneable {
    private final String configurationName;
    private Map<String, String> properties;

    /**
     * @param name name configuration settings
     */
    public ValidatorConfiguration(String name) {
        this(name, new HashMap<>());
    }

    /**
     * @param name name configuration settings
     * @param properties validator properties
     */
    public ValidatorConfiguration(String name, Map<String, String> properties) {
        this.configurationName = name;
        this.properties = properties;
    }

    /**
     * Return the properties map
     *
     * @return a map of the configuration properties to their values
     */
    public Map<String, String> getProperties() {
        return properties;
    }

    /**
     * Get property value.
     *
     * @param name property name
     * @return value of the specified property
     */
    public String getProperty(String name) {
        return this.properties.get(name);
    }

    /**
     * Get configuration name.
     *
     * @return configuration name
     */
    public String getConfigurationName() {
        return configurationName;
    }

    /**
     * Get validator class name
     *
     * @return validator class name
     */
    public String getValidatorClassName() {
        return configurationName + "Validator";
    }

    /**
     * Add an property.
     *
     * @param name  property name
     * @param value property value
     * @return this object
     */
    public ValidatorConfiguration addProperty(String name, Object value) {
        properties.put(name, String.valueOf(value));
        return this;
    }

    @Deprecated
    public ValidatorConfiguration addAttribute(String name, Object value) {
        return addProperty(name, value);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValidatorConfiguration)) return false;
        ValidatorConfiguration that = (ValidatorConfiguration)o;
        return Objects.equals(configurationName, that.configurationName) &&
               Objects.equals(properties, that.properties);
    }

    @Override public int hashCode() {
        return Objects.hash(configurationName);
    }

    @Override public String toString() {
        return configurationName;
    }

    /**
     * @return a copy of ValidatorConfiguration
     */
    @Override public ValidatorConfiguration clone() {
        try {
            ValidatorConfiguration clone = (ValidatorConfiguration)super.clone();
            clone.properties = new HashMap<>(properties);
            return clone;
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
