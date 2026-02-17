/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2019
 http://railcraft.info

 This code is the property of CovertJaguar
 and may only be used with explicit written
 permission unless otherwise specified on the
 license page at http://railcraft.info/wiki/info:license.
 -----------------------------------------------------------------------------*/

package mods.railcraft.common.carts;

import ic2.api.item.ITeBlockSpecialItem;
import mods.railcraft.client.render.carts.LocomotiveRenderType;
import mods.railcraft.common.blocks.RailcraftBlocks;
import mods.railcraft.common.items.ItemGear;
import mods.railcraft.common.items.Metal;
import mods.railcraft.common.items.RailcraftItems;
import mods.railcraft.common.plugins.color.EnumColor;
import mods.railcraft.common.plugins.forge.CraftingPlugin;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by CovertJaguar on 8/30/2016 for Railcraft.
 *
 * @author CovertJaguar <http://www.railcraft.info>
 */
public class ItemLocoDiesel extends ItemLocomotive {
    public ItemLocoDiesel(IRailcraftCartContainer cart) {
        super(cart, LocomotiveRenderType.ELECTRIC, EnumColor.RED, EnumColor.BLACK);
    }

    @Override
    public void defineRecipes() {
        super.defineRecipes();

        Item ic2te = Item.getByNameOrId("ic2:te");
        ItemStack generatorStack = ItemStack.EMPTY;

        if (ic2te != null) {
            generatorStack = new ItemStack(ic2te, 1, 7);
        }

        // TODO: make a recipe
        if (!generatorStack.isEmpty()) {
            CraftingPlugin.addShapedRecipe(getStack(),
                 "LD ",
                 "TBT",
                 "GMG",
                 'L', Blocks.REDSTONE_LAMP,
                 'D', generatorStack,
                 'B', RailcraftBlocks.GLASS,
                 'M', Items.MINECART,
                 'G', RailcraftItems.GEAR, ItemGear.EnumGear.STEEL,
                 'T', RailcraftItems.PLATE, Metal.STEEL);
        }
    }
}
