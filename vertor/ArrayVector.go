package vertor

import (
	"dataStruct"
	"errors"
)

const (
	defaultCapacity = 10
)

type ArrayVector struct {

	// 当前向量的长度
	capacity int

	// 存放数据的容器
	container [...]dataStruct.Person

}

// 创建ArrayVector实例对象
func NewArrayVector(capacity int) *ArrayVector {
	arrayVector := ArrayVector{}
	arrayVector.capacity = capacity
	arrayVector.container = [capacity]dataStruct.Person{}
	return &arrayVector
}

// 默认长度的ArrayVector实例对象
func NewArrayVectorDefault() *ArrayVector {
	return NewArrayVector(defaultCapacity)
}

// 增长容器的空间
func (av *ArrayVector) grow() {
	newVector := NewArrayVector(av.capacity * 0.5)
	newVector.copy(av)
	av = newVector
}

// 复制元素
func (av *ArrayVector) copy(old *ArrayVector) {
	for i := 0; i < old.capacity; i++ {
		av.container[i] = old.container[i]
	}
}

// 获取向量规模大小
func (av *ArrayVector) Size() int {
	return av.capacity
}

// 获取指定位置的元素
func (av *ArrayVector) Get(index int) (dataStruct.Person, error){
	if index >= 0 && index < av.capacity {
		return av.container[index], nil
	}
	return dataStruct.Person{}, errors.New("not found")
}

// 替换指定位置上的元素
func (av *ArrayVector) Put(index int, person dataStruct.Person) error {
	if index >= av.capacity {
		return errors.New("out of index")
	}
	av.container[index] = person
	return nil
}
