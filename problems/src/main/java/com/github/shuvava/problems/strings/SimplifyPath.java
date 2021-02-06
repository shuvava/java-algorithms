package com.github.shuvava.problems.strings;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory
 * in a Unix-style file system, convert it to the simplified canonical path.
 * <p>
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..'
 * refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated
 * as a single slash '/'. For this problem, any other format of periods such as '...' are treated as
 * file/directory names.
 * <p>
 * The canonical path should have the following format:
 * <p>
 * The path starts with a single slash '/'. Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'. The path only contains the directories on the path
 * from the root directory to the target file or directory (i.e., no period '.' or double period
 * '..') Return the simplified canonical path.
 * <p>
 * Example 1: Input: path = "/home/" Output: "/home" Explanation: Note that there is no trailing
 * slash after the last directory name. Example 2: Input: path = "/../" Output: "/" Explanation:
 * Going one level up from the root directory is a no-op, as the root level is the highest level you
 * can go. Example 3: Input: path = "/home//foo/" Output: "/home/foo" Explanation: In the canonical
 * path, multiple consecutive slashes are replaced by a single one. Example 4: Input: path =
 * "/a/./b/../../c/" Output: "/c"
 */
public class SimplifyPath {

  public static String simplifyPath(String path) {
    var pathItems = Stream
      .of(path.split("/"))
      .map(String::trim)
      .collect(ArrayList<String>::new, ArrayList::add, ArrayList::addAll);
    var result = new ArrayList<String>();

    for (String pathItem : pathItems) {
      if (pathItem.equals(".") || pathItem.length() == 0) {
        continue;
      }
      if (pathItem.equals("..")) {
        if (result.size() > 0) {
          result.remove(result.size() - 1);
        }
      } else {
        result.add(pathItem);
      }
    }

    return "/" + String.join("/", result);
  }
}
