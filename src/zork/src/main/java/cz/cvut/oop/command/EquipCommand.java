package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;
import cz.cvut.oop.model.*;

import java.util.Objects;

public class EquipCommand implements Command{

    @Override
    public String getName() {
        return "equip";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        String weaponToEquip = arguments[1];
        Item weapon = null;
        Item newWeapon = null;
        Player player = gameData.getPlayer();

        for (int i = 0; i < gameData.getCurrentRoom().getFloor().size(); i++){
            if ((Objects.equals(gameData.getCurrentRoom().getFloor().get(i).getName(), weaponToEquip))) {
                weapon = gameData.getCurrentRoom().getFloor().get(i);
                newWeapon = player.swapWeapons(weapon);
            }
            else if (!(gameData.getCurrentRoom().getFloor().get(i).getName().equals(weaponToEquip))) return "Takový předmět se tu nenachází";
        }

        return "Do ruky sis dal " + newWeapon.getName() + "se sílou útoku od " + newWeapon.getDamage()[0] + " do " + newWeapon.getDamage()[1];
    }
}
