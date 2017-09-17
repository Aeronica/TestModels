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

import java.util.Collection;
import java.util.function.Function;

import com.google.common.collect.ImmutableList;

import net.aeronica.mods.testmodels.ModLogger;
import net.aeronica.mods.testmodels.TestModels;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.model.IModelState;

public class ModelM01 implements IModel
{

    public static final ResourceLocation TEXTURE_SHEET = new ResourceLocation(TestModels.prependID("blocks/model_m01_block"));

    public static final ModelResourceLocation MODEL_CORE = new ModelResourceLocation(TestModels.prependID("model_m01_block"));
    
    @Override
    public Collection<ResourceLocation> getDependencies() {
      return ImmutableList.copyOf(new ResourceLocation[]{MODEL_CORE});
    }

    @Override
    public Collection<ResourceLocation> getTextures() {
      return ImmutableList.copyOf(new ResourceLocation[]{TEXTURE_SHEET});
    }
    
    @Override
    public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter)
    {
        try {
            IModel subComponent = ModelLoaderRegistry.getModel(MODEL_CORE);
            IBakedModel bakedModelCore = subComponent.bake(state, format, bakedTextureGetter);
            return bakedModelCore;
          } catch (Exception exception) {
            ModLogger.error("ModelM01.bake() failed due to exception:", exception);
            return ModelLoaderRegistry.getMissingModel().bake(state, format, bakedTextureGetter);
          }
    }
    
    @Override
    public IModelState getDefaultState() {
      return null;
    }
    
}
