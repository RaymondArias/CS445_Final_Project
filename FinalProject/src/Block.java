class Block {
    private boolean isActive;
    private BlockType type;
    private float x;
    private float y;
    private float z;
    
    public enum BlockType{
        BlockType_Grass(0),
        BlockType_Sand(1),
        BlockType_Water(2),
        BlockType_Dirt(3),
        BlockType_Stone(4),
        BlockType_Bedrock(5);
        private int blockID;
        BlockType(int i)
        {
            blockID = i;
        }
        public int getID(){
            return blockID;
        }
        public void setID(int i)
        {
            blockID = i;
        }
    }
    public Block(BlockType type)
    {
        this.type = type;
    }
    public void setCoords(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public boolean isActive()
    {
        return isActive;
    }
    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }
    public int getID()
    {
        return type.getID();
    }
}
