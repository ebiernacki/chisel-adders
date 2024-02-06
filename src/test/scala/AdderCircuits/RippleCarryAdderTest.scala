package AdderCircuits

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import scala.util.Random


class RippleCarryAdderTest extends AnyFlatSpec with ChiselScalatestTester {

    //Simple test
    "Ripple Carry Adder" should s"add 2 + 1 = 3 (2bits)" in {
        test(new RippleCarryAdder(2)){ dut => 
            dut.io.A.poke(2.U)
            dut.io.B.poke(1.U)
            dut.io.Sum.expect(3.U) 
            dut.io.Cout.expect(0.U)

            var sum = dut.io.Sum.peekInt()
            var carry = dut.io.Cout.peekInt()

            val asInt = sum.toInt
            //fancy printing to see binary
            val bin = asInt.toBinaryString

            println(s"Adding 2bit 2 + 1 gives sum(dec):  $sum, sum(binary):$bin and carry_out: $carry")
            
        }
    }

    //4 and 5 bit tests to see overflow
    "Ripple Carry Adder" should s"add 8 and 8 with 4/5 bits to test overflow and carry" in {
        test(new RippleCarryAdder(4)){ dut => 
            dut.io.A.poke(8.U)
            dut.io.B.poke(8.U)
            dut.io.Sum.expect(0.U) 
            dut.io.Cout.expect(1.U)

            var sum = dut.io.Sum.peekInt()
            var carry = dut.io.Cout.peekInt()

            val asInt = sum.toInt
            //fancy printing to see binary
            val bin = "%4s".format(asInt.toBinaryString).replace(' ', '0')

            println(s"Adding 4bit 8 + 8 gives sum(dec):  $sum, sum(binary):$bin and carry_out: $carry")
            
        }

        test(new RippleCarryAdder(5)){ dut => 
            dut.io.A.poke(8.U)
            dut.io.B.poke(8.U)
            dut.io.Sum.expect(16.U) 
            dut.io.Cout.expect(0.U)

            var sum = dut.io.Sum.peekInt()
            var carry = dut.io.Cout.peekInt()

            val asInt = sum.toInt
            //fancy printing to see binary
            val bin = asInt.toBinaryString

            println(s"Adding 5bit 8 + 8 gives sum(dec): $sum, sum(binary):$bin and carry_out: $carry")
            
        }
    }

    //The following code creates RCA's of random widths and tests them based on expected values
    def randomTest(width: Int) = {
        val in1 = BigInt(width, Random) //not oneline for printing formats
        val in1asUint = in1.U(width.W)  //to UInt for chisel
        val in2 = BigInt(width, Random)
        val in2asUint = in2.U(width.W)

        var expected = (in1 + in2).U //replaceable
        var trunc: Boolean = false
        var carry_out = 0.U


        //check if width is too much
        if(expected.getWidth > width){
            trunc = true
            carry_out = 1.U
            expected = expected(width-1 , 0) //chop off MSB if value has grown over width
        }

        //singular test thats generated in for loop below
        it should s"RippleCarry Add: width = $width, in1 = $in1, in2 = $in2, expected = ${expected.litValue} carry_out: ${carry_out.litValue}" in {
            test(new RippleCarryAdder(width)) { dut =>
                dut.io.A.poke(in1asUint)
                dut.io.B.poke(in2asUint)
                dut.io.Sum.expect(expected)
                dut.io.Cout.expect(carry_out)
            }
        }
    }

    //generate seq of random widths in range  1 -> 64, add 64 to end
    var randomWidths: Seq[Int] = Seq.fill(5)(Random.nextInt(64) + 1)
    randomWidths = randomWidths :+ 64

    //generate 6 tests for all (6) widths 
    for (width <- randomWidths) {
        randomTest(width)
    }
}
