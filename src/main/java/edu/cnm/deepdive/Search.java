package edu.cnm.deepdive;

public class Search {

  public static int binarySearchRecursive(int needle, int[] haystack) {
    return binarySearch(needle, haystack, 0, haystack.length);
  }

  public static int binarySearch(int needle, int[] haystack) {
    int beginIndex = 0;
    int endIndex = haystack.length;
    int position = -1;
    while (beginIndex < endIndex) {
      int midpoint = (beginIndex + endIndex) / 2;
      int midpointValue = haystack[midpoint];
      if (needle == midpointValue) {
        position = midpoint;
        break;
      } else if (needle < midpointValue) {
        endIndex = midpoint;
      } else {
        beginIndex = midpoint + 1;
      }
    }
    return (position >= 0) ? position : ~beginIndex;
  }

  public static int binarySearch(int needle, int[] haystack, int beginIndex, int endIndex) {
    int position;
    if (endIndex <= beginIndex) {
      position = ~beginIndex;
    } else {
      int midpoint = (beginIndex + endIndex) / 2;
      int midpointValue = haystack[midpoint];
      if (needle == midpointValue) {
        position = midpoint;
      } else if (needle < midpointValue) {
        position = binarySearch(needle, haystack, beginIndex, midpoint);
      } else {
        position = binarySearch(needle, haystack, midpoint + 1, endIndex);
      }
    }
    return position;
  }

}
