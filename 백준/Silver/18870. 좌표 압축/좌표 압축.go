package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

var rw *bufio.ReadWriter = bufio.NewReadWriter(
	bufio.NewReader(os.Stdin),
	bufio.NewWriter(os.Stdout),
)

type Value struct {
	value int
	rank  int
	index int
}

func main() {
	defer rw.Flush()
	n, _ := strconv.Atoi(getInputLine(rw))
	values := make([]*Value, n)
	valueString := strings.Split(getInputLine(rw), " ")
	for i := 0; i < n; i++ {
		value, _ := strconv.Atoi(valueString[i])
		values[i] = &Value{
			value: value,
			rank:  i,
			index: i,
		}
	}
	sort.Slice(values, func(i, j int) bool {
		return values[i].value < values[j].value
	})

	m := 1000000001
	rank := 0
	for i := 0; i < len(values); i++ {
		if i > 0 && values[i].value != values[i-1].value {
			rank++
		}
		values[i].rank = rank
		m = min(m, values[i].rank)
	}

	sort.Slice(values, func(i, j int) bool {
		return values[i].index < values[j].index
	})

	for _, v := range values {
		fmt.Fprint(rw, v.rank-m, " ")
	}
}

func getInputLine(rw *bufio.ReadWriter) string {
	line, _ := rw.ReadString('\n')
	return strings.TrimSpace(line)
}
