package AdderCircuits

import chisel3._

//Subtract 2 numbers using 2s Complement Addition

class Subtractor(n : Int) extends Module { 
    val io = IO(new Bundle{
        val a      = Input(UInt(n.W))
        val b      = Input(UInt(n.W))

        val diff   = Output(UInt(n.W))
    })  

    
}













    // val twos = Module(new TwosComplement(n))
    // twos.io.in := io.b

    // val rca = Module(new RippleCarryAdder(n))
    

    // rca.io.A := io.a
    // rca.io.B := twos.io.out

    // io.diff := rca.io.Sum