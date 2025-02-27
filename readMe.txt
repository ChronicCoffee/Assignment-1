--------------------------------------------------
Project Name: Complexity and Sorting
Authors: [Onkar Singh]
         [Noah Gallasic]
         [Asfand Khan]
--------------------------------------------------

Description:
------------
This application sorts a collection of three-dimensional geometric shapes based on a selected property 
(height, volume, or base area) using multiple sorting algorithms. It benchmarks each sorting algorithm 
(Bubble, Selection, Insertion, Merge, Quick, and a Custom sort such as Heap Sort) and displays both 
the timing results and selected sorted output.

Requirements:
-------------
- Java 8 (or later)
- Command-line access for running the application
- Eclipse IDE for development

Installation:
-------------
1. Ensure that Java is installed on your system by running:
       java -version
2. Extract the provided project folder to a suitable location.
3. The executable JAR file (Sort.jar) is located in the root of the project folder.
4. Do not include test data files (e.g., shapes1.txt, shapes2.txt, etc.) in the final submission.

Usage:
------
To run the application, open a command prompt or terminal window and navigate to the directory 
containing the Sort.jar file. The application accepts three command-line arguments in any order:

  -f<fileName>    : Specifies the path to the file containing shape data.
  -t<h/v/a>      : Specifies the property for comparison:
                       h = height,
                       v = volume,
                       a = base area.
  -s<b/s/i/m/q/z>: Specifies the sorting algorithm:
                       b = Bubble Sort,
                       s = Selection Sort,
                       i = Insertion Sort,
                       m = Merge Sort,
                       q = Quick Sort,
                       z = Custom Sort (e.g., Heap Sort).

Examples:
---------
1. To sort shapes by volume using Bubble Sort with data file "shapes1.txt" located in the res folder:
       java -jar Sort.jar -fres/shapes1.txt -tv -sb

2. To sort shapes by base area using Quick Sort:
       java -jar Sort.jar -f"res/shapes2.txt" -ta -sq

3. To sort shapes by height using Insertion Sort:
       java -jar Sort.jar -f"res/shapes3.txt" -th -si

Notes:
------
- The program outputs benchmarking information for each sorting algorithm (execution times in milliseconds).
- It then displays the sorted results including the first shape, every 1000th shape, and the last shape.
- Ensure the shape data file is formatted correctly according to the assignment specification.
- If invalid or missing command-line arguments are provided, the program will display an error message and exit.

Files Included in the Submission:
-----------------------------------
- Sort.jar         : Executable Java Archive for the sorting application.
- readMe.txt       : This file with installation and usage instructions.
- doc/             : Folder containing the generated Javadoc documentation.
- [Exported Project Folder] : Complete Eclipse project directory (excluding test data files).
- mySort.txt       : Document detailing the custom sorting algorithm and its complexity analysis.
- Group Evaluation & Peer Assessment Forms: Completed documents for group self-evaluation and peer assessment.


--------------------------------------------------
