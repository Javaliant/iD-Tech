


public class Berserker extends Character {

	Berserker(String name) {
		super(name);
		strength = 13;
		health = 70;
		defense = 0;
	}

	@Override
	public int attack(Character target) {
		System.out.println(name + " attacks! " + name + " is getting stronger!");
		return target.takeDamage(strength++);
	}
}
