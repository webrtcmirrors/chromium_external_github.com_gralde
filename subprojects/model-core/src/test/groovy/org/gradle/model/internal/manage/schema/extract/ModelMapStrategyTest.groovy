/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.model.internal.manage.schema.extract

import org.gradle.model.internal.manage.schema.CompositeSchema
import org.gradle.model.internal.manage.schema.ManagedImplSchema
import org.gradle.model.internal.manage.schema.ModelMapSchema
import org.gradle.model.internal.manage.schema.StructSchema
import org.gradle.model.internal.type.ModelType
import org.gradle.model.internal.type.ModelTypes
import spock.lang.Specification

class ModelMapStrategyTest extends Specification {
    def store = new DefaultModelSchemaStore(new DefaultModelSchemaExtractor())

    def "assembles schema for model map"() {
        expect:
        def schema = store.getSchema(ModelTypes.modelMap(String))
        schema instanceof ModelMapSchema
        schema instanceof ManagedImplSchema
        schema instanceof CompositeSchema
        !(schema instanceof StructSchema)
        schema.elementType == ModelType.of(String)
        schema.elementTypeSchema == store.getSchema(ModelType.of(String))
    }
}
