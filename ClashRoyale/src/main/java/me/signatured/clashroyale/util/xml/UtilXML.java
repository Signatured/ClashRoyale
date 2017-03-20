package me.signatured.clashroyale.util.xml;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.jdom2.Element;

import me.signatured.clashroyale.util.ClashUtil;
import me.signatured.clashroyale.util.shape.Cuboid;

public class UtilXML {
	
	public static Element getArenaSide(Element element, int id) {
		List<Element> children = element.getChildren("side");
		
		return children.get(id - 1);
	}
	
	public static Cuboid getMainCuboid(Element root, int id, World world) {
		Element child = getArenaSide(root, id);
		Element element = child.getChild("main");
		Location corner1 = ClashUtil.deserializeLoc(world.getName() + "," + element.getAttributeValue("pos1"));
		Location corner2 = ClashUtil.deserializeLoc(world.getName() + "," + element.getAttributeValue("pos2"));
		return new Cuboid(corner1, corner2);
	}
	
	public static Cuboid getLane1Cuboid(Element root, int id, World world) {
		Element child = getArenaSide(root, id);
		Element element = child.getChild("lane1");
		Location corner1 = ClashUtil.deserializeLoc(world.getName() + "," + element.getAttributeValue("pos1"));
		Location corner2 = ClashUtil.deserializeLoc(world.getName() + "," + element.getAttributeValue("pos2"));
		return new Cuboid(corner1, corner2);
	}
	
	public static Cuboid getLane2Cuboid(Element root, int id, World world) {
		Element child = getArenaSide(root, id);
		Element element = child.getChild("lane2");
		Location corner1 = ClashUtil.deserializeLoc(world.getName() + "," + element.getAttributeValue("pos1"));
		Location corner2 = ClashUtil.deserializeLoc(world.getName() + "," + element.getAttributeValue("pos2"));
		return new Cuboid(corner1, corner2);
	}
}
