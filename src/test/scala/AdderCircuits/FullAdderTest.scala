package AdderCircuits

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

//Test combinations for 1 bit full adders
class FullAdderTest extends AnyFlatSpec with ChiselScalatestTester {
    "Full Adder Test" should s"correctly compute sum and carry" in {
        test(new FullAdder()){ dut => 
            dut.io.a.poke(0.U)
            dut.io.b.poke(0.U)
            dut.io.c_in.poke(0.U)
            dut.io.sum.expect(0.U)
            dut.io.c_out.expect(0.U)

            var sum = dut.io.sum.peek().litValue
            var carry = dut.io.c_out.peek().litValue

            println(s"Adding 0 + 0 with carry_in = 0 gives sum: $sum and carry_out: $carry")

            dut.io.a.poke(0.U)
            dut.io.b.poke(0.U)
            dut.io.c_in.poke(1.U)
            dut.io.sum.expect(1.U)
            dut.io.c_out.expect(0.U)

            sum = dut.io.sum.peek().litValue
            carry = dut.io.c_out.peek().litValue

            println(s"Adding 0 + 0 with carry_in = 1 gives sum: $sum and carry_out: $carry")


            dut.io.a.poke(1.U)
            dut.io.b.poke(0.U)
            dut.io.c_in.poke(0.U)
            dut.io.sum.expect(1.U)
            dut.io.c_out.expect(0.U)

            sum = dut.io.sum.peek().litValue
            carry = dut.io.c_out.peek().litValue

            println(s"Adding 1 + 0 with carry_in = 0 gives sum: $sum and carry_out: $carry")

            dut.io.a.poke(1.U)
            dut.io.b.poke(0.U)
            dut.io.c_in.poke(1.U)
            dut.io.sum.expect(0.U)
            dut.io.c_out.expect(1.U)

            sum = dut.io.sum.peek().litValue
            carry = dut.io.c_out.peek().litValue

            println(s"Adding 1 + 0 with carry_in = 1 gives sum: $sum and carry_out: $carry")
   
            dut.io.a.poke(1.U)
            dut.io.b.poke(1.U)
            dut.io.c_in.poke(0.U)
            dut.io.sum.expect(0.U)
            dut.io.c_out.expect(1.U)

            sum = dut.io.sum.peek().litValue
            carry = dut.io.c_out.peek().litValue

            println(s"Adding 1 + 1 with carry_in = 0 gives sum: $sum and carry_out: $carry")
        
            dut.io.a.poke(1.U)
            dut.io.b.poke(1.U)
            dut.io.c_in.poke(1.U)
            dut.io.sum.expect(1.U)
            dut.io.c_out.expect(1.U)

            sum = dut.io.sum.peek().litValue
            carry = dut.io.c_out.peek().litValue

            println(s"Adding 1 + 1 with carry_in = 1 gives sum: $sum and carry_out: $carry")
        }
    } 

    // def randomTest(width: Int) = {
    //     val in1 = BigInt(width, Random) //not oneline for printing formats
    //     val in1asUint = in1.U(width.W)  //to UInt for chisel
    //     val in2 = BigInt(width, Random)
    //     val in2asUint = in2.U(width.W)

    //     var expected = (in1 + in2).U //replaceable
    //     var trunc: Boolean = false


    //     //check if width is too much
    //     if(expected.getWidth > width){
    //         trunc = true
    //         expected = expected(width-1 , 0) //chop off MSB if value has grown over width
    //     }

    //     //singular test thats generated in for loop below
    //     it should s"RippleCarry Add: width = $width, in1 = $in1, in2 = $in2, expected = $expected, truncated: $trunc" in {
    //         test(new RippleCarryAdder(width)) { dut =>
    //             dut.io.A.poke(in1asUint)
    //             dut.io.B.poke(in2asUint)
    //             dut.io.Sum.expect(expected)
    //         }
    //     }
    // }

    // //generate seq of random widths in range  1 -> 64, add 64 to end
    // var randomWidths: Seq[Int] = Seq.fill(5)(Random.nextInt(64) + 1)
    // randomWidths = randomWidths :+ 64

    // //generate 6 tests for all (6) widths 
    // for (width <- randomWidths) {
    //     randomTest(width)
    // }

}
