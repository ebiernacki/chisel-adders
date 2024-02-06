package AdderCircuits

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import scala.util.Random

class SubtractorTest extends AnyFlatSpec with ChiselScalatestTester {
    "Subtractor test" should s"subtract 2 numbers" in {
        test(new Subtractor(5)){ dut => 
            dut.io.a.poke(8.U)
            dut.io.b.poke(8.U)
            dut.io.diff.expect(0.U) 

            dut.io.a.poke(8.U)
            dut.io.b.poke(0.U)
            dut.io.diff.expect(8.U) 

            dut.io.a.poke(8.U)
            dut.io.b.poke(5.U)
            dut.io.diff.expect(3.U)

            dut.io.a.poke(0.U)
            dut.io.b.poke(0.U)
            dut.io.diff.expect(0.U)  
        }
    }

}