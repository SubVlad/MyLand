package Logic;

public class Velocity {
    public int pathX;
    public int pathY;
    public int delayBetweenSteps;
    public int directionXleft;;
    public int directionXright;
    public int directionYup;
    public int directionYdown;
    public int myTime;
    public int mySpeed;
    public Velocity(int pathX, int pathY)
    {
        this.pathX = pathX;
        this.pathY = pathY;
        this.delayBetweenSteps = 2; // 2 only if speed is 10 or less
        this.mySpeed = 10;  // no more than 20, under 15 is well, 10 is recomended

    }
    public void sumVelocity(Velocity velocity)
    {
        this.pathX = this.pathX + velocity.pathX;
        this.pathY = this.pathY + velocity.pathY;
    }
    public void subtractVelocity(Velocity velocity)
    {
        this.pathX = this.pathX - velocity.pathX;
        this.pathY = this.pathY - velocity.pathY;
    }
    public void multiplyVelocity(int coef)
    {
        this.pathX = this.pathX * coef;
        this.pathY = this.pathY * coef;
    }
    public int getPathX()
    {
        return pathX;
    }
    public int getPathY()
    {
        return pathY;
    }
    public void setPathX(int vectorX)
    {
        this.pathX = vectorX;
    }
    public void setPathY(int vectorY)
    {
        this.pathY = vectorY;
    }
    public void directMe()
    {
       /* int vectorX = this.directionXright - this.directionXleft;
        int vectorY = this.directionYdown - this.directionYup;
        this.myTime = this.myTime + this.mySpeed;
        if(this.myTime == this.timeX)
        {
            this.setPathX(vectorX);
            this.setPathY(vectorY);
            this.myTime = 0;
        }else{
            this.setPathX(vectorX);
            this.setPathY(vectorY);
        }*/
        int vectorX = this.directionXright - this.directionXleft;
        int vectorY = this.directionYdown - this.directionYup;
        if(this.myTime == 0){
            if(vectorX != 0 && vectorY != 0){
                this.setPathX(vectorX * this.mySpeed / 2);
                this.setPathY(vectorY * this.mySpeed / 2);
            }else{
            this.setPathX(vectorX * this.mySpeed);
            this.setPathY(vectorY * this.mySpeed);
            }
        }else{
            this.setPathX(0);
            this.setPathY(0);
        }
        if(vectorX != 0 || vectorY != 0){
            this.myTime = this.myTime + 1;
        }
        if(this.myTime >= this.delayBetweenSteps){
            this.myTime = 0;
        }
    }
    public void setDirectionXleft(int directionXleft)
    {
        this.directionXleft = directionXleft;
    }
    public void setDirectionXright(int directionXright)
    {
        this.directionXright = directionXright;
    }
    public void setDirectionYup(int directionYup)
    {
        this.directionYup = directionYup;
    }
    public void setDirectionYdown(int directionYdown)
    {
        this.directionYdown = directionYdown;
    }
}
