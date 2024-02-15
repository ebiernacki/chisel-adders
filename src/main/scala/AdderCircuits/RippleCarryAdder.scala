package AdderCircuits

import chisel3._
import chisel3.util._

/* 
* A n-bit Ripple Carry Adder with carry in (initially set to 0) and a carry out
* Think abut setting up a loop to create a Full Adder to add each bit in the inputs, linking the carrys together
* 
* A note on Vectors:
* Vectors are chisels arrays. They are indexable with (), have a retrivalble length (vectorName.length), they can be iterated over, pre/appened, reversable, and more. Check the chisel cheatsheet for more
* 
* Here is how you can declare a vector of 15 UInt values with a width of 3 bits, where the values are initalized to 1.U 
* val myVec = VecInit(Seq.fill(15)(1.U(3.W)))
* 
* You can also concatenate all the values of a Vector together with the command Cat(myVec)
* Say myVec = (1, 0, 1, 1)
* Cat(myVec) = 1011
* 
* or
* Cat("b101".U, "b11".U)  // equivalent to "b10111".U
* 
* You can also Cat().reverse, or toString, or shift with << >>
*/

class RippleCarryAdder(n: Int) extends Module {
    val io = IO(new Bundle{
        val A     = Input(UInt(n.W))
        val B     = Input(UInt(n.W))
        
        val Sum   = Output(UInt(n.W))
        val Cout  = Output(UInt(1.W))
    })
    
    //vector for to hold all the sums (think of as array)
    val sums = VecInit(Seq.fill(n)(0.U(1.W))) 

    //assume the initail carry is 0
    var currentCarry = 0.U

    for(i <- 0 to (n - 1)){
        val fAdd = Module(new FullAdder)
        fAdd.io.a := io.A(i)
        fAdd.io.b := io.B(i)
        fAdd.io.c_in := currentCarry
        sums(i) := fAdd.io.sum 
        // io.Sum(i) := fAdd.io.sum
        currentCarry = fAdd.io.c_out
    }

    io.Sum  := Cat(sums.reverse) //.asUInt // if you filled from front, you can reverse it here
    io.Cout := currentCarry 

    
}