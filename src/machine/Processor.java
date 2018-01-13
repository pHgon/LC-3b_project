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
    
    public int executar(Instrucao instruction, Memory memory, int pc){
        int offsetPC = 0;
        System.out.println("PC: " + pc);
        System.out.println("\nopcode: " + instruction.getOpcode());
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
            case "1100":
                offsetPC = this.jmpret(instruction, pc);
                break;
            case "0100":
                offsetPC = this.jsrjsrr(instruction, pc);
                break;                    
            case "1001":
                offsetPC = this.not(instruction, pc);
                break;                    
        }        
        return offsetPC;
    }
    private int add(Instrucao instruction){
        Tuple tuple = Break.AddAnd(instruction);
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
        Tuple tuple = Break.AddAnd(instruction);
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
    private int br(Instrucao instruction){
        Tuple tuple = Break.BR(instruction);
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
    private int jmpret(Instrucao instruction, int pc){
        Tuple tuple = Break.JMPRET(instruction);
        return this.registradores[tuple.t1] - pc;        
        /*if(tuple.t1 == 7){
            //ret
            return this.registradores[7] - pc;        
        }
        else{
            //jmp            
            
        }*/        
    }
    private int jsrjsrr(Instrucao instruction, int pc) {
        Tuple tuple = Break.JSRJSRR(instruction);
        int bitOp, offset, baseR;
        bitOp = tuple.t1;
        offset = tuple.t2;
        baseR = tuple.t3;
        
        this.registradores[7] = pc + 1;
        if(bitOp == 1){
            //jsr
            return ((offset << 1) + 1);
        }
        else{
            //jsrr
            return this.registradores[baseR] - pc;
        }        
    }
    private int not(Instrucao instruction, int pc){
        Tuple tuple = Break.NOT(instruction);
        int dr, sr, sign, number;
        dr = tuple.t1;
        sr = tuple.t2;        
        
        
        number = ~Integer.parseInt(Integer.toBinaryString(this.registradores[sr]), 2);        
        sign = Integer.parseInt(Integer.toBinaryString(number).substring(0,1));
        System.out.println("Sign: " +  sign);
        System.out.println("Not Number: " +  number);

        this.registradores[dr] = number;
        this.n = 0;
        this.z = 0;
        this.p = 0;
        
        if(sign == 1){
            this.n = 1;
        }
        else{
            if(number == 0){
                this.z = 1;
            }
            else{
                this.p = 1;
            }
        }        
        
        return 1;
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
