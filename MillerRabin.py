"""
Final Project Question 1b
Name: Cassandra Wendlandt-Bloodsworth
StudentNumber: 3551770
"""
import random
import sys

def is_prime(n,k): 
    """checks to see if the number is prime using the 
        miller rabin primality test

    Args:
        n (int): large positive number that is passed in by user
        k (int): number of iterations that are to be done

    Returns:
        0 : a not a prime number 
        1 : a is a prime number
    """
    #special cases 
    if (n==1 or n==4):
        return 0
    if (n<=3):
        return 1

    #find q in 2^k * q = n-1
    q=n-1
    while (q%2==0):
        q = q//2

    #repeat k times 
    for i in range(k):
        #if the miller rabin test returns 0 that means it is not a prime number
        if (miller_rabin_test(q,n)==0):
            return 0
    return 1

def miller_rabin_test(q,n):
    """checks to see if the number is prime using the 
        miller rabin primality test
        This method does the steps to test to see if it is a prime number

    Args:
        q (int): number that is calcualted in is_prime
        n (int): large positive number passed in from user

    Returns:
        0 : a not a prime number 
        1 : a is a prime number
    """
    #picking a value
    a = random.randint(1, n-1)


    #print("a value ",a, "q: ",q,"n: ",n)
    
    #print("(a^q)%n value ",(a^q)%n)
    #Special case 
    #calculate a^q mod n = 1 it true return 1 for being prime
    if ((a**q)%n==1 or (a**q)%n == n-1):
        return 1
    x=(a**q)%n

    #check the j
    for j in range(k):
        if (a**((2**j)*q)%n == n-1):
            return 1
    return 0

if __name__ == '__main__':
    
    k=10
    if (len(sys.argv) != 2):
            print("enter a large positive number in the command line")
    else: 
        if (int(sys.argv[1])<0):
            print("enter two positive numbers only in the command line")
        else:
            a = int(sys.argv[1])
            print (is_prime(a,k))
