package AdderCircuits

import chisel3._

//Subtract 2 numbers using 2s Complement Addition
//NOTE: This module takes the form of: a - b

class Subtractor(n : Int) extends Module { 
    val io = IO(new Bundle{
        val a      = Input(UInt(n.W))
        val b      = Input(UInt(n.W))

        val diff   = Output(UInt(n.W))
    })  

    
}