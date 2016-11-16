/***************************************************************
* file: Block.java
* author: Raymond Arias and Justin Buth
* class: CS 445 – Computer Graphics
*
* assignment: Final Project
* date last modified: 11/15/2016
*
* purpose: Class to hold data about blocks
*
****************************************************************/
class Block {
    private boolean isActive;
    private BlockType type;
    private float x;
    private float y;
    private float z;
    /*
    Enumeration of block types
    */
    public enum BlockType{
        BlockType_Grass(0),
        BlockType_Sand(1),
        BlockType_Water(2),
        BlockType_Dirt(3),
        BlockType_Stone(4),
        BlockType_Bedrock(5);
        private int blockID;
        /**
         * Constructor for block type
         * @param i 
         */
        BlockType(int i)
        {
            blockID = i;
        }
        /**
         * Method: getID
         * Purpose: gets the block id
         */
        public int getID(){
            return blockID;
        }
        /**
         * Method: setID
         * Purpose: Sets the block id
         */
        public void setID(int i)
        {
            blockID = i;
        }
    }
    /**
    * Method: Block
    * Purpose: constructor for block
    */
    public Block(BlockType type)
    {
        this.type = type;
    }
    /**
    * Method: setCoords
    * Purpose: set the coordinates for this block
    */
    public void setCoords(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    /**
    * Method: isActive
    * Purpose: returns whether this block is active
    */
    public boolean isActive()
    {
        return isActive;
    }
    /**
    * Method: setIsActive
    * Purpose: sets whether this block is active
    */
    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }
    /**
    * Method: getID
    * Purpose: returns this block's id
    */
    public int getID()
    {
        return type.getID();
    }
}
