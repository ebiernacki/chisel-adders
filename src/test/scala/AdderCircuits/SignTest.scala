package AdderCircuits

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import scala.util.Random
import os.truncate

class SignTest extends AnyFlatSpec with ChiselScalatestTester {
    "Sign test" should s"determine the sign of an input" in {
        test(new Sign(4)){ dut => 
            dut.io.input.poke(1.U)
            dut.io.neg.expect(false.B)
            dut.io.pos.expect(true.B)
            dut.io.zero.expect(false.B)
            println("Input of 0001b should be positive")


            dut.io.input.poke(0.U)
            dut.io.neg.expect(false.B)
            dut.io.pos.expect(false.B)
            dut.io.zero.expect(true.B)
            println("Input of 0000b should be negative")


            dut.io.input.poke(15.U)
            dut.io.neg.expect(true.B)
            dut.io.pos.expect(false.B)
            dut.io.zero.expect(false.B)
            println("Input of 1111b should be negative")
        }
    }
}