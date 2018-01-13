/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machine;

/**
 *
 * @author lorenzo
 */
public final class Break {
    public static Tuple AddAnd(Instrucao instruction){        
        String bits12 = instruction.getBits12();
        int dr = Integer.parseInt(bits12.substring(0, 3), 2);
        int sr1 = Integer.parseInt(bits12.substring(3, 6), 2);
        int bitOp = Integer.parseInt(bits12.substring(6, 7), 2);
        int sr2 = 0;
        int dir = 0;
        if(bitOp == 0){
            //add normal
            sr2 = Integer.parseInt(bits12.substring(9, 12), 2);
            System.out.println("SR2: " + (sr2 + 1));            
        }
        else{
            //addi
            dir = Integer.parseInt(bits12.substring(7, 12), 2);
            System.out.println("Dir: " + dir);            
        }
        
        System.out.println("DR: " + (dr + 1));
        System.out.println("SR1: " + (sr1 + 1));
        System.out.println("bitOp: " + bitOp);        
        
        return new Tuple(dr, sr1, bitOp, sr2, dir);
    }
    public static Tuple BR(Instrucao instruction){
        String bits12 = instruction.getBits12();
        
        int n, z, p, offset;
        n = Integer.parseInt(bits12.substring(0, 1), 2);
        z = Integer.parseInt(bits12.substring(1, 2), 2);
        p = Integer.parseInt(bits12.substring(3, 4), 2);
        offset = Integer.parseInt(bits12.substring(4, 12), 2);
                
        System.out.println("n: " + (n));
        System.out.println("z: " + (z));
        System.out.println("p: " + (p));
        System.out.println("offset: " + (offset));        
        
        return new Tuple(n, z, p, offset, 0);
    }
    public static Tuple JMPRET(Instrucao instruction){
        int baseR = Integer.parseInt(instruction.getBits12().substring(3, 6), 2);        
        System.out.println("baseR: " + baseR);
        return new Tuple(baseR, 0, 0, 0, 0);
    }

    public static Tuple JSRJSRR(Instrucao instruction) {
        String bits12 = instruction.getBits12();
        int bitOp, offset = 0, baseR = 0;
        bitOp = Integer.parseInt(bits12.substring(0, 1), 2);        
        System.out.println("bitOp: " + bitOp);
        if(bitOp == 1){
            //jsr
            offset = Integer.parseInt(bits12.substring(1, 12), 2);        
            System.out.println("offset: " + offset);
        }
        else{
            //jsrr
            baseR = Integer.parseInt(bits12.substring(3, 6), 2);        
            System.out.println("baseR: " + baseR);
        }
        return new Tuple(bitOp, offset, baseR, 0, 0);
    }
    public static Tuple NOT(Instrucao instruction) {
        String bits12 = instruction.getBits12();
        int dr, sr;
        dr = Integer.parseInt(bits12.substring(0, 3), 2);        
        sr = Integer.parseInt(bits12.substring(3, 6), 2);        
        
        System.out.println("dr: " + dr);        
        System.out.println("sr: " + sr);        
        
        return new Tuple(dr, sr, 0, 0, 0);
    }
}
