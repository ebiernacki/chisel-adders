// package AdderCircuits

// import chisel3._
// import chisel3.util._
// import chiseltest._
// import org.scalatest.flatspec.AnyFlatSpec
// import scala.util.Random


// class AdderTest extends AnyFlatSpec with ChiselScalatestTester {
//     "half adder" should s"add two 1bit inputs" in {
//         test(new HalfAdder()){ dut => 
//             dut.io.a.poke(1.U)
//             dut.io.b.poke(1.U)
//             dut.io.carry.expect(1.U)
//             dut.io.sum.expect(0.U)
//         }
//     } 
//     "full adder" should s"add two 1bit inputs" in {
//         test(new FullAdder()){ dut => 
//             dut.io.a.poke(1.U)
//             dut.io.b.poke(0.U)
//             dut.io.c_in.poke(1.U)
//             dut.io.sum.expect(0.U)
//             dut.io.c_out.expect(1.U)

//         }
//     } 
//     "ripple carry adder" should s"add two 5bit inputs" in {
//         test(new RippleCarryAdder(5)){ dut => 
//             dut.io.A.poke(10.U)
//             dut.io.B.poke(10.U)
//             dut.io.Sum.expect(20.U) 
//             dut.io.Cout.expect(0.U)
//         }
//     } 
//     "another ripple carry adder" should s"add two 5bit inputs" in {
//         test(new RippleCarryAdder(5)){ dut => 
//             dut.io.A.poke(15.U)
//             dut.io.B.poke(17.U)
//             dut.io.Sum.expect(0.U) 
//             dut.io.Cout.expect(1.U)
//         }
//     } 


    
//     // def randomTest(width: Int) = {
//     //     val in1 = BigInt(width, Random) //not oneline for printing formats
//     //     val in1asUint = in1.U(width.W)  //to UInt for chisel
//     //     val in2 = BigInt(width, Random)
//     //     val in2asUint = in2.U(width.W)

//     //     var expected = (in1 + in2).U //replaceable
//     //     var trunc: Boolean = false


//     //     //check if width is too much
//     //     if(expected.getWidth > width){
//     //         trunc = true
//     //         expected = expected(width-1 , 0) //chop off MSB if value has grown over width
//     //     }

//     //     //singular test thats generated in for loop below
//     //     it should s"RippleCarry Add: width = $width, in1 = $in1, in2 = $in2, expected = $expected, truncated: $trunc" in {
//     //         test(new RippleCarryAdder(width)) { dut =>
//     //             dut.io.A.poke(in1asUint)
//     //             dut.io.B.poke(in2asUint)
//     //             dut.io.Sum.expect(expected)
//     //         }
//     //     }
//     // }

//     // //generate seq of random widths in range  1 -> 64, add 64 to end
//     // var randomWidths: Seq[Int] = Seq.fill(5)(Random.nextInt(64) + 1)
//     // randomWidths = randomWidths :+ 64

//     // //generate 6 tests for all (6) widths 
//     // for (width <- randomWidths) {
//     //     randomTest(width)
//     // }
//     "another ripple carry adder" should s"add two 11bit inputs" in {
//         test(new RippleCarryAdder(12)){ dut => 
//             dut.io.A.poke(1234.U)
//             dut.io.B.poke(1.U)
//             dut.io.Sum.expect(1235.U) 
//             dut.io.Cout.expect(0.U)
//         }
//     } 


//     "2s compliment test" should s"invert and add 1" in {
//         test(new TwosComplement(12)){ dut => 
//             dut.io.in.poke(1234.U)
            
//             dut.io.out.expect(2862.U) 
           
//         }
//     } 


//     "sub test" should s"subtract" in {
//         test(new sub(4)){ dut => 
//             dut.io.a.poke(8.U)
//             dut.io.b.poke(5.U)

//             var z = dut.io.negb.peek().litValue
//             // printf("negb=%b\n", dut.io.negb.peek())

//             println(s"negb (-5) is: $z")
//             dut.io.sum.expect(3.U) 
//         }
//     } 

//     "sign test" should s"detect sign" in {
//         test(new Sign(4)){ dut => 
//             dut.io.input.poke(8.U)
//             val neg = dut.io.neg.peek()

//             println(s"is neg: $neg")
//         }
//     } 


// }
