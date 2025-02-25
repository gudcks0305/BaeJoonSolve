package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var rw *bufio.ReadWriter = bufio.NewReadWriter(
	bufio.NewReader(os.Stdin),
	bufio.NewWriter(os.Stdout),
)
var white, blue int

func main() {
	defer rw.Flush()
	n, _ := strconv.Atoi(getInputLine(rw))
	papers := make([][]int, n)
	white, blue = 0, 0
	for i := 0; i < n; i++ {
		papers[i] = make([]int, n)
		str := strings.Split(getInputLine(rw), " ")
		for k, v := range str {
			papers[i][k], _ = strconv.Atoi(v)
		}
	}

	Recur(papers)
	fmt.Fprintln(rw, white)
	fmt.Fprintln(rw, blue)
}
func printArr(papers [][]int) {
	for _, v := range papers {
		fmt.Println(v)
	}
}
func Recur(papers [][]int) {
	isDone, color := IsDone(papers)
	if isDone {
		if color == 1 {
			blue++
		} else {
			white++
		}
		return // Stop recursion for this branch if it's single color
	}
	// 4등분 먼저 하기
	divided, err := divideArray(papers)
	if err != nil {
		fmt.Println("Error:", err)
		return
	}
	Recur(divided[0]) // Recursively process each quadrant
	Recur(divided[1])
	Recur(divided[2])
	Recur(divided[3])
}

func divideArray(papers [][]int) ([][][]int, error) {
	rows := len(papers)
	if rows == 0 {
		return nil, fmt.Errorf("empty array")
	}
	cols := len(papers[0]) // 모든 행의 길이가 같다고 가정

	if rows%2 != 0 || cols%2 != 0 {
		return nil, fmt.Errorf("array dimensions must be even")
	}

	midRow := rows / 2
	midCol := cols / 2

	result := make([][][]int, 4)

	// 1사분면
	result[0] = make([][]int, midRow)
	for i := 0; i < midRow; i++ {
		result[0][i] = make([]int, midCol)
		copy(result[0][i], papers[i][:midCol]) // 복사본 사용
	}

	// 2사분면
	result[1] = make([][]int, midRow)
	for i := 0; i < midRow; i++ {
		result[1][i] = make([]int, midCol)
		copy(result[1][i], papers[i][midCol:]) // 복사본 사용
	}

	// 3사분면
	result[2] = make([][]int, midRow)
	for i := 0; i < midRow; i++ {
		result[2][i] = make([]int, midCol)
		copy(result[2][i], papers[i+midRow][:midCol]) // 복사본 사용
	}

	// 4사분면
	result[3] = make([][]int, midRow)
	for i := 0; i < midRow; i++ {
		result[3][i] = make([]int, midCol)
		copy(result[3][i], papers[i+midRow][midCol:]) // 복사본 사용
	}

	return result, nil
}

func DoneGo(papers [][]int) {
	d, color := IsDone(papers)
	if d {
		if color == 1 {
			blue++
		} else {
			white++
		}
	} else {
		Recur(papers)
	}
}

func IsDone(papers [][]int) (bool, int) {
	firstColor := papers[0][0]
	if len(papers) == 1 {
		return true, firstColor
	}
	for _, v := range papers {
		for _, v2 := range v {
			if v2 != firstColor {
				return false, -1
			}
		}
	}
	return true, firstColor
}

func getInputLine(rw *bufio.ReadWriter) string {
	line, _ := rw.ReadString('\n')
	return strings.TrimSpace(line)
}
