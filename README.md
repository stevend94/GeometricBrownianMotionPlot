# GeometricBrownianMotionPlot
A simple program to simulate geometric brownian motion which is used in the black-scholes model for pricing derivated as a way
to represent movement of stock prices, includes parellization computation of data. This program was written in java and compiled
using javac compiler version 1.8.0_60, the graph program is relatively simplistic in it's  design but works well in plotting the
data of our geometric brownian motion simulation.

#Introduction
Included in the files is a Main.java file which acts as a simple template for program, but some parameters can be changed and added in
as you see fit. The first is interchangable values are the 3 variables at the start, which are

ITERATIONS - Number of data point iterations to calculated for each process

PROCESSES - The number of processes for the Geometric Brownian Motion simulation to compute

INCREMENT - This refers to the increment in time for our simulation (If unfamiliar just stick with the default value)

Then when you have set the variables to your prefered values, then you can add a process by using the setProcess function on the
GeometricBrownianMotion object which should be defined gbm in the default Main.java template, the number add should equal the number
of prestated processes for the PROCESSES variable.The parameters for this function are given by,

-gbm.setProcesses([(int)process number], [(float) initial value], [(float)drift rate]
, [(float)volatility], [(boolean)independent randomness])

This last input parameter can be left out and the default option of false will be taken. This parameter refers to whether or not the
the process shares the same gaussian random number at each iteration. We can see from the next image how the 4 processes share the same
random input value at each iterative data point.

![untitled picture](https://cloud.githubusercontent.com/assets/7094275/18420492/c55bd556-786b-11e6-8e8e-2a41cd4267dc.png)

As you can see, each process follows a very similar path to all other processes at each iteration which has been slighlty magnified
by setting the drift rate, time increment and volatility of each process at relativly low levels. The next image shows the converse,
how each process has independent randomness at each iteration to all other processes.

![independent randomness](https://cloud.githubusercontent.com/assets/7094275/18420511/31dd6b68-786c-11e6-817d-a8ea86f1a9db.png)

#Maximal Process and Iterative Stress Test
When a large number of processes are included, the computations of the simulation and the plotting of many data points
 on the graph becomes quite strenuous on any cpu (obviously) but after several tests on machine I decided to set the maximal
 processes for the simulation at 200, whilst not restricting the number of iterations (usually set at 400, there was in occasion
 in which I accidently process 4000 iterations each for 200 processes which I didn't realise but became suspicious when the applet
 was using 30/40% of my cpu). This ofcourse can be readily changed with any lower/higher value you wish,
 i've also included a couple of images of the stress tests below

 ![200 processes test](https://cloud.githubusercontent.com/assets/7094275/18420544/f10074cc-786c-11e6-8719-903b948b1399.png)


![200 processes test 2](https://cloud.githubusercontent.com/assets/7094275/18420547/08519cb4-786d-11e6-8048-69a1b7ea7bea.png)

#Optimization and personalization
The inclusion of this interchangability of dependent/independent randomness at each iteration of a process unfortunatily
reduces the efficiency of the simulation, so future refinments to this feature will probably be added. Any input from others is also
welcome for optimisation, other personal features can be changed such as the point size, line size and line color if you are familiar
with the code. The colors for instance in the DataGrapher java file can be interchanged, or more colors added as you see fit as I
decided to only include 6 seperate colors.

I am also working on a short introduction to Geometric Brownian Motion for those who are interested in the mathematics behind the code,
but until then much material can be found online and in books, as it is a highly inportant topic in the fields of mathematics,
physics and finance to name a few.
