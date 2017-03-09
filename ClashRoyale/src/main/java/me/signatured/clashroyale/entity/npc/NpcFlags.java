package me.signatured.clashroyale.entity.npc;

import lombok.Data;

@Data
public class NpcFlags {
	
	private boolean flying = false;
	private boolean structuresOnly = false;
	private boolean attackFlying = false;
	private boolean attackGround = true;
}
