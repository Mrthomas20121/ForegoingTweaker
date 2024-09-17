package mrthomas20121.foregoing_tweaker.actions;

import com.blamejared.crafttweaker.api.action.recipe.ActionRecipeBase;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.fluid.MCFluidStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.buuz135.industrial.recipe.DissolutionChamberRecipe;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Iterator;
import java.util.Map;

public class ActionRemoveByInputFluid extends ActionRecipeBase<DissolutionChamberRecipe> {

    private final MCFluidStack input;

    public ActionRemoveByInputFluid(IRecipeManager<DissolutionChamberRecipe> manager, MCFluidStack input) {
        super(manager);
        this.input = input;
    }

    @Override
    public void apply() {
        getRecipeMutator().removeByRecipeTest(recipe -> recipe.inputFluid.isFluidEqual(this.input.getInternal()));
    }

    @Override
    public String describe() {
        return "Removing \"" + ForgeRegistries.RECIPE_TYPES.getKey(getManager().getRecipeType()) + "\" recipes with output" + input.getRegistryName().toString();
    }
}