package Logic;

public class Direction {
    public byte value;
    public Direction(byte value)
    {
        this.value = value;
    }
    public Direction()
    {
        this.value = 0; // default
    }

    public byte getValue()
    {
        return this.value;
    }
    public void setValueInstantly(byte value)
    {
        this.value = value;
    }
    public void turnDirection(byte deltaValue)
    {
        byte bufer = (byte) (this.value + deltaValue);
        if(bufer >= 0 && bufer < 8){
            this.value = bufer;
        }else {
            if (bufer >= 8) {
                this.value = (byte) (bufer - 8);
            }
            if (bufer < 0) {
                this.value = (byte) (bufer + 8);
            }
        }
    }
    public byte getTurnedDirection(byte delta) {
        byte bufer = (byte) (this.value + delta);
        if (bufer >= 0 && bufer < 8) {
            return bufer;
        }
        if (bufer >= 8) {
            bufer = (byte) (bufer - 8);
            bufer = getTurnedDirection(bufer);
        }
        if(bufer < 0){
            bufer = (byte) (bufer + 8);
            bufer = getTurnedDirection(bufer);
        }
        return bufer;
    }
    public void setTurnedDirection(byte delta)
    {
        this.value = this.getTurnedDirection(delta);
    }
}
