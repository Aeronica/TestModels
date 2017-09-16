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

import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;

public class BakedModelM01 implements IBakedModel
{

    @Override
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isAmbientOcclusion()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isGui3d()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isBuiltInRenderer()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleTexture()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemOverrideList getOverrides()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
