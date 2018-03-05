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
public class Tuple {
    private int t1;    
    private int t2;
    private int t3;
    private int t4;
    private int t5;
    public Tuple(int t1, int t2, int t3, int t4, int t5){
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.t5 = t5;
    }

    /**
     * @return the t1
     */
    public int getT1() {
        return t1;
    }

    /**
     * @return the t2
     */
    public int getT2() {
        return t2;
    }

    /**
     * @return the t3
     */
    public int getT3() {
        return t3;
    }

    /**
     * @return the t4
     */
    public int getT4() {
        return t4;
    }

    /**
     * @return the t5
     */
    public int getT5() {
        return t5;
    }
}
