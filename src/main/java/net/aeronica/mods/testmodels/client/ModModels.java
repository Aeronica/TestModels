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
package net.aeronica.mods.testmodels.client;

import com.google.common.collect.BiMap;

import net.aeronica.mods.testmodels.TestModels;
import net.aeronica.mods.testmodels.m01.ModelLoaderM01;
import net.aeronica.mods.testmodels.server.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.GameData;

@SideOnly(Side.CLIENT)
@EventBusSubscriber(value = Side.CLIENT, modid = TestModels.ID)
public class ModModels
{

    private ModModels() { /* NOP */ }
    
    @SubscribeEvent
    public static void register(ModelRegistryEvent event)
    {
        BiMap<Block, Item> biMap = GameData.getBlockItemMap();
        ModelLoaderRegistry.registerLoader(ModelLoaderM01.INSTANCE);
        
        StateMapperBase ignoreState = new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState iBlockState) {
              return new ModelResourceLocation(TestModels.prependID("model_m01_statemapper"));
            }
          };
          ModelLoader.setCustomStateMapper(ModBlocks.any_wood, ignoreState);
          
          setModel(biMap.get(ModBlocks.any_wood), "model_m01_block");      
    }

    public static void setModel(Item item, String name)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(TestModels.prependID(name), "inventory"));
    }
    
}
