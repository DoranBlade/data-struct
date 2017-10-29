package vertor

import "dataStruct"

// 向量接口
type Vector interface {

	// 获取元素数量
	Size() int

	// 获取指定位置的元素
	Get(index int) (dataStruct.Person, error)

	// 替换指定位置上的元素
	Put(index int, person dataStruct.Person)

	// 在指定位置上插入元素，其后元素向后移动
	Insert(index int, person dataStruct.Person)

	// 删除指定位置的元素
	Remove(index int)

	// 排序元素
	Sort()

	// 查找指定元素的位置
	Find(person dataStruct.Person) int

	// 删除重复元素
	Deduplicate()
}
