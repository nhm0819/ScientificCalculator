# ScientificCalculatorApp  
Using Java and Android Studio


## 1. Requirement Analysis  
* Operations 
  * Four rules calculations (+, -, *, /)
  * Log, Power ( L, ^ )
  * Mod (%)
  * Bracket { '( )' }
  
* Numbers
  * int, double
  * e, pi  
  
* Basic
  * eraser
  * clear
  * preview
  
## 2. Structure Design
 1. Use Case Diagram
 2. Sequence Diagram
 3. Class Diagram
 
 
## 3. Data Structure Design
* Used data types : Expression(String), Operand(double), operator(String), Buttons
* input : Button (String)
* output : Textview (Double)

## 4. Algorithm Design
1. Input expression
2. Split to Operands and Operators
3. Rearrange in Postfix notation
4. Calculate according to an postfix notation
5. Output double type result 

## 5. Implement with an application

+ Calculate in order operator priority
<img src="https://github.com/nhm0819/ScientificCalculatorApp/blob/master/images/app_1.png?raw=true" width="30%" height="30%">  
<br>  

+ Calculate in parentheses first
<img src="https://github.com/nhm0819/ScientificCalculatorApp/blob/master/images/app_2.png?raw=true" width="30%" height="30%">
<br>  

+ Calculation can be continued based on the result value
<img src="https://github.com/nhm0819/ScientificCalculatorApp/blob/master/images/app_3.png?raw=true" width="30%" height="30%">
<br>  

+ Can input real numbers
<img src="https://github.com/nhm0819/ScientificCalculatorApp/blob/master/images/app_4.png?raw=true" width="30%" height="30%">
