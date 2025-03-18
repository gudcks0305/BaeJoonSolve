package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

// Setup buffered I/O for faster input/output operations
var rw *bufio.ReadWriter = bufio.NewReadWriter(
	bufio.NewReader(os.Stdin),
	bufio.NewWriter(os.Stdout),
)

func main() {
	// Ensure all buffered output is written before program exits
	defer rw.Flush()
	nm := strings.Split(getInputLine(), " ")
	n, _ := strconv.Atoi(nm[0])
	m, _ := strconv.Atoi(nm[1])
	numStrings := strings.Split(getInputLine(), " ")
	numbers := make([]int, n)
	visit := make([]bool, n)
	for i, v := range numStrings {
		numbers[i], _ = strconv.Atoi(v)
	}
	sort.Ints(numbers)
	BackTracking(n, m, 0, "", numbers, visit)

}

func BackTracking(n, m, cnt int, str string, numbers []int, visit []bool) {
	if cnt == m {
		fmt.Println(strings.TrimSpace(str))
		return
	}
	for i, v := range numbers {
		if visit[i] {
			continue
		}
		visit[i] = true
		BackTracking(n, m, cnt+1, str+" "+strconv.Itoa(v), numbers, visit)
		visit[i] = false
	}
}

// getInputLine reads a line from stdin and returns it without trailing whitespace
func getInputLine() string {
	line, _ := rw.ReadString('\n')
	return strings.TrimSpace(line)
}
