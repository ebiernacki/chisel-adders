package AdderCircuits


import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import scala.util.Random


class TwosComplementTest extends AnyFlatSpec with ChiselScalatestTester {
    "2s compliment test" should s"invert and add 1 to get the 2s Comp" in {
        test(new TwosComplement(4)){ dut => 
            dut.io.in.poke(3.U)
            // val expected = (Math.pow(2,5) - 3).toInt
            dut.io.out.expect(13.U) 

            println(s"Unsigned Twos Complement of 4bit 3 is: ${dut.io.out.peek().litValue}")
        }
        
        test(new TwosComplement(5)){ dut => 
            dut.io.in.poke(3.U)
            // val expected = (Math.pow(2,5) - 3).toInt
            dut.io.out.expect(29.U) 

            println(s"Unsigned Twos Complement of 5bit 3 is: ${dut.io.out.peek().litValue}")
        }

        test(new TwosComplement(8)){ dut => 
            dut.io.in.poke(15.U)
            // val expected = (Math.pow(2,5) - 15).toInt
            dut.io.out.expect(241.U) 

            println(s"Unsigned Twos Complement of 8bit 15 is: ${dut.io.out.peek().litValue}")
        }

        
        test(new TwosComplement(12)){ dut => 
            dut.io.in.poke(1234.U)
            
            // val expected = (Math.pow(2,12) - 1234).toInt
            dut.io.out.expect(2862.U) 

            println(s"Unsigned Twos Complement of 12bit 1234 is: ${dut.io.out.peek().litValue}")
        }
    } 

}
