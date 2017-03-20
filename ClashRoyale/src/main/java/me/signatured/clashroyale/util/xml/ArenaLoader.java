package me.signatured.clashroyale.util.xml;

import java.io.File;
import java.io.IOException;

import org.bukkit.World;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.arena.ClashArenaData;
import me.signatured.clashroyale.util.shape.Cuboid;

public class ArenaLoader {
	
	public static ClashArenaData getArenaData(ClashPlayer player, World world, int side) {
		File file = new File("arena.xml");
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document;
		Element root = null;
		
		try {
			document = saxBuilder.build(file);
			root = document.getRootElement();
		} catch (JDOMException | IOException ex) {
			ex.printStackTrace();
		}
		
		Cuboid main = UtilXML.getMainCuboid(root, side, world);
		Cuboid lane1 = UtilXML.getLane1Cuboid(root, side, world);
		Cuboid lane2 = UtilXML.getLane2Cuboid(root, side, world);
		
		return new ClashArenaData(player, main, lane1, lane2);
	}
}
