package cofh.thermalcultivation.init;

import cofh.core.gui.CreativeTabCore;
import cofh.thermalcultivation.ThermalCultivation;
import cofh.thermalfoundation.ThermalFoundation;
import cofh.thermalfoundation.init.TFProps;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TCProps {

	private TCProps() {

	}

	public static void preInit() {

		configCommon();
		configClient();
	}

	/* HELPERS */
	private static void configCommon() {

		String category;
		String comment;
	}

	private static void configClient() {

		/* CREATIVE TABS */
		if (TFProps.useUnifiedTabs) {
			ThermalCultivation.tabCommon = ThermalFoundation.tabCommon;
			ThermalCultivation.tabItems = ThermalFoundation.tabItems;
			ThermalCultivation.tabUtils = ThermalFoundation.tabUtils;

			TFProps.initToolTab();
			ThermalCultivation.tabTools = ThermalFoundation.tabTools;
		} else {
			ThermalCultivation.tabCommon = new CreativeTabCore("thermalcultivation") {

				@Override
				@SideOnly (Side.CLIENT)
				public ItemStack getTabIconItem() {

					return new ItemStack(TCItems.itemWateringCan, 1, 1);
				}
			};
			ThermalCultivation.tabItems = ThermalCultivation.tabCommon;
			ThermalCultivation.tabUtils = ThermalCultivation.tabCommon;
			ThermalCultivation.tabTools = ThermalCultivation.tabCommon;
		}
	}

}
