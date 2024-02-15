package AdderCircuits

import chisel3._

//Calculate the 2s compliment of the input number of width n
//Hints:
//Mind the difference between logical not !, and Bitwise not ~
//How could you use a Ripple Carry Adder here?

class TwosComplement(n: Int) extends Module {
    val io = IO(new Bundle{
        val in  = Input(UInt(n.W))  
        val out = Output(UInt(n.W)) 
    }) 

    val rca = Module(new RippleCarryAdder(n))

    //invert
    rca.io.A := ~io.in
    rca.io.B := 1.U

    io.out := rca.io.Sum

    //rca.io.Cout
    
}