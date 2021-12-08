"""This module takes a cipher text and the cipher key length and uses them for
crypoanalysis to uncover the orignal plain text

CS4355 question 2
Cassandra Wendlandt-Bloodsworth 
3551700
"""

import string
import copy
import random

ALPHABET = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split()
ENGLISH_ALPHA_FREQ = {"A": 8.2, "B": 1.5, "C": 2.8, "D": 4.3, "E": 12.7,
                      "F": 2.2, "G": 2.0, "H": 6.1, "I": 7.0, "J": 0.2,
                      "K": 0.8, "L": 4.0, "M": 2.4, "N": 6.7, "O": 7.5,
                      "P": 1.9, "Q": 0.1, "R": 6.0, "S": 6.3, "T": 9.1,
                      "U": 2.8, "V": 1.0, "W": 2.4, "X": 0.2, "Y": 2.0,
                      "Z": 0.1}
ENGLISH_FREQ_SORTED = ["E", "T", "O", "A", "I", "N", "S", "H", "R", "D", "L", 
                       "U", "C", "M", "F", "W", "Y", "G", "P", "B", "V", "K", 
                       "Q", "J", "X", "Z"]

def vigenere(ciphertext, keylength):
    """This function does the work described by the module docstring

    Args:
        ciphertext (str): The ciphertext to uncover
        keylength (int):
            The key length used to encrypt the plaintext to the ciphertext

    Returns:
        str: The plaintext uncovered
    """
    freq_map_list = [{} for _ in range(keylength)]
    NUM_KEYS = 10
    partitioned = partition(ciphertext, keylength)

    pos = 0
    for part in partitioned:
        for c in part:
            freq_map_list[pos][c] = freq_map_list[pos].get(c, 0) + 1
        pos+=1

    pot_key_set = build_keys(freq_map_list)

    best_keys = []

    for _ in range(NUM_KEYS):
        randkey = ""
        for key in pot_key_set:
            randkey += key[random.randrange(0,4)]
        best_keys.append(randkey)
    return best_keys

def build_keys(freq_map_list):
    """This function takes the frequency map and builds potential keys

    Args:
        freq_map_list (list(dict)): Frequency map list

    Returns:
        list: List of potential keys  based on frequency analysis
    """
    MOST_FREQ_ENG = ENGLISH_FREQ_SORTED[:keylength]
    potential_keys = []

    most_freq_letter = ''
    most_freq = 0
    ret_key = ''
    for freq_map in freq_map_list:
        for letter, freq in freq_map.items():
            if freq > most_freq:
                most_freq = freq
                most_freq_letter = letter

        for letter in MOST_FREQ_ENG:
            ret_key += translate_from_english_freq(most_freq_letter, letter)
        potential_keys.append(ret_key)
        ret_key = ''
        most_freq = 0
    return potential_keys

def translate_from_english_freq(letter, translate):
    """This function translates a letter given the translated to letter
    and returns the index of the alphabet

    Args:
        letter (str): letter to translate
        translate (str): The letter to translate from

    Returns:
        str: the index of the alphabet that the letter was translated to
    """
    i = ALPHABET.index(letter)
    k = ALPHABET.index(translate)
    M = (i - k) % 26
    return ALPHABET[M]

def decrypt(ciphertext, key):
    """This function decrypts a caesar cypher given the key and ciphertext

    Args:
        ciphertext (str): The ciphertext trimmed
        key (str): The cipher key

    Returns:
        str: The decrypted text trimmed
    """
    plaintext = ""
    pos = 0
    for c in ciphertext:
        i = ALPHABET.index(c)
        k = ALPHABET.index(key[pos % len(key)])
        M = (i - k) % 26
        plaintext += ALPHABET[M]
        pos += 1
    return plaintext

def partition(ciphertext, keylength):
    """This function partitions the ciphertext into keylength number of
    substrings

    Args:
        ciphertext (str): input ciphertext
        keylength:
            The keylength for the Vigenere cipher to use in partitioning the
            ciphertext into substrings

    Returns:
        list(str): The parititoned ciphertext
    """
    retval = ["" for _ in range(keylength)]
    ciphertrimmed = "".join([i for i in ciphertext if i.isalpha()])
    i = 0
    for c in ciphertrimmed:
        pos = i % keylength
        retval[pos] += c
        i+=1
    return retval

def pretty_print(originaltext, solvedtext):
    """This function prettifys the solved text based on the format of the 
    originaltext

    Args:
        originaltext (str): the original text with format
        solvedtext (str): the plaintext solved, trimmed

    Returns:
        str: The formatted solved text
    """
    pos = 0
    pretty_string = ""
    for c in originaltext:
        if c.isalpha():
            pretty_string += solvedtext[pos]
            pos += 1
        else:
            pretty_string += c
    return pretty_string

if __name__ == "__main__":
    ciphertext = "OOFWGTXYE - FKVY MHIULX WTOGLE TH AMBELFS MV XAIAAPL," \
                 + "KQSDAAPL, ZQROLD AGK YUVO YOKL - FONJT NXHDLR LHEKF MSILOT"\
                 + "HM PABSK LBMQ IG AADTF’E MHKQRG DAREK. FEVOZOEVSY BZ BOPLDEW"\
                 + "UAT CBET UF EIEPOOG JTIIZ MNW LXEVADIVPFY, UBF BR ATE" \
                 + "VYQAMPHIMF MNW PZGXUGIMF AF VVYPNAQR LJUEGAUSMZ IHH"\
                 + "ADAGZXAML EOVPQTR’Z ZEXKE AGK IAGAE IGAA PKVPUVAE TAHF CTU"\
                 + "UMIYAVX IATA ZACBLFY TUP TAL QCHUAMR."
    keylength = 4
    ciphertrimmed = "".join([i for i in ciphertext if i.isalpha()])
    #solved = decrypt(ciphertrimmed, "MATH")

    best_keys = vigenere(ciphertext, keylength)
    for key in best_keys:
        print("\n*********Potential Key: " + key + "************\n")
        solved = decrypt(ciphertrimmed, key)
        print(pretty_print(ciphertext, solved))
