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
public class Processor {
    int[] registradores;
    int n, z, p;
    
    public Processor(){
        this.registradores = new int[8];
        this.n = 0;
        this.z = 0;
        this.p = 0;
    }
    
    public int executar(Instrucao instruction, Memory memory){
        int offsetPC = 0;
        System.out.println("opcode: " + instruction.getOpcode());
        switch(instruction.getOpcode()){
            case "0001":
                offsetPC = this.add(instruction);
                break;
            case "0101":
                offsetPC = this.and(instruction);
                break;
            case "0000":
                offsetPC = this.br(instruction);
                break;
        }        
        return offsetPC;
    }
    private Tuple breakAddAnd(Instrucao instruction){        
        String bits12 = instruction.getBits12();
        int dr = Integer.parseInt(bits12.substring(0, 3), 2) -1;
        int sr1 = Integer.parseInt(bits12.substring(3, 6), 2) -1;
        int bitOp = Integer.parseInt(bits12.substring(6, 7), 2);
        int sr2 = 0;
        int dir = 0;
        if(bitOp == 0){
            //add normal
            sr2 = Integer.parseInt(bits12.substring(9, 12), 2) -1;
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
        System.out.println("\n");
        
        return new Tuple(dr, sr1, bitOp, sr2, dir);
    }
    private int add(Instrucao instruction){
        Tuple tuple = breakAddAnd(instruction);
        int dr, sr1, bitOp, sr2, dir;
        dr = tuple.t1;
        sr1 = tuple.t2;
        bitOp = tuple.t3;
        sr2 = tuple.t4;
        dir = tuple.t5;
        
        if(bitOp == 0){
            //add normal
            this.registradores[dr] = this.registradores[sr1] + this.registradores[sr2];
        }
        else{
            //addi            
            this.registradores[dr] = this.registradores[sr1] + dir;
        }     
                                       
        return 1;
    }
    private int and(Instrucao instruction){
        Tuple tuple = breakAddAnd(instruction);
        int dr, sr1, bitOp, sr2, dir;
        dr = tuple.t1;
        sr1 = tuple.t2;
        bitOp = tuple.t3;
        sr2 = tuple.t4;
        dir = tuple.t5;
        
        if(bitOp == 0){
            //and normal
            this.registradores[dr] = this.registradores[sr1] & this.registradores[sr2]; 
        }
        else{
            //andi            
            this.registradores[dr] = this.registradores[sr1] &  dir; 
        }             
        return 1;
    }
    private Tuple breakBR(Instrucao instruction){
        String bits12 = instruction.getBits12();
        int _n, _z, _p, offset;
        _n = Integer.parseInt(bits12.substring(0, 1), 2);
        _z = Integer.parseInt(bits12.substring(1, 2), 2);
        _p = Integer.parseInt(bits12.substring(3, 4), 2);
        offset = Integer.parseInt(bits12.substring(4, 12), 2);
                
        System.out.println("n: " + (_n));
        System.out.println("z: " + (_z));
        System.out.println("p: " + (_p));
        System.out.println("offset: " + (offset));
        System.out.println("\n");
        
        return new Tuple(_n, _z, _p, offset, 0);
    }
    private int br(Instrucao instruction){
        Tuple tuple = breakBR(instruction);
        int _n, _z, _p, offset;
        _n = tuple.t1;
        _z = tuple.t2;
        _p = tuple.t3;
        offset = tuple.t4;
        
        if((_n == 1 && _n == this.n) || (_z == 1 && _z == this.z) || (_p == 1 && _p == this.p)){
            System.out.println("Offset shiftado: " + (offset << 1));
            return offset << 1;
        }       
        
        return 0;
    }
    @Override
    public String toString(){
        return "Registradores: " + 
                this.registradores[0] + " " +
                this.registradores[1] + " " +
                this.registradores[2] + " " +
                this.registradores[3] + " " +
                this.registradores[4] + " " +
                this.registradores[5] + " " +
                this.registradores[6] + " " +
                this.registradores[7] + " ";
    }    
}
