package Logic.Colliders;

import Logic.Character;
import Logic.Mechmap;

public interface Collider {
    void colliderMove(Character character);
    void addCollider(Mechmap mechmap);
}
