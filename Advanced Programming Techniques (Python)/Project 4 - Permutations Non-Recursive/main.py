import sys
import getopt

__author__ = 'alexandrugutu'

def permutations(inputList, outputFile):
	allPermutations = [[]]
	for i in inputList:
		currentRoundOfPermutations = []
		for index, tuple in enumerate(allPermutations):
				if (index % 2):
					for index in range(len(tuple) + 1):
						currentRoundOfPermutations += [tuple[:index] + [i] + tuple[index:]]
				else:
					for index in range(len(tuple), -1, -1):
						currentRoundOfPermutations += [tuple[:index] + [i] + tuple[index:]]

		allPermutations = currentRoundOfPermutations

	for tuple in enumerate(allPermutations):
		# print(tuple)
		with open(outputFile, 'a') as fileWriter:
			fileWriter.write(str(tuple) + '\n')


def __init__(argv):
	try:
		opts, args = getopt.getopt(argv, "hi:o:", ["ifile=", "ofile="])
	except getopt.GetoptError:
		print("test.py -i <inputFile> -o <outputFile>")
		sys.exit(2)
	for opt, arg in opts:
		if opt == '-h':
			print("test.py -i <inputFile> -o <outputFile>")
			sys.exit()
		elif opt in ("-i", "--ifile"):
			inputFile = arg
		elif opt in ("-o", "--ofile"):
			outputFile = arg

	return(inputFile,outputFile)


inputFile, outputFile = __init__(sys.argv[1:])


with open(inputFile) as fileReader:
	for line in fileReader:
		inputList = list(map(int, line.split()))
		permutations(inputList, outputFile)
		with open(outputFile, 'a') as fileWriter:
			fileWriter.write('\n')