package control;

import creatures.Entity;
import game.Game;

public class EntityController {

    private Entity toControl;
    private boolean isHostile;

    private Game game;

    public EntityController(Entity toControl, boolean isHostile, Game game) {
        this.toControl = toControl;
        this.isHostile = isHostile;
        this.game = game;
    }

    public void controlEntity() {
        if(isHostile) {



        } else {
            float entityX = toControl.getPosition().getX();  // Getting entity x and y in nice clean variables
            float entityY = toControl.getPosition().getY();

            float closestDistanceToEnemy = Float.POSITIVE_INFINITY; // Setting the initial furthest distance to an enemy to infinity

            Entity closestEnemy = null;

            for(int i = 0; i < game.getSpiders().size(); i++) {
                float spiderX = game.getSpiders().get(i).getPosition().getX();  // Getting spider x and y in nice clean variables
                float spiderY = game.getSpiders().get(i).getPosition().getY();

                // Getting the distance from the enemy to the entity
                float distanceToEnemy = (float) Math.sqrt(((entityX - spiderX) * (entityX - spiderX)) + ((entityY - spiderY) * (entityY - spiderY)));

                // If the current distance is less than the closestDistanceToEnemy value, set the closestDistanceToEnemy value to the distanceToEnemy value
                closestDistanceToEnemy = Math.min(distanceToEnemy, closestDistanceToEnemy);

                closestEnemy = game.getSpiders().get(i);
            }

            for(int i = 0; i < game.getGoblins().size(); i++) {
                float goblinX = game.getGoblins().get(i).getPosition().getX();  // Getting goblin x and y in nice clean variables
                float goblinY = game.getGoblins().get(i).getPosition().getY();

                // Getting the distance from the enemy to the entity
                float distanceToEnemy = (float) Math.sqrt(((entityX - goblinX) * (entityX - goblinX)) + ((entityY - goblinY) * (entityY - goblinY)));

                // If the current distance is less than the closestDistanceToEnemy value, set the closestDistanceToEnemy value to the distanceToEnemy value
                closestDistanceToEnemy = Math.min(distanceToEnemy, closestDistanceToEnemy);

                closestEnemy = game.getGoblins().get(i);
            }
            
            if(closestDistanceToEnemy != Float.POSITIVE_INFINITY)
                toControl.setDirection(closestEnemy.getDirection());

        }
    }

}
