import math
import sys
import getopt

__author__ = 'alexandrugutu'


def __init__(argv):

	inputFile = ''
	outputFile = ''

	try:
		opts, args = getopt.getopt(argv, "hi:o:", ["ifile=","ofile="])
	except getopt.GetoptError:
		print ("test.py -i <inputFile> -o <outputFile>")
		sys.exit(2)
	for opt, arg in opts:
		if opt == '-h':
			print ("test.py -i <inputFile> -o <outputFile>")
			sys.exit()
		elif opt in ("-i", "--ifile"):
			inputFile = arg
		elif opt in ("-o", "--ofile"):
			outputFile = arg

	global userVariables, price, p, a, b, c, d, k

	print(inputFile, outputFile)

	with open(inputFile) as fp:
		for line in fp:
			userVariables = list(map(int, line.split()))
			valueLenghtChecking(userVariables)
			valuePChecking(userVariables)
			valueChecking(userVariables)

			p = userVariables[0]
			a = userVariables[1]
			b = userVariables[2]
			c = userVariables[3]
			d = userVariables[4]
			k = userVariables[5]

			price = []

			stockEquation(p, a, b, c, d, k)

			with open(outputFile, 'a') as fileWriter:
				fileWriter.write(str(maxDifference(price)) + '\n')

def valueLenghtChecking(userVariables):
	if len(userVariables) != 6:
		raise TypeError("Need 6 variables!")

def valuePChecking(userVariables):
	if (userVariables[0] < 1 or userVariables[0] > 1000):
		raise TypeError("P needs to be greater than 0 or less than 1000")

def valueChecking(userVariables):

	if (userVariables[1] < 0 or userVariables[1] > 1000):
		raise TypeError("a needs to be between 0 and 1000")
	elif (userVariables[2] < 0 or userVariables[2] > 1000):
		raise TypeError("b needs to be between 0 and 1000")
	elif (userVariables[3] < 0 or userVariables[3] > 1000):
		raise TypeError("c needs to be between 0 and 1000")
	elif (userVariables[4] < 0 or userVariables[4] > 1000):
		raise TypeError("d needs to be between 0 and 1000")
	elif (userVariables[5] < 0 or userVariables[5] > math.pow(10,6)):
		raise TypeError("k needs to be between 0 and 1000")

def stockEquation(p, a, b, c, d, k):
	for i in range(0, k, 1):
		value = p * (math.sin(a * i + b) + math.cos(c * i + d) + 2)
		price.append(value)

def maxDifference(price):
	maxval, maxdec = 0, 0
	for i in range(len(price)):
		maxdec = max(maxdec, maxval - price[i])
		maxval = max(maxval, price[i])
	return maxdec

__init__(sys.argv[1:])
