import sys
import getopt
from collections import defaultdict

__author__ = 'alexandrugutu'


def __init__(argv):
	global inputFile, outputFile

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

	return inputFile, outputFile


inputFile, outputFile = __init__(sys.argv[1:])

with open(inputFile) as fileReader:
	inputParameters = list(map(int, fileReader.readline().split()))

xValues = inputParameters[0]
yValues = inputParameters[1]

keyboardArray = [[0 for y in range(yValues)] for x in range(xValues)]

currentCharacter = ''
targetWord = ''

with open(inputFile) as fileReader:
	fileReader.readline()
	for x in range(xValues):
		for y in range(yValues):
			currentCharacter = fileReader.read(1)
			if (currentCharacter is '\n'):
				currentCharacter = fileReader.read(1)
			keyboardArray[x][y] = currentCharacter


print(keyboardArray)

with open(inputFile) as afileReader:
	for lines in afileReader:
		targetWord = lines

targetWord = keyboardArray[0][0] + targetWord
targetWord += "*"
numberOfSteps = 0

keyboardGraph = defaultdict(list)

for x in range(xValues):
	for y in range(yValues):
		leftValue = y - 1
		rightValue = y + 1
		upValue = x - 1
		downValue = x + 1

		if (x == 0 and y == 0):
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x][y + 1])
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x + 1][y])
		elif (x == 0 and y == yValues - 1):
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x][y - 1])
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x + 1][y])
		elif (x == xValues - 1 and y == 0):
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x][y + 1])
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x - 1][y])
		elif (x == xValues - 1 and y == yValues - 1):
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x][y - 1])
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x - 1][y])
		elif (rightValue > yValues - 1):
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x][y - 1])
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x - 1][y])
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x + 1][y])
		elif (leftValue < 0):
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x][y + 1])
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x - 1][y])
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x + 1][y])
		elif (upValue < 0):
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x + 1][y])
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x][y + 1])
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x][y - 1])
		elif (downValue > xValues - 1):
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x - 1][y])
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x][y - 1])
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x][y + 1])
		else:
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x][y + 1])
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x][y - 1])
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x - 1][y])
			keyboardGraph[keyboardArray[x][y]].append(keyboardArray[x + 1][y])

def bfs(graph, start, end, currentPath=[]):
	currentPath = currentPath + [start]
	if start == end:
		return currentPath
	if not start in graph:
		return None
	shortestPath = None
	for node in graph[start]:
		if node not in currentPath:
			newpath = bfs(graph, node, end, currentPath)
			if newpath:
				if not shortestPath or len(newpath) < len(shortestPath):
					shortestPath = newpath
	return shortestPath

for k in keyboardGraph:
	sequence = keyboardGraph[k]
	unique = []
	[unique.append(item) for item in sequence if item not in unique]
	keyboardGraph[k] = unique

print (keyboardGraph)

for index in range(len(targetWord) - 1):
	numberOfSteps += len(bfs(keyboardGraph, targetWord[index], targetWord[index + 1]))

print (numberOfSteps)

