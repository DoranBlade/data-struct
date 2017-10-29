package list

import (
	"testing"
)

func Test(t *testing.T) {
	result := compute(15)
	t.Log(result)
}

func compute(val int) int {
	val++
	count := 0
	for val -= 3;val > 0; val -= 3 {
		count++
	}
	return count
}
