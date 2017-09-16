/* MIT License
 *
 * Copyright (c) 2017 Aeronica
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.aeronica.mods.testmodels;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.aeronica.mods.testmodels.server.ServerProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.InstanceFactory;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TestModels.ID, name = TestModels.NAME, version = TestModels.VERSION,
     acceptedMinecraftVersions = "[1.12,1.13)",
     dependencies = TestModels.DEPS,
     certificateFingerprint = "999640c365a8443393a1a21df2c0ede9488400e9")

public class TestModels
{
    public static final String ID = "testmodels";
    public static final String NAME = "TestModels";
    public static final String VERSION = "{@VERSION}";
    public static final String DEPS = "required-after:forge@[1.9.4-12.17.0.2051,)";
    private static final Logger LOGGER = LogManager.getFormatterLogger("TestModels");
    
    public static final CreativeTabs TAB = new ModTab();

    private TestModels() { /* NOP */ }
    
    private static final class Holder {
        private static final TestModels INSTANCE = new TestModels();
    }
    
    @InstanceFactory
    public static TestModels instance() {
        return Holder.INSTANCE;
    }

    @SidedProxy(
            clientSide = "net.aeronica.mods.testmodels.client.ClientProxy",
            serverSide = "net.aeronica.mods.testmodels.server.ServerProxy")
    public static ServerProxy proxy;
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModLogger.setLogger(event.getModLog());
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
    }

    @Mod.EventHandler
    public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
        LOGGER.warn("Problem with Signed Jar: %s", event.description());
    }
    
    public static String prependID(String name)
    {
        return ID + ":" + name;
    }
}
