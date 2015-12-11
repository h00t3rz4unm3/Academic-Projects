import sys
import getopt
import time
from shapely.geometry import Polygon, LineString
from shapely.affinity import translate

__author__ = 'alexandrugutu'

class Shape(object):
	def __init__(self, fileInput):
		self.inputParameters = list(map(int, fileInput.split()))
		self.numberOfVertices = self.inputParameters[0]
		self.coordinates = self.inputParameters[1:-2]
		self.xCoordinates = []
		self.yCoordinates = []
		self.coordinateTuples = []
		self.deltaX = self.inputParameters[-2]
		self.deltaY = self.inputParameters[-1]
		self.InputVerification()

		for i in range(0, len(self.coordinates), 2):
			self.xCoordinates.append(self.coordinates[i])
		for i in range(1, len(self.coordinates), 2):
			self.yCoordinates.append(self.coordinates[i])

		self.CoordinateConversion()
		self.MaxSideLength()

		self.polygon = Polygon(self.coordinateTuples)

	def SetPolygon(self, polygon):
		self.polygon = polygon

	def InputVerification(self):
		if (self.inputParameters[0] < 3):
			raise TypeError("Too few inputs, needs to be greater than 3 and less than 10")
		elif (self.inputParameters[0] > 10):
			raise TypeError("Too many inputs, needs to be less than 10 and greater than 3")
		elif (self.inputParameters[-2] < -100):
			raise TypeError("Delta X is too slow, needs to be greater than -100 and less than 100")
		elif (self.inputParameters[-2] > 100):
			raise TypeError("Delta X is too fast, needs to be less than 100 and greater than -100")
		elif (self.inputParameters[-1] < -100):
			raise TypeError("Delta Y is too slow, needs to be greater than -100 and less than 100")
		elif (self.inputParameters[-1] > 100):
			raise TypeError("Delta Y is too fast, needs to be less than 100 and greater than -100")
		elif (len(self.inputParameters) != (2 * self.inputParameters[0]) + 3):
			raise TypeError("Wrong number of input parameters.\nExpected: %d Received: %d" % (((2 * self.inputParameters[0]) + 3), len(self.inputParameters)))

	def MaxSideLength(self):
		for i in range(0, len(self.coordinateTuples) - 1, 1):
			lineString = LineString(self.coordinateTuples[i:i+2])
			if (lineString.length > 500):
				raise TypeError("At least one side of the polygon is over 500, invalid")
		lineString = LineString((self.coordinateTuples[-1], self.coordinateTuples[0]))
		if (lineString.length > 500.0):
			TypeError("At least one side of the polygon is over 500, invalid")


	def PrintInformation(self):
		print("Input Parameters: ", self.inputParameters)
		print("Number of Vertices: ", self.numberOfVertices)
		print("X Coordinates: ", self.xCoordinates)
		print("Y Coordinates: ", self.yCoordinates)
		print("Coordinates: ", self.coordinateTuples)
		print("Delta X: ", self.deltaX)
		print("Delta Y: ", self.deltaY)

	def CoordinateConversion(self):
		self.coordinateTuples = list(zip(self.xCoordinates, self.yCoordinates))

	def MovePolygon(self, time):
		self.polygon = translate(self.polygon, self.deltaX * time, self.deltaY * time)


def __init__(argv):
	startTime = 0

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
	print("here2",inputFile)

def MaxTime(areaAndTime):
	timeList = list(areaAndTime.keys())
	areaList = list(areaAndTime.values())
	return(timeList[areaList.index(max(areaList))])

inputFile, outputFile = __init__(sys.argv[1:])


shapes = []
timeDifference = 0
areaAndTime = dict()
print("here",inputFile)
with open(inputFile) as fileReader:
	for line in fileReader:
		shapes.append(Shape(line))

currentTime = 0
incrementValue = 0.0001

while (currentTime < 25):
	if (shapes[0].polygon.intersects(shapes[1].polygon)):
		newPolygon = Polygon(shapes[0].polygon.intersection(shapes[1].polygon))
		areaAndTime[currentTime] = newPolygon.area
	shapes[0].MovePolygon(incrementValue)
	shapes[1].MovePolygon(incrementValue)
	currentTime += incrementValue

with open(outputFile, 'a') as fileWriter:
	if (len(areaAndTime) is 0):
		fileWriter.write("Never")
	else:
		fileWriter.write('Max Time: {:.6f}'.format(MaxTime(areaAndTime)) + ' Max Area: {:.6f}'.format(areaAndTime[MaxTime(areaAndTime)]))
