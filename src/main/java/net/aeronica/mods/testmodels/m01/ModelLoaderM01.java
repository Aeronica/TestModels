/**
 * Copyright {2016} Paul Boese aka Aeronica
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
package net.aeronica.mods.testmodels.m01;

import net.aeronica.mods.testmodels.TestModels;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;

public enum ModelLoaderM01 implements ICustomModelLoader
{

    INSTANCE;
    
    public final String MODEL_M01_RESOURCE_LOCATION = "models/block/model_m01/";
    
    @Override
    public void onResourceManagerReload(IResourceManager resourceManager)
    {
        /* NOP */
    }

    @Override
    public boolean accepts(ResourceLocation modelLocation)
    {
        
        return modelLocation.getResourceDomain().equals(TestModels.ID) && 
                modelLocation.getResourcePath().startsWith(MODEL_M01_RESOURCE_LOCATION);
    }

    @Override
    public IModel loadModel(ResourceLocation modelLocation) throws Exception
    {
        String resourcePath = modelLocation.getResourcePath();
        if (!resourcePath.startsWith(MODEL_M01_RESOURCE_LOCATION)) {
          assert false : "loadModel expected " + MODEL_M01_RESOURCE_LOCATION + " but found " + resourcePath;
        }
        String modelName = resourcePath.substring(MODEL_M01_RESOURCE_LOCATION.length());

        if (modelName.equals("model_m01")) {
          return new ModelM01();
        } else {
          return ModelLoaderRegistry.getMissingModel();
        }
    }

}
