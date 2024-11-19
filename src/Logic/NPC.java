package Logic;

import Logic.Strategies.MoveStrategyForNPC;
import Logic.Strategies.MoveStrategyInterface;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NPC extends Character  implements MovableObject{

    public NPC(String name, int lives, int netX, int netY, int spriteNumber, int visibleIndex, int movableIndex, int colliderIndex)
    {
        super(name, lives, netX, netY, spriteNumber, visibleIndex, movableIndex, colliderIndex);
        this.form = Form.NPC;
        this.movestrategy = new MoveStrategyForNPC();
    }


    @Override
    public byte[] getButtons() {
        return null;
    }
}
