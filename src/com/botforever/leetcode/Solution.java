package com.botforever.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        int check = size -1;
        while (check >= 0) {
            if (digits[check] +1 < 10)
                break;
            check--;
        }

        if (check <0) size++;
        int[] out = new int[size];
        if (check <0) {
            out[0]=1;
            for (int i=1;i<size;i++)
                out[i]=0;
            return out;
        } else {
            for (int  i=0;i <check;i++)
                out[i]=digits[i];
            out[check] = digits[check]+1;
            for (int i =check+1;i<size;i++)
                out[i]=0;
            return out;
        }
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null) return null;
        if (matrix.length == 0) return new int[0];

        int M = matrix.length;
        int N = matrix[0].length;
        int dir = -1, idx = 0;
        int r = 0, c = 0, y = 0, x = 0;
        int[] out = new int[M*N];
        out[0] = matrix[0][0];
        idx++;
        while (idx < M * N) {
            if (dir == -1) {
                y = r - 1;
                x = c + 1;
                if (y >= 0 && x < N) {
                    r--;
                    c++;
                } else if (y < 0) {
                    if (x >= N) {
                        r = 1;
                        c = N - 1;
                    } else {
                        r = 0;
                        c++;
                    }
                    dir = 1;
                } else if (x >= N) {
                    r++;
                    c = N - 1;
                    dir = 1;
                }
            } else {
                y = r + 1;
                x = c - 1;

                if (y < M && x >= 0) {
                    r++;
                    c--;
                } else if (y >= M) {
                    r = M - 1;
                    c++;
                    dir = - 1;
                } else if (x < 0) {
                    r++;
                    c = 0;
                    dir = -1;
                }
            }

            out[idx] = matrix[r][c];
            idx++;
        }
        return out;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> out = new ArrayList<>(numRows);
        if (numRows == 0) {
            return out;
        }
        int idx = 0;
        if (idx == 0) {
            ArrayList<Integer> row = new ArrayList<Integer>(1);
            row.add(1);
            out.add(row);
        }
        if (numRows == 1) return out;

        idx++;
        if (idx == 1) {
            ArrayList<Integer> row = new ArrayList<Integer>(2);
            row.add(1);
            row.add(1);
            out.add(row);
        }
        if (numRows == 2) return out;

        for (idx = 2; idx < numRows; idx++) {
            ArrayList<Integer> row = new ArrayList<Integer>(idx);
            row.add(1);
            ArrayList<Integer> top = (ArrayList<Integer>) out.get(idx - 1);
            for (int i = 0; i < top.size() - 1; i++) {
                int x = top.get(i);
                int y = top.get(i+1);
                row.add(x+y);
            }
            row.add(1);
            out.add(row);
        }
        return out;
    }

    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int i = a.length();
        int j = b.length();
        int delta = Math.abs(i-j);
        for (int k = 0; k < delta; k++) {
            sb.append('0');
        }
        if (i > j) {
            sb.append(b);
            b = sb.toString();
        } else if (i < j) {
            sb.append(a);
            a = sb.toString();
        }
        sb = new StringBuffer();
        i = a.length() - 1;
        int x, y, c = 0, n;
        while (i >= 0 ) {
            x = a.charAt(i) - '0';
            y = b.charAt(i) - '0';
            n = x + y + c;
            if (n == 2 ) {
                c = 1;
                n = 0;
            } else if (n == 3) {
                c = 1;
                n = 1;
            } else {
                c = 0;
            }
            sb.append(n);
            i--;

        }
        if (c == 1) {
            sb.append('1');
        }
        return  sb.reverse().toString();
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;
        int x = haystack.length();
        int y = needle.length();
        if (x < y)
            return -1;
        int i = 0, j = 0;
        for (i = 0; i < x - y; i++) {
            for (j = 0; j < y; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
            if (j == y) return i;
        }
        return -1;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        StringBuffer sb = new StringBuffer();
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < len)
                len = strs[i].length();
        }
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }

        return sb.toString();
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
