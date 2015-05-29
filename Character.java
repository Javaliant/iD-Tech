/* Author: Luigi Vincent

*/



public class Character {
	protected String name;
	protected int strength = 10;
	protected int health = 50;
	protected int defense = 5;

	public Character(String name) {
		this.name = name;
	}

	public int attack(Character target) {
		System.out.println(name + " attacks!");
		return target.takeDamage(strength);
	}

	public int takeDamage(int damage) {
		int damageTaken = Math.max(0, damage - defense);
		health = Math.max(0, health - damageTaken);
		System.out.println(name + " took " + damageTaken + " damage");
		return damageTaken;
	}

	public static void battle(Character player, Character target) {
		int turn = 0;

		System.out.println(player.name() + " VS. " + target.name() +
			"\n===============");

		while (player.health() > 0 && target.health() > 0) {
			System.out.println("\nTurn: " + turn++);
			player.attack(target);
			target.attack(player);
		}

		if (player.health() == target.health()) {
			System.out.println("It's a draw!");
		} else {
			System.out.println(player.health() > 0 ?
				player.name() + " wins!" : target.name() + " wins!");
		}
	}

	public Character str(int strength) {
		this.strength = strength;
		return this;
	}
	public Character def(int defense) {
		this.defense = defense;
		return this;
	}
	public Character hp(int health) {
		this.health = health;
		return this;
	}

	public int strength() {
		return strength;
	}

	public int health() {
		return health;
	}

	public int defense() {
		return defense;
	}

	public String name() {
		return name;
	}

	public void status() {
		System.out.println(name + " current HP: " + health
			+ ", STR: " + strength + ", DEF: " + defense);
	}
}
