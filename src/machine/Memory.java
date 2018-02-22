package machine;

/**
 *
 * @author pHgon
 */        
public class Memory {
    private String[] posMemory;
    
    
    /** 
     * CONSTRUCTOR
     * @param size  Memory address space
     */
    public Memory(int size){
        this.posMemory = new String[size];
        for(int i=0; i<size; i++)
        	this.posMemory[i] = "00000000";
    }
    
    public String printMemory(int inicio, int fim){
        String buffer = "";
        for(int i=inicio ; i < fim; i++) {
            buffer = buffer + "posição: " + Integer.toString(i)+ " =" + Integer.parseInt(posMemory[i]) + "\n";
        }

        return buffer;
    }
    
    
    /**
     * Set a memory position with a 8 bits value (-128 a 127)
     * @param position  Memory address
     * @param value     Integer value
     */
    public void setByte(int position, int value){
        this.posMemory[position] = this.convertInBinary(value, 8);
    }
    
    
    /**
     * Set a memory position with a 16 bits value (-32768 a 32767)
     * @param position  Memory initial address
     * @param value     Integer value 
     */
    public void setWord(int position, int value){
        String binValue = this.convertInBinary(value, 16);
        String[] binValues = {binValue.substring(0, 8), binValue.substring(8, 16)};
        
        for(int i=0; i<2; i++){
            this.posMemory[position+i] = binValues[i];
        }    
    }
    
    
    /**
     * Get a memory 8 bits value (-128 a 127)
     * @param position  Memory address
     * @return A integer value stored in the memory
     */
    public int getByte(int position){                
        String value = this.posMemory[position];        
        
        if(value.charAt(0) == '1'){
            value = "111111111111111111111111" + value;
            long num = Long.parseLong(value, 2);
            return (int)num;
        }
        return Integer.parseInt(value, 2);
    }
    
    
    /**
     * Get a memory 16 bits value (-32768 a 32767)
     * @param position  Memory address
     * @return A integer value stored in the memory
     */
    public int getWord(int position){
        String high = this.posMemory[position];
        String low  = this.posMemory[position+1];
        high = high + low;
        
        if(high.charAt(0) == '1'){
            high = "1111111111111111" + high;
            long num = Long.parseLong(high, 2);
            return (int)num;
        }
        return Integer.parseInt(high, 2);
    }
    
    
    /**
     * Convert a int value in a binary of n bits
     * @param value  A integer value
     * @param bits   Number of bits to be converted
     * @return A String of the value converted in binary
     */
    private String convertInBinary(int value, int bits){
        String binValue = Integer.toBinaryString(value);
        int size = binValue.length();
        if(size > bits){
            binValue = binValue.substring(size-bits, size);
        }
        else{
            if(size<bits){
                while(binValue.length() < bits){
                    binValue = '0' + binValue;
                }
            }
        }
        return binValue;
    }
}
