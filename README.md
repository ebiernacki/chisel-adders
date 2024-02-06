# Chisel Adders Repository
A quick note about Scala and Chisel
So far, we have used only val to capture computation.  When you write

    val x = 5

The variable x is once and forever the value 5.  You are not allowed to change x.  This is the preferred way to declare variables that won't vary.

In this assignment you will likely want to have a variable that can change after its original value is assigned.  To do that, you say var instead of val, as in

    var x = 5

    x = x + 1

So that now you can change x after its initial value is assigned.

***

This assignment has 5 modules for you to complete. Complete them in the following order:

- Full Adder 
    - Remember the truth table and logic expressions
    - Test by clicking the green arrow(results will be in Debug Console, not terminal) in the test or with sbt testOnly AdderCircuits.FullAdderTest
- Sign
    - Check to see if the input value is positive, negative, or zero. Use what you know about negative numbers and twos complement
    - Take a look at the test cases in SignTest.scala Why does an input of 15.U give us a negative result? (Hint: look at the number of bits used) Create a new test() case with a Sign Module of different bit width and write tests for a positive, negative and zero values. 
    - Test by clicking the green arrow in the test or with sbt testOnly AdderCircuits.SignTest 
- Ripple Carry Adder 
    - You can use a for loop and create modules inside of it
    - Test by clicking the green arrow in the test or with sbt testOnly AdderCircuits.RippleCarryAdderTest
- Twos Complement
    - How can you use your Ripple Carry Adder to do this? Here is a [wiki link](https://en.wikipedia.org/wiki/Two%27s_complement) if you need a refresher. 
    - Test by clicking the green arrow in the test or with sbt testOnly AdderCircuits.TwosComplementTest
- Subtractor
    - Now that you can represent negative numbers, how can you use the Twos Complement module to subtract?
    - Test by clicking the green arrow in the test or with sbt testOnly AdderCircuits.SubtractorTest




**Getting the Repo:**
```bash
$ https://github.com/ebiernacki/chisel-adders.git 
```

**Testing the Examples**
- To test the Full Adder Module:
    ```bash
    sbt
    testOnly AdderCircuits.FullAdderTest
    ```
- replace ```FullAdderTest``` with the name of the test you want to run



## External Setup Guides and Running the Projects

- [Java, Sbt and Chisel Guide](https://docs.google.com/document/d/13pX-4cFuGuj_i7VRhmksyf7YL6-qXiF8-O9J9m_yVfI/edit?usp=sharing)
- [GTKWave Guide](https://docs.google.com/document/d/1-muYy8XSGP4EbMIbLuwTEscIj1UC-u8HU5glcBpIFUo/edit?usp=sharing)
- [Vivado Guide](https://docs.google.com/document/d/1O-y1rnS1V_Bjyc2GwYd9C6Gq1IsqVcxacy2lTD6tHME/edit?usp=sharing)





