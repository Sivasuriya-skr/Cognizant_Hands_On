# Financial Forecasting Tool

## 1. Understanding Recursive Algorithms

### Concept of Recursion
Recursion is a programming technique where a method calls itself directly or indirectly to solve a problem. It solves a larger problem by breaking it down into smaller sub-problems of the same form. 

Every recursive algorithm requires two primary components:
1.  **Base Case**: The termination condition that returns a value directly without making further recursive calls, preventing infinite loops.
2.  **Recursive Case**: The part of the function where the problem is reduced to a smaller sub-problem, and the function calls itself.

Recursion simplifies problems that exhibit **self-similarity** or have recursive mathematical definitions (such as tree traversals, factorials, Fibonacci sequences, or compound interest calculations).

---

## 2. Analysis of the Recursive Forecasting Algorithm

### Time Complexity
*   **Time Complexity**: $O(N)$, where $N$ is the number of years. Since we make exactly one recursive call per year decrement (from $N$ to $0$), there are $N + 1$ total calls.
*   **Space Complexity**: $O(N)$ auxiliary space. Every recursive call pushes a stack frame onto the call stack. For $N$ years, there will be $N$ active stack frames, which can lead to a `StackOverflowError` if $N$ is very large (typically $\ge 10,000$ in Java depending on JVM settings).

---

## 3. Optimization of Recursive Solutions

To optimize recursive algorithms and avoid excessive computation or stack overflows:

1.  **Memoization (Top-Down Dynamic Programming)**: 
    Store the results of expensive function calls in a cache (e.g., a hash map or array) and return the cached result when the same inputs occur again. This is extremely effective for branching recursive problems like the Fibonacci sequence, converting $O(2^N)$ complexity to $O(N)$.
    
2.  **Iterative Solution (Bottom-Up Approach)**:
    Convert the recursion into a standard loop. This achieves $O(N)$ time complexity and reduces space complexity from $O(N)$ call stack space to $O(1)$ constant space.
    ```java
    public static double calculateFutureValueIterative(double pv, double r, int n) {
        double fv = pv;
        for (int i = 0; i < n; i++) {
            fv *= (1 + r);
        }
        return fv;
    }
    ```

3.  **Direct Mathematical Formula**:
    For simple forecasting based on constant growth rates, we can use the formula $FV = PV \times (1 + r)^n$. In Java, this is computed in $O(\log n)$ or $O(1)$ time and $O(1)$ space using `Math.pow`:
    ```java
    public static double calculateFutureValueFormula(double pv, double r, int n) {
        return pv * Math.pow(1 + r, n);
    }
    ```
