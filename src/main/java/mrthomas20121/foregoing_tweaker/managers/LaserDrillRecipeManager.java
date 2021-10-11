package mrthomas20121.foregoing_tweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.managers.IRecipeManager;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionAddRecipe;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.buuz135.industrial.recipe.LaserDrillOreRecipe;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.RegistryKey;
import org.openzen.zencode.java.ZenCodeType;

@Document("mods/ForegoingTweaker/LaserDrill/Ores")
@ZenCodeType.Name("mods.foregoing_tweaker.LaserDrillRecipe")
@ZenRegister
public class LaserDrillRecipeManager implements IRecipeManager {

    @ZenCodeType.Method
    public void addRecipe(String name, IItemStack output, int color, int depth_min, int depth_max, int weight) {
        LaserDrillRarity rarity = new LaserDrillRarity(new RegistryKey[]{}, new RegistryKey[]{}, depth_min, depth_max, weight);
        CraftTweakerAPI.apply(new ActionAddRecipe(this, new LaserDrillOreRecipe(name, output.asVanillaIngredient(), color, null, rarity)));
    }

    @Override
    public IRecipeType<LaserDrillOreRecipe> getRecipeType() {
        return LaserDrillOreRecipe.SERIALIZER.getRecipeType();
    }
}
