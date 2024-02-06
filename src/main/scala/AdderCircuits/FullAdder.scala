package AdderCircuits

import chisel3._

//A Full Adder takes in 3 inputs (2 bits to add, and a carry bit), and outputs the sum and a carry
//Remember and use the truth table to create the combinational logic expressions for the output 
class FullAdder() extends Module { 
    val io = IO(new Bundle{
        val a     = Input(UInt(1.W))
        val b     = Input(UInt(1.W))
        val c_in  = Input(UInt(1.W))
        val sum   = Output(UInt(1.W))
        val c_out = Output(UInt(1.W))
    })   



    
}