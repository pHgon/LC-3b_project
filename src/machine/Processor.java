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
    short[] registradores;
    int n, z, p;
    String buffer = "";
    
    public String streamProcessor(){
        return buffer + "\n";
    }
    
    public Processor(){
        this.registradores = new short[8];
        this.n = 0;
        this.z = 0;
        this.p = 0;
        this.buffer = "";
    }
    
    public int executar(Instrucao instruction, Memory mem, int pc){
        int offsetPC = 0;
        buffer = this.buffer + "PC: " + pc;
        buffer = this.buffer + "\nopcode: " + instruction.getOpcode() + "\n";
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
            case "0010":
                offsetPC = this.ldb(instruction, pc, mem);
                break;      
            case "1010":
                offsetPC = this.ldi(instruction, pc, mem);
                break;  
            case "0110":
                offsetPC = this.ldr(instruction, pc, mem);
                break;  
            case "1110":
                offsetPC = this.lea(instruction, pc, mem);
                break;              
            case "1101":
                offsetPC = this.shf(instruction, pc, mem);
                break; 
            case "0011":
                offsetPC = this.stb(instruction, pc, mem);
                break; 
            case "1011":
                offsetPC = this.sti(instruction, pc, mem);
                break;                 
            case "0111":
                offsetPC = this.str(instruction, pc, mem);
                break;           
        }        
        return offsetPC;
    }
    private int add(Instrucao instruction){
        Tuple tuple = Break.AddAnd(instruction);
        int dr, sr1, bitOp, sr2;
        short dir, result;
        dr = tuple.t1;
        sr1 = tuple.t2;
        bitOp = tuple.t3;
        sr2 = tuple.t4;
        dir = (short)tuple.t5;
        buffer = this.buffer +  "DR: " + Integer.toString(tuple.t1 +1) + "\n" +
                                "SR1: " + Integer.toString(tuple.t2 +1) + "\n" +
                                "BITOP: " + Integer.toString(tuple.t3) + "\n" +
                                "SR2: " + Integer.toString(tuple.t4 +1) + "\n" +
                                "DIR: " + Integer.toString(tuple.t5 ) + "\n\n";
        
        if(bitOp == 0){
            //add normal
            result = (short) (this.registradores[sr1] + this.registradores[sr2]);
        }
        else{
            //addi            
            result = (short) (this.registradores[sr1] + dir);
        }     
        this.registradores[dr] = result;
                       
        this.setNZP(result);
        
        return 1;
    }
    private int and(Instrucao instruction){
        Tuple tuple = Break.AddAnd(instruction);
        int dr, sr1, bitOp, sr2;
        short dir;
        dr = tuple.t1;
        sr1 = tuple.t2;
        bitOp = tuple.t3;
        sr2 = tuple.t4;
        dir = (short) tuple.t5;
                buffer = this.buffer +  "DR: " + Integer.toString(tuple.t1 +1) + "\n" +
                                        "SR1: " + Integer.toString(tuple.t2 +1) + "\n" +
                                        "BITOP: " + Integer.toString(tuple.t3) + "\n" +
                                        "SR2: " + Integer.toString(tuple.t4 +1) + "\n" +
                                        "DIR: " + Integer.toString(tuple.t5 ) + "\n\n";
        if(bitOp == 0){
            //and normal
            this.registradores[dr] = (short) (this.registradores[sr1] & this.registradores[sr2]); 
        }
        else{
            //andi            
            this.registradores[dr] = (short) (this.registradores[sr1] &  dir); 
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
                buffer = this.buffer +  "N: " + Integer.toString(tuple.t1) + "\n" +
                                        "Z: " + Integer.toString(tuple.t2) + "\n" +
                                        "P: " + Integer.toString(tuple.t3) + "\n" +
                                        "OFFSET: " + Integer.toString(tuple.t4) + "\n\n";
                
        if((_n == 1 && _n == this.n) || (_z == 1 && _z == this.z) || (_p == 1 && _p == this.p)){
            buffer = this.buffer + "Offset shiftado: " + Integer.toString(offset << 1) + "\n";
            return offset << 1;
        }       
        
        return 0;
    }
    private int jmpret(Instrucao instruction, int pc){
        Tuple tuple = Break.JMPRET(instruction);
        buffer =  this.buffer + "BASE_R: " + Integer.toString(tuple.t1) + "\n\n";
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
        buffer = this.buffer +  "BITOP: " + Integer.toString(tuple.t1) + "\n" +
                                "OFFSET: " + Integer.toString(tuple.t2) + "\n" +
                                "BASE_R: " + Integer.toString(tuple.t3) + "\n\n" ;
        
        this.registradores[7] = (short) (pc + 1);
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
        int dr, sr, number;
        dr = tuple.t1;
        sr = tuple.t2;        
         buffer = this.buffer +  "DR: " + Integer.toString(tuple.t1) + "\n" +
                                 "SR: " + Integer.toString(tuple.t2) + "\n\n" ;

        
        number = ~Integer.parseInt(Integer.toBinaryString(this.registradores[sr]), 2);                    
        buffer = this.buffer + "Not Number:" + Integer.toString(number) + "\n";

        this.registradores[dr] = (short) number;
                       
        this.setNZP((short) number);
        
        return 1;
    }
    private int ldb(Instrucao instruction, int pc, Memory mem) {
        Tuple tuple = Break.LDBLDILDR(instruction);        
        int dr, baseR;
        short offset;
        dr = tuple.t1;
        baseR = tuple.t2;
        offset = (short)tuple.t3;
         buffer = this.buffer +  "DR: " + Integer.toString(tuple.t1) + "\n" +
                                 "BASE_R: " + Integer.toString(tuple.t2) + "\n" +
                                 "OFFSET: " + Integer.toString(tuple.t3) + "\n\n" ;
        
        this.registradores[dr] = (short) mem.getByte((this.registradores[baseR] + offset));
        this.setNZP(this.registradores[dr]);
        
        return 1;
    }
    private int ldi(Instrucao instruction, int pc, Memory mem) {
        Tuple tuple = Break.LDBLDILDR(instruction);
        int dr, baseR;
        short offset, address;
        dr = tuple.t1;
        baseR = tuple.t2;
        offset = (short)(tuple.t3 << 1);
        address = (short) (this.registradores[baseR] + (short) offset);        

        address = this.setZeroLast(address);
        buffer = this.buffer +  "DR: " + Integer.toString(tuple.t1) + "\n" +
                                "BASE_R: " + Integer.toString(tuple.t2) + "\n" +
                                "OFFSET: " + Integer.toString(tuple.t3) + "\n\n" ;

        
        this.registradores[dr] = (short)mem.getWord(mem.getWord(address));        
        
        this.setNZP(this.registradores[dr]);
        
        return 1;
    }
    private int ldr(Instrucao instruction, int pc, Memory mem) {
        Tuple tuple = Break.LDBLDILDR(instruction);
        int dr, baseR;
        short offset, address;
        dr = tuple.t1;
        baseR = tuple.t2;
        offset = (short)(tuple.t3 << 1);
        address = (short) (this.registradores[baseR] + (short) offset);
         buffer = this.buffer +  "DR: " + Integer.toString(tuple.t1) + "\n" +
                                 "BASE_R: " + Integer.toString(tuple.t2) + "\n" +
                                 "OFFSET: " + Integer.toString(tuple.t3) + "\n\n" ;

        address = this.setZeroLast(address);
        
        this.registradores[dr] = (short)mem.getWord(address);        
        
        this.setNZP(this.registradores[dr]);
        
        return 1;
    }
    private int lea(Instrucao instruction, int pc, Memory mem) {
        Tuple tuple = Break.LEA(instruction);
        
        int dr;
        short offset;
        dr = tuple.t1;
        offset = (short) ((tuple.t2 << 1) + pc + 1);
        buffer = this.buffer +  "DR: " + Integer.toString(tuple.t1) + "\n" +
                                "OFFSET: " + Integer.toString(tuple.t2) + "\n\n" ;
        
        this.registradores[dr] = (short)offset;
        this.setNZP(this.registradores[dr]);
        
        return 1;
    }   
    private int shf(Instrucao instruction, int pc, Memory mem) {
        Tuple tuple = Break.SHF (instruction);
        int dr, sr, a, d;
        short offset, result;
        
        dr = tuple.t1;
        sr = tuple.t2;
        a = tuple.t3;
        d = tuple.t4;
        offset = (short) tuple.t5;
        result = 0;
        
        buffer = this.buffer +  "DR: " + Integer.toString(tuple.t1) + "\n" +
                                "SR1: " + Integer.toString(tuple.t2) + "\n" +
                                "BITOP: " + Integer.toString(tuple.t3) + "\n" +
                                "SR2: " + Integer.toString(tuple.t4) + "\n" +
                                "DIR: " + Integer.toString(tuple.t5) + "\n\n";
        if(d == 0){
            result = (short)(this.registradores[sr] << offset);
        }
        else{
            if(a == 0){
                result = (short)(this.registradores[sr] >>> offset);
            }
            else{
                result = (short)(this.registradores[sr] >> offset);               
            }
        }
    
        this.registradores[dr] = result;
        this.setNZP(result);
        return 1;
    }
    private int stb(Instrucao instruction, int pc, Memory mem) {
        Tuple tuple = Break.STBSTISTR(instruction);
        int sr, baseR;
        short offset;
        sr = tuple.t1;
        baseR = tuple.t2;
        offset = (short) tuple.t3;
        buffer = this.buffer +  "SR: " + Integer.toString(tuple.t1) + "\n" +
                                 "BASE_R: " + Integer.toString(tuple.t2) + "\n" +
                                 "OFFSET: " + Integer.toString(tuple.t3) + "\n\n" ;
        
        offset = (short) (this.registradores[baseR] + offset);
        
        mem.setByte(offset, this.registradores[sr]);
        buffer = this.buffer + "Pos:" + Integer.toString(offset) + " Value:" + Integer.toString(mem.getByte(offset)) + "\n";
        return 1;
    }
    private int sti(Instrucao instruction, int pc, Memory mem) {
        Tuple tuple = Break.STBSTISTR(instruction);
        int sr, baseR;
        short offset;
        sr = tuple.t1;
        baseR = tuple.t2;
        offset = (short) (tuple.t3 << 1);
                buffer = this.buffer +  "SR: " + Integer.toString(tuple.t1) + "\n" +
                                 "BASE_R: " + Integer.toString(tuple.t2) + "\n" +
                                 "OFFSET: " + Integer.toString(tuple.t3) + "\n\n" ;
        
        offset = (short) (this.registradores[baseR] + offset);
        offset = this.setZeroLast(offset);
        
        mem.setWord(mem.getWord(offset), this.registradores[sr]);
        buffer = this.buffer + "Pos:" + Integer.toString(mem.getWord(offset)) + " Value:" + Integer.toString(mem.getWord(mem.getWord(offset))) + "\n";
        return 1;
    }

    private int str(Instrucao instruction, int pc, Memory mem) {
        Tuple tuple = Break.STBSTISTR(instruction);
        int sr, baseR;
        short offset;
        sr = tuple.t1;
        baseR = tuple.t2;
        offset = (short) tuple.t3;
                buffer = this.buffer +  "SR: " + Integer.toString(tuple.t1) + "\n" +
                                 "BASE_R: " + Integer.toString(tuple.t2) + "\n" +
                                 "OFFSET: " + Integer.toString(tuple.t3) + "\n\n" ;
        
        offset = (short) (this.registradores[baseR] + (offset << 1));
        offset = this.setZeroLast(offset);

        mem.setWord(offset, this.registradores[sr]);
        buffer = this.buffer + "Pos: " + Integer.toString(offset) + " Value:" + Integer.toString(mem.getWord(offset)) + "\n";
        return 1;
    }
    private short setZeroLast(int number){
        //set 0 na primeira posicao????????????
        String leAddress = Integer.toBinaryString(number);                       
        char[] myNameChars = leAddress.toCharArray();
        myNameChars[leAddress.length()-1] = '0';
        leAddress = String.valueOf(myNameChars);
        
        return (short) Integer.parseInt(leAddress,2);
    }
    private void setNZP(short number){
        int sign = Integer.parseInt(Integer.toBinaryString(number).substring(0,1));
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
