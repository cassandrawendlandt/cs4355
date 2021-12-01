"""
Final Project Question 1a
Name: Cassandra Wendlandt-Bloodsworth
StudentNumber: 3551770
"""
import sys
def gcd_calculation(a, b):
    """uses the Extend euclidean algorithm to finds the gcd of the two numbers

    Args:
        a (int): large positive number 
        b (int): large positive number

    Returns:
        gcd (int): the greatest common demonator 
        x (int): the x value in the formula a*x +/- b*y =1 
        y (int): the y value in the formula a*x +/- b*y =1 
    """
    #check the special case
    if a == 0:
        return b, 0, 1
    else:
        gcd, x, y = gcd_calculation(b % a, a)
        return gcd, y - (b // a) * x, x
 
def mod_inverse(a,b,x,y):
    """modInverse finds the inverse of the 

    Args:
        a (int): large positive number, passed in from the users
        b (int): large positive number, passed in from the users
        x (int): the x value in the formula a*x +/- b*y =1 
        y (int): retrived from the gcd_calculation

    Returns:
        c (int): the value of a^-1 mod b
        d (int): the value of b^-1 mod a
    """
    c = 0
    d = 0

    if (x < 0):
        c=b-x*-1
    elif (x >= 0):
        c=x%b
    if (y < 0):
        d=a-y*-1
    elif(y>0):
        d=y%a
    return c,d

if __name__ == '__main__':
    #checks to make sure the user passes in the two large postivie numbers
    if (len(sys.argv) !=3):
        print("enter two large positive number in the command line")
    else: 
        if (int(sys.argv[1])<0 or int(sys.argv[2])<0):
            print("enter two positive numbers only in the command line")
        else:
            a=int(sys.argv[1])
            b=int(sys.argv[2])
            gcd, x, y = gcd_calculation(a, b) 
            if (gcd != 1):
                print("The multiplicative inverse cannot be found")
            else:
                c,d=mod_inverse(a,b,x,y)
                print ("c =",a,"^-1 mod", b," =",c)
                print ("d =",b,"^-1 mod", a," =",d)
