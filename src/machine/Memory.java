package machine;

/**
 *
 * @author pHgon
 */        
public class Memory {
    private short[] posMemory;
    
    /** 
     * CONSTRUCTOR
     * @param size  Memory address space
     */
    public Memory(int size){
        this.posMemory = new short[size];
    }
    
    /**
     * Set a memory position with a value
     * @param position  Memory address
     * @param value     Integer value
     */
    public void setMemory(int position, int value){
        this.posMemory[position] = (short)value;
        System.out.println(this.posMemory[position]);
    }
    
    /**
     * Get a memory value
     * @param position  Memory address
     * @return A integer value stored in the memory
     */
    public int getMemory(int position){
        return (int)this.posMemory[position];
    }
}
