package AdderCircuits

import chisel3._


//Detect the sign of the input value using what you know about 2s Complement
//Set all of the outputs so that only one is true for a given input
//Meaning that and input of zero should only have io.zero = true, while io.neg = io.pos = false


class Sign(n : Int) extends Module { 
    val io = IO(new Bundle{
        val input = Input(UInt(n.W))
        
        val neg   = Output(Bool())
        val pos   = Output(Bool())
        val zero  = Output(Bool())
    })  


    val msb = io.input(n - 1)

    var currOr = false.B


    for(i <- 0 to (n - 1)){
        currOr = currOr | io.input(i)
    }

    io.zero := !currOr  //!io.input.orR  //orR is one of chisels UInt bit-reduction methods -- see chisel cheat sheet
    io.neg := msb
    io.pos := !msb & currOr

}