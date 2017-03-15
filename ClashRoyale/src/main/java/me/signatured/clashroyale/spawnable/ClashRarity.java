package me.signatured.clashroyale.spawnable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClashRarity {

	COMMON("Common"), RARE("Rare"), EPIC("Epic"), LEGENDARY("Legendary");

	private String name;

	public int getCardsRequired(int level) {
		switch (this) {

		case COMMON:
			switch (level) {

			case 2:
				return 2;
			case 3:
				return 4;
			case 4:
				return 10;
			case 5:
				return 20;
			case 6:
				return 50;
			case 7:
				return 100;
			case 8:
				return 200;
			case 9:
				return 400;
			case 10:
				return 800;
			case 11:
				return 1000;
			case 12:
				return 2000;
			case 13:
				return 5000;
			default:
				return -1;
			}
		case RARE:
			switch (level) {

			case 2:
				return 2;
			case 3:
				return 4;
			case 4:
				return 10;
			case 5:
				return 20;
			case 6:
				return 50;
			case 7:
				return 100;
			case 8:
				return 200;
			case 9:
				return 400;
			case 10:
				return 800;
			case 11:
				return 1000;
			default:
				return -1;
			}
		case EPIC:
			switch (level) {

			case 2:
				return 2;
			case 3:
				return 4;
			case 4:
				return 10;
			case 5:
				return 20;
			case 6:
				return 50;
			case 7:
				return 100;
			case 8:
				return 200;
			default:
				return -1;
			}
		case LEGENDARY:
			switch (level) {

			case 2:
				return 2;
			case 3:
				return 4;
			case 4:
				return 10;
			case 5:
				return 20;
			default:
				return -1;
			}

		default:
			return -1;
		}
	}

	public int getGoldRequired(int level) {
		switch (this) {

		case COMMON:
			switch (level) {

			case 2:
				return 5;
			case 3:
				return 20;
			case 4:
				return 50;
			case 5:
				return 150;
			case 6:
				return 400;
			case 7:
				return 1000;
			case 8:
				return 2000;
			case 9:
				return 4000;
			case 10:
				return 8000;
			case 11:
				return 20000;
			case 12:
				return 50000;
			case 13:
				return 100000;
			default:
				return -1;
			}
		case RARE:
			switch (level) {

			case 2:
				return 50;
			case 3:
				return 150;
			case 4:
				return 400;
			case 5:
				return 1000;
			case 6:
				return 2000;
			case 7:
				return 4000;
			case 8:
				return 8000;
			case 9:
				return 20000;
			case 10:
				return 50000;
			case 11:
				return 100000;
			default:
				return -1;
			}
		case EPIC:
			switch (level) {

			case 2:
				return 40;
			case 3:
				return 2000;
			case 4:
				return 4000;
			case 5:
				return 8000;
			case 6:
				return 20000;
			case 7:
				return 50000;
			case 8:
				return 100000;
			default:
				return -1;
			}
		case LEGENDARY:
			switch (level) {

			case 2:
				return 5000;
			case 3:
				return 20000;
			case 4:
				return 50000;
			case 5:
				return 100000;
			default:
				return -1;
			}

		default:
			return -1;
		}
	}

	public int getXpGained(int level) {
		switch (this) {

		case COMMON:
			switch (level) {

			case 2:
				return 4;
			case 3:
				return 5;
			case 4:
				return 6;
			case 5:
				return 10;
			case 6:
				return 25;
			case 7:
				return 50;
			case 8:
				return 100;
			case 9:
				return 200;
			case 10:
				return 400;
			case 11:
				return 600;
			case 12:
				return 800;
			case 13:
				return 1600;
			default:
				return -1;
			}
		case RARE:
			switch (level) {

			case 2:
				return 6;
			case 3:
				return 10;
			case 4:
				return 25;
			case 5:
				return 50;
			case 6:
				return 100;
			case 7:
				return 200;
			case 8:
				return 400;
			case 9:
				return 600;
			case 10:
				return 800;
			case 11:
				return 1600;
			default:
				return -1;
			}
		case EPIC:
			switch (level) {

			case 2:
				return 25;
			case 3:
				return 50;
			case 4:
				return 100;
			case 5:
				return 200;
			case 6:
				return 400;
			case 7:
				return 1000;
			case 8:
				return 1600;
			default:
				return -1;
			}
		case LEGENDARY:
			switch (level) {

			case 2:
				return 200;
			case 3:
				return 400;
			case 4:
				return 1000;
			case 5:
				return 1600;
			default:
				return -1;
			}

		default:
			return -1;
		}
	}
	
	public int getSpawnNpcLevel(int level) {
		switch (this) {

		case COMMON:
			switch (level) {

			case 1:
				return 3;
			case 2:
				return 4;
			case 3:
				return 5;
			case 4:
				return 6;
			case 5:
				return 7;
			case 6:
				return 8;
			case 7:
				return 9;
			case 8:
				return 10;
			case 9:
				return 11;
			case 10:
				return 12;
			case 11:
				return 13;
			case 12:
				return 14;
			case 13:
				return 15;
			default:
				return -1;
			}
		case RARE:
			switch (level) {

			case 1:
				return 3;
			case 2:
				return 4;
			case 3:
				return 5;
			case 4:
				return 6;
			case 5:
				return 7;
			case 6:
				return 8;
			case 7:
				return 9;
			case 8:
				return 10;
			case 9:
				return 11;
			case 10:
				return 12;
			case 11:
				return 13;
			default:
				return -1;
			}
		case EPIC:
			switch (level) {

			case 1:
				return 3;
			case 2:
				return 4;
			case 3:
				return 5;
			case 4:
				return 6;
			case 5:
				return 7;
			case 6:
				return 8;
			case 7:
				return 9;
			case 8:
				return 10;
			default:
				return -1;
			}
		case LEGENDARY:
			switch (level) {

			case 1:
				return 3;
			case 2:
				return 4;
			case 3:
				return 5;
			case 4:
				return 6;
			case 5:
				return 7;
			default:
				return -1;
			}

		default:
			return -1;
		}
	}
}
