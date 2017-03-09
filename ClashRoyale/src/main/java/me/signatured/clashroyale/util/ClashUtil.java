package me.signatured.clashroyale.util;

import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.npc.skin.SkinnableEntity;
import net.citizensnpcs.util.NMS;

public class ClashUtil {
	
	public static void applySkin(NPC npc, String skinName) {
		npc.data().setPersistent("player-skin-name", skinName);
		
		if (npc.isSpawned()) {
			SkinnableEntity skinnable = NMS.getSkinnable(npc.getEntity());
			if (skinnable != null)
				skinnable.setSkinName(skinName);
		}
	}
}
